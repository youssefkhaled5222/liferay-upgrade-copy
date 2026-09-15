<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<%
	List<String> languagesName = (List<String>) request.getAttribute("languagesNames") != null
			? (List<String>) request.getAttribute("languagesNames")
			: new ArrayList<>();

	String tabsName = String.join(",", languagesName);
	String errorMsg = (String) request.getAttribute("errorMsg") != null
			? (String) request.getAttribute("errorMsg")
			: "";
	String lovCode = (String) request.getAttribute("lovCode") != null
			? (String) request.getAttribute("lovCode")
			: "";
	List<String> localeLanguageNames = (List<String>) request.getAttribute("localeLanguageNames") != null
			? (List<String>) request.getAttribute("localeLanguageNames")
			: new ArrayList<>();
%>

<portlet:renderURL var="cancel_Lov">
	<portlet:param name="action" value="viewLovData" />
</portlet:renderURL>

<portlet:actionURL var="lovDataCreate" name="lovDataCreate">
</portlet:actionURL>
<div>
	<h3 class="pb-4">Add/Edit Data</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="duplicateCode" message="The Record Type Code already exists in this LOV." />
	<div class="card">
		<div class="card-body">
			<form id="lovDataAddForm" action="<%=lovDataCreate%>" method="post">
				<fieldset <%= isOther ? "disabled" : "" %>>
				<liferay-ui:error key="error"
					message="<%=errorMsg%>" />
				<div class="card">
					<div class="card-body">

						<%if(lovCode.equals("001")){ %>
						<div class="mb-3">
							<label class="form-label">Record Type Code:</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." required
								class="custom-select" id="inputGroupSelect01"
								name="<portlet:namespace/>recordTypeCode">
								<option value="">Choose...</option>
								<%
									for ( String langLocale : localeLanguageNames) {
								%>
								<option value="<%=langLocale%>"><%=langLocale%></option>
								<%
									}
								%>
							</select>
						</div>
						
						<%}else{ %>
						<div class="mb-3">
							<label for="recordTypeCode" class="form-label">Record
								Type Code:</label> <input class="form-control" type="text"
								id="recordTypeCode" name="<portlet:namespace/>recordTypeCode"
								required>
						</div>
						<%} %>

						<div class="mb-3">
							<label for="recordShortDescription" class="form-label">Record
								Short Description:</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								id="recordShortDescription" class="form-control" required
								name="<portlet:namespace/>recordShortDescription">
						</div>
						<%
							if (languagesName.size() != 0) {
						%>
						<liferay-ui:tabs names="<%=tabsName%>" refresh="false"
							value="${selectedTab}">
							<%
								for (int i = 0; i < languagesName.size(); i++) {
							%>

							<liferay-ui:section>

								<div class="mb-3">
									<label for="recordDescription" class="form-label">Record
										Description:</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" id="recordDescription"
										class="form-control"
										name="<portlet:namespace/><%=languagesName.get(i)%>descValue">
								</div>

							</liferay-ui:section>
							<%
								}
							%>
						</liferay-ui:tabs>
						<%
							} else {
						%>
						<div class="h3 p-4 mb-4 text-secondary text-dark text-center">No
							Languages found in current channel</div>
						<%
							}
						%>
						<div class="d-flex justify-content-end">
							<button type="button"
								onclick="window.location.href='<%=cancel_Lov%>'"
								class="btn btn-secondary px-5 mr-3">CANCEL</button>
							<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
						</div>
					</div>
				</div>
				</fieldset>
			</form>

		</div>
	</div>
</div>

<!-- Save Confirmation Modal -->
<div class="modal hide fade" id="telemoneySaveModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneySaveModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneySaveModalTitle">Confirm Save</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to save this LOV Data?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" onclick="confirmSave()">Save</button>
			</div>
		</div>
	</div>
</div>

<script>
	function openSaveModal() {
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function closeSaveModal() {
		$("#telemoneySaveModal").modal("hide");
		$("#telemoneySaveModal").addClass("hide");
	}

	function confirmSave() {
		document.getElementById('lovDataAddForm').submit();
		closeSaveModal();
	}
</script>

