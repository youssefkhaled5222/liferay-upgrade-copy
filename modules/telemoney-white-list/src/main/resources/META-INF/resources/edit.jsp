<%@ include file="/init.jsp"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
String allow = request.getAttribute("allow")!=null? (String) request.getAttribute("allow"):"";
String poi =  request.getAttribute("poi")!=null? (String) request.getAttribute("poi"):"";
String enName = request.getAttribute("enName")!=null? (String) request.getAttribute("enName"):"";
String arName =  request.getAttribute("arName")!=null? (String) request.getAttribute("arName"):"";
String cif = request.getAttribute("cif")!=null? (String) request.getAttribute("cif"):"";
String mobile =  request.getAttribute("mobile")!=null? (String) request.getAttribute("mobile"):"";
%>
<portlet:renderURL var="cancel_Lov">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<portlet:actionURL name="updateStatus" var="updateStatus">
</portlet:actionURL>

<div>
	<h3 class="pb-4">Edit Customer Status</h3>


	<div class="card">
		<div class="card-body">
			<form action="<%=updateStatus%>" method="post">
				<div class="mb-3">
					<label class="form-label">POI</label> <input type="text" readonly
						class="form-control" id="poi" required
						name="<portlet:namespace/>poi" value="<%=poi%>">
				</div>
				
				<div class="mb-3">
					<label class="form-label">English Name</label> <input type="text" readonly
						class="form-control" id="enName" required
						name="<portlet:namespace/>enName" value="<%=enName%>">
				</div>
				
				<div class="mb-3">
					<label class="form-label">Arabic Name</label> <input type="text" readonly
						class="form-control" id="arName" required
						name="<portlet:namespace/>arName" value="<%=arName%>">
				</div>
				
				<div class="mb-3">
					<label class="form-label">CIF</label> <input type="text" readonly
						class="form-control" id="cif" required
						name="<portlet:namespace/>cif" value="<%=cif%>">
				</div>
				
				<div class="mb-3">
					<label class="form-label">Mobile NO.</label> <input type="text" readonly
						class="form-control" id="mobile" required
						name="<portlet:namespace/>mobile" value="<%=mobile%>">
				</div>

				<div class="mb-3">
					<label class="form-label">Allow</label> <select
						class="custom-select" required name="<portlet:namespace/>allow"> 
						<option value="" >--Please choose an option--</option>
						<option value="Y" <%=allow.equals("Y") ? "selected" : ""%>>YES</option>
						<option value="N" <%=allow.equals("N") ? "selected" : ""%>>NO</option>
					</select> 
				</div>



				<div class="d-flex justify-content-end">
					<button type="button"
						onclick="window.location.href='<%=cancel_Lov%>'"
						class="btn btn-secondary px-5 mr-3">CANCEL</button>
					<button type="submit" class="btn btn-primary px-5">SAVE</button>
				</div>
			</form>
		</div>
	</div>



</div>