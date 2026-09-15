<%@page import="com.ejada.telemony.db.model.Feature"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<%
if (isOther) {
    response.getWriter().write("You are not authorized to access this page.");
    return;
}
%>

<%
	List<String> languagesName = (List<String>) request.getAttribute("languagesNames") != null
			? (List<String>) request.getAttribute("languagesNames")
			: new ArrayList<>();
	List<Feature> features = (List<Feature>) request.getAttribute("features") != null
			? (List<Feature>) request.getAttribute("features")
			: new ArrayList<>();
	Map<String, String> titleValues = (Map<String, String>) request.getAttribute("titleValues") != null
			? (Map<String, String>) request.getAttribute("titleValues")
			: new HashMap<>();
	Map<String, String> descValues = (Map<String, String>) request.getAttribute("descValues") != null
			? (Map<String, String>) request.getAttribute("descValues")
			: new HashMap<>();
	Map<String, String> bannerImages = (Map<String, String>) request.getAttribute("bannerImages") != null
			? (Map<String, String>) request.getAttribute("bannerImages")
			: new HashMap<>();
	Map<String, String> imageOverlays = (Map<String, String>) request.getAttribute("imageOverlays") != null
			? (Map<String, String>) request.getAttribute("imageOverlays")
			: new HashMap<>();
	Map<String, String> links = (Map<String, String>) request.getAttribute("links") != null
			? (Map<String, String>) request.getAttribute("links")
			: new HashMap<>();
	Map<String, String> urls = (Map<String, String>) request.getAttribute("urls") != null
			? (Map<String, String>) request.getAttribute("urls")
			: new HashMap<>();
	String bannerName = (String) request.getAttribute("bannerName") != null
			? (String) request.getAttribute("bannerName")
			: "";
	String status = (String) request.getAttribute("status") != null
			? (String) request.getAttribute("status")
			: "";
	Long bannerContentId = (Long) request.getAttribute("bannerContentId") != null
			? (Long) request.getAttribute("bannerContentId")
			: 0;
	String tabsName = String.join(",", languagesName);
	Long bannerId = (Long) request.getAttribute("bannerId") != null
			? (Long) request.getAttribute("bannerId")
			: ParamUtil.getLong(request, "bannerId", 0);
	boolean hasPendingVersion = request.getAttribute("hasPendingVersion") != null
			? (boolean) request.getAttribute("hasPendingVersion")
			: false;
%>

<portlet:actionURL name="getBannerIdForView" var="back">
	<portlet:param name="selectedBannerId"
		value="<%=String.valueOf(bannerId)%>" />
</portlet:actionURL>

<portlet:actionURL name="addContent" var="addContent">
	<portlet:param name="selectedBannerId"
		value="<%=String.valueOf(bannerId)%>" />
	<portlet:param name="bannerContentId"
		value="<%=String.valueOf(bannerContentId)%>" />
</portlet:actionURL>

<style>
.banner-ovelay {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 100;
}
</style>
<h3 class="pb-4">Add/Edit Content</h3>
<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
<liferay-ui:error key="hasPendingVersion" message="This banner has changes pending approval. You cannot add or modify content until the pending changes are reviewed." />
<div class="card">
	<div class="card-body">
		<form method="post" action="<%=addContent%>" id="contentSaveForm" enctype="multipart/form-data">
			<!-- Hidden input for server-side validation -->
			<input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%= hasPendingVersion %>" />
			<div class="row">
				<div class="col-md-12">
					<div class="mb-3">
						<label class="form-label">Name</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
							name="<portlet:namespace/>bannerName" type="text"
							class="form-control" id="bannerName" value="<%=bannerName%>"
							required placeholder="Enter Banner Name" />
					</div>
					<div class="mb-3">
						<label class="form-label" for="status">Status</label> <select pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
							name="<portlet:namespace/>status" class="custom-select"
							id="status" required>
							<option value="" disabled
								<%=status.equals("") ? "selected" : ""%>>Choose...</option>
							<option value="0" <%=status.equals("0") ? "selected" : ""%>>Publish</option>
							<option value="1" <%=status.equals("1") ? "selected" : ""%>>Draft</option>
						</select>
					</div>
					<%-- <div class="mb-3">
						<label class="form-label">Order</label> <select
							name="<portlet:namespace/>contentOrder" class="custom-select"
							id="contentOrder">
							<option disabled selected>Choose ...</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
					</div> --%>
					<div class="mb-3">
						<h5>Content Versions for languages</h5>
						<div class="mb-2">This instance of the content will have the
							following language versions</div>
						<!-- names = the List of Tab from Languages -->
						<%
							if (languagesName.size() != 0) {
						%>
						<liferay-ui:tabs names="<%=tabsName%>" refresh="false"
							value="${selectedTab}">
							<%
								for (int i = 0; i < languagesName.size(); i++) {
											String linkType = links.get(languagesName.get(i)) == null
													? ""
													: links.get(languagesName.get(i));
											String url = urls.get(languagesName.get(i)) == null ? "" : urls.get(languagesName.get(i));
											String imageOverlay = imageOverlays.get(languagesName.get(i)) == null
													? ""
													: imageOverlays.get(languagesName.get(i));
							%>
							<liferay-ui:section>
								<div class="input-group flex-column align-items-center">
									<div class="custom-file">
										<input type="hidden"
											value="<%=bannerImages.get(languagesName.get(i)) != null
									? bannerImages.get(languagesName.get(i))
									: ""%>"
											"
											name="<portlet:namespace /><%=languagesName.get(i)%>BannerImageCheck">
										<input
											name="<portlet:namespace/><%=languagesName.get(i)%>BannerImage"
											type="file" class="custom-file-input"
											<%=languagesName.get(i).equals("English")
									&& bannerImages.get(languagesName.get(i)) == null ? "required" : ""%>
											id="<%=languagesName.get(i)%>BannerImage"
											onchange="checkBannerImage(this)"> <label
											class="custom-file-label"
											for="<%=languagesName.get(i)%>BannerImage">Select
											Banner Image</label>
									</div>
									<div class="my-3" style="position: relative;">
										<img alt=""
											src="data:image/jpeg;base64,<%=bannerImages.get(languagesName.get(i)) != null
									? bannerImages.get(languagesName.get(i))
									: ""%>"
											style="max-width: 100%" id="<%=languagesName.get(i)%>Image">
										<div class="banner-ovelay"
											style="background-color:rgba(0,0,0,<%=imageOverlay%>)"></div>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label"
										for="<%=languagesName.get(i)%>ImageOverlay">Image
										Overlay</label> <select
										name="<portlet:namespace/><%=languagesName.get(i)%>ImageOverlay"
										class="custom-select"
										id="<%=languagesName.get(i)%>ImageOverlay"
										onchange="applyOverlay(this)"
										<%=languagesName.get(i).equals("English") ? "required" : ""%>>
										<option value="" disabled
											<%=imageOverlay.equals("") ? "selected" : ""%>>Choose...</option>
										<option value="0%"
											<%=imageOverlay.equals("0%") ? "selected" : ""%>>0%</option>
										<option value="20%"
											<%=imageOverlay.equals("20%") ? "selected" : ""%>>20%</option>
										<option value="40%"
											<%=imageOverlay.equals("40%") ? "selected" : ""%>>40%</option>
										<option value="60%"
											<%=imageOverlay.equals("60%") ? "selected" : ""%>>60%</option>
										<option value="80%"
											<%=imageOverlay.equals("80%") ? "selected" : ""%>>80%</option>
										<option value="100%"
											<%=imageOverlay.equals("100%") ? "selected" : ""%>>100%</option>
									</select>
								</div>
								<div class="mb-3">
									<label class="form-label">Enter Title: (Optional)</label> <input
										name="<portlet:namespace/><%=languagesName.get(i)%>TitleValue"
										type="text"
										value="<%=titleValues.get(languagesName.get(i)) != null
									? titleValues.get(languagesName.get(i))
									: ""%>"
										class="form-control" id="" />
								</div>
								<div class="mb-3">
									<label class="form-label">Enter Description: (Optional)</label>
									<textarea
										name="<portlet:namespace/><%=languagesName.get(i)%>DescValue"
										class="form-control" id="" rows="3"><%=descValues.get(languagesName.get(i)) != null
									? descValues.get(languagesName.get(i))
									: ""%></textarea>

								</div>
								<div class="mb-3">
									<label class="form-label"
										for="<%=languagesName.get(i)%>LinkType">Link Type</label> <select
										name="<portlet:namespace/><%=languagesName.get(i)%>LinkType"
										class="custom-select link-type-banner-content"
										id="<%=languagesName.get(i)%>LinkType"
										onchange="showURLOption(event)"
										<%=languagesName.get(i).equals("English") ? "required" : ""%>>
										<option value="" disabled
											<%=linkType.equals("") ? "selected" : ""%>>Choose...</option>
										<option value="0" <%=linkType.equals("0") ? "selected" : ""%>>Internal
											URL</option>
										<option value="1" <%=linkType.equals("1") ? "selected" : ""%>>External
											URL</option>
									</select>
								</div>
								<div class="mb-3 <%=linkType.equals("0") ? "" : "d-none"%>">
									<label class="form-label"
										for="<%=languagesName.get(i)%>InternalURL">Internal
										URL</label> <select
										<%=linkType.equals("0") && languagesName.get(i).equals("English") ? "required" : ""%>
										name="<portlet:namespace/><%=languagesName.get(i)%>InternalURL"
										class="custom-select"
										id="<%=languagesName.get(i)%>InternalURL">
										<%
											for (Feature feature : features) {
										%>
										<option value="<%=feature.getRouteId()%>"
											<%=linkType.equals("0") ? url.equals(feature.getRouteId()) ? "selected" : "" : ""%>><%=feature.getFeatureName()%></option>
										<%
											}
										%>

										<%
											if (features.isEmpty()) {
										%>
										<option value="" disabled selected>No features in
											current channel</option>
										<%
											}
										%>
									</select>
								</div>

								<div class="mb-3 <%=linkType.equals("1") ? "" : "d-none"%>">
									<label class="form-label"
										for="<%=languagesName.get(i)%>ExternalURL">External
										URL</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
										name="<portlet:namespace/><%=languagesName.get(i)%>ExternalURL"
										class="custom-select" placeholder="Enter your URL... "
										id="<%=languagesName.get(i)%>ExternalURL"
										value="<%=linkType.equals("1") ? url : ""%>"
										<%=linkType.equals("1") && languagesName.get(i).equals("English") ? "required" : ""%>>
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
					</div>

					<div class="d-flex justify-content-end">
						<button type="button" onclick="window.location.href='<%=back%>'"
							class="btn btn-secondary px-5 mr-3">BACK</button>
						<% if (hasPendingVersion) { %>
						<button type="button" class="btn btn-primary px-5" disabled title="This banner has pending changes awaiting approval">
							SAVE (Pending Approval)
						</button>
						<% } else { %>
						<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
						<% } %>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- Save Confirmation Modal -->
<div class="modal hide fade" id="telemoneySaveModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneySaveModalTitle"
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
			<div class="modal-body text-5 text-center">Are you sure you want to save this Content?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" onclick="confirmSave()">Save</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function openSaveModal() {
		var form = document.getElementById('contentSaveForm');
		if (!form.checkValidity()) {
			form.reportValidity();
			return;
		}
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function closeSaveModal() {
		$("#telemoneySaveModal").modal("hide");
		$("#telemoneySaveModal").addClass("hide");
	}

	function confirmSave() {
		document.getElementById('contentSaveForm').submit();
		closeSaveModal();
	}

	$('.custom-file-input')
			.on(
					'change',
					function(e) {
						var fileName = 'Choose file';
						var imageElement = e.target.parentElement.nextElementSibling.firstElementChild;
						if (e.target.files[0]) {
							fileName = e.target.files[0].name;
							var imgFile = e.target.files[0];
							imageElement.src = URL.createObjectURL(imgFile);
							$(this).next('.custom-file-label').html(fileName);
						} else {
							$(this).next('.custom-file-label').html(fileName);
						}
					})
	function applyOverlay(element) {
		overlayElement = element.parentElement.previousElementSibling.lastElementChild.lastElementChild;
		overlayElement.style.backgroundColor = "rgba(0,0,0," + element.value
				+ ")";
	}

	function checkBannerImage(element) {
		var checkBannerInput = element.previousElementSibling;
		checkBannerInput.value = "checked";

	}

	function showURLOption(event) {
		var urlValue = "";
		var currElement = "";
		if (event.target) {
			urlValue = event.target.value;
			currElement = event.target;
		} else {
			urlValue = event.value;
			currElement = event;
		}
		var currLang = currElement.id.substring(0, currElement.id.length - 8);
		if (urlValue === "0") {
			currElement.parentElement.nextElementSibling.classList
					.remove("d-none");
			currElement.parentElement.nextElementSibling.nextElementSibling.classList
					.add("d-none");

			if (currLang == "English") {
				currElement.parentElement.nextElementSibling.nextElementSibling.lastElementChild
						.removeAttribute("required");
				currElement.parentElement.nextElementSibling.lastElementChild.required = true;

			}
		} else if (urlValue === "1") {
			currElement.parentElement.nextElementSibling.classList
					.add("d-none");

			currElement.parentElement.nextElementSibling.nextElementSibling.classList
					.remove("d-none");
			if (currLang == "English") {
				currElement.parentElement.nextElementSibling.lastElementChild
						.removeAttribute("required");
				currElement.parentElement.nextElementSibling.nextElementSibling.lastElementChild.required = true;
			}
		}

	}

	/* 	window.onload =()=>{
	 var mySelectElements = document.querySelectorAll(".custom-select.link-type-banner-content");
	 mySelectElements.forEach((select)=>{
	 showURLOption(select);
	 });
	 } */
</script>
