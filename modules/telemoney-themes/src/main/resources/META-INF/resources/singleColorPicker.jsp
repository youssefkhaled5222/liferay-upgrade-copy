<%@ include file="/init.jsp"%>
<%
	String colorPickerLabelId = ParamUtil.getString(request, "colorPickerLabelId");
	String colorPickerInputId = ParamUtil.getString(request, "colorPickerInputId");
	String colorPickerBg = ParamUtil.getString(request, "colorPickerBg");
	String colorPickerBgId = ParamUtil.getString(request, "colorPickerBgId");
	String colorLabel = ParamUtil.getString(request, "colorLabel");
	String disabled = ParamUtil.getString(request, "disabled","");
%>

<div class="d-flex flex-column">
	<p class="mb-1"><%=colorLabel%></p>
	<div id="<%=colorPickerBgId%>"
		style="width: 100%; height: 150px; border: 1px solid rgba(0, 0, 0, 0.1);"
		class="rounded-top"></div>

	<label for="<%=colorPickerInputId%>" id="<%=colorPickerLabelId%>"
		class="p-1 d-flex align-items-center justify-content-between rounded-bottom bg-light">
		<p class="m-0"></p> <svg xmlns="http://www.w3.org/2000/svg"
			height="1em" viewBox="0 0 512 512" fill="#000000">
			<path
				d="M0 64C0 28.7 28.7 0 64 0H352c35.3 0 64 28.7 64 64v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V64zM160 352c0-17.7 14.3-32 32-32V304c0-44.2 35.8-80 80-80H416c17.7 0 32-14.3 32-32V160 69.5c37.3 13.2 64 48.7 64 90.5v32c0 53-43 96-96 96H272c-8.8 0-16 7.2-16 16v16c17.7 0 32 14.3 32 32V480c0 17.7-14.3 32-32 32H192c-17.7 0-32-14.3-32-32V352z" /></svg>
	</label> <input type="color" id="<%=colorPickerInputId%>"
		name="<portlet:namespace/><%=colorPickerInputId%>"
		style="opacity: 0; width: 100%; height: 0;" <%=disabled%> />
</div>

<script>
document.getElementById('<%=colorPickerBgId%>').style.backgroundColor="<%=colorPickerBg%>";
document.getElementById('<%=colorPickerInputId%>').value="<%=colorPickerBg%>";

document.getElementById('<%=colorPickerLabelId%>').getElementsByTagName('p')[0].textContent="<%=colorPickerBg%>";
document.getElementById('<%=colorPickerInputId%>').oninput = (e) => {
	  document.getElementById('<%=colorPickerLabelId%>').getElementsByTagName('p')[0].textContent = e.target.value;
	  document.getElementById('<%=colorPickerBgId%>').style.backgroundColor = e.target.value;
	  document.getElementById('<%=colorPickerInputId%>').value = e.target.value
	};
</script>