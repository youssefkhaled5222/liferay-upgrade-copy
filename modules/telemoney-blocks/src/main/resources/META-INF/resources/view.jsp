<%@ include file="/init.jsp" %>

<portlet:actionURL var="updateBlock" name="updateBlock">
</portlet:actionURL>

<div>
	<h3 class="pb-4">Update Block</h3>
	<div class="card">
		<div class="card-body">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-secondary px-5" onclick="window.location.href='<%=updateBlock%>'">
					Update Block
				</button>
			</div>
		</div>
	</div>
</div>