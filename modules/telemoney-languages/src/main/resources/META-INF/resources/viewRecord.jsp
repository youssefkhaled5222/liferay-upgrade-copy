<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>

<portlet:renderURL var="cancel_Lang">
	<portlet:param name="action" value="view" />
</portlet:renderURL>


<%
	Long id = (Long) request.getAttribute("id");
	String langName = (String) request.getAttribute("name");
	String local = (String) request.getAttribute("local");
	Long channelId = (Long) request.getAttribute("channelId");
	boolean primaryLanguage = (boolean) request.getAttribute("primaryLanguage");
%>



<div class="table-responsive">
	<table class="table mb-4">
		<thead>
			<tr>
				<th scope="col">Language ID</th>
				<th scope="col">Name</th>
				<th scope="col">Local</th>
				<th scope="col">Primary</th>


			</tr>
		</thead>
		<tbody>

			<tr>
				<td><%=id%></td>
				<td><%=langName%></td>
				<td><%=local%></td>
				<td><%=primaryLanguage ? "True" : "False"%></td>
			<tr>
		</tbody>
	</table>
	<div class="d-flex justify-content-end">
		<button type="button"
			onclick="window.location.href='<%=cancel_Lang%>'"
			class="btn btn-secondary px-5" name="cancelAction">Back</button>
	</div>
</div>