<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>

<%
if (!isAdministrator && !isPo) {
    // Redirect or show an error message
    response.getWriter().write("You are not authorized to access this page.");
    return;
}
%>

<portlet:actionURL name="languageUpdate" var="languageUpdate">
</portlet:actionURL>

<portlet:renderURL var="cancel_Lang">
<portlet:param name="action" value="view" />
</portlet:renderURL>

<%
String langName = (String)request.getAttribute("name");
String local = (String)request.getAttribute("local");
Long channelId = (Long)request.getAttribute("channelId");
%>



<div>
	<h3 class="pb-4">Languages</h3>
	<div class="card">
		<div class="card-body">
			<form action="<%=languageUpdate%>" method="post">
				<div class="mb-3">
					<label class="form-label">Language</label> 
					<input type="text"
						class="form-control" id="langName"
						name="<portlet:namespace/>langName"
						 value="<%=langName%>">
				</div>
				<div class="mb-3">
					<label class="form-label">Locale</label> 
					<input type="text"
						required
						class="form-control" id="local" 
						name="<portlet:namespace/>local"
						value="<%=local%>">
						
						<input type="hidden"
						
						class="form-control" id="channelId" 
						name="<portlet:namespace/>channelId"
						value="<%=channelId%>">
				</div>
				
				<div class="d-flex justify-content-end">

					<button type="submit" class="btn btn-primary px-5 mr-3" name="saveAction">save</button>
					<button type="button" onclick="window.location.href='<%=cancel_Lang%>'"  class="btn btn-secondary px-5" name="cancelAction">cancel</button>

				</div>
			</form>
		</div>
	</div>
</div>