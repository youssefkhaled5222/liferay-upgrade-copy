<%@page import="com.ejada.telemony.db.model.Languages"%>
<%@page import="com.ejada.telemony.db.model.LovData"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>

<%
if (!isAdministrator && !isPo) {
    // Redirect or show an error message
    response.getWriter().write("You are not authorized to access this page.");
    return;
}
%>

<portlet:actionURL name="addLanguage" var="addLanguage">
</portlet:actionURL>

<portlet:renderURL var="cancel_Lang">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<%
	List<LovData> langDatas = request.getAttribute("langList") != null
			&& ((List<LovData>) request.getAttribute("langList")).size() != 0
					? (List<LovData>) request.getAttribute("langList")
					: new ArrayList<>();

	List<Languages> existingLanguages = request.getAttribute("existingLanguages") != null
			&& ((List<Languages>) request.getAttribute("existingLanguages")).size() != 0
					? (List<Languages>) request.getAttribute("existingLanguages")
					: new ArrayList<>();
%>



<div>
	<h3 class="pb-4">Languages</h3>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<div class="card">
		<div class="card-body">
			<form action="<%=addLanguage%>" method="post">




				<%
					if (langDatas.size() != 0 && !langDatas.isEmpty() && langDatas != null) {
				%>
				<div class="mb-3">
					<label class="form-label">Language</label> <select
						class="custom-select" id="langName" required pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
						name="<portlet:namespace/>langName">
						<option value="">Choose...</option>
						<%
							for (LovData data : langDatas) {

									boolean isLanguageExisting = existingLanguages.stream()
											.anyMatch(lang -> lang.getLangName().equals(data.getRecordTypeCode()));
						%>
						<option value="<%=data.getRecordTypeCode()%>"
							<%=isLanguageExisting ? "disabled" : ""%>>
							<%=data.getRecordTypeCode()%>
						</option>
						<%
							}
						%>
					</select>

				</div>
				<div class="form-check d-flex align-items-center mb-3">
					<input class="form-check-input" type="checkbox"
						id="primaryLanguage" name="<portlet:namespace/>primaryLanguage" />
					<label class="form-check-label mx-2" for="primaryLanguage">Set
						as a primary language (can't be deleted later)</label>
				</div>
				<div class="d-flex justify-content-end">


					<button type="button"
						onclick="window.location.href='<%=cancel_Lang%>'"
						class="btn btn-secondary px-5  mr-3" name="cancelAction">CANCEL</button>
					<button type="submit" class="btn btn-primary px-5"
						name="saveAction">SAVE</button>

				</div>
				<%
					} else {
				%>
				<label class="form-label">Please insert Language in LOV with
					Code 001</label>
				<%
					}
				%>




			</form>
		</div>
	</div>
</div>

