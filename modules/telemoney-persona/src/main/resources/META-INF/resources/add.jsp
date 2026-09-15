<%@page import="com.ejada.telemony.db.model.LovData"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.model.Themes"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<%
if (isOther) {
    response.getWriter().write("You are not authorized to access this page.");
    return;
}
%>

<portlet:renderURL var="cancel_Lang">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<portlet:actionURL name="personaCreate" var="personaCreate"></portlet:actionURL>

<%
	List<Themes> darkThemes = (List<Themes>) request.getAttribute("darkThemes") != null
			? (List<Themes>) request.getAttribute("darkThemes")
			: new ArrayList<>();
	List<Themes> lightThemes = (List<Themes>) request.getAttribute("lightThemes") != null
			? (List<Themes>) request.getAttribute("lightThemes")
			: new ArrayList<>();

	List<LovData> nationalities = request.getAttribute("nationalityList") != null
			&& ((List<LovData>) request.getAttribute("nationalityList")).size() != 0
					? (List<LovData>) request.getAttribute("nationalityList")
					: new ArrayList<>();

	Date dateFrom = new Date();
	Calendar startCalendar = Calendar.getInstance();
	startCalendar.setTime(dateFrom);
	int startYearPersona = startCalendar.get(Calendar.YEAR);
	int startMonthPersona = startCalendar.get(Calendar.MONTH);
	int startDayPersona = startCalendar.get(Calendar.DAY_OF_MONTH);

	Date dateTo = new Date();
	Calendar endCalendar = Calendar.getInstance();
	endCalendar.setTime(dateTo);
	int endYearPersona = endCalendar.get(Calendar.YEAR);
	int endMonthPersona = endCalendar.get(Calendar.MONTH);
	int endDayPersona = endCalendar.get(Calendar.DAY_OF_MONTH);
%>

<div>
	<h3 class="pb-4">Create New Persona</h3>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<div class="row">
		<div class="col-md-9">
			<div class="card">
				<div class="card-body">
					<form action="<%=personaCreate%>" method="post"
						id="personaCreateForm"
						onsubmit="return validateDates()">
						<div class="mb-3">
							<label class="form-label">Status</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="statusSelect" required
								name="<portlet:namespace/>status"
								onchange="toggleDateRange(this.value)">
								<option value="">Choose...</option>
								<option value="Active">Active</option>
								<option value="Deactive">Deactive</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								required class="form-control" id="name"
								name="<portlet:namespace/>name">
						</div>
						<div class="mb-3">
							<label class="form-label">Description</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								required class="form-control" id="description"
								name="<portlet:namespace/>description">
						</div>
						<div class="mb-3">
							<label class="form-label">Priority</label> <input type="number"
								required class="form-control" id="priority" min="0"
								oninput="validity.valid||(value='');"
								name="<portlet:namespace/>priority">
						</div>
						<div class="row">
							<div class="mb-3 col-md-4">
								<label class="form-label">Start Age</label> <input type="number"
									class="form-control" id="startAge" required min="0"
									oninput="validity.valid||(value='');"
									name="<portlet:namespace/>startAge">
							</div>
							<div class="mb-3 col-md-4">
								<label class="form-label">End Age</label> <input type="number"
									class="form-control" id="endAge" required min="0"
									oninput="validity.valid||(value='');"
									name="<portlet:namespace/>endAge">
							</div>
						</div>
						<div class="mb-3">
							<label class="form-label">Gender</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." required
								class="custom-select" id="gender"
								name="<portlet:namespace/>gender">
								<option value="">Choose...</option>
								<option value="MALE">MALE</option>
								<option value="FEMALE">FEMALE</option>
								<option value="BOTH">BOTH</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Nationality</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." required
								class="custom-select multi-select" multiple id="nationality"
								name="<portlet:namespace/>nationality">
							    <option value="All">All</option>
								<%
									for (LovData nationality : nationalities) {
								%>
								<option value="<%=nationality.getRecordDescription("English")%>">
									<%=nationality.getRecordDescription("English")%>
								</option>
								<!-- <option value="Egyptian">Egyptian</option>
								<option value="Palestinian">Palestinian</option>
								<option value="Indian">Indian</option> -->
								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Job Sector</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select multi-select" multiple id="sector" required
								name="<portlet:namespace/>sector">
								<option value="Employee">Employee</option>
								<option value="Retired">Retired</option>
								<option value="Unemployed">Unemployed</option>
 							    <option value="Student">Student</option>
						</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Income</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="incom" required
								name="<portlet:namespace/>incom">
								<option value="0-0">Default Range</option>
								<option value="500-999">500-999</option>
								<option value="1000-4999">1000-4999</option>
								<option value="5000-9999">5000-9999</option>
								<option value="10000-30000">10000-30000</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Segments</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select multi-select" multiple id="customerSegment"
								required name="<portlet:namespace/>customerSegment">
								<option value="CTLEM">TMMAS</option>
								<option value="0TELM">CATEL</option>
								<option value="0CASA">Current Account</option>
								<option value="00HHS">Household</option>
							    <option value="0PREP">Ratibi</option>
								<option value="Current ANB Accounts">Current ANB
									Accounts</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Light theme</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." required
								class="custom-select" id="inputGroupSelect01"
								name="<portlet:namespace/>lightThemeId">
								<option value="">Choose...</option>
								<%
									for (Themes light : lightThemes) {
								%>
								<option value="<%=light.getThemeId()%>"><%=light.getThemeEnName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Dark theme</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." required
								class="custom-select" id="inputGroupSelect01"
								name="<portlet:namespace/>darkThemeId">
								<option value="">Choose...</option>
								<%
									for (Themes dark : darkThemes) {
								%>
								<option value="<%=dark.getThemeId()%>"><%=dark.getThemeEnName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div>
							<h4>Date Range</h4>
							<div>Persona will be available on this range only:</div>
							<div class="row mb-3">
								<div class="col-md-4">
									<label class="form-label">From</label>
									<liferay-ui:input-date name="startDatePersona"
										yearValue="<%=startYearPersona%>"
										dayValue="<%=startDayPersona%>"
										monthValue="<%=startMonthPersona%>" />
								</div>
								<div class="col-md-4">
									<label class="form-label">To</label>
									<liferay-ui:input-date name="endDatePersona"
										yearValue="<%=endYearPersona%>" dayValue="<%=endDayPersona%>"
										monthValue="<%=endMonthPersona%>" />
								</div>
							</div>
						</div>
						<div class="d-flex justify-content-end">
							<button type="button"
								onclick="window.location.href='<%=cancel_Lang%>'"
								class="btn btn-secondary px-5 mr-3" name="cancelAction">CANCEL</button>
							<button type="button" class="btn btn-primary px-5" onclick="openCreateModal()">SAVE</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal hide fade" id="telemoneyCreateModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyCreateModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="createModalTitle">Create Persona</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to create this persona?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="createPersonaConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/multiselect-dropdown.js"></script>

<script>
	function openCreateModal() {
		var form = document.getElementById('personaCreateForm');
		if (!form.reportValidity()) {
			return;
		}
		if (validateDates()) {
			$("#telemoneyCreateModal").modal("show");
			$("#telemoneyCreateModal").removeClass("hide");
		}
	}

	function createPersonaConfirm() {
		document.getElementById('personaCreateForm').submit();
	}

	function toggleDateRange(status) {
		var fromDateInput = document
				.getElementById('<portlet:namespace/>startDatePersona');
		var toDateInput = document
				.getElementById('<portlet:namespace/>endDatePersona');

		if (status === 'Deactive') {
			fromDateInput.disabled = true;
			toDateInput.disabled = true;
			fromDateInput.value = ''; // Set the value to an empty string or null
			toDateInput.value = ''; // Set the value to an empty string or null
		} else {
			fromDateInput.disabled = false;
			toDateInput.disabled = false;
			fromDateInput.value = ''; // Set the value to an empty string or null
			toDateInput.value = ''; // Set the value to an empty string or null
		}
	}

	function validateDates() {
		var startDate = new Date(document
				.getElementById('<portlet:namespace/>startDatePersona').value);
		var endDate = new Date(document
				.getElementById('<portlet:namespace/>endDatePersona').value);

		if (startDate >= endDate) {
			alert('End date must be later than start date.');
			return false; // Prevent form submission
		}

		return true; // Allow form submission
	}
</script>
