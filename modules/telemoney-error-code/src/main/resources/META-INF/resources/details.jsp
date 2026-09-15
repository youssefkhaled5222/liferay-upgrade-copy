<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemoney.error.code.portlet.LanguageDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
 String statusCode = (String)request.getAttribute("statusCode") != null
			? (String) request.getAttribute("statusCode")
			: "";
			
 String language = (String)request.getAttribute("language") != null
			? (String) request.getAttribute("language")
			: "";
			
 String description = (String)request.getAttribute("description") != null
			? (String) request.getAttribute("description")
			: "";
			
 List<LanguageDTO> langs =  request.getAttribute("records") != null
			? (List<LanguageDTO>) request.getAttribute("records")
			: new ArrayList();

 Boolean hasPendingVersion = (Boolean) request.getAttribute("hasPendingVersion");
 if (hasPendingVersion == null) {
     hasPendingVersion = false;
 }
 boolean isLocked = isOther || hasPendingVersion;
%>

<portlet:actionURL name="updateErrorCode" var="updateErrorCode">
</portlet:actionURL>

<portlet:renderURL var="cancel_update">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">Error code details</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />	
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This error code has a pending version and cannot be modified." />

	<% if (hasPendingVersion) { %>
	<div class="alert alert-warning" role="alert">
		<strong>Pending Approval:</strong> This error code has a pending version awaiting approval and cannot be modified.
	</div>
	<% } %>

	<div class="card">
		<div class="card-body">
			<form action="<%=updateErrorCode%>" method="post" name="<portlet:namespace/>updateForm" id="<portlet:namespace/>updateForm">
				
				<!-- Hidden fields for old values -->
				<input type="hidden" name="<portlet:namespace/>oldStatusCode" value="<%=statusCode%>">
				<input type="hidden" name="<portlet:namespace/>oldLanguage" value="<%=language%>">
				<input type="hidden" name="<portlet:namespace/>oldDescription" value="<%=description%>">


				<fieldset <%= isLocked ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Status Code</label> 
					<input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control"  
					name="<portlet:namespace/>statusCode" value= "<%=statusCode %>">
				</div>
				<div class="mb-3">
					<label class="form-label">Languages</label> 
					<select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-control" id="" name="<portlet:namespace/>language">
						<%
							for(LanguageDTO lang:langs){
						%>
				      <option value="<%=lang.getLanguageCode()%>"
				      		  <%=lang.getLanguageCode().equals(language) ? "selected" : ""%>>
				      	<%=lang.getLanguageCode() %>
				      </option>
				     
				      <%} %>
				    </select>				
				</div>
				<div class="mb-3">
					<label class="form-label">Description</label> 
					<textarea pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." class="form-control" id="" rows="7" name="<portlet:namespace/>description"><%= description%></textarea>
				</div>
				</fieldset>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_update%>'"
						class="btn btn-secondary px-5 mr-3"><%= isLocked ? "BACK" : "CANCEL" %></button>
					<% if (!isLocked) { %>
					<button type="button" class="btn btn-primary px-5" onclick="openModal()">UPDATE</button>
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
				<h5 class="modal-title" id="exampleModalLongTitle">Update Error Code</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to update this error code?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="submitUpdate()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function openModal() {
		$("#telemoneyUpdateModal").modal("show");
		$("#telemoneyUpdateModal").removeClass("hide");
	}

	function closeModal() {
		$("#telemoneyUpdateModal").modal("hide");
		$("#telemoneyUpdateModal").addClass("hide");
	}

	function submitUpdate() {
		document.getElementById('<portlet:namespace/>updateForm').submit();
	}
</script>