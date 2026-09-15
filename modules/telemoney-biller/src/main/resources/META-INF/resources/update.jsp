
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.ejada.telemoney.biller.portlet.PaymentTypeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.ejada.telemoney.biller.portlet.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:renderURL var="cancel_update">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<portlet:actionURL name="updateBiller" var="updateBiller">
</portlet:actionURL>
<%

List<CategoryDTO> categories  =  request.getAttribute("billerCategories")!=null?
								(List<CategoryDTO>) request.getAttribute("billerCategories"):
								new ArrayList();
								
List<PaymentTypeDTO> paymentTypes  =  request.getAttribute("paymentTypes")!=null?
								(List<PaymentTypeDTO>) request.getAttribute("paymentTypes"):
								new ArrayList();

String id  = (String)request.getAttribute("id");
String prePaidCode  = (String)request.getAttribute("prePaidCode");
String postPaidCode  = (String)request.getAttribute("postPaidCode");
String billerNameAr  = (String)request.getAttribute("billerNameAr");
String billerNameEn  = (String)request.getAttribute("billerNameEn");
String billerCategoryId  = (String)request.getAttribute("billerCategoryId");
String billerCategoryNameEn  = (String)request.getAttribute("billerCategoryNameEn");
String labelNameAr  = (String)request.getAttribute("labelNameAr");
String labelNameEn  = (String)request.getAttribute("labelNameEn");
String payementTypeId  = (String)request.getAttribute("payementTypeId");
String allowedFixedValues  = (String)request.getAttribute("allowedFixedValues");
double paymentMinAmount  = (double)request.getAttribute("paymentMinAmount");
double paymentMaxAmount  = (double)request.getAttribute("paymentMaxAmount");
String allowedPaymentAmounts  = (String)request.getAttribute("allowedPaymentAmounts");
String photoLink  = (String)request.getAttribute("photoLink");
String serverURL = PortalUtil.getPortalURL(request);
String itemSelectorURL = (String)request.getAttribute("itemSelectorURL");

// Get pending category IDs to show visual indicator
Set<String> pendingCategoryIds = (Set<String>) request.getAttribute("pendingCategoryIds");
if (pendingCategoryIds == null) {
	pendingCategoryIds = new HashSet<>();
}

// Get hasPendingVersion flag (true if biller itself is pending or parent category is pending)
Boolean hasPendingVersionObj = (Boolean) request.getAttribute("hasPendingVersion");
boolean hasPendingVersion = hasPendingVersionObj != null ? hasPendingVersionObj : false;

// Get isCategoryPending flag
Boolean isCategoryPendingObj = (Boolean) request.getAttribute("isCategoryPending");
boolean isCategoryPending = isCategoryPendingObj != null ? isCategoryPendingObj : false;

// Disable editing if pending version exists or if user is "other" role
boolean isDisabled = isOther || hasPendingVersion;

%>
<div>
	<h3 class="pb-4">Biller</h3>
	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<% if (isCategoryPending) { %>
		<strong>Category Pending Approval:</strong> The parent category has a pending change awaiting approval. Editing is disabled until the change is approved or rejected.
		<% } else { %>
		<strong>Pending Approval:</strong> This biller has a pending change awaiting approval. Editing is disabled until the change is approved or rejected.
		<% } %>
	</div>
	<% } %>
		    <liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This biller has a pending version awaiting approval and cannot be modified." />

	<div class="card">
		<div class="card-body">
	<form action="<%=updateBiller%>" method="post">
				<!-- Hidden fields for old values (for workflow comparison) -->
				<input type="hidden" name="<portlet:namespace/>oldPrepaidcode" value="<%=prePaidCode %>">
				<input type="hidden" name="<portlet:namespace/>oldPostpaidcode" value="<%=postPaidCode %>">
				<input type="hidden" name="<portlet:namespace/>oldBillerNameArabic" value="<%=billerNameAr %>">
				<input type="hidden" name="<portlet:namespace/>oldBillerNameEnglish" value="<%=billerNameEn %>">
				<input type="hidden" name="<portlet:namespace/>oldBillerCategoryId" value="<%=billerCategoryId %>">
				<input type="hidden" name="<portlet:namespace/>oldLabelNameArabic" value="<%=labelNameAr %>">
				<input type="hidden" name="<portlet:namespace/>oldLabelNameEnglish" value="<%=labelNameEn %>">
				<input type="hidden" name="<portlet:namespace/>oldPaymentType" value="<%=payementTypeId %>">
				<input type="hidden" name="<portlet:namespace/>oldAllowFixedValues" value="<%=allowedFixedValues %>">
				<input type="hidden" name="<portlet:namespace/>oldPaymentMinAmount" value="<%=paymentMinAmount %>">
				<input type="hidden" name="<portlet:namespace/>oldPaymentMaxAmount" value="<%=paymentMaxAmount %>">
				<input type="hidden" name="<portlet:namespace/>oldAllowedPaymentAmount" value="<%=allowedPaymentAmounts %>">
				<input type="hidden" name="<portlet:namespace/>oldPhotoLink" value="<%=photoLink %>">


		<fieldset <%= isDisabled ? "disabled" : "" %>>
				<div class="mb-3">
				<div class="mb-3">
					<label class="form-label">ID</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>id" 
					value="<%=id %>">
				<div class="mb-3">
					<label class="form-label">Biller category</label>
					<select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="custom-select" required
					name="<portlet:namespace/>billerCategoryId">				
					    <option value="">Choose...</option>
					    <%
							for (CategoryDTO category : categories) {
								String categoryIdStr = String.valueOf(category.getCategoryId());
								boolean isCatPendingInDropdown = pendingCategoryIds.contains(categoryIdStr);
								boolean isSelected = billerCategoryNameEn.equals(category.getCategoryNameEn());
						%>
					    <option value="<%= category.getCategoryId()%>" 
					    <%= isSelected ? "selected" : "" %>
					    ><%= category.getCategoryNameEn() %><%= (isCatPendingInDropdown && isSelected) ? " (Current - Pending Approval)" : "" %></option>
					    <% } %>
					 </select>
				</div>
				<div class="mb-3">
					<label class="form-label">Postpaid code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>postpaidcode" 
					value="<%=postPaidCode %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Prepaid code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>prepaidcode"
					value="<%=prePaidCode %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Biller name English</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>billerNameEnglish"
					value="<%=billerNameEn %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Biller name Arabic</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>billerNameArabic"
					value="<%=billerNameAr %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Payment type</label> 
					<select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="custom-select" name="<portlet:namespace/>paymentType" required>
					    <option value="">Choose...</option>
					    <%for(PaymentTypeDTO paymentType : paymentTypes){ 
					    	if(payementTypeId.equals(paymentType.getId())){
					    	}
					    
					    %>
					    <option value="<%= paymentType.getId()%>"
					    <%=payementTypeId.equals(String.valueOf(paymentType.getId())) ? "selected" : ""%>
					    ><%=paymentType.getType()%></option>
					    <%} %>
					 </select>
				</div>
				<div class="mb-3">
					<label class="form-label">Label name English</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>labelNameEnglish"
					value="<%=labelNameEn %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Label name Arabic</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>labelNameArabic"
					value="<%=labelNameAr %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Allow fixed values</label> 
					<br/>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="<portlet:namespace/>allowFixedValues" id="inlineRadio1"
					  <%=allowedFixedValues.equals("1")?"checked":"" %> value="1" onchange = "handleAllowFixedValueChange()">
					  <label class="form-check-label mx-2" for="inlineRadio1">Yes</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="<portlet:namespace/>allowFixedValues" id="inlineRadio2"
					  <%=allowedFixedValues.equals("2") ? "checked" :"" %> value="2" onchange = "handleAllowFixedValueChange()">
					  <label class="form-check-label mx-2" for="inlineRadio2">No</label>
					</div>
				</div>
				<div id = "fixedValueChange">
					<div class="mb-3">
						<label class="form-label">Payment min amount (optional)</label> 
						<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>paymentMinAmount"
						value="<%=paymentMinAmount %>">
					</div>
					<div class="mb-3">
						<label class="form-label">Payment max amount (optional)</label> 
						<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>paymentMaxAmount"
						value="<%=paymentMaxAmount %>">
					</div>
				</div>	
				<div class="mb-3">
						<label class="form-label">Allowed payment amount</label> 
						<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>allowedPaymentAmount"
						value="<%=allowedPaymentAmounts %>">
				</div>
							
				<div class="mb-3">
					<label class="form-label">Photo link</label> 
					<input type="hidden" id="<portlet:namespace/>serverURL"  name="<portlet:namespace/>serverURL" value="<%=serverURL%>">
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="<portlet:namespace/>photoLink" name="<portlet:namespace/>photoLink" value="<%=photoLink %>">
					<aui:button class="btn px-5 mr-3" name="chooseImage" value="Choose Image" />
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_update%>'"
						class="btn btn-secondary px-5 mr-3"><%= isDisabled ? "BACK" : "CANCEL" %></button>
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
				<h5 class="modal-title" id="exampleModalLongTitle">Update Biller</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this biller?</div>
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
		var form = document.querySelector('form[action="<%=updateBiller%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyUpdateModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset for update
	});
</script>

<script type="text/javascript">

	$('.custom-file-input').on('change', function(e) {
		var fileName = 'Choose file';
		if (e.target.files[0]) {
			fileName = e.target.files[0].name;
			$(this).next('.custom-file-label').html(fileName);
		} else {
			$(this).next('.custom-file-label').html(fileName);
		}
	})
	
	
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
<script>
function handleAllowFixedValueChange() {
    var radrio1 = document.getElementById("inlineRadio1").checked;
    var radrio2 = document.getElementById("inlineRadio2").checked;
    var fixedValueChange = document.getElementById("fixedValueChange");
    
    console.log(radrio1);
    console.log(radrio2);

    if (radrio1 === false) { // Fixed Value
    	fixedValueChange.style.display = "block";
	}else{
		fixedValueChange.style.display = "none";
		}
}

handleAllowFixedValueChange();
</script>