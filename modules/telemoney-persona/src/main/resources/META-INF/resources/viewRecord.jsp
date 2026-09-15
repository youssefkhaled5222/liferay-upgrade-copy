<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.dynamic.data.lists.exception.RecordGroupIdException"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<portlet:renderURL var="cancel_Lang">
	<portlet:param name="action" value="view" />
</portlet:renderURL>



<%
	Long id = (Long) request.getAttribute("id");
	Long channelId = (Long) request.getAttribute("channelId");
	String darkThemeId = (String) request.getAttribute("darkThemeId");
	String lightThemeId = (String) request.getAttribute("lightThemeId");
	int startAge = (int) request.getAttribute("startAge");
	int endAge = (int) request.getAttribute("endAge");
	
	int priority = (int) request.getAttribute("priority");


	String status = request.getAttribute("status") != null ? (String) request.getAttribute("status")
			: "Choose...";
	String customerSegment = request.getAttribute("customerSegment") != null ? (String) request.getAttribute("customerSegment")
			: "Choose...";
	String nationality = (String) request.getAttribute("nationality");
	String name = (String) request.getAttribute("name");
	
	String gender = (String) request.getAttribute("gender");
	String description = (String) request.getAttribute("description");
	String jobSector = (String) request.getAttribute("jobSector");
	Date dateFrom = (Date)request.getAttribute("dateFrom");
	Date dateTo = (Date)request.getAttribute("dateTo");
	
	String sector = (String)request.getAttribute("sector");
	String incom = (String)request.getAttribute("incom");

%>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Channel ID</th>
				<th scope="col">Dark Theme Id</th>
				<th scope="col">Light Theme Id</th>
				<th scope="col">Priority</th>
				<th scope="col">Age</th>
				<th scope="col">Nationality</th>
				<th scope="col">Program</th>
				<th scope="col">Description</th>
				<th scope="col">Gender</th>
				<th scope="col">Sector</th>
				<th scope="col">Incom</th>
				<th scope="col">Status</th>
				<th scope="col">date From</th>
				<th scope="col">date To</th>

			</tr>
		</thead>
		<tbody>

			<tr>
				<td><%=id%></td>
				<td><%=name%></td>
				<td><%=channelId%></td>
				<td><%=darkThemeId%></td>
				<td><%=lightThemeId%></td>
				<td><%= priority %></td>
				<td><%=startAge +"-" + endAge%></td>
				<td><%= nationality %></td>
				<td><%=customerSegment%></td>
				<td><%=description%></td>
				<td><%=gender%></td>
				<td><%=sector%></td>
				<td><%=incom%></td>
				<td><%=status%></td>
				<td><%=dateFrom%></td>	
				<td><%=dateTo%></td>				
				
			<tr>
		</tbody>
	</table>
	<div class="d-flex justify-content-end">
		<button type="button"
			onclick="window.location.href='<%=cancel_Lang%>'"
			class="btn btn-secondary px-5" name="cancelAction">Back</button>
	</div>
</div>