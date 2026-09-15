<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>

<%
if (!isAdministrator) {
    // Redirect or show an error message
    response.getWriter().write("You are not authorized to access this page.");
    return;
}
%>

<portlet:actionURL var="addChannel" name="addChannel">
</portlet:actionURL>
<portlet:renderURL var="backToview">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">Add Channel</h3>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<div class="card">
		<div class="card-body">
			<form method="post" action="<%=addChannel%>"
				name="<portlet:namespace/>addChannel">
				<div class="mb-3">
					<label class="form-label">Channel</label> <input type="text"
						class="form-control" id="<portlet:namespace />channelName"
						name="<portlet:namespace />channelName" required pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed.">
				</div>
				<div class="mb-3">
					<label class="form-label">Type</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
						class="custom-select" id="inputGroupSelect01"
						name="<portlet:namespace />channelType">
						<option selected>Choose...</option>
						<option value="0">Mobile</option>
						<option value="1">Web</option>
						
					</select>
				</div>
				<div class="mb-3">
					<label class="form-label">English Description</label>
					<textarea class="form-control" id="" rows="3"
						name="<portlet:namespace />channelEnDesc" required pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."></textarea>
				</div>
				<div class="mb-3">
					<label class="form-label">Arabic Description</label>
					<textarea class="form-control" id="" rows="3" required pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."></textarea>
				</div>
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-secondary px-5 mr-3"
						onclick="window.location.href='<%=backToview%>'">CANCEL</button>
					<button type="submit" class="btn btn-primary px-5">SAVE</button>
				</div>
			</form>
		</div>
	</div>
</div>