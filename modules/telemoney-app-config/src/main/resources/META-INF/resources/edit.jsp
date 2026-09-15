<%@page import="com.ejada.telemony.db.model.AppConfigItem"%>
<%@page import="com.ejada.telemony.db.model.AppEnvironment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:renderURL var="backURL">
	<portlet:param name="myView" value="view"/>
</portlet:renderURL>

<portlet:actionURL name="editAppConfig" var="editAppConfigURL" />

<%
	AppEnvironment record = (AppEnvironment)request.getAttribute("record");
	List<AppConfigItem> configItems = (List<AppConfigItem>)request.getAttribute(
		"configItems");

	if (configItems == null) {
		configItems = new ArrayList<>();
	}

	String environmentName = record != null ? record.getEnvironmentName() : "";
	long environmentId = record != null ? record.getEnvironmentId() : 0L;
	String errorMsg = (String)request.getAttribute("errorMessage") != null
		? (String)request.getAttribute("errorMessage")
		: "";
%>

<div>
	<h3 class="pb-4">Edit App Config</h3>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="duplicateConfigKey" message="Duplicate config key is not allowed." />
	<div class="my-3">
		<liferay-ui:error key="error" message="<%= errorMsg %>" />
	</div>

	<div class="card">
		<div class="card-body">
			<form action="<%= editAppConfigURL %>" method="post"
				name="<portlet:namespace/>editAppConfigForm"
				id="<portlet:namespace/>editAppConfigForm">
				<input type="hidden" name="<portlet:namespace/>environmentId"
					value="<%= environmentId %>" />
				<fieldset <%= isOther ? "disabled" : "" %>>
					<div class="form-group">
						<label for="<portlet:namespace/>environmentName">Environment Name</label>
						<input type="text" class="form-control"
							id="<portlet:namespace/>environmentName"
							name="<portlet:namespace/>environmentName"
							value="<%= environmentName %>"
							style="text-transform: uppercase;"
							oninput="this.value = this.value.toUpperCase();"
							readonly />
					</div>

					<div class="d-flex align-items-center justify-content-between mt-4 mb-2">
						<strong>Config Items</strong>
						<% if (!isOther) { %>
						<button type="button" class="btn btn-sm btn-outline-primary"
							id="<portlet:namespace/>addConfigItemRowBtn">+</button>
						<% } %>
					</div>

					<div class="row font-weight-bold mb-2">
						<div class="col-md-3">Key</div>
						<div class="col-md-3">Type</div>
						<div class="col-md-5">Value</div>
						<div class="col-md-1"></div>
					</div>

					<div id="<portlet:namespace/>configItemsContainer">
						<%
							if (configItems.isEmpty()) {
						%>
						<div class="row mb-2 config-item-row">
							<div class="col-md-3">
								<input type="text" class="form-control"
									name="<portlet:namespace/>itemKey"
									required="required" />
							</div>
							<div class="col-md-3">
								<select class="form-control"
									name="<portlet:namespace/>itemType"
									required="required">
									<option value="String">String</option>
									<option value="Integer">Integer</option>
									<option value="Boolean">Boolean</option>
									<option value="Double">Double</option>
								</select>
							</div>
							<div class="col-md-5">
								<input type="text" class="form-control"
									name="<portlet:namespace/>itemValue"
									required="required" />
							</div>
							<div class="col-md-1 d-flex align-items-center">
								<button type="button"
									class="btn btn-sm btn-outline-danger remove-config-item-row"
									title="Remove">-</button>
							</div>
						</div>
						<%
							}
							else {
								for (AppConfigItem item : configItems) {
						%>
						<div class="row mb-2 config-item-row">
							<div class="col-md-3">
								<input type="text" class="form-control"
									name="<portlet:namespace/>itemKey"
									value="<%= item.getKeyName() != null ? item.getKeyName() : "" %>"
									required="required" />
							</div>
							<div class="col-md-3">
								<select class="form-control"
									name="<portlet:namespace/>itemType"
									required="required">
									<option value="String" <%= "String".equalsIgnoreCase(item.getValueType()) ? "selected" : "" %>>String</option>
									<option value="Integer" <%= "Integer".equalsIgnoreCase(item.getValueType()) ? "selected" : "" %>>Integer</option>
									<option value="Boolean" <%= "Boolean".equalsIgnoreCase(item.getValueType()) ? "selected" : "" %>>Boolean</option>
									<option value="Double" <%= "Double".equalsIgnoreCase(item.getValueType()) ? "selected" : "" %>>Double</option>
								</select>
							</div>
							<div class="col-md-5">
								<% if ("Boolean".equalsIgnoreCase(item.getValueType())) { %>
								<select class="form-control"
									name="<portlet:namespace/>itemValue"
									required="required">
									<option value="">Select value</option>
									<option value="true" <%= "true".equalsIgnoreCase(item.getValue()) ? "selected" : "" %>>true</option>
									<option value="false" <%= "false".equalsIgnoreCase(item.getValue()) ? "selected" : "" %>>false</option>
								</select>
								<% } else { %>
								<input type="text" class="form-control"
									name="<portlet:namespace/>itemValue"
									value="<%= item.getValue() != null ? item.getValue() : "" %>"
									required="required" />
								<% } %>
							</div>
							<div class="col-md-1 d-flex align-items-center">
								<button type="button"
									class="btn btn-sm btn-outline-danger remove-config-item-row"
									title="Remove">-</button>
							</div>
						</div>
						<%
								}
							}
						%>
					</div>
				</fieldset>

				<div class="d-flex justify-content-end mt-3">
					<button type="button" class="btn btn-secondary px-5 mr-3"
						onclick="window.location.href='<%=backURL%>'"><%= isOther ? "BACK" : "CANCEL" %></button>
					<% if (!isOther) { %>
					<button type="submit" class="btn btn-primary px-5">UPDATE</button>
					<% } %>
				</div>
			</form>
		</div>
	</div>
</div>

<% if (!isOther) { %>
<div class="modal hide fade" id="appConfigUpdateModal" tabindex="-1"
	role="dialog" aria-labelledby="appConfigUpdateModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="appConfigUpdateModalTitle">Update</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you want to update this Environment ?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="<portlet:namespace/>confirmUpdateBtn">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	(function() {
		const ns = '<portlet:namespace/>';
		const addRowBtn = document.getElementById(ns + 'addConfigItemRowBtn');
		const container = document.getElementById(ns + 'configItemsContainer');
		const form = document.getElementById(ns + 'editAppConfigForm');
		const confirmUpdateBtn = document.getElementById(ns + 'confirmUpdateBtn');
		let isConfirmedSubmission = false;

		if (!addRowBtn || !container || !form || !confirmUpdateBtn) {
			return;
		}

		function updateRemoveButtons() {
			const rows = container.querySelectorAll('.config-item-row');
			rows.forEach(function(r) {
				const btn = r.querySelector('.remove-config-item-row');
				if (btn) {
					btn.disabled = rows.length <= 1;
				}
			});
		}

		function getValueField(row) {
			return row.querySelector('[name="' + ns + 'itemValue"]');
		}

		function createTextValueField(value) {
			const input = document.createElement('input');
			input.type = 'text';
			input.className = 'form-control';
			input.name = ns + 'itemValue';
			input.required = true;
			input.value = value || '';

			return input;
		}

		function createBooleanValueField(value) {
			const select = document.createElement('select');
			select.className = 'form-control';
			select.name = ns + 'itemValue';
			select.required = true;

			select.innerHTML =
				'<option value="">Select value</option>' +
				'<option value="true">true</option>' +
				'<option value="false">false</option>';

			if (value === 'true' || value === 'false') {
				select.value = value;
			}

			return select;
		}

		function bindValueFieldValidation(row) {
			const valueField = getValueField(row);

			if (!valueField) {
				return;
			}

			valueField.addEventListener(
				valueField.tagName === 'SELECT' ? 'change' : 'input',
				function() {
					enforceTypeValidation(row);
				}
			);
		}

		function syncValueField(row, resetValue) {
			const typeSelect = row.querySelector('select[name="' + ns + 'itemType"]');
			const valueColumn = row.querySelector('.col-md-5');
			const currentValueField = getValueField(row);

			if (!typeSelect || !valueColumn || !currentValueField) {
				return;
			}

			const currentValue = resetValue ? '' : currentValueField.value.trim().toLowerCase();
			const nextField = typeSelect.value === 'Boolean'
				? createBooleanValueField(currentValue)
				: createTextValueField(resetValue ? '' : currentValueField.value);

			valueColumn.replaceChild(nextField, currentValueField);
			bindValueFieldValidation(row);
		}

		function enforceTypeValidation(row) {
			const typeSelect = row.querySelector('select[name="' + ns + 'itemType"]');
			const valueInput = getValueField(row);

			if (!typeSelect || !valueInput) {
				return;
			}

			const type = typeSelect.value;
			const trimmedValue = valueInput.value.trim();

			valueInput.removeAttribute('pattern');
			valueInput.setCustomValidity('');

			if (type === 'Boolean') {
				valueInput.removeAttribute('title');
			}
			else if (type === 'Integer') {
				valueInput.setAttribute('pattern', '^-?[0-9]+$');
				valueInput.setAttribute('title', 'Integer type accepts whole numbers only (e.g. 42, -7).');

				if (trimmedValue !== '' && !/^-?[0-9]+$/.test(trimmedValue)) {
					valueInput.setCustomValidity('Integer type accepts whole numbers only (e.g. 42, -7).');
				}
			}
			else if (type === 'Double') {
				valueInput.setAttribute('pattern', '^-?[0-9]+(\.[0-9]+)?$');
				valueInput.setAttribute('title', 'Double type accepts decimal numbers only (e.g. 3.14, -0.5).');

				if (trimmedValue !== '' && !/^-?[0-9]+(\.[0-9]+)?$/.test(trimmedValue)) {
					valueInput.setCustomValidity('Double type accepts decimal numbers only (e.g. 3.14, -0.5).');
				}
			}
			else {
				valueInput.removeAttribute('title');
			}
		}

		function bindRowValidation(row) {
			const typeSelect = row.querySelector('select[name="' + ns + 'itemType"]');

			if (!typeSelect) {
				return;
			}

			typeSelect.addEventListener('change', function() {
				syncValueField(row, true);
				enforceTypeValidation(row);
			});

			syncValueField(row, false);
			enforceTypeValidation(row);
		}

		addRowBtn.addEventListener('click', function() {
			const row = document.createElement('div');
			row.className = 'row mb-2 config-item-row';
			row.innerHTML =
				'<div class="col-md-3">' +
					'<input type="text" class="form-control" name="' + ns + 'itemKey" required="required" />' +
				'</div>' +
				'<div class="col-md-3">' +
					'<select class="form-control" name="' + ns + 'itemType" required="required">' +
						'<option value="String">String</option>' +
						'<option value="Integer">Integer</option>' +
						'<option value="Boolean">Boolean</option>' +
						'<option value="Double">Double</option>' +
					'</select>' +
				'</div>' +
				'<div class="col-md-5">' +
					'<input type="text" class="form-control" name="' + ns + 'itemValue" required="required" />' +
				'</div>' +
				'<div class="col-md-1 d-flex align-items-center">' +
					'<button type="button" class="btn btn-sm btn-outline-danger remove-config-item-row" title="Remove">-</button>' +
				'</div>';

			container.appendChild(row);
			bindRowValidation(row);
			updateRemoveButtons();
		});

		container.addEventListener('click', function(event) {
			const target = event.target;
			if (!target.classList.contains('remove-config-item-row')) {
				return;
			}

			const rows = container.querySelectorAll('.config-item-row');
			if (rows.length <= 1) {
				return;
			}

			const row = target.closest('.config-item-row');
			if (row) {
				row.remove();
			}
			updateRemoveButtons();
		});

		form.addEventListener('submit', function(event) {
			if (isConfirmedSubmission) {
				isConfirmedSubmission = false;
				return;
			}

			const rows = container.querySelectorAll('.config-item-row');
			for (let i = 0; i < rows.length; i++) {
				enforceTypeValidation(rows[i]);
				const valueInput = getValueField(rows[i]);

				if (valueInput && !valueInput.checkValidity()) {
					event.preventDefault();
					valueInput.reportValidity();
					valueInput.focus();
					return;
				}
			}

			event.preventDefault();
			$("#appConfigUpdateModal").modal("show");
			$("#appConfigUpdateModal").removeClass("hide");
		});

		confirmUpdateBtn.addEventListener('click', function() {
			isConfirmedSubmission = true;
			$("#appConfigUpdateModal").modal("hide");
			form.submit();
		});

		$('#appConfigUpdateModal').on('hidden.bs.modal', function() {
			$("#appConfigUpdateModal").addClass("hide");
		});

		container.querySelectorAll('.config-item-row').forEach(function(row) {
			bindRowValidation(row);
		});
		updateRemoveButtons();
	})();
</script>
<% } %>
