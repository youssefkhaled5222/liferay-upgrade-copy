<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.liferay.portal.kernel.language.Language"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="com.ejada.telemony.db.model.ResourceLocalization"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>




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
	String featuerName = (String) request.getAttribute("featuerName") != null
			? (String) request.getAttribute("featuerName")
			: "";
	String action = (String) request.getAttribute("action") != null
			? (String) request.getAttribute("action")
			: "add";

	List<String> languagesNames = (List<String>) request.getAttribute("languagesName") != null
			? (List<String>) request.getAttribute("languagesName")
			: new ArrayList<>();

	List<Feature> allFeatures = (List<Feature>) request.getAttribute("allFeatures") != null
			? (List<Feature>) request.getAttribute("allFeatures")
			: new ArrayList<>();

	String errorMsg = (String) request.getAttribute("errorMsg") != null
			? (String) request.getAttribute("errorMsg")
			: "";

	Map<String, String> nameValues = (Map<String, String>) request.getAttribute("nameValues") != null
			? (Map<String, String>) request.getAttribute("nameValues")
			: new HashMap<>();

	Map<String, String> attachfilesName = (Map<String, String>) request.getAttribute("attachfilesName") != null
			? (Map<String, String>) request.getAttribute("attachfilesName")
			: new HashMap<>();

	Map<String, String> attachValues = (Map<String, String>) request.getAttribute("attachValues") != null
			? (Map<String, String>) request.getAttribute("attachValues")
			: new HashMap<>();

	Map<String, String> descriptionValues = (Map<String, String>) request
			.getAttribute("descriptionValues") != null
					? (Map<String, String>) request.getAttribute("descriptionValues")
					: new HashMap<>();

	Map<String, String> routeIdValues = (Map<String, String>) request.getAttribute("routeIdValues") != null
			? (Map<String, String>) request.getAttribute("routeIdValues")
			: new HashMap<>();

	Map<String, String> urlValues = (Map<String, String>) request.getAttribute("urlValues") != null
			? (Map<String, String>) request.getAttribute("urlValues")
			: new HashMap<>();

	List<Feature> pages = (List<Feature>) request.getAttribute("pages") != null
			? (List<Feature>) request.getAttribute("pages")
			: new ArrayList<>();
	long selectedFeatureId = request.getAttribute("selectedFeatureId") != null
			? (Long) request.getAttribute("selectedFeatureId")
			: 0;
%>

<portlet:actionURL name="addResourceLocalized"
	var="addResourceLocalized">
	<portlet:param name="action" value="<%=String.valueOf(action)%>" />
	<portlet:param name="selectedResourceId"
		value="<%=String.valueOf(resourceId)%>" />
</portlet:actionURL>

<div>
	<h3 class="pb-4">Add New Resource</h3>
	<liferay-ui:error key="file-upload-error" message="File upload error" />
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="error" message="<%=errorMsg%>" />
	<div class="card">
		<div class="card-body">
			<form action="<%=addResourceLocalized%>" method="post"
				enctype="multipart/form-data"
				name="<portlet:namespace/>addUpdateResourceForm"
				id="<portlet:namespace/>addUpdateResourceForm">
				<fieldset <%= isOther ? "disabled" : "" %>>
				<% if (!pages.isEmpty()) { %>
				<div class="form-group row mb-4">
					<label for="pageSelect" class="col-auto col-form-label">Page</label>
					<div class="col-sm-3">
						<select class="form-control" id="pageSelect" name="<portlet:namespace/>selectedFeatureId">
							<% for (Feature featurePage : pages) { %>
								<option value="<%=featurePage.getEntityResourceId()%>" <%=featurePage.getEntityResourceId() == selectedFeatureId ? "selected" : ""%>><%=featurePage.getFeatureName()%></option>
							<% } %>
						</select>
					</div>
				</div>
				<% } %>
				<div class="mb-3">
					<label class="form-label">Resource Code</label> <input type="text"
						class="form-control" id="<portlet:namespace/>resourceCode"
						value="<%=resourceCode%>" name="<portlet:namespace/>resourceCode"
						required pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed.">
				</div>
				<div class="mb-3">
					<label class="form-label">Resource Type</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
						id="<portlet:namespace/>resourceType" class="custom-select"
						name="<portlet:namespace/>resourceType"
						onchange="showResourceType(this)" required>
						<option selected value="-1">Choose...</option>
						<option value="1" <%=resourceType.equals("1") ? "selected" : ""%>>URL</option>
						<option value="2" <%=resourceType.equals("2") ? "selected" : ""%>>Attachment</option>
						<option value="3" <%=resourceType.equals("3") ? "selected" : ""%>>Terms
							and Conditions</option>
					</select>
				</div>

				<div class="url-container"
					<%=resourceType.equals("1") ? "" : "style='display:none;' "%>>

					<div class="mb-3">

						<label class="form-label">Url Type</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
							class="custom-select" name="<portlet:namespace/>urlType"
							id="<portlet:namespace/>urlType" onchange="showUrlType(this)">
							<option selected value="-1">Choose...</option>
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
						<li><a data-toggle="tab" href="#URLTab<%=i%>"
							class="nav-link <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>
					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<div id="URLTab<%=i%>"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0">
							<div class="mb-3">
								<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
									name="<portlet:namespace/><%=languagesNames.get(i)%>urlName"
									id="<portlet:namespace/><%=languagesNames.get(i)%>urlName"
									value="<%=(nameValues.get(languagesNames.get(i)) != null)
							? nameValues.get(languagesNames.get(i))
							: ""%>"
									class="form-control">
							</div>

							<div class="mb-3 internal-type "
								<%=urlType.equals("1") ? "" : "style='display:none;' "%>>
								<label class="form-label">Featuer Type</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
									id="<portlet:namespace/><%=languagesNames.get(i)%>featuerName"
									name="<portlet:namespace/><%=languagesNames.get(i)%>featuerName"
									class="custom-select">
									<option value="-1">Choose...</option>
									<%
										for (int j = 0; j < allFeatures.size(); j++) {
													String featureRouteId = (String) request.getAttribute("featureRouteId") != null
															? (String) request.getAttribute("featureRouteId")
															: "";
									%>
									<option
										<%=(routeIdValues.get(languagesNames.get(i)) != null
								&& routeIdValues.get(languagesNames.get(i)).equals(allFeatures.get(j).getRouteId()))
										? "selected"
										: ""%>
										name="<portlet:namespace/><%=languagesNames.get(i)%>featureRouteId"
										value="<%=allFeatures.get(j).getRouteId()%>"><%=allFeatures.get(j).getFeatureName()%></option>

									<%
										}
									%>
								</select>
							</div>

							<div class="mb-3 external-type"
								<%=urlType.equals("2") ? "" : "style='display:none;' "%>>
								<label class="form-label">External Type</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
									id="<portlet:namespace/><%=languagesNames.get(i)%>url"
									name="<portlet:namespace/><%=languagesNames.get(i)%>url"
									value="<%=(urlValues.get(languagesNames.get(i)) != null) ? urlValues.get(languagesNames.get(i)) : ""%>"
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

				<div class="attachments-container"
					<%=resourceType.equals("2") ? "" : "style='display:none;' "%>>

					<%
						if (languagesNames.size() != 0) {
					%>
					<ul class="nav nav-tabs">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<li><a data-toggle="tab" href="#AttachTab<%=i%>"
							class="nav-link  <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>
					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<div id="AttachTab<%=i%>"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0">
							<div class="mb-3">
								<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
									name="<portlet:namespace/><%=languagesNames.get(i)%>attachName"
									id="<portlet:namespace/><%=languagesNames.get(i)%>attachName"
									value="<%=(nameValues.get(languagesNames.get(i)) != null)
							? nameValues.get(languagesNames.get(i))
							: ""%>"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Attachments</label>
								<div class="input-group">
									<div class="w-100">
										<input type="file" class="custom-file-input"
											onchange="$('.<%=languagesNames.get(i)%>lang-file-name').html(this.files[0].name)"
											name="<portlet:namespace/><%=languagesNames.get(i)%>attachFile"
											id="<portlet:namespace/><%=languagesNames.get(i)%>attachFile"
											value="<%=(attachValues.get(languagesNames.get(i)) != null)
							? attachValues.get(languagesNames.get(i))
							: ""%>" />
										<label
											class="custom-file-label <%=languagesNames.get(i)%>lang-file-name"
											name="<portlet:namespace/><%=languagesNames.get(i)%>custom-file-label"
											id="<portlet:namespace/><%=languagesNames.get(i)%>custom-file-label"
											for="inputGroupFile01"><%=(attachfilesName.get(languagesNames.get(i)) != null)
							? attachfilesName.get(languagesNames.get(i))
							: "Choose file"%> </label>
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

				<div class="termsandconditions-container"
					<%=resourceType.equals("3") ? "" : "style='display:none;' "%>>

					<%
						if (languagesNames.size() != 0) {
					%>

					<ul class="nav nav-tabs">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>
						<li><a data-toggle="tab" href="#TermsTab<%=i%>"
							class="nav-link <%=i == 0 ? "active" : ""%>"><%=languagesNames.get(i)%></a></li>
						<%
							}
						%>
					</ul>
					<div class="tab-content">
						<%
							for (int i = 0; i < languagesNames.size(); i++) {
						%>

						<div id="TermsTab<%=i%>"
							class="tab-pane fade in <%=i == 0 ? "active" : ""%> px-0">
							<div class="mb-3">
								<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
									name="<portlet:namespace/><%=languagesNames.get(i)%>termsCondName"
									id="<portlet:namespace/><%=languagesNames.get(i)%>termsCondName"
									value="<%=(nameValues.get(languagesNames.get(i)) != null)
							? nameValues.get(languagesNames.get(i))
							: ""%>"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label>
								<textarea class="form-control"
									id="<portlet:namespace/><%=languagesNames.get(i)%>descriptionValue"
									rows="3"
									name="<portlet:namespace/><%=languagesNames.get(i)%>descriptionValue"><%=(descriptionValues.get(languagesNames.get(i)) != null)
							? descriptionValues.get(languagesNames.get(i))
							: ""%></textarea>
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
				</fieldset>
				<div class="d-flex justify-content-end mt-3">
					<button type="button" class="btn btn-secondary px-5 mr-3"
						onclick="window.location.href='<%=back%>'"><%= (isOther || action.equals("view")) ? "BACK" : "CANCEL" %></button>
					<% if (!isOther && !action.equals("view")) { %>
					<button type="button" id="submitBtn" class="btn btn-primary px-5">SAVE</button>
					<% } %>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="modal hide fade" id="telemoneyAddUpdateModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyAddUpdateModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="addUpdateModalTitle"><%= action.equals("add") ? "Add Resource" : "Update Resource" %></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">
				<%= action.equals("add") ? "Are you sure you want to add this resource?" : "Are you sure you want to update this resource?" %>
			</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="addUpdateResourceConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var resourceType = '';
	var urlType = '';
	function showUrlType(select) {
		if (select.value == "1") {
			$('.internal-type').show();
			$('.external-type').hide();
		} else {
			$('.external-type').show();
			$('.internal-type').hide();
		}
		urlType = select.value;

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
		resourceType = select.value;
	}

	$('.custom-file-input').on('change', function(e) {
		var fileName = 'Choose file';
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

	function openAddUpdateModal() {
		$("#telemoneyAddUpdateModal").modal("show");
		$("#telemoneyAddUpdateModal").removeClass("hide");
	}

	function closeAddUpdateModal() {
		$("#telemoneyAddUpdateModal").modal("hide");
		$("#telemoneyAddUpdateModal").addClass("hide");
	}

	function addUpdateResourceConfirm() {
		$("#<portlet:namespace/>addUpdateResourceForm").submit();
	}

	$('#telemoneyAddUpdateModal').on('hidden.bs.modal', function(e) {
		// Modal dismissed, no action needed
	})
</script>
<style>
.nav-tabs a.active {
	border-bottom-color: #80acff !important;
	border-width: 3px;
}
</style>

<aui:script use="liferay-util-window,liferay-portlet-url">
var formValidator;
var namespace = "<portlet:namespace />";

$('#submitBtn').click(function() {
    if (formValidator) {
        formValidator.resetAllFields();
    }
    var languages = [ 
                        <c:forEach items="${languagesName}"
		var="language" varStatus="status"> 
                        "${language}"<c:if test="${!status.last}">,</c:if>
	</c:forEach>
    ];
    var selectedLanguageName = $(".attachments-container ul li a.active").text().trim();

    // Check if the selected language is English before proceeding
    if (selectedLanguageName === "English") {
        var rules = {};
        var fieldStrings = {};
        var uploadSize = true;
        var fileInputId = namespace + selectedLanguageName + 'attachFile';
        var fileInput = document.getElementById(fileInputId);
        var fileName = "";
        if (fileInput && fileInput.files.length > 0) {
            fileName = fileInput.files.item(0).name;
            var size = 0;
            for (var num1 = 0; num1 < fileInput.files.length; num1++) {
                var file = fileInput.files[num1];
                if (file.size > 10485760) { // 10 MB
                    fileInput.focus();
                    uploadSize = false;
                } else {
                    uploadSize = true;
                }
                size += file.size;
            }
        }

        // Define and use the form validator within the scope of the selected language condition
        AUI().use('aui-form-validator', function(A) {
            function validateFileExtension(fileInput, allowedExtensions) {
                if (fileInput && fileInput.files.length > 0) {
                    var fileNameEx = fileInput.files[0].name;
                    var fileExtension = fileNameEx.split('.').pop().toLowerCase();
                    return allowedExtensions.includes(fileExtension);
                }
                return true;
            }

            // Add custom validation rules and messages
            A.mix(A.config.FormValidator.RULES, {
                custDropDown: function(val, fieldNode, ruleValue) {
                    return (val != "-1");
                },
                uploadFileSize: function(val, fieldNode, ruleValue) {
                    return uploadSize;
                },
                acceptFiles: function(val, fieldNode, ruleValue) {
                    var allowedExtensions = ruleValue.split(',').map(function(ext) { return ext.trim().toLowerCase(); });
                    return validateFileExtension(fileInput, allowedExtensions);
                },
                checkFileName: function(val, fieldNode, ruleValue) {
                    var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
                    return regex.test(fileName);
                }
            }, true);

            A.mix(A.config.FormValidator.STRINGS, {
                custDropDown: Liferay.Language.get('required'),
                required: Liferay.Language.get('required'),
                uploadFileSize: '<liferay-ui:message
		key="uploadFileSize" />',
                checkFileName: '<liferay-ui:message key="checkFileName" />'
            }, true);

            // Other form validations based on resourceType and other conditions can be defined here similarly

            formValidator = new A.FormValidator({
                boundingBox: "#" + namespace + "addUpdateResourceForm",
                rules: rules,
                fieldStrings: fieldStrings,
                validateOnBlur: false,
                showAllMessages: true
            });

            formValidator.validate();
            if (!formValidator.hasErrors()) {
                openAddUpdateModal();
            } else {
                // Handle errors
            }
        });
    }else{
                openAddUpdateModal();
    }
});

</aui:script>