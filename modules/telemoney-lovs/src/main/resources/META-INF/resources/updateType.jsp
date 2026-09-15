<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL var="updateType" name="lovListUpdate">
</portlet:actionURL>

<portlet:renderURL var="cancel_Lov">
	<portlet:param name="action" value="view" />
</portlet:renderURL>
<%
	String name = (String) request.getAttribute("name");
	String arName = (String) request.getAttribute("arName");
	String code = (String) request.getAttribute("code");
	Long channelId = (Long) request.getAttribute("channelId");
	String eventCode = (String) request.getAttribute("eventCode");

	List<String> languagesName = (List<String>) request.getAttribute("languagesNames") != null
			? (List<String>) request.getAttribute("languagesNames")
			: new ArrayList<>();

	Map<String, String> nameValues = (Map<String, String>) request.getAttribute("Names") != null
			? (Map<String, String>) request.getAttribute("Names")
			: new HashMap<>();

	String tabsName = String.join(",", languagesName);

	// Check for pending version
	Boolean hasPendingVersionObj = (Boolean) request.getAttribute("hasPendingVersion");
	boolean hasPendingVersion = hasPendingVersionObj != null && hasPendingVersionObj;

	// Determine if editing should be disabled
	boolean isDisabled = isOther || hasPendingVersion;
%>



<div>
	<h3 class="pb-4">
		<% if (hasPendingVersion) { %>
		View Type
		<span class="badge badge-warning ml-2" style="font-size: 0.65rem; vertical-align: middle; background-color: #f0ad4e;">
			Pending Approval - View Only
		</span>
		<% } else { %>
		Add/Edit Types
		<% } %>
	</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This LOV has a pending draft version and cannot be modified until it is approved or discarded." />
	<liferay-ui:error key="codeChanged" message="Type Code cannot be modified." />


	<div class="card">
		<div class="card-body">
			<form action="<%=updateType%>" method="post" id="lovTypeForm" onsubmit="return validateForm()">
				<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%= hasPendingVersion %>" />
				<fieldset <%= isDisabled ? "disabled" : "" %>>
				<div class="mb-3">
					<label class="form-label">Type Code</label> <input type="text"
						class="form-control" id="code" required readonly
						name="<portlet:namespace/>code" value="<%=code%>"
						style="background-color: #e9ecef;">
				</div>

				<div class="mb-3">
					<label class="form-label">Event Code</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
						class="form-control" id="eventCode" required
						name="<portlet:namespace/>eventCode" value="<%=eventCode%>">
				</div>


				<input type="hidden" class="form-control" id="channelId"
					name="<portlet:namespace/>channelId" value="<%=channelId%>">

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
							<label class="form-label">Type Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id=""
								name="<portlet:namespace/><%=languagesName.get(i)%>nameValue"
								value="<%=nameValues.get(languagesName.get(i))%>">
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
					<% } else { %>
					<button type="button"
						onclick="window.location.href='<%=cancel_Lov%>'"
						class="btn btn-secondary px-5 mr-3">BACK</button>
					<% } %>
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
			document.getElementById('lovTypeForm').submit();
		}
		closeSaveModal();
	}
</script>

