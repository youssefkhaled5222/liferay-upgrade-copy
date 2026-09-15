<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="createBillerCategory" var="createBillerCategory">
</portlet:actionURL>

<portlet:renderURL var="cancel_add">
	<portlet:param name="action" value="viewCategory" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">Biller category</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<div class="card">
		<div class="card-body">
			<form action="<%=createBillerCategory%>" method="post">			
				<fieldset <%= isOther ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Category Code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>categoryCode">
				</div>
				<div class="mb-3">
					<label class="form-label">Category name English</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>categoryNameEn">
				</div>
				<div class="mb-3">
					<label class="form-label">Category name Arabic</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id="" name="<portlet:namespace/>categoryNameAr">
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

<!-- Add Category Confirmation Modal -->
<div class="modal hide fade" id="telemoneyAddCategoryModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyAddCategoryModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Add Biller Category</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to add this biller category?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="confirmAdd()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function showAddConfirmation() {
		$("#telemoneyAddCategoryModal").modal("show");
		$("#telemoneyAddCategoryModal").removeClass("hide");
	}

	function confirmAdd() {
		var form = document.querySelector('form[action="<%=createBillerCategory%>"]');
		if (form) {
			form.submit();
		}
	}

	$('#telemoneyAddCategoryModal').on('hidden.bs.modal', function(e) {
		// Nothing to reset
	});
</script>
