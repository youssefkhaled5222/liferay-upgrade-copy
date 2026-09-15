<%@page import="com.ejada.telemony.db.model.LovData"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.model.Themes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page
	import="com.liferay.dynamic.data.lists.exception.RecordGroupIdException"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>

<%
if (isOther) {
    response.getWriter().write("You are not authorized to access this page.");
    return;
}

Boolean viewOnly = request.getAttribute("viewOnly") != null
		? (Boolean) request.getAttribute("viewOnly")
		: false;
%>

<portlet:renderURL var="cancel_Lang">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<portlet:actionURL name="personaUpdate" var="personaUpdate">
</portlet:actionURL>

<%
	Long channelId = (Long) request.getAttribute("channelId");
	int startAge = (int) request.getAttribute("startAge");
	int endAge = (int) request.getAttribute("endAge");
	String name = (String) request.getAttribute("name");

	String gender = (String) request.getAttribute("gender");
	String description = (String) request.getAttribute("description");
	String status = (String) request.getAttribute("status");
	String incom = (String) request.getAttribute("incom");

	Boolean defaultPersona = (Boolean) request.getAttribute("defaultPersona");

	int priority = (int) request.getAttribute("priority");

	String lightTheneName = request.getAttribute("lightTheneName") != null
			? (String) request.getAttribute("lightTheneName")
			: null;
	String darkTheneName = request.getAttribute("darkTheneName") != null
			? (String) request.getAttribute("darkTheneName")
			: null;

	Long darkThemeId = request.getAttribute("darkThemeId") != null
			? (Long) request.getAttribute("darkThemeId")
			: 0L;
	Long lightThemeId = request.getAttribute("lightThemeId") != null
			? (Long) request.getAttribute("lightThemeId")
			: 0L;
	List<Themes> darkThemes = request.getAttribute("darkThemes") != null
			? (List<Themes>) request.getAttribute("darkThemes")
			: new ArrayList<>();
	List<Themes> lightThemes = request.getAttribute("lightThemes") != null
			? (List<Themes>) request.getAttribute("lightThemes")
			: new ArrayList<>();

	Date dateFrom = (Date) request.getAttribute("dateFrom") != null
			? (Date) request.getAttribute("dateFrom")
			: null;
	Calendar startCalendar = Calendar.getInstance();
	Integer startYearPersona;
	Integer startMonthPersona;
	Integer startDayPersona;
	if (dateFrom != null) {
		startCalendar.setTime(dateFrom);
		startYearPersona = startCalendar.get(Calendar.YEAR);
		startMonthPersona = startCalendar.get(Calendar.MONTH);
		startDayPersona = startCalendar.get(Calendar.DAY_OF_MONTH);
	} else {

		startYearPersona = 0;
		startMonthPersona = 0;
		startDayPersona = 0;
	}

	Date dateTo = (Date) request.getAttribute("dateTo") != null ? (Date) request.getAttribute("dateTo") : null;
	Calendar endCalendar = Calendar.getInstance();
	Integer endYearPersona;
	Integer endMonthPersona;
	Integer endDayPersona;
	if (dateTo != null) {
		endCalendar.setTime(dateTo);
		endYearPersona = endCalendar.get(Calendar.YEAR);
		endMonthPersona = endCalendar.get(Calendar.MONTH);
		endDayPersona = endCalendar.get(Calendar.DAY_OF_MONTH);
	} else {

		endYearPersona = 0;
		endMonthPersona = 0;
		endDayPersona = 0;

	}

	String nationality = (String) request.getAttribute("nationality");
	JSONArray selectedNationalityJSON = JSONFactoryUtil.createJSONArray(
			nationality != null && nationality.startsWith("[") ? nationality : "[]");

	String customerSegment = request.getAttribute("customerSegment") != null
			? (String) request.getAttribute("customerSegment")
			: "";
	JSONArray selectedSegmentJSON = JSONFactoryUtil.createJSONArray(
			customerSegment.startsWith("[") ? customerSegment : "[]");

	String sector = (String) request.getAttribute("sector");
	JSONArray selectedSectorJSON = JSONFactoryUtil.createJSONArray(
			sector != null && sector.startsWith("[") ? sector : "[]");

	List<String> secValues = new ArrayList<>(Arrays.asList("Employee", "Retired", "Unemployed", "Student"));
	List<String> natValues = new ArrayList<>(
			Arrays.asList("Egyptian", "Saudi Arabian", "Palestinian", "Indian"));
	List<String> incomeValues = new ArrayList<>(
			Arrays.asList("500-999", "1000-4999", "5000-9999", "10000-30000"));
	List<String> profValues = new ArrayList<>(Arrays.asList("TMMAS", "CATEL", "Current Account", "Household","Ratibi"));
	Map<String, String> segmentValues = new HashMap<String, String>() {
		{
			put("TMMAS", "CTLEM");
			put("CATEL", "0TELM");
			put("Current Account", "0CASA");
			put("Household", "00HHS");
			put("Ratibi","0PREP");

		}
	};
	List<LovData> nationalities = request.getAttribute("nationalityList") != null
			&& ((List<LovData>) request.getAttribute("nationalityList")).size() != 0
					? (List<LovData>) request.getAttribute("nationalityList")
					: new ArrayList<>();
%>
<div>
	<h3 class="pb-4"><%= viewOnly ? "View Persona" : "Update Persona" %></h3>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<div class="row">
		<div class="col-md-9">
			<div class="card">
				<div class="card-body">
					<form action="<%=personaUpdate%>" method="post"
						id="personaUpdateForm"
						onsubmit="return validateDates()">
						<div class="mb-3">
							<label class="form-label">Status</label> <select
								class="custom-select" id="statusSelect" required
								onchange="toggleDateRange(this.value)"
								name="<portlet:namespace/>status">
								<option value="Active"
									<%=status.equals("Active") ? "selected" : ""%>>Active</option>
								<option value="Deactive"
									<%=status.equals("Deactive") ? "selected" : ""%>>Deactive</option>
							</select>
						</div>

						<div class="mb-3">
							<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="name" name="<portlet:namespace/>name"
								required value="<%=name%>"> <input type="hidden"
								class="form-control" id="name"
								name="<portlet:namespace/>channelId" value="<%=channelId%>">
						</div>
						<div class="mb-3">
							<label class="form-label">Description</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
								class="form-control" id="description" required
								name="<portlet:namespace/>description" value="<%=description%>">
						</div>
						<div class="mb-3">
							<label class="form-label"> Priority</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="number"
								class="form-control" id="priority" required min="0"
								oninput="validity.valid||(value='');"
								name="<portlet:namespace/>priority" value="<%=priority%>">
						</div>
						<div class="row">
							<div class="mb-3 col-md-4">
								<label class="form-label">Start Age</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="number"
									class="form-control" id="startAge" required min="0"
									oninput="validity.valid||(value='');"
									name="<portlet:namespace/>startAge" value="<%=startAge%>">
							</div>

							<div class="mb-3 col-md-4">
								<label class="form-label">End Age</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="number"
									class="form-control" id="endAge" required min="0"
									oninput="validity.valid||(value='');"
									name="<portlet:namespace/>endAge" value="<%=endAge%>">
							</div>
						</div>
						<div class="mb-3">
							<label class="form-label">Gender</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="inputGroupSelect01" required
								name="<portlet:namespace/>gender">
								<option value="MALE"
									<%=gender.equals("MALE") ? "selected" : ""%>>MALE</option>
								<option value="FEMAlE"
									<%=gender.equals("FEMAlE") ? "selected" : ""%>>FEMALE</option>
								<option value="BOTH"
									<%=gender.equals("BOTH") ? "selected" : ""%>>BOTH</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Nationality</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select multi-select" multiple id="nationality"
								required name="<portlet:namespace/>nationality">
								<%
									boolean isAllSelected = false;
									for (int i = 0; i < selectedNationalityJSON.length(); i++) {
										String sec = selectedNationalityJSON.getString(i);
										if (sec.equals("All"))
										{
											isAllSelected = true;
											break;
										}
									}
							%>
							<option value="All" <%=isAllSelected ? "selected" : ""%>>All</option>

							<%
									for (LovData data : nationalities) {
										boolean found = false;
										String nationalityName = data.getRecordDescription("English");
										for (int i = 0; i < selectedNationalityJSON.length(); i++) {
											String sec = selectedNationalityJSON.getString(i);
											if (sec.equals(nationalityName)) {
												found = true;
												break; // Element found, no need to continue searching
											}

										}
								%>
								<option value="<%=nationalityName%>"
									<%=(found) ? "selected" : ""%>><%=nationalityName%></option>

								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Job Sector</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select multi-select" multiple id="sector" required
								multiple name="<portlet:namespace/>sector">
								<%
									for (String s : secValues) {
										boolean found = false;
										for (int i = 0; i < selectedSectorJSON.length(); i++) {
											String sec = selectedSectorJSON.getString(i);
											if (sec.equals(s)) {
												found = true;
												break; // Element found, no need to continue searching
											}

										}
								%>
								<option value="<%=s%>" <%=(found) ? "selected" : ""%>><%=s%></option>

								<%
									}
								%>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Income</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="incom" required
								name="<portlet:namespace/>incom">
								<option value="0-0" <%=incom.equals("0-0") ? "selected" : ""%>>Default
									Range</option>
								<option value="500-999"
									<%=incom.equals("500-999") ? "selected" : ""%>>500-999</option>
								<option value="1000-4999"
									<%=incom.equals("1000-4999") ? "selected" : ""%>>1000-4999</option>
								<option value="5000-9999"
									<%=incom.equals("5000-9999") ? "selected" : ""%>>5000-9999</option>
								<option value="10000-30000"
									<%=incom.equals("10000-30000") ? "selected" : ""%>>10000-30000</option>

							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Segments</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select multi-select" multiple id="customerSegment"
								required name="<portlet:namespace/>customerSegment">
								<%
									for (String p : profValues) {
										boolean found = false;
										for (int i = 0; i < selectedSegmentJSON.length(); i++) {
											String seg = selectedSegmentJSON.getString(i);
											if (seg.equals(segmentValues.get(p))) {
												found = true;
												break; // Element found, no need to continue searching
											}

										}
								%>
								<option value="<%=segmentValues.get(p)%>"
									<%=(found) ? "selected" : ""%>><%=p%></option>

								<%
									}
								%>
							</select>
						</div>
						<input type="hidden" class="form-control" id="defaultPersona"
							name="<portlet:namespace/>defaultPersona"
							value="<%=defaultPersona%>">

						<div class="mb-3">
							<label class="form-label">Light theme</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="inputGroupSelect01" required
								name="<portlet:namespace/>lightThemeId">

								<%
									for (Themes light : lightThemes) {
								%>
								<option value="<%=light.getThemeId()%>"
									<%=(lightTheneName != null && lightTheneName.equals(light.getThemeEnName())) ? "selected" : ""%>>
									<%=light.getThemeEnName()%></option>
								<%
									}
								%>

							</select>
						</div>
						<div class="mb-3">
							<label class="form-label">Dark theme</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
								class="custom-select" id="inputGroupSelect01" required
								name="<portlet:namespace/>darkThemeId">

								<%
									for (Themes dark : darkThemes) {
								%>
								<option value="<%=dark.getThemeId()%>"
									<%=(darkTheneName != null && darkTheneName.equals(dark.getThemeEnName())) ? "selected" : ""%>>
									<%=dark.getThemeEnName()%></option>
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
									<%
										if (dateFrom != null) {
									%>
									<liferay-ui:input-date name="startDatePersona"
										yearValue="<%=startYearPersona.intValue()%>"
										dayValue="<%=startDayPersona.intValue()%>"
										monthValue="<%=startMonthPersona.intValue()%>" />

									<%
										} else {
									%>
									<liferay-ui:input-date name="startDatePersona" yearValue=""
										dayValue="" monthValue="" />
									<%
										}
									%>


								</div>
								<div class="col-md-4">
									<label class="form-label">To</label>
									<%
										if (dateTo != null) {
									%>
									<liferay-ui:input-date name="endDatePersona"
										yearValue="<%=endYearPersona.intValue()%>"
										dayValue="<%=endDayPersona.intValue()%>"
										monthValue="<%=endMonthPersona.intValue()%>" />

									<%
										} else {
									%>
									<liferay-ui:input-date name="endDatePersona" yearValue=""
										dayValue="" monthValue="" />
									<%
										}
									%>

								</div>
							</div>

						</div>
						<input type="hidden" id="originalStartDate"
							value="<%=startMonthPersona%>/<%=startDayPersona%>/<%=startYearPersona%>">
						<input type="hidden" id="originalEndDate"
							value="<%=endMonthPersona%>/<%=endDayPersona%>/<%=endYearPersona%>">

						<input type="hidden" id="statusElement" value="<%=status%>">



						<div class="d-flex justify-content-end">
							<% if (viewOnly) { %>
							<button type="button"
								onclick="window.location.href='<%=cancel_Lang%>'"
								class="btn btn-secondary px-5" name="backAction">BACK</button>
							<% } else { %>
							<button type="button"
								onclick="window.location.href='<%=cancel_Lang%>'"
								class="btn btn-secondary px-5  mr-3" name="cancelAction">CANCEL</button>
							<button type="button" class="btn btn-primary px-5" onclick="openUpdateModal()">SAVE</button>
							<% } %>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal hide fade" id="telemoneyUpdateModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyUpdateModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="updateModalTitle">Update Persona</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to update this persona?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="updatePersonaConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/multiselect-dropdown.js"></script>

<script>
	function toggleDateRange(status) {
		var fromDateInput = document
				.getElementById('<portlet:namespace/>startDatePersona');
		var toDateInput = document
				.getElementById('<portlet:namespace/>endDatePersona');
		var originalStartDateInput = document
				.getElementById('originalStartDate');
		var originalEndDateInput = document.getElementById('originalEndDate');

		if (status === 'Deactive') {
			fromDateInput.disabled = true;
			toDateInput.disabled = true;
			fromDateInput.value = ''; // Set the value to an empty string or null
			toDateInput.value = ''; // Set the value to an empty string or null
		} else {
			fromDateInput.disabled = false;
			toDateInput.disabled = false;

			// Format the date values to match the expected format (MM/DD/YYYY)
			var originalStartDate = originalStartDateInput.value.split("/");
			var originalEndDate = originalEndDateInput.value.split("/");

			// Check if the original date values are not "0/0/0001"
			if (originalStartDate[0] !== "0" || originalEndDate[0] !== "0") {
				// Adjust the month component (subtract 1 as months are zero-indexed in JavaScript)
				fromDateInput.value = (parseInt(originalStartDate[0], 10) + 1)
						+ "/" + originalStartDate[1] + "/"
						+ originalStartDate[2];
				toDateInput.value = (parseInt(originalEndDate[0], 10) + 1)
						+ "/" + originalEndDate[1] + "/" + originalEndDate[2];
			} else {
				// Set the value to an empty string or null if the original date values are "0/0/0001"
				fromDateInput.value = '';
				toDateInput.value = '';
			}
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

	function validateAge() {
		var startDate = document.getElementById('<portlet:namespace/>startAge');
		var endDate = document.getElementById('<portlet:namespace/>endAge');
		console.log(startDate);
		console.log(endDate);
		if (startDate >= endDate) {
			alert('End date must be later than start date.');
			return false; // Prevent form submission
		}

		return true; // Allow form submission
	}

	function validateAll() {
		return validateAge() && validateDates();
	}

	function openUpdateModal() {
		var form = document.getElementById('personaUpdateForm');
		if (!form.reportValidity()) {
			return;
		}
		if (validateDates()) {
			$("#telemoneyUpdateModal").modal("show");
			$("#telemoneyUpdateModal").removeClass("hide");
		}
	}

	function updatePersonaConfirm() {
		document.getElementById('personaUpdateForm').submit();
	}

	// Initial call to set the date range based on the initial status
	toggleDateRange(document.getElementById('statusElement').value);
</script>
