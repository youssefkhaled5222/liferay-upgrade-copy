<%@ include file="/init.jsp"%>


<portlet:renderURL var="add">
	<portlet:param name="myview" value="add" />
</portlet:renderURL>

<div class="my-4">
	<h1>Localization</h1>
	<liferay-ui:error key="file-upload-error" message="File upload error" />
	<liferay-ui:error key="zipSizeExceeded" message="Export failed: The generated ZIP file exceeds the 10MB size limit. Please reduce the number of selected items and try again." />
	<liferay-ui:error key="import-processing-error" message="An error occurred while processing the import. Please check if you uploaded the correct file, then try again."/>
	<liferay-ui:error key="import-duplicate-keys-error" message="Import failed: some keys already exist in another page"/>
	<p class="text-secondary">Manage Localization</p>
</div>
<div class="row">
	<div class="col-md-4">
		<a class="mb-4" href="<%=add%>">
			<div class="card bg-info text-white w-100 h-100">
				<div class="card-body d-flex flex-column h-100">
					<div class="icon d-flex justify-content-end">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-person-square"
							viewBox="0 0 16 16">
						  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
						  <path
								d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z" />
						</svg>
					</div>
					<div class="h2 pt-5">Manage Localization</div>
					<div class="h4 font-weight-normal">Consumer App</div>
				</div>
			</div>
		</a>
	</div>
</div>