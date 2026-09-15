<%@ include file="/init.jsp"%>
<%
	String colorPickerFirstLabelId = ParamUtil.getString(request, "colorPickerFirstLabelId");
	String colorPickerFirstInputId = ParamUtil.getString(request, "colorPickerFirstInputId");
	String colorPickerSecondLabelId = ParamUtil.getString(request, "colorPickerSecondLabelId");
	String colorPickerSecondInputId = ParamUtil.getString(request, "colorPickerSecondInputId");
	String colorPickerThirdLabelId = ParamUtil.getString(request, "colorPickerThirdLabelId");
	String colorPickerThirdInputId = ParamUtil.getString(request, "colorPickerThirdInputId");
	String colorPickerFourthLabelId = ParamUtil.getString(request, "colorPickerFourthLabelId");
	String colorPickerFourthInputId = ParamUtil.getString(request, "colorPickerFourthInputId");
	String colorPickerFifthLabelId = ParamUtil.getString(request, "colorPickerFifthLabelId");
	String colorPickerFifthInputId = ParamUtil.getString(request, "colorPickerFifthInputId");

	String colorPickerFirstBg = ParamUtil.getString(request, "colorPickerFirstBg");
	String colorPickerSecondBg = ParamUtil.getString(request, "colorPickerSecondBg");
	String colorPickerThirdBg = ParamUtil.getString(request, "colorPickerThirdBg");
	String colorPickerFourthBg = ParamUtil.getString(request, "colorPickerFourthBg");
	String colorPickerFifthBg = ParamUtil.getString(request, "colorPickerFifthBg");

	String colorPickerBgId = ParamUtil.getString(request, "colorPickerBgId");
	String colorLabel = ParamUtil.getString(request, "colorLabel");
	String disabled = ParamUtil.getString(request, "disabled","");
%>

<div class="d-flex flex-column">
	<p class="mb-1"><%=colorLabel%></p>
	<div id="<%=colorPickerBgId%>" style="width: 100%; height: 150px;" class="rounded-top"></div>

	<!-- First -->
	<label for="<%=colorPickerFirstInputId%>" id="<%=colorPickerFirstLabelId%>" class="p-1 d-flex align-items-center justify-content-between bg-light">
		<p class="m-0"></p>
	</label>
	<input type="color" value="#000000" id="<%=colorPickerFirstInputId%>"
		   name="<portlet:namespace/><%=colorPickerFirstInputId%>"
		   style="opacity: 0; width: 100%; height: 0;" <%=disabled%>/>

	<!-- Second -->
	<label for="<%=colorPickerSecondInputId%>" id="<%=colorPickerSecondLabelId%>" class="p-1 d-flex align-items-center justify-content-between bg-light">
		<p class="m-0"></p>
	</label>
	<input type="color" value="#000000" id="<%=colorPickerSecondInputId%>"
		   name="<portlet:namespace/><%=colorPickerSecondInputId%>"
		   style="opacity: 0; width: 100%; height: 0;" <%=disabled%>/>

	<!-- Third -->
	<label for="<%=colorPickerThirdInputId%>" id="<%=colorPickerThirdLabelId%>" class="p-1 d-flex align-items-center justify-content-between bg-light">
		<p class="m-0"></p>
	</label>
	<input type="color" value="#000000" id="<%=colorPickerThirdInputId%>"
		   name="<portlet:namespace/><%=colorPickerThirdInputId%>"
		   style="opacity: 0; width: 100%; height: 0;" <%=disabled%>/>

	<!-- Fourth -->
	<label for="<%=colorPickerFourthInputId%>" id="<%=colorPickerFourthLabelId%>" class="p-1 d-flex align-items-center justify-content-between bg-light">
		<p class="m-0"></p>
	</label>
	<input type="color" value="#000000" id="<%=colorPickerFourthInputId%>"
		   name="<portlet:namespace/><%=colorPickerFourthInputId%>"
		   style="opacity: 0; width: 100%; height: 0;" <%=disabled%>/>

	<!-- Fifth -->
	<label for="<%=colorPickerFifthInputId%>" id="<%=colorPickerFifthLabelId%>" class="p-1 d-flex align-items-center justify-content-between rounded-bottom bg-light">
		<p class="m-0"></p>
	</label>
	<input type="color" value="#000000" id="<%=colorPickerFifthInputId%>"
		   name="<portlet:namespace/><%=colorPickerFifthInputId%>"
		   style="opacity: 0; width: 100%; height: 0;" <%=disabled%>/>
</div>

<script>
	document.getElementById('<%=colorPickerBgId%>').style.backgroundImage =
			"linear-gradient(" +
			'<%=colorPickerFirstBg%>' + "," +
			'<%=colorPickerSecondBg%>' + "," +
			'<%=colorPickerThirdBg%>' + "," +
			'<%=colorPickerFourthBg%>' + "," +
			'<%=colorPickerFifthBg%>' +
			")";

	document.getElementById('<%=colorPickerFirstLabelId%>').getElementsByTagName('p')[0].textContent="<%=colorPickerFirstBg%>";
	document.getElementById('<%=colorPickerSecondLabelId%>').getElementsByTagName('p')[0].textContent="<%=colorPickerSecondBg%>";
	document.getElementById('<%=colorPickerThirdLabelId%>').getElementsByTagName('p')[0].textContent="<%=colorPickerThirdBg%>";
	document.getElementById('<%=colorPickerFourthLabelId%>').getElementsByTagName('p')[0].textContent="<%=colorPickerFourthBg%>";
	document.getElementById('<%=colorPickerFifthLabelId%>').getElementsByTagName('p')[0].textContent="<%=colorPickerFifthBg%>";

	document.getElementById('<%=colorPickerFirstInputId%>').value="<%=colorPickerFirstBg%>";
	document.getElementById('<%=colorPickerSecondInputId%>').value="<%=colorPickerSecondBg%>";
	document.getElementById('<%=colorPickerThirdInputId%>').value="<%=colorPickerThirdBg%>";
	document.getElementById('<%=colorPickerFourthInputId%>').value="<%=colorPickerFourthBg%>";
	document.getElementById('<%=colorPickerFifthInputId%>').value="<%=colorPickerFifthBg%>";

	// Input change listeners
	document.getElementById('<%=colorPickerFirstInputId%>').oninput = (e) => {
		document.getElementById('<%=colorPickerFirstLabelId%>').getElementsByTagName('p')[0].textContent = e.target.value;
		updateGradient();
	};
	document.getElementById('<%=colorPickerSecondInputId%>').oninput = (e) => {
		document.getElementById('<%=colorPickerSecondLabelId%>').getElementsByTagName('p')[0].textContent = e.target.value;
		updateGradient();
	};
	document.getElementById('<%=colorPickerThirdInputId%>').oninput = (e) => {
		document.getElementById('<%=colorPickerThirdLabelId%>').getElementsByTagName('p')[0].textContent = e.target.value;
		updateGradient();
	};
	document.getElementById('<%=colorPickerFourthInputId%>').oninput = (e) => {
		document.getElementById('<%=colorPickerFourthLabelId%>').getElementsByTagName('p')[0].textContent = e.target.value;
		updateGradient();
	};
	document.getElementById('<%=colorPickerFifthInputId%>').oninput = (e) => {
		document.getElementById('<%=colorPickerFifthLabelId%>').getElementsByTagName('p')[0].textContent = e.target.value;
		updateGradient();
	};

	function updateGradient() {
		document.getElementById('<%=colorPickerBgId%>').style.backgroundImage =
				"linear-gradient(" +
				document.getElementById('<%=colorPickerFirstLabelId%>').getElementsByTagName('p')[0].textContent + "," +
				document.getElementById('<%=colorPickerSecondLabelId%>').getElementsByTagName('p')[0].textContent + "," +
				document.getElementById('<%=colorPickerThirdLabelId%>').getElementsByTagName('p')[0].textContent + "," +
				document.getElementById('<%=colorPickerFourthLabelId%>').getElementsByTagName('p')[0].textContent + "," +
				document.getElementById('<%=colorPickerFifthLabelId%>').getElementsByTagName('p')[0].textContent +
				")";
	}
</script>
