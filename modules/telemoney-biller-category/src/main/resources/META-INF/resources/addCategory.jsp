<%@ include file="/init.jsp" %>

<div>
	<h3 class="pb-4">Biller category</h3>
	<div class="card">
		<div class="card-body">
			<form>			
				<div class="mb-3">
					<label class="form-label">Biller category ID</label> 
					<input type="text" class="form-control" id="">
				</div>
				<div class="mb-3">
					<label class="form-label">Category Code</label> 
					<input type="text" class="form-control" id="">
				</div>
				<div class="mb-3">
					<label class="form-label">Category name English</label> 
					<input type="text" class="form-control" id="">
				</div>
				<div class="mb-3">
					<label class="form-label">Category name Arabic</label> 
					<input type="text" class="form-control" id="">
				</div>
				<div class="d-flex justify-content-end">
					<button type="submit" class="btn btn-primary px-5 mr-3">Add</button>
					<button type="submit" class="btn btn-primary px-5 mr-3 d-none">Update</button>
					<button type="submit" class="btn btn-secondary px-5">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>