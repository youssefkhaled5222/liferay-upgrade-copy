<%@page import="com.ejada.telemony.db.model.Segment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<portlet:actionURL var="addFeatureView" name="addFeatureView">
</portlet:actionURL>
<portlet:actionURL var="deleteFeature" name="deleteFeature">
</portlet:actionURL>

<portlet:actionURL var="search" name="search">
</portlet:actionURL>

<portlet:actionURL var="reset" name="reset">
</portlet:actionURL>

<%!
	// Helper method to get segment names as comma-separated string
	private String getSegmentNamesForFeature(long featureId, Map<Long, List<Segment>> featureSegmentsMap) {
		if (featureSegmentsMap == null || !featureSegmentsMap.containsKey(featureId)) {
			return "";
		}
		List<Segment> segments = featureSegmentsMap.get(featureId);
		if (segments == null || segments.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Segment segment : segments) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(segment.getName());
		}
		return sb.toString();
	}
%>

<%
	
	List<Feature> features = request.getAttribute("listOfFeatures") != null
		? (List<Feature>) request.getAttribute("listOfFeatures")
			: new ArrayList<>();

	// Get feature segments map (featureId -> approved segments)
	Map<Long, List<Segment>> featureSegmentsMap = request.getAttribute("featureSegmentsMap") != null
			? (Map<Long, List<Segment>>) request.getAttribute("featureSegmentsMap")
			: new HashMap<>();

	// Get features with pending versions
	Set<Long> featuresWithPending = request.getAttribute("featuresWithPending") != null
		? (Set<Long>) request.getAttribute("featuresWithPending")
		: new HashSet<>();

	String searchInput = request.getAttribute("searchInput") == null ?
			 "" : (String) request.getAttribute("searchInput");
	
	features = request.getAttribute("filteredFeatures") != null
			? (List<Feature>) request.getAttribute("filteredFeatures")
					: features;
			
    features = request.getAttribute("reset") == "true"? (List<Feature>) request.getAttribute("listOfFeatures")
							: features;
%>

<style>
    .pending-badge {
        background-color: #ffc107;
        color: #000;
        padding: 2px 8px;
        border-radius: 4px;
        font-size: 11px;
        margin-left: 8px;
    }
</style>

<div>
	<h3 class="pb-4">Feature Toggling</h3>
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="hasPendingVersion" message="This feature has a pending version awaiting approval and cannot be modified." />
	<liferay-ui:error key="linkedToLocalization"
					  message="This feature cannot be deleted because it is either used on a localization page or has a pending request awaiting approval or rejection." />
	<liferay-ui:error key="linkedToResource"
					  message="This feature cannot be deleted because it is either used on a resources page or has a pending request awaiting approval or rejection." />
	<liferay-ui:error key="parentHaveChildren" message="The parent already has children and cannot be changed to a child." />
	<liferay-ui:error key="parentNotSelected" message="You must choose a parent page for this feature page." />
	<liferay-ui:error key="errorUpdatingFeature" message="An unexpected error occurred while updating the feature." />
	<div class="card">
		<div class="card-body">
			<div class="row">
			    <div class="col-md-12">
			        <div class="d-flex align-items-end mb-3">
			              
			               <form class="d-flex" action=<%=search %> method="post" name="<portlet:namespace/>search" id="<portlet:namespace/>search">       
                                
                                <input type="text" name="<portlet:namespace/>searchInput" value="<%=searchInput%>"  id="searchInput" class="form-control w-100 inline" placeholder="Search">
                                
                                <button type="submit" class="btn btn-primary px-3 inline ml-2">
			                         Search
			                    </button>
			                   
                            </form>
			               
			                <form action=<%=reset %> method="post" name="<portlet:namespace/>reset" id="<portlet:namespace/>reset">
			                    <button type="submit" class="btn btn-link ml-2" onclick="">reset</button>
			                    </form>
			                
			            
			            <% if (!isOther) { %>
			            <div class="ml-auto">
			                <button type="submit" class="btn btn-primary px-5" onclick="window.location.href='<%=addFeatureView %>'">
			                    Add Feature
			                </button>
			            </div>
			            <% } %>
			            
			        </div>
			    </div>
			</div>

			<hr/>
			<div>
			    <%
			    int index = 0;
			    if(!features.isEmpty() && searchInput.isEmpty()){
				    for (Feature parentFeature : features) {
				        if (parentFeature.getPageType().contains("0")) {
				            boolean hasPendingVersion = featuresWithPending.contains(parentFeature.getFeatureId());
			    %>
			        <div class="parent">
			        
			            <div class="d-flex justify-content-between align-items-center ">
			            <div class="">
			                <span class="font-weight-bold show-child">&#10148;</span>
			                <% if (hasPendingVersion) { %>
			                    <span class="font-weight-bold"><%= parentFeature.getFeatureName() %></span>
			                    <span class="pending-badge">Pending Approval</span>
			                <% } else { %>
			                    <a class="font-weight-bold" href="
			                    <portlet:actionURL  name="getFeatureDataForView" >
								    <portlet:param name="selectedFeatureId" value="<%=String.valueOf(parentFeature.getFeatureId())%>" />
								    <portlet:param name="hasPendingVersion" value="false" />
							    </portlet:actionURL>"><%= parentFeature.getFeatureName() %></a>
			                <% } %>
			                <span class="font-weight-bold"> - Segments</span> (<%= getSegmentNamesForFeature(parentFeature.getFeatureId(), featureSegmentsMap) %>)
			            </div>
			            <% if (!isOther && !hasPendingVersion) { %>
			             <div class="d-flex justify-content-end">
				                <form action=<%=deleteFeature %> method="post" name="<portlet:namespace/>featureDeleteForm" id="<portlet:namespace/>featureDeleteForm">
				                    <a class="btn btn-primary " onclick="deletefeature('<%=parentFeature.getFeatureId()%>', '<%=parentFeature.getPageType()%>')" class="dropdown-item"> Delete </a>
				                    <input type="text" class="d-none" name="<portlet:namespace/>deleteId" id="<portlet:namespace/>deleteId" />
				                    <input type="hidden" name="<portlet:namespace/>deletePageType" id="<portlet:namespace/>deletePageType" />
				                    <input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%=hasPendingVersion%>" />
				                </form>
				         </div>
				         <% } else if (!isOther && hasPendingVersion) { %>
				         <div class="d-flex justify-content-end">
				             <span class="text-muted">Actions disabled (pending approval)</span>
				         </div>
				         <% } %>
			            </div>
			           
			           
			            <% 
			            for (Feature childFeature : features) {
			                if (childFeature.getEntityResourceId() == parentFeature.getEntityResourceId() && childFeature.getPageType().contains("1")
							     && childFeature.getChildResourceId()>0L)
							{
			                    boolean childHasPending = featuresWithPending.contains(childFeature.getFeatureId());
			            %>
			                    <div class="child ml-5 my-2">
			                        <div class="d-flex justify-content-between align-items-center">
			                        <div class="">
			                            <% if (childHasPending) { %>
			                                <span class="font-weight-bold"><%= childFeature.getFeatureName() %></span>
			                                <span class="pending-badge">Pending Approval</span>
			                            <% } else { %>
			                                <a class="font-weight-bold" href="
			                                <portlet:actionURL  name="getFeatureDataForView" >
											    <portlet:param name="selectedFeatureId" value="<%=String.valueOf(childFeature.getFeatureId())%>" />
											    <portlet:param name="hasPendingVersion" value="false" />
										    </portlet:actionURL>"><%= childFeature.getFeatureName() %></a>
			                            <% } %>
			                            <span class="font-weight-bold"> - Segments</span> (<%= getSegmentNamesForFeature(childFeature.getFeatureId(), featureSegmentsMap) %>)
			                        </div>
			                        <% if (!isOther && !childHasPending) { %>
			                        <div class="d-flex justify-content-end">
			                            <form action=<%=deleteFeature %> method="post" name="<portlet:namespace/>featureDeleteForm" id="<portlet:namespace/>featureDeleteForm">
			                                <a class="btn btn-primary" onclick="deletefeature('<%=childFeature.getFeatureId()%>', '<%=childFeature.getPageType()%>')" class="dropdown-item"> Delete </a>
			                                <input type="text" class="d-none" name="<portlet:namespace/>deleteId" id="<portlet:namespace/>deleteId" />
			                                <input type="hidden" name="<portlet:namespace/>deletePageType" id="<portlet:namespace/>deletePageType" />
			                                <input type="hidden" name="<portlet:namespace/>hasPendingVersion" value="<%=childHasPending%>" />
			                            </form>
			                        </div>
			                        <% } else if (!isOther && childHasPending) { %>
			                        <div class="d-flex justify-content-end">
			                            <span class="text-muted">Actions disabled (pending approval)</span>
			                        </div>
			                        <% } %>
			                        </div>
			                    </div>
			            <% } /* if */} /* for */ %>
			        </div>
			        <hr>
			        
			    <% } }  } else if(!features.isEmpty() && !searchInput.isEmpty()){
			    	              for (Feature feature : features) {
			    %>
			                        <div class="d-flex justify-content-between align-items-center ml-5 my-2 ">
			                        <div class="">
			                            <a class="font-weight-bold" href="
			                            <portlet:actionURL  name="getFeatureDataForView" >
											<portlet:param name="selectedFeatureId" value="<%=String.valueOf(feature.getFeatureId())%>" />
										</portlet:actionURL>"><%= feature.getFeatureName() %></a>
			                            <span class="font-weight-bold"> - Segments</span> (<%= getSegmentNamesForFeature(feature.getFeatureId(), featureSegmentsMap) %>)
			                        </div>
			                        <% if (!isOther) { %>
			                        <div class="d-flex justify-content-end">
			                            <form action=<%=deleteFeature %> method="post" name="<portlet:namespace/>featureDeleteForm" id="<portlet:namespace/>featureDeleteForm">
			                                <a class="btn btn-primary" onclick="deletefeature('<%=feature.getFeatureId()%>', '<%=feature.getPageType()%>')" class="dropdown-item"> Delete </a>
			                                <input type="text" class="d-none" name="<portlet:namespace/>deleteId" id="<portlet:namespace/>deleteId" />
			                                <input type="hidden" name="<portlet:namespace/>deletePageType" id="<portlet:namespace/>deletePageType" />
			                            </form>
			                        </div>
			                        <% } %>
			                    </div>
			                    <hr>
			            <% } /* if */} /* for */  else { %>
			    <div class="my-2">
						<div class="d-flex justify-content-between align-items-center py-3 border-bottom">
							<div>
								<h5>No Features Found.</h5>
							</div>
						</div>
					</div>
					<%}%>
			</div>
		</div>

	</div>
</div>
<div class="modal hide fade" id="telemoneyDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneyDeleteModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Delete Feature</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to delete this feature?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="deleteFeatureConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	$('.child').hide();
	$('.show-child').css({"cursor": "pointer"});
	$('.show-child').on( "click", function() {
		$(this).closest('.parent').find('.child').toggle();
	});
	
	function deletefeature(questionId, pageType) {
		var questionIdField = document.getElementById('<portlet:namespace/>deleteId');
		var pageTypeField = document.getElementById('<portlet:namespace/>deletePageType');
		questionIdField.value = questionId;
		pageTypeField.value = pageType;
		openModal();
	}
	
	function deleteFeatureConfirm() {
		document.getElementById('<portlet:namespace/>featureDeleteForm').submit();
	}
	
	function resetDelete() {
		var recordIdField = document.getElementById('<portlet:namespace/>deleteId');
		var pageTypeField = document.getElementById('<portlet:namespace/>deletePageType');
		recordIdField.value = "";
		pageTypeField.value = "";
	}
	
	function openModal() {
		$("#telemoneyDeleteModal").modal("show");
		$("#telemoneyDeleteModal").removeClass("hide");
	}
	
	function closeModal() {
		$("#telemoneyDeleteModal").modal("hide");
		$("#telemoneyDeleteModal").addClass("hide");
	}
	
	$('#telemoneyDeleteModal').on('hidden.bs.modal', function(e) {
		resetDelete();
	})

</script>
	