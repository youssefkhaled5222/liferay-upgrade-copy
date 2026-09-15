<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<portlet:actionURL name="lovListCreate" var="lovListCreate">
</portlet:actionURL>

<portlet:renderURL var="cancel_Lov">
	<portlet:param name="action" value="view" />
</portlet:renderURL>


<portlet:actionURL name="insertDataFromFile" var="insertDataFromFile">
</portlet:actionURL>

<%
	List<String> languagesName = (List<String>) request.getAttribute("languagesNames") != null
			? (List<String>) request.getAttribute("languagesNames")
			: new ArrayList<>();

	String tabsName = String.join(",", languagesName);

	String errorMsg = (String) request.getAttribute("errorMsg") != null
			? (String) request.getAttribute("errorMsg")
			: "";
%>


<div>
	
	<h3 class="pb-4" onclick="handleClick()">Add/Edit Types</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active" id="home-tab"
			data-toggle="tab" href="#home" role="tab" aria-controls="home"
			aria-selected="true">Form</a></li>
		<li class="nav-item" id="profile-tab" style="display: none;"><a
			class="nav-link" data-toggle="tab" href="#profile" role="tab"
			aria-controls="profile" aria-selected="false">CSV</a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="home" role="tabpanel"
			aria-labelledby="home-tab">

			<form action="<%=lovListCreate%>" method="post" id="lovAddForm">
				<fieldset <%= isOther ? "disabled" : "" %>>
				<liferay-ui:error key="error" message="<%=errorMsg%>" />
				<div class="card">
					<div class="card-body">
						<div class="mb-3">
							<label class="form-label">Type Code</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="code" name="<portlet:namespace/>code"
								required>
						</div>
						<div class="mb-3">
							<label class="form-label">Event Code</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="eventCode"
								name="<portlet:namespace/>eventCode" required>
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
									<label class="form-label">Type Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
										class="form-control" id=""
										name="<portlet:namespace/><%=languagesName.get(i)%>nameValue">
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
		<div class="tab-pane fade" id="profile" role="tabpanel"
			aria-labelledby="profile-tab">

			<div class="card">
				<div class="card-body">

					<form action="<%=insertDataFromFile%>" method="post"
						enctype="multipart/form-data">
						<fieldset <%= isOther ? "disabled" : "" %>>
						<label for="fileInput">Add Type Using a CSV file:</label>
						<div>
							<input type="file" id="fileInput" name="fileInputFieldName"
								class="btn btn-primary px-5 mr-3" accept=".csv" />
						</div>
						<br> <br>
						<div>
							<input type="submit" class="btn btn-primary px-5 mr-3"
								value="Upload" />
							<button type="button"
								onclick="window.location.href='<%=cancel_Lov%>'"
								class="btn btn-secondary px-5">cancel</button>
						</div>
						</fieldset>
					</form>
				</div>
			</div>
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
			<div class="modal-body text-5 text-center">Are you sure you want to save this LOV?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" onclick="confirmSave()">Save</button>
			</div>
		</div>
	</div>
</div>

<script>
	var clickCount = 0;

	function openSaveModal() {
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function closeSaveModal() {
		$("#telemoneySaveModal").modal("hide");
		$("#telemoneySaveModal").addClass("hide");
	}

	function confirmSave() {
		document.getElementById('lovAddForm').submit();
		closeSaveModal();
	}

	function handleClick() {
		clickCount++;

		if (clickCount === 1) {
			// Single click, start the timer for double click
			setTimeout(function() {
				if (clickCount === 1) {
					// It's a single click
					clickCount = 0;
				} else {
					// It's a double click
					toggleCsvTab();
				}
			}, 300); // Adjust the time here based on your preference
		}
	}

	function toggleCsvTab() {
		var csvTab = document.getElementById('profile-tab');
		var csvTabContent = document.getElementById('profile');
		if (csvTab.style.display === 'none') {
			csvTab.style.display = 'block';
			csvTabContent.style.display = 'block';
		} else {
			csvTab.style.display = 'none';
			csvTabContent.style.display = 'none';
		}

		// Reset the click count after handling the double click
		clickCount = 0;
	}
</script>
