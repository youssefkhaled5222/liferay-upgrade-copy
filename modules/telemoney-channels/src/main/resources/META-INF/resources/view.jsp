<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.ejada.telemony.db.model.Channels"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<%
	List<Channels> channels = (List<Channels>) request.getAttribute("listOfChannels") != null
			? (List<Channels>) request.getAttribute("listOfChannels")
			: new ArrayList<>();
	String errorMsg = (String) request.getAttribute("errorMessage") != null
			? (String) request.getAttribute("errorMessage")
			: "Internal Error";
%>

<portlet:renderURL var="add">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<div>
	<h3 class="pb-4">
		Channels
		</h5>
		<liferay-ui:error key="error" message="<%=errorMsg%>" />
		<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
		<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
		<div class="row">
			<%
				int index = 0;
				for (Channels channel : channels) {
			%>
			<div class="col-md-2 mb-4">
				<div class="card bg-info text-white h-100">
					<div class="card-body d-flex flex-column h-100">
						<div class="icon d-flex justify-content-end">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-phone" viewBox="0 0 16 16">
						  <path
									d="M11 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h6zM5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H5z" />
						  <path d="M8 14a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
						</svg>
						</div>
						<div class="h2 pt-5"><%=channel.getName()%></div>
						<div class="h5">
							ID:
							<%=channel.getChannelId()%></div>
						<div class="mt-auto">
							<div class="dropdown d-flex justify-content-end dropright">
								<%-- <button class="btn text-white dropdown-toggle p-0" type="button"
									id="dropdownMenuButton<%=index%>" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-three-dots-vertical"
										viewBox="0 0 16 16">
							  <path
											d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
							</svg>
								</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton<%=index%>">
									<a class="dropdown-item" href="#">View</a> <a
										class="dropdown-item" href="#">Delete</a>
								</div> --%>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%
				index++;
				}
			%>
			<% if (isAdministrator) { %>
			<div class="col-md-2 mb-4">
				<div class="card bg-light text-dark h-100">
					<div class="card-body d-flex flex-column h-100">
						<div class="icon d-flex justify-content-end">
							<button class="btn p-0" onclick="window.location.href='<%=add%>'">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
							  <path fill-rule="evenodd"
										d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
							</svg>
							</button>
						</div>
						<div class="h2 pt-5 mt-auto">Add Channel</div>
					</div>
				</div>
			</div>
			<% } %>
		</div>
</div>
