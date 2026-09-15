<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL var="updateData" name="lovDataUpdate">
</portlet:actionURL>

<%
	Long lovId = (Long) request.getAttribute("lovId");
	String lovType = (String) request.getAttribute("lovType");
	String recordTypeCode = (String) request.getAttribute("recordTypeCode");
	String recordShortDescription = (String) request.getAttribute("recordShortDescription");

	Map<String, String> descValues = (Map<String, String>) request.getAttribute("descs") != null
			? (Map<String, String>) request.getAttribute("descs")
			: new HashMap<>();

	List<String> languagesName = (List<String>) request.getAttribute("languagesNames") != null
			? (List<String>) request.getAttribute("languagesNames")
			: new ArrayList<>();

	String tabsName = String.join(",", languagesName);
	
	String lovCode = (String) request.getAttribute("lovCode") != null
			? (String) request.getAttribute("lovCode")
			: "";
	List<String> localeLanguageNames = (List<String>) request.getAttribute("localeLanguageNames") != null
			? (List<String>) request.getAttribute("localeLanguageNames")
			: new ArrayList<>();

	// Check for pending version
	Boolean hasPendingVersionObj = (Boolean) request.getAttribute("hasPendingVersion");
	boolean hasPendingVersion = hasPendingVersionObj != null && hasPendingVersionObj;

	// Determine if editing should be disabled
	boolean isDisabled = isOther || hasPendingVersion;
%>

<portlet:renderURL var="cancel_Lov">
	<portlet:param name="action" value="viewLovData" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">
		<% if (hasPendingVersion) { %>
		View Data
		<span class="badge badge-warning ml-2" style="font-size: 0.65rem; vertical-align: middle; background-color: #f0ad4e;">
			Pending Approval - View Only
		</span>
		<% } else { %>
		Add/Edit Data
		<% } %>
	</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This LOV has a pending draft version and cannot be modified until it is approved or discarded." />
	<liferay-ui:error key="codeChanged" message="Record Type Code cannot be modified." />
	<div class="card">
		<div class="card-body">
			<form action="<%=updateData%>" method="post" id="lovDataForm" onsubmit="return validateForm()">
				<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%= hasPendingVersion %>" />
				<fieldset <%= isDisabled ? "disabled" : "" %>>
				<liferay-ui:error key="error">
				    The language named: <liferay-ui:message
						key="<%=recordTypeCode%>" /> was not found within the supported languages.
				</liferay-ui:error>
				<input type="hidden" id="lovId" value="<%=lovId%>"
					name="<portlet:namespace/>lovId"> <input type="hidden"
					id="lovType" value="<%=lovType%>"
					name="<portlet:namespace/>lovType">

				<%if(lovCode.equals("001")){ %>
					<div class="mb-3">
						<label for="typeCode" class="form-label">Record Type Code:</label>
						 	<select required disabled
								class="custom-select" id="inputGroupSelect01"
								name="<portlet:namespace/>recordTypeCode"
								style="background-color: #e9ecef;">
								<option pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." value="">Choose...</option>
								<%
									for ( String langLocale : localeLanguageNames) {
								%>
								<option value="<%=langLocale%>"
									<%=langLocale.equals(recordTypeCode) ? "selected" : "" %>>
									<%=langLocale%></option>
								<%
									}
								%>
							</select>
							<input type="hidden" name="<portlet:namespace/>recordTypeCode" value="<%=recordTypeCode%>">
					</div>
				<%}else{ %>
					<div class="mb-3">
						<label for="typeCode" class="form-label">Record Type Code:</label> <input
							type="text" required readonly class="form-control" id="recordTypeCode"
							value="<%=recordTypeCode%>"
							name="<portlet:namespace/>recordTypeCode"
							style="background-color: #e9ecef;">
					</div>	
				<%} %>
				<div class="mb-3">
					<label for="shortDescription" class="form-label"> record
						Short Description:</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" required
						class="form-control" id="recordShortDescription"
						value="<%=recordShortDescription%>"
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
							<label for="description" class="form-label">record
								Description:</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text" class="form-control" id=""
								name="<portlet:namespace/><%=languagesName.get(i)%>descValue"
								value="<%=descValues.get(languagesName.get(i))%>">
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
					<% if (!isDisabled) { %>
					<button type="button"
						onclick="window.location.href='<%=cancel_Lov%>'"
						class="btn btn-secondary px-5 mr-3">CANCEL</button>
					<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
					<% } else if (hasPendingVersion) { %>
					<button type="button"
						onclick="window.location.href='<%=cancel_Lov%>'"
						class="btn btn-secondary px-5 mr-3">BACK</button>
					<button type="button" class="btn btn-primary px-5" disabled title="Cannot save - pending approval">
						SAVE (Pending Approval)
					</button>
					<% } %>
				</div>


				</fieldset>
				<% if (isOther && !hasPendingVersion) { %>
				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_Lov%>'"
						class="btn btn-secondary px-5 mr-3">BACK</button>
				</div>
				<% } %>
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
			<div class="modal-body text-5 text-center">Are you sure you want to save these changes?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" onclick="confirmSave()">Save</button>
			</div>
		</div>
	</div>
</div>

<script>
	// Server-side validation protection against inspect element tampering
	var hasPendingVersion = <%= hasPendingVersion %>;

	function validateForm() {
		if (hasPendingVersion) {
			alert('Cannot save - this LOV has a pending approval.');
			return false;
		}
		return true;
	}

	function openSaveModal() {
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function closeSaveModal() {
		$("#telemoneySaveModal").modal("hide");
		$("#telemoneySaveModal").addClass("hide");
	}

	function confirmSave() {
		if (validateForm()) {
			document.getElementById('lovDataForm').submit();
		}
		closeSaveModal();
	}
</script>

