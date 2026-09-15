<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ include file="/init.jsp"%>
<%@page import="com.ejada.telemony.db.model.Themes"%>
<%@page import="com.ejada.telemony.db.model.Persona"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
if (isOther) {
    response.getWriter().write("You are not authorized to access this page.");
    return;
}

Boolean viewOnly = request.getAttribute("viewOnly") != null
		? (Boolean) request.getAttribute("viewOnly")
		: false;
%>

<portlet:renderURL var="backToview">
	<portlet:param name="action" value="view" />
</portlet:renderURL>

<portlet:renderURL var="reset">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>



<%
	Themes targetTheme = (Themes) request.getAttribute("targetTheme");
	long themeId = 0;
	String themeEnName = "";
	String themeArName = "";
	String splashBg = "";
	String splashAnimation = "";
	String headerBg = "";
	String balanceBg = "";
	boolean defaultTheme = false;
	List<Persona> checkTheme = (List<Persona>) request.getAttribute("checkTheme") != null
			? (List<Persona>) request.getAttribute("checkTheme")
			: new ArrayList<>();
	boolean darkTheme = false;

	JSONObject neutral =  JSONFactoryUtil.createJSONObject();
	neutral.put("black", "#1A1F2D");
	neutral.put("gray1", "#3B3F50");
	neutral.put("gray2", "#6E7184");
	neutral.put("gray3", "#B6B9CE");
	neutral.put("gray4", "#E8EBFF");
	neutral.put("gray5", "#F4F6FF");
	neutral.put("gray6", "#6e7184");
	neutral.put("white", "#FFFFFF");
	neutral.put("disabledGray", "#F7F8FF");
	neutral.put("cards", "#282A33");
	neutral.put("Background", "#F8F8F8");

	JSONObject primary =JSONFactoryUtil.createJSONObject();
	primary.put("bg", "#FFE9EF");
	primary.put("light", "#F1919B");
	primary.put("dark", "#CC0029");
	primary.put("default", "#F43653");
	primary.put("disabled", "#E3B9BF");
	primary.put("icon", "#F43653");

	JSONObject secondary = JSONFactoryUtil.createJSONObject();
	secondary.put("bg", "#E5E8F2");
	secondary.put("light", "#4C63A3");
	secondary.put("dark", "#00153D");
	secondary.put("default", "#00205F");
	secondary.put("disabled", "#959DAF");
	secondary.put("extra", "#4B63A3");

	JSONObject success = JSONFactoryUtil.createJSONObject();
	success.put("bg", "#F1F8E8");
	success.put("light", "#ACD77C");
	success.put("dark", "#2A6B12");
	success.put("default", "#88C540");
	success.put("success", "#78B538");

	JSONObject error = JSONFactoryUtil.createJSONObject();
	error.put("bg", "#FFECEF");
	error.put("light", "#FFCFD4");
	error.put("dark", "#E22025");
	error.put("default", "#FF7474");

	JSONObject warning = JSONFactoryUtil.createJSONObject();
	warning.put("bg", "#FFFDE6");
	warning.put("light", "#FFF06F");
	warning.put("dark", "#F87902");
	warning.put("default", "#FFC01E");

	JSONObject support = JSONFactoryUtil.createJSONObject();
	support.put("defaultYellow", "#FCDB7B");
	support.put("bgYellow", "#FFFBF2");
	support.put("lightBlue", "#618BEE");
	support.put("cardDefault", "#009DEA");
	support.put("cardDarkBlue", "#003E70");
	support.put("cardExtra", "#4C63A3");
	support.put("extra", "#4B63A3");
	support.put("logo","#FFFFFF");

	
	
	JSONObject primaryGd = JSONFactoryUtil.createJSONObject();
	JSONObject gradient =JSONFactoryUtil.createJSONObject();

	primaryGd.put("primary1", "#001F5F");
	primaryGd.put("primary2", "#001F5F");
	primaryGd.put("dashboardColorOne","0B378E");
	primaryGd.put("dashboardColorTwo","00205F");
	primaryGd.put("dashboardColorThree","F43653");

	gradient.put("primary", primaryGd);
	String actionRequired = "add";

	if (targetTheme != null) {
		themeId = targetTheme.getThemeId();
		actionRequired = "update";
		themeArName = targetTheme.getThemeArName();
		themeEnName = targetTheme.getThemeEnName();
		darkTheme = targetTheme.getDarkTheme();
		neutral = JSONFactoryUtil.createJSONObject(targetTheme.getNeutralColors());
		primary = JSONFactoryUtil.createJSONObject(targetTheme.getPrimaryColors());
		secondary =JSONFactoryUtil.createJSONObject(targetTheme.getSecondaryColors());
		success =JSONFactoryUtil.createJSONObject(targetTheme.getSuccessColors());
		error = JSONFactoryUtil.createJSONObject(targetTheme.getErrorColors());
		warning = JSONFactoryUtil.createJSONObject(targetTheme.getWarningColors());
		support = JSONFactoryUtil.createJSONObject(targetTheme.getSupportColors());
		gradient = JSONFactoryUtil.createJSONObject(targetTheme.getGradientColors());
		splashBg = targetTheme.getSplashBg();
		splashAnimation = targetTheme.getSplashAnimation();
		headerBg = targetTheme.getHeaderBg();
		balanceBg = targetTheme.getBalanceBg();
		defaultTheme = targetTheme.getDefaultTheme();
	}
%>

<portlet:actionURL name="addTheme" var="addTheme">
	<portlet:param name="modeConfigurable"
		value="<%=String.valueOf(checkTheme.isEmpty())%>" />
	<portlet:param name="selectedMode"
		value="<%=String.valueOf(darkTheme)%>" />
	<portlet:param name="defaultTheme"
		value="<%=String.valueOf(defaultTheme)%>" />
</portlet:actionURL>

<portlet:actionURL name="editTheme" var="editTheme">
	<portlet:param name="clickedTheme" value="<%=String.valueOf(themeId)%>" />
	<portlet:param name="targetAction" value="edit" />
</portlet:actionURL>

<portlet:actionURL name="viewTheme" var="viewTheme">
	<portlet:param name="clickedTheme" value="<%=String.valueOf(themeId)%>" />
</portlet:actionURL>
<div>
	<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
	<liferay-ui:error key="xssDetected" message="Invalid input: special characters are not allowed." />
	<liferay-ui:error key="file-upload-error" message="File upload error" />
	<form method="post" action="<%=addTheme%>" enctype="multipart/form-data" id="themeAddForm">
	<fieldset <%= isOther ? "disabled" : "" %>>
		<input type="text" name="<portlet:namespace/>themeId" id="themeId"
			class="d-none" value='<%=themeId%>' />
		<div class="card my-5">
			<div class="card-body p-3">
				<div class="d-flex align-items-center mb-3">
					<!-- 					<svg xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"
						width="20" height="20" viewBox="0 0 256 256" xml:space="preserve">

<g
							style="stroke: none; stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: none; fill-rule: nonzero; opacity: 1;"
							transform="translate(1.4065934065934016 1.4065934065934016) scale(2.81 2.81)">
	<path
							d="M 45 0 C 20.147 0 0 20.147 0 45 c 0 24.853 20.147 45 45 45 s 45 -20.147 45 -45 C 90 20.147 69.853 0 45 0 z M 53.504 70 H 41.897 V 33.049 l -11.401 3.331 v -8.791 L 52.439 20 h 1.065 V 70 z"
							style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1;"
							transform=" matrix(1 0 0 1 0 0) " stroke-linecap="round" />
</g>
</svg> -->
					<h3 class="my-0 mx-2">Theme Details</h3>
				</div>
				<hr />
				<div class="row">
					<div class="mb-3 col-md-6">
						<label class="form-label">Name (English)</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed."
							type="text" class="form-control" placeholder="Please Enter"
							name="<portlet:namespace/>themeEnName" value='<%=themeEnName%>'
							required />
					</div>
					<div class="mb-3 col-md-6">
						<label class="form-label">Name (Arabic)</label> <input pattern="^[^<>&quot;&#39;]+$"
 title="Special characters like < > ' &quot; are not allowed." type="text"
							class="form-control" placeholder="Please Enter"
							name="<portlet:namespace/>themeArName" value='<%=themeArName%>'
							required />
					</div>
				</div>
				<div class="mb-5">
					<%
						if (!checkTheme.isEmpty()) {
							String usedPersonas = "";
							for (Persona pers : checkTheme) {
								usedPersonas += pers.getName() + ", ";
							}
					%>
					<div class="alert alert-info" role="alert">
						Cannot change the mode as it is used in
						<%=usedPersonas.substring(0, usedPersonas.length() - 2)%>
					</div>
					<%
						}
					%>

					<div class="form-check d-flex align-items-center">
						<input class="form-check-input" type="checkbox"
							id="flexSwitchCheckDefault" name="<portlet:namespace/>darkTheme"
							<%=darkTheme ? "checked" : ""%>
							<%=!checkTheme.isEmpty() || defaultTheme ? "disabled" : ""%> />
						<label class="form-check-label mx-2" for="flexSwitchCheckDefault">This
							is a Dark Theme</label>
					</div>
				</div>
				<liferay-ui:tabs names="Theme details,Component" refresh="false">
					<liferay-ui:section>
						<div class="d-flex align-items-center mb-3">
							<!-- 					<svg xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"
						width="20" height="20" viewBox="0 0 256 256" xml:space="preserve">
<g
							style="stroke: none; stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: none; fill-rule: nonzero; opacity: 1;"
							transform="translate(1.4065934065934016 1.4065934065934016) scale(2.81 2.81)">
	<path
							d="M 45 0 C 20.147 0 0 20.147 0 45 c 0 24.853 20.147 45 45 45 s 45 -20.147 45 -45 C 90 20.147 69.853 0 45 0 z M 62.705 70 H 28.311 v -7.448 l 15.843 -16.656 c 3.905 -4.445 5.857 -7.977 5.857 -10.595 c 0 -2.121 -0.463 -3.735 -1.388 -4.841 s -2.268 -1.659 -4.029 -1.659 c -1.738 0 -3.148 0.74 -4.231 2.217 c -1.084 1.478 -1.625 3.323 -1.625 5.535 H 27.295 c 0 -3.024 0.756 -5.817 2.269 -8.379 c 1.512 -2.562 3.61 -4.565 6.297 -6.009 C 38.546 20.723 41.547 20 44.865 20 c 5.326 0 9.427 1.23 12.305 3.69 c 2.878 2.46 4.316 5.992 4.316 10.595 c 0 1.941 -0.362 3.831 -1.084 5.67 c -0.722 1.84 -1.844 3.77 -3.367 5.788 c -1.524 2.021 -3.978 4.723 -7.364 8.108 l -6.364 7.346 h 19.398 V 70 z"
							style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1;"
							transform=" matrix(1 0 0 1 0 0) " stroke-linecap="round" />
</g>
</svg> -->
							<h4 class="my-0">Select Colors For Theme</h4>
						</div>
						<hr />
						<h4 class="mb-3">Neutral Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelNeutral0" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral0" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("black").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Black" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral1" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral1" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral1" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("gray1").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Gray 1" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral2" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral2" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral2" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("gray2").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Gray 2" />

								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral3" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral3" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral3" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("gray3").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Gray 3" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral4" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral4" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral4" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("gray4").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Gray 4" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral5" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral5" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral5" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("gray5").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Gray 5" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral6" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral6" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral6" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("gray6").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Gray 6" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral7" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral7" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral7" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("white").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="White" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral8" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral8" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral8" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("disabledGray").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Disabled Gray" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdNeutral9" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdNeutral9" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdNeutral9" />
									<liferay-util:param name="colorPickerBg"
										value="<%=neutral.get("cards").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Cards" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
													  servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
														value="colorPickerLabelIdNeutral10" />
									<liferay-util:param name="colorPickerInputId"
														value="colorPickerInputIdNeutral10" />
									<liferay-util:param name="colorPickerBgId"
														value="colorPickerBgIdNeutral10" />
									<liferay-util:param name="colorPickerBg"
														value="<%=neutral.get("Background").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Background" />
								</liferay-util:include>
							</div>
						</div>


						<h4 class="mb-3">Primary Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdPrimary0" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdPrimary0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdPrimary0" />
									<liferay-util:param name="colorPickerBg"
										value="<%=primary.get("bg").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Background" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdPrimary1" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdPrimary1" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdPrimary1" />
									<liferay-util:param name="colorPickerBg"
										value="<%=primary.get("light").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Light" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdPrimary2" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdPrimary2" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdPrimary2" />
									<liferay-util:param name="colorPickerBg"
										value="<%=primary.get("dark").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Dark" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdPrimary3" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdPrimary3" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdPrimary3" />
									<liferay-util:param name="colorPickerBg"
										value="<%=primary.get("default").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Default" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdPrimary4" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdPrimary4" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdPrimary4" />
									<liferay-util:param name="colorPickerBg"
										value="<%=primary.get("disabled").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Disabled" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
													  servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
														value="colorPickerLabelIdPrimary5" />
									<liferay-util:param name="colorPickerInputId"
														value="colorPickerInputIdPrimary5" />
									<liferay-util:param name="colorPickerBgId"
														value="colorPickerBgIdPrimary5" />
									<liferay-util:param name="colorPickerBg"
														value="<%=primary.get("icon").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Icon" />
								</liferay-util:include>
							</div>
						</div>
						<h4 class="mb-3">Secondary Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSecondary0" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSecondary0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSecondary0" />
									<liferay-util:param name="colorPickerBg"
										value="<%=secondary.get("bg").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Background" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSecondary1" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSecondary1" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSecondary1" />
									<liferay-util:param name="colorPickerBg"
										value="<%=secondary.get("light").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Light" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSecondary2" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSecondary2" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSecondary2" />
									<liferay-util:param name="colorPickerBg"
										value="<%=secondary.get("dark").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Dark" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSecondary3" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSecondary3" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSecondary3" />
									<liferay-util:param name="colorPickerBg"
										value="<%=secondary.get("default").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Default" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSecondary4" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSecondary4" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSecondary4" />
									<liferay-util:param name="colorPickerBg"
										value="<%=secondary.get("disabled").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Disabled" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSecondary5" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSecondary5" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSecondary5" />
									<liferay-util:param name="colorPickerBg"
										value="<%=secondary.get("extra").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Extra" />
								</liferay-util:include>
							</div>
						</div>

						<h4 class="mb-3">Success Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSuccess0" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSuccess0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSuccess0" />
									<liferay-util:param name="colorPickerBg"
										value="<%=success.get("bg").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Background" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSuccess1" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSuccess1" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSuccess1" />
									<liferay-util:param name="colorPickerBg"
										value="<%=success.get("light").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Light" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSuccess2" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSuccess2" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSuccess2" />
									<liferay-util:param name="colorPickerBg"
										value="<%=success.get("dark").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Dark" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSuccess3" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSuccess3" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSuccess3" />
									<liferay-util:param name="colorPickerBg"
										value="<%=success.get("default").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Default" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSuccess4" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSuccess4" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSuccess4" />
									<liferay-util:param name="colorPickerBg"
										value="<%=success.get("success").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Success" />
								</liferay-util:include>
							</div>
						</div>


						<h4 class="mb-3">Error Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdError0" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdError0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdError0" />
									<liferay-util:param name="colorPickerBg"
										value="<%=error.get("bg").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Background" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdError1" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdError1" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdError1" />
									<liferay-util:param name="colorPickerBg"
										value="<%=error.get("light").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Light" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdError2" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdError2" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdError2" />
									<liferay-util:param name="colorPickerBg"
										value="<%=error.get("dark").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Dark" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdError3" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdError3" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdError3" />
									<liferay-util:param name="colorPickerBg"
										value="<%=error.get("default").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Default" />
								</liferay-util:include>
							</div>
						</div>

						<h4 class="mb-3">Warning Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdWarning0" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdWarning0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdWarning0" />
									<liferay-util:param name="colorPickerBg"
										value="<%=warning.get("bg").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Background" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdWarning1" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdWarning1" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdWarning1" />
									<liferay-util:param name="colorPickerBg"
										value="<%=warning.get("light").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Light" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdWarning2" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdWarning2" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdWarning2" />
									<liferay-util:param name="colorPickerBg"
										value="<%=warning.get("dark").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Dark" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdWarning3" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdWarning3" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdWarning3" />
									<liferay-util:param name="colorPickerBg"
										value="<%=warning.get("default").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Default" />
								</liferay-util:include>
							</div>
						</div>

						<h4 class="mb-3">Support Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport0" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport0" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("defaultYellow").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Default Yellow" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport1" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport1" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport1" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("bgYellow").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="BG Yellow" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport2" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport2" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport2" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("lightBlue").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Light Blue" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport3" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport3" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport3" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("cardDefault").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Default Card" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport4" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport4" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport4" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("cardDarkBlue").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Dark Blue Card" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport5" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport5" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport5" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("cardExtra").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Extra Card" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport6" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport6" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport6" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("extra").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Extra" />
								</liferay-util:include>
							</div>
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/singleColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerLabelId"
										value="colorPickerLabelIdSupport7" />
									<liferay-util:param name="colorPickerInputId"
										value="colorPickerInputIdSupport7" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdSupport7" />
									<liferay-util:param name="colorPickerBg"
										value="<%=support.get("logo").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Logo" />
								</liferay-util:include>
							</div>
						</div>

						<h4 class="mb-3">Gradient Colors</h4>
						<div class="row mb-4">
							<div class="mb-3 col-md-2">
								<liferay-util:include page="/gradientColorPicker.jsp"
									servletContext="<%=application%>">
									<liferay-util:param name="colorPickerFirstLabelId"
										value="colorPickerFirstLabelIdGrad0" />
									<liferay-util:param name="colorPickerSecondLabelId"
										value="colorPickerSecondLabelIdGrad0" />
									<liferay-util:param name="colorPickerThirdLabelId"
														value="colorPickerThirdLabelIdGrad0" />
									<liferay-util:param name="colorPickerFourthLabelId"
														value="colorPickerFourthLabelIdGrad0" />
									<liferay-util:param name="colorPickerFifthLabelId"
														value="colorPickerFifthLabelIdGrad0" />
									<liferay-util:param name="colorPickerFirstInputId"
										value="colorPickerFirstInputIdGrad0" />
									<liferay-util:param name="colorPickerSecondInputId"
										value="colorPickerSecondInputIdGrad0" />
									<liferay-util:param name="colorPickerThirdInputId"
														value="colorPickerThirdInputIdGrad0" />
									<liferay-util:param name="colorPickerFourthInputId"
														value="colorPickerFourthInputIdGrad0" />
									<liferay-util:param name="colorPickerFifthInputId"
														value="colorPickerFifthInputIdGrad0" />
									<liferay-util:param name="colorPickerBgId"
										value="colorPickerBgIdGrad0" />
									<liferay-util:param name="colorPickerFirstBg"
										value="<%=gradient.getJSONObject("primary").get("primary1").toString().toUpperCase()%>" />
									<liferay-util:param name="colorPickerSecondBg"
										value="<%=gradient.getJSONObject("primary").get("primary2").toString().toUpperCase()%>" />
									<liferay-util:param name="colorPickerThirdBg"
														value="<%=gradient.getJSONObject("primary").get("dashboardColorOne").toString().toUpperCase()%>" />
									<liferay-util:param name="colorPickerFourthBg"
														value="<%=gradient.getJSONObject("primary").get("dashboardColorTwo").toString().toUpperCase()%>" />
									<liferay-util:param name="colorPickerFifthBg"
														value="<%=gradient.getJSONObject("primary").get("dashboardColorThree").toString().toUpperCase()%>" />
									<liferay-util:param name="colorLabel" value="Primary" />
								</liferay-util:include>
							</div>
						</div>

					</liferay-ui:section>
					<liferay-ui:section>
						<div class="d-flex align-items-center mb-3">
							<h4 class="my-0 mx-2">Splash Screen Details</h4>
						</div>
						<div class="input-group mb-3 flex-column align-items-center">
							<div class="custom-file">
								<input name="<portlet:namespace/>imageBackgroundSplash"
									type="file" class="custom-file-input" id="imageBackgroundInput"
									onchange="customFile(event)"> <label
									class="custom-file-label" for="<imageBackgroundInput">Upload
									Image Background</label>
							</div>
							<img alt="" src="data:image/jpeg;base64,<%=splashBg%>"
								style="max-width: 100%" class="mt-3" id="imageBackground">
						</div>
						<div class="input-group mb-3 flex-column align-items-center">
							<div class="custom-file">
								<input name="<portlet:namespace/>splashAnimation" type="file"
									class="custom-file-input" id="splashAnimationInput"
									onchange="customFile(event)"> <label
									class="custom-file-label" for="splashAnimationInput">Upload
									Splash Animation</label>
							</div>
							<img alt="" src="data:image/jpeg;base64,<%=splashAnimation%>"
								style="max-width: 100%" class="mt-3" id="splashAnimation">
						</div>
						<h4>Header</h4>
						<div class="input-group mb-3 flex-column align-items-center">
							<div class="custom-file">
								<input name="<portlet:namespace/>imageBackgroundHeader"
									type="file" class="custom-file-input"
									id="imageBackgroundInputHeader" onchange="customFile(event)">
								<label class="custom-file-label"
									for="<imageBackgroundHeaderInput">Upload Image
									Background</label>
							</div>
							<img alt="" src="data:image/jpeg;base64,<%=headerBg%>"
								style="max-width: 100%" class="mt-3" id="imageBackgroundHeader">
						</div>
						<h4>Balance Component</h4>
						<div class="input-group mb-3 flex-column align-items-center">
							<div class="custom-file">
								<input name="<portlet:namespace/>imageBackgroundBalance"
									type="file" class="custom-file-input"
									id="imageBackgroundInputBalance" onchange="customFile(event)">
								<label class="custom-file-label"
									for="<imageBackgroundBalanceInput">Upload Image
									Background</label>
							</div>
							<img alt="" src="data:image/jpeg;base64,<%=balanceBg%>"
								style="max-width: 100%" class="mt-3" id="imageBackgroundBalance">
						</div>
					</liferay-ui:section>
				</liferay-ui:tabs>

				</fieldset>
				<div class="d-flex justify-content-end p-3">
					<% if (viewOnly) { %>
					<button type="button" class="btn btn-secondary px-5"
						onclick="window.location.href='<%=backToview%>'">BACK</button>
					<% } else { %>
					<button type="button" class="btn btn-secondary px-5 mr-3"
						onclick="window.location.href='<%=backToview%>'">CANCEL</button>
					<% if (!isOther) { %>
					<button type="button" class="btn btn-secondary px-5 mr-3"
						onclick="window.location.href='<%=themeId == 0 ? reset : editTheme%>'">RESET</button>
					<button type="button" class="btn btn-primary px-5" onclick="openSaveModal()">SAVE</button>
					<% } %>
					<% } %>
				</div>
			</div>
		</div>
	</form>
</div>

<!-- Save Confirmation Modal -->
<div class="modal hide fade" id="telemoneySaveModal" tabindex="-1"
	role="dialog" aria-labelledby="telemoneySaveModalCenteredTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="saveModalTitle"><%=themeId == 0 ? "Create" : "Update"%> Theme</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center">Are you sure you
				want to <%=themeId == 0 ? "create" : "update"%> this theme?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="saveThemeConfirm()">Confirm</button>
			</div>
		</div>
	</div>
</div>

<script>
	function customFile(e) {
		var fileName = 'Upload Image Background';
		var imageElement = e.target.parentElement.nextElementSibling;
		if (e.target.id == "splashAnimationInput")
			fileName = 'Upload Splash Animation';
		if (e.target.files[0]) {
			fileName = e.target.files[0].name;
			var imgFile = e.target.files[0];
			imageElement.src = URL.createObjectURL(imgFile);

		}
		e.target.nextElementSibling.textContent = fileName;
	}

	function openSaveModal() {
		$("#telemoneySaveModal").modal("show");
		$("#telemoneySaveModal").removeClass("hide");
	}

	function saveThemeConfirm() {
		document.getElementById('themeAddForm').submit();
	}
</script>