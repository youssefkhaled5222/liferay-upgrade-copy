<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.ejada.telemony.db.model.ResourceLocalization"%>

<portlet:renderURL var="back">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<%
	Long resourceId = (Long) request.getAttribute("resourceId") != null
			? (Long) request.getAttribute("resourceId")
			: 1;

	String resourceCode = (String) request.getAttribute("resourceCode") != null
			? (String) request.getAttribute("resourceCode")
			: "";
	String resourceType = (String) request.getAttribute("resourceType") != null
			? (String) request.getAttribute("resourceType")
			: "";
	String urlType = (String) request.getAttribute("urlType") != null
			? (String) request.getAttribute("urlType")
			: "";
	String action = (String) request.getAttribute("action") != null
			? (String) request.getAttribute("action")
			: "add";

	List<ResourceLocalization> resourceLocalized = (List<ResourceLocalization>) request
			.getAttribute("resourceLocalization") != null
					? (List<ResourceLocalization>) request.getAttribute("resourceLocalization")
					: new ArrayList<>();

	List<String> languagesNames = (List<String>) request.getAttribute("languagesName") != null
			? (List<String>) request.getAttribute("languagesName")
			: new ArrayList<>();

			
%>

<portlet:actionURL name="addResourceLocalized"
	var="addResourceLocalized">
	<portlet:param name="action" value="<%=String.valueOf(action)%>" />
	<portlet:param name="selectedResourceId"
		value="<%=String.valueOf(resourceId)%>" />
</portlet:actionURL>

<div>
	<h3 class="pb-4">Add New Resource</h3>
	<div class="card">
		<div class="card-body">
			<form action="<%=addResourceLocalized%>" method="post">
				<div class="mb-3">
					<label class="form-label">Resource Code</label> <input type="text"
						class="form-control" id="resourceCode"
						name="<portlet:namespace/>resourceCode">
				</div>
				<div class="mb-3">
					<label class="form-label">Resource Type</label> <select
						class="custom-select" name="<portlet:namespace/>resourceType"
						onchange="showResourceType(this)">
						<option selected>Choose...</option>
						<option value="1" <%=resourceType.equals("1") ? "selected" : ""%>>URL</option>
						<option value="2" <%=resourceType.equals("2") ? "selected" : ""%>>Attachment</option>
						<option value="3" <%=resourceType.equals("3") ? "selected" : ""%>>Terms
							and Conditions</option>
					</select>
				</div>

				<div class="url-container" style="display: none;">

					<div class="mb-3">
						<label class="form-label">Url Type</label> <select
							class="custom-select" name="<portlet:namespace/>urlType"
							onchange="showUrlType(this)">
							<option>Choose...</option>
							<option value="1" <%=urlType.equals("1") ? "selected" : ""%>>internal
								URL</option>
							<option value="2" <%=urlType.equals("2") ? "selected" : ""%>>external
								URL</option>
						</select>
					</div>

					<%
						if (languagesNames.size() != 0) {
					%>

					<ul class="nav nav-tabs">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<li><a data-toggle="tab"
							href="#<%=languagesNames.get(i)%>URL"
							class="nav-link <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>
					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
									String routeIdValue = (String) request
											.getAttribute("routeIdValue") != null
													? (String) request.getAttribute("routeIdValue")
													: "";
						%>
						<div id="<%=languagesNames.get(i)%>URL"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0">
							<div class="mb-3">
								<label class="form-label">Name</label> <input type="text"
									name="<portlet:namespace/><%=languagesNames.get(i)%>urlName"
									id="urlName_<%=i%>"
									value="<%=(resourceLocalized.size() != 0)
							? (resourceLocalized.get(i) != null ? resourceLocalized.get(i).getName() : "")
							: ""%>"
									class="form-control">
							</div>
							<div class="mb-3 internal-type" style="display: none;">
								<label class="form-label">Internal Type</label> <select
									name="<portlet:namespace/><%=languagesNames.get(i)%>routeId"
									class="custom-select">
									<option selected>Choose...</option>
									<option value="1"
										<%=routeIdValue.equals("1") ? "selected" : ""%>>One</option>
									<option value="2"
										<%=routeIdValue.equals("2") ? "selected" : ""%>>Two</option>
									<option value="3"
										<%=routeIdValue.equals("3") ? "selected" : ""%>>Three</option>
								</select>
							</div>
							<div class="mb-3 external-type" style="display: none;">
								<label class="form-label">External Type</label> <input
									id="url_<%=i%>"
									name="<portlet:namespace/><%=languagesNames.get(i)%>url"
									value="<%=(resourceLocalized.size() != 0)
							? (resourceLocalized.get(i) != null
									? resourceLocalized.get(i).getUrl()
									: "")
							: ""%>"
									type="text" class="form-control">
							</div>
						</div>

						<%
							}
						%>
					</div>


					<%
						}
					%>


				</div>

				<div class="attachments-container" style="display: none;">

					<%
						if (languagesNames.size() != 0) {
					%>
					<ul class="nav nav-tabs">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<li><a data-toggle="tab"
							href="#<%=languagesNames.get(i)%>Attach"
							class="nav-link  <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>
					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<div id="<%=languagesNames.get(i)%>Attach"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0">
							<div class="mb-3">
								<label class="form-label">Name</label> <input type="text"
									name="<portlet:namespace/><%=languagesNames.get(i)%>attachName"
									value="<%=(resourceLocalized.size() != 0)
							? (resourceLocalized.get(i) != null ? resourceLocalized.get(i).getName() : "")
							: ""%>"
									class="form-control" id="attachName_<%=i%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Attachments</label>
								<div class="input-group">
									<div class="custom-file">
										<input type="file" class="custom-file-input"
											name="<portlet:namespace/><%=languagesNames.get(i)%>attachFile"
											id="attachFile_<%=i%>"> <label
											class="custom-file-label" for="inputGroupFile01">Choose
											file</label>
									</div>
								</div>
							</div>
						</div>
						<%
							}
						%>

					</div>
					<%
						}
					%>
				</div>

				<div class="termsandconditions-container" style="display: none;">

					<%
						if (languagesNames.size() != 0) {
					%>

					<ul class="nav nav-tabs">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<li><a data-toggle="tab"
							href="#<%=languagesNames.get(i)%>TermsCond"
							class="nav-link <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>
					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<div id="<%=languagesNames.get(i)%>TermsCond"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0">

							<div class="mb-3">
								<label class="form-label">Name</label> <input type="text"
									name="<portlet:namespace/><%=languagesNames.get(i)%>termsCondName"
									value="<%=(resourceLocalized.size() != 0)
							? (resourceLocalized.get(i) != null ? resourceLocalized.get(i).getName() : "")
							: ""%>"
									class="form-control" id="termsCondName_<%=i%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label>
								<textarea class="form-control" id="descriptionValue" rows="3"
									name="<portlet:namespace/><%=languagesNames.get(i)%>descriptionValue">
								<%=(resourceLocalized.size() != 0)
							? (resourceLocalized.get(i) != null ? resourceLocalized.get(i).getDescription() : "")
							: ""%>
								</textarea>
							</div>

						</div>
						<%
							}
						%>
					</div>
					<%
						}
					%>
				</div>

				<div class="d-flex justify-content-end mt-3">
					<button type="submit" class="btn btn-primary px-5 mr-3">Update</button>
					<button type="button" class="btn btn-secondary px-5">Cancel</button>
					<button type="button" class="btn btn-secondary px-5"
						onclick="window.location.href='<%=back%>'">Back</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	function showUrlType(select) {
		if (select.value == "1") {
			$('.internal-type').show();
			$('.external-type').hide();
		} else {
			$('.external-type').show();
			$('.internal-type').hide();
		}
	}

	function showResourceType(select) {

		if (select.value == "1") {
			$('.url-container').show();
			$('.attachments-container').hide();
			$('.termsandconditions-container').hide();
		} else if (select.value == "2") {
			$('.attachments-container').show();
			$('.url-container').hide();
			$('.termsandconditions-container').hide();
		} else {
			$('.termsandconditions-container').show();
			$('.url-container').hide();
			$('.attachments-container').hide();
		}
	}

	$('.custom-file-input').on('change', function(e) {
		var fileName = 'Choose file';
		console.log(e.target.files)
		if (e.target.files[0]) {
			fileName = e.target.files[0].name;
			$(this).next('.custom-file-label').html(fileName);
		} else {
			$(this).next('.custom-file-label').html(fileName);
		}
	})
	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	})
</script>
<style>
.nav-tabs a.active {
	border-bottom-color: #80acff !important;
	border-width: 3px;
}
</style>
