<%@ include file="/init.jsp"%>
<portlet:actionURL name="validate" var="validate" />

<div class="container py-5">
	<form class="form" action="<%=validate%>" method="post"
		name="loginForm" id="loginForm">
		<div class="form-group">
			<label for="<portlet:namespace/>email" class="form-label">Email</label>
			<input type="email" name="<portlet:namespace/>email"
				id="<portlet:namespace/>email" class="form-control" />
		</div>
		<div class="form-group">
			<label for="<portlet:namespace/>password" class="form-label">Password</label>
			<input type="password" name="<portlet:namespace/>password"
				id="<portlet:namespace/>password" class="form-control" />
		</div>
		<div class="form-group d-flex align-items-center">
			<input class="form-check-input" type="checkbox" id="rememberMe"
				name="<portlet:namespace/>rememberMe" /> <label
				class="form-check-label mx-2" for="rememberMe"> Remember me</label>
		</div>
		<div class="d-flex justify-content-end">
			<button class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
