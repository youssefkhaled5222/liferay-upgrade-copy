<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="updateBillerCategory" var="updateBillerCategory">
</portlet:actionURL>

<portlet:renderURL var="cancel_add">
	<portlet:param name="action" value="viewCategory" />
</portlet:renderURL>


<%
String categoryID  = (String)request.getAttribute("categoryID");
String categoryNameAr  = (String)request.getAttribute("categoryNameAr");
String categoryNameEn  = (String)request.getAttribute("categoryNameEn");
String categoryCode  = (String)request.getAttribute("categoryCode");

// Get hasPendingVersion flag from request
Boolean hasPendingVersionObj = (Boolean)request.getAttribute("hasPendingVersion");
boolean hasPendingVersion = hasPendingVersionObj != null ? hasPendingVersionObj : false;

// Disable editing if pending version exists or if user is "other" role
boolean isDisabled = isOther || hasPendingVersion;
%>
<div>
	<h3 class="pb-4">Biller category</h3>
	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This category has a pending change awaiting approval. Editing is disabled until the change is approved or rejected.
	</div>
	<% } %>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This biller has a pending version awaiting approval and cannot be modified." />

	<div class="card">
		<div class="card-body">
			<form action="<%=updateBillerCategory%>" method="post">
				<!-- Hidden fields for old values -->
				<input type="hidden" name="<portlet:namespace/>oldCategoryNameAr" value="<%=categoryNameAr%>">
				<input type="hidden" name="<portlet:namespace/>oldCategoryNameEn" value="<%=categoryNameEn%>">


				<fieldset <%= isDisabled ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Category ID</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="<portlet:namespace/>catId"   
					name="<portlet:namespace/>catId" value="<%=categoryID%>" readonly>
					<% System.out.print(categoryID);%>
				</div>
				<div class="mb-3">
					<label class="form-label">Category name English</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="<portlet:namespace/>categoryNameEn"
					 name="<portlet:namespace/>categoryNameEn" value="<%=categoryNameEn%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Category name Arabic</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="<portlet:namespace/>categoryNameAr"
					name="<portlet:namespace/>categoryNameAr" value="<%=categoryNameAr%>">
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_add%>'"
						class="btn btn-secondary px-5 mr-3"><%= isDisabled ? "BACK" : "CANCEL" %></button>
					<% if (!isDisabled) { %>
					<button type="button" class="btn btn-primary" onclick="showUpdateConfirmation()">Update</button>
					<% } %>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Update Category Confirmation Modal -->
<div class="modal hide fade" id="telemoneyUpdateCategoryModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyUpdateCategoryModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Update Biller Category</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this biller category?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="confirmUpdate()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function showUpdateConfirmation() {
		$("#telemoneyUpdateCategoryModal").modal("show");
		$("#telemoneyUpdateCategoryModal").removeClass("hide");
	}

	function confirmUpdate() {
		var form = document.querySelector('form[action="<%=updateBillerCategory%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyUpdateCategoryModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset
	});
</script>
