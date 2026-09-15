<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="com.ejada.telemony.db.model.Localization"%>
<%@page import="com.ejada.telemony.db.model.Languages"%>
<%@page import="com.ejada.telemony.db.model.Feature"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<link rel="stylesheet"
	  href="<%=request.getContextPath()%>/css/codemirror.css">

<link rel="stylesheet"
	  href="<%=request.getContextPath()%>/css/dracula.css">

<link rel="stylesheet"
	  href="<%=request.getContextPath()%>/css/matchesonscrollbar.css">

<style>
	.CodeMirror {
		height: 70vh;
	}
</style>



<%
	List<Localization> locals = (List<Localization>) request.getAttribute("locals") != null
			? (List<Localization>) request.getAttribute("locals")
			: new ArrayList<>();
	List<String> languagesNames = (List<String>) request.getAttribute("languagesNames") != null
			? (List<String>) request.getAttribute("languagesNames")
			: new ArrayList<>();
	List<Feature> pages = (List<Feature>) request.getAttribute("pages") != null
			? (List<Feature>) request.getAttribute("pages")
			: new ArrayList<>();
	long selectedFeatureId = request.getAttribute("selectedFeatureId") != null
			? (Long) request.getAttribute("selectedFeatureId")
			: 0;
	String errorMessage = (String) request.getAttribute("errorMessage") != null
			? (String) request.getAttribute("errorMessage")
			: "";
	boolean hasPendingDraft = request.getAttribute("hasPendingDraft") != null
			? (Boolean) request.getAttribute("hasPendingDraft")
			: false;
	Boolean hasPendingImport = (Boolean) request.getAttribute("hasPendingImport");
	if (hasPendingImport == null) hasPendingImport = false;
	String tabsNames = String.join(",", languagesNames);
%>

<portlet:renderURL var="pageChangeURL">
	<portlet:param name="myview" value="add" />
</portlet:renderURL>

<portlet:actionURL name="updateLocalization" var="updateLocalization">
	<portlet:param name="myview" value="add" />
</portlet:actionURL>

<portlet:actionURL name="rollbackLocalization"
				   var="rollbackLocalization">
	<portlet:param name="myview" value="add" />
</portlet:actionURL>


<portlet:actionURL name="exportLocalization" var="exportLocalizationURL" />
<portlet:actionURL name="importLocalization" var="importLocalizationURL" />

<%
	if (languagesNames.isEmpty()) {
%>
<div class="h3 p-4 mb-4 text-secondary text-dark text-center">No
	Languages found in current channel</div>

<%
} else {
%>
<form method="post" id="localizationUpdateForm"
	  action="<%=updateLocalization%>">
	<div class="languagesIDs">
		<%
			for (int i = 0; i < languagesNames.size(); i++) {
		%>

		<textarea class="d-none" id="<%=languagesNames.get(i)%>Value"><%=(locals.get(i) != null)
				? (locals.get(i).getLocalValue() != null ? locals.get(i).getLocalValue() : "")
				: "{}"%></textarea>
		<%
			}
		%>
	</div>
	<input class="d-none" type="text" id="clickedLang"
		   name="<portlet:namespace/>clickedLang" /> <input class="d-none"
															type="text" id="confirmation" name="<portlet:namespace/>confirmation" />
	<input type="hidden" id="selectedFeatureId" name="<portlet:namespace/>selectedFeatureId" value="<%=selectedFeatureId%>" />
	<%
		for (int i = 0; i < locals.size(); i++) {
	%>
	<input class="d-none" type="text" id="<%=languagesNames.get(i)%>langId"
		   name="<portlet:namespace/><%=languagesNames.get(i)%>langId" />
	<input class="d-none" type="text" id="<%=languagesNames.get(i)%>LocalizationId"
		   value="<%=(locals.get(i) != null) ? locals.get(i).getLocalizationId() : 0%>" />
	<%
		}
	%>

	<div>
		<div class="my-4 d-flex justify-content-between align-items-center">
			<div>
				<h1>Localization</h1>
				<p class="text-secondary">Manage
					Localization</p>
			</div>
			<% if ((isAdministrator || isPo || isTranslator) && !hasPendingDraft) { %>
			<div>
				<% if (!hasPendingImport) { %>
				<button type="button" class="btn btn-secondary mr-2" onclick="openImportModal();">
					Import
				</button>
				<% } %>
				<button type="button" class="btn btn-primary" onclick="openExportModal()">
					Export
				</button>
			</div>
			<% } %>
		</div>

		<% if (!pages.isEmpty()) { %>
		<div class="form-group row mb-4">
			<label for="pageSelect" class="col-auto col-form-label">Page</label>
			<div class="col-sm-3">
				<select class="form-control" id="pageSelect" onchange="onPageChange(this)">
					<% for (Feature featurePage : pages) { %>
						<option value="<%=featurePage.getFeatureId()%>" <%=featurePage.getFeatureId() == selectedFeatureId ? "selected" : ""%>><%=featurePage.getFeatureName()%></option>
					<% } %>
				</select>
			</div>
		</div>
		<% } %>

		<liferay-ui:error key="error" message="<%=errorMessage%>" />
		<liferay-ui:error key="notAuthorized" message="You are not authorized to perform this action." />
		<liferay-ui:error key="import-processing-error" message="An error occurred while processing the import. Please check if you uploaded the correct file, then try again."/>


		<% if (hasPendingDraft) { %>
		<div class="alert alert-warning">
			<strong>Warning:</strong> Editing is locked because there is a pending change awaiting approval.
		</div>
		<% } %>


		<liferay-ui:tabs names="<%=tabsNames%>" refresh="false"
						 onClick="setClickedLang(this)">
			<%
				for (int i = 0; i < languagesNames.size(); i++) {
			%>
			<div class=""></div>
			<liferay-ui:section>
				<%
					if (locals.get(i) != null) {
				%>
				<div class="d-flex align-items-center mb-1">
					<span class="badge badge-dark h5 px-3 p-2">last modified by:
						<%=locals.get(i).getUserName()%></span>
				</div>
				<div class="d-flex align-items-center">
					<span class="badge badge-dark h5 px-3 p-2">current version:
						<%=locals.get(i).getVersion()%></span>
					<%
						if (locals.get(i).getVersion() > 1) {
					%>
					<% if (!isOther && !hasPendingDraft) { %>
					<button class="badge badge-dark p-2" onclick="openRollbackModal()"
							type="button">
						<svg xmlns="http://www.w3.org/2000/svg" height="1em"
							 viewBox="0 0 512 512" fill="#FFFFFF">
							<!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
							<path
									d="M125.7 160H176c17.7 0 32 14.3 32 32s-14.3 32-32 32H48c-17.7 0-32-14.3-32-32V64c0-17.7 14.3-32 32-32s32 14.3 32 32v51.2L97.6 97.6c87.5-87.5 229.3-87.5 316.8 0s87.5 229.3 0 316.8s-229.3 87.5-316.8 0c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0c62.5 62.5 163.8 62.5 226.3 0s62.5-163.8 0-226.3s-163.8-62.5-226.3 0L125.7 160z" /></svg>
					</button>
					<% } %>
					<%
						}
					%>
				</div>
				<%
				} else {
				%><div class="d-flex align-items-center">
					<span class="badge badge-dark h5 px-3 p-2">please add your
						first version</span>
			</div>

				<%
					}
				%>

				<div class="my-3">
					<textarea
							name="<portlet:namespace/><%=languagesNames.get(i)%>TextArea"
							id="<%=languagesNames.get(i)%>TextArea"></textarea>
					<div class="form-check d-flex align-items-center mt-2">
						<input class="form-check-input" type="checkbox"
							   id="<%=languagesNames.get(i)%>LineNumbers" checked
							   onchange="checkShowLineNumbers(this)" /> <label
							class="form-check-label mx-1 mr-2"
							for="<%=languagesNames.get(i)%>LineNumbers">Show Line
						Number</label> 
						<% if (!isOther) { %>
						<input class="form-check-input" type="checkbox"
											  id="<%=languagesNames.get(i)%>ReadOnly"
											  onchange="checkReadOnly(this)" /> <label
							class="form-check-label mx-1 mr-2"
							for="<%=languagesNames.get(i)%>ReadOnly">Read Only</label>
						<% } %>
					</div>
					<% if (!isOther) { %>
					<div class="d-flex align-items-center mt-1" style="gap: 10px;">
						<input type="text" class="form-control w-25" style="height: 33px;"
							   id="<%=languagesNames.get(i)%>SearchInput"
							   placeholder="Enter your Keyword..." />
						<button type="button" class="btn btn-primary btn-sm"
								id="<%=languagesNames.get(i)%>Search"
								onclick="codeMirrorSearch(this)">Search</button>
						<button type="button" class="btn btn-outline-primary btn-sm"
								id="<%=languagesNames.get(i)%>FindPrev"
								onclick="codeMirrorFindPrev(this)">Find Prev</button>
						<button type="button" class="btn btn-outline-primary btn-sm"
								id="<%=languagesNames.get(i)%>FindNext"
								onclick="codeMirrorFindNext(this)">Find Next</button>
						<button type="button" class="btn btn-outline-primary btn-sm"
								id="<%=languagesNames.get(i)%>Clear" onclick="clearSearch(this)">Clear</button>
					</div>
					<% if (!hasPendingDraft) { %>
					<div class="d-flex align-items-center mt-2" style="gap: 10px;">
						<input type="text" class="form-control w-25" style="height: 33px;"
							   id="<%=languagesNames.get(i)%>ReplaceInput"
							   placeholder="Replace with..." />
						<button type="button" class="btn btn-primary btn-sm"
								id="<%=languagesNames.get(i)%>ReplaceOne"
								onclick="codeMirrorReplace(this)">Replace</button>
						<button type="button" class="btn btn-outline-primary btn-sm"
								id="<%=languagesNames.get(i)%>ReplaceAll"
								onclick="codeMirrorReplaceAll(this)">Replace All</button>
					</div>
					<% } %>
					<% } %>
				</div>
			</liferay-ui:section>
			<%
				}
			%>
		</liferay-ui:tabs>

		<div class="my-4 d-flex justify-content-end">
			<% if (hasPendingDraft) { %>
			<button type="button" class="btn btn-secondary px-5"
					onclick="history.back()">BACK</button>
			<% } else { %>
			<button type="button" class="btn btn-secondary px-5 mr-3"
					onclick="history.back()"><% if (!isOther) { %>CANCEL<% } else { %>BACK<% } %></button>
			<% if (!isOther) { %>
			<button type="button" class="btn btn-outline-primary px-5  mr-3"
					onclick="validate()">VALIDATE</button>
			<button type="button" class="btn btn-primary px-5"
					onclick="openConfirmModal()">SAVE</button>
			<% } %>
			<% } %>
		</div>
	</div>
</form>
<div class="modal hide fade" id="localizationErrorModal" tabindex="-1"
	 role="dialog" aria-labelledby="localizationErrorModalCenteredTitle"
	 aria-hidden="true">
	<div
			class="modal-dialog modal-dialog-scrollable modal-dialog-centered w-100"
			role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="localizationErrorModalTitle"></h5>
				<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5" id="localizationErrorModalBody"></div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-primary" onclick="closeModal()">Close</button>
			</div>
		</div>
	</div>
</div>
<div class="modal hide fade" id="localizationConfirmModal" tabindex="-1"
	 role="dialog" aria-labelledby="localizationConfirmModalCenteredTitle"
	 aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="localizationConfirmModalTitle">UPDATE</h5>
				<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center"
				 id="localizationErrorModalBody">Are you sure you want to
				update Localization?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary"
						onclick="closeConfirmModal()">Cancel</button>
				<button type="submit" class="btn btn-primary"
						onclick="updateLocalization()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<div class="modal hide fade" id="localizationRollbackModal"
	 tabindex="-1" role="dialog"
	 aria-labelledby="localizationRollbackModalCenteredTitle"
	 aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-100" role="document">
		<div class="modal-content w-auto m-auto">
			<div class="modal-header">
				<h5 class="modal-title" id="localizationConfirmModalTitle">Rollback</h5>
				<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-5 text-center"
				 id="localizationErrorModalBody">Are you sure you want the
				previous version?</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary"
						onclick="closeRollbackModal()">Cancel</button>
				<button type="submit" class="btn btn-primary"
						onclick="rollBackLocalization()">Confirm</button>
			</div>
		</div>
	</div>
</div>
<form method="post" id="localizationRollbackForm"
	  action="<%=rollbackLocalization%>">
	<input class="d-none" type="text" id="languageId"
		   name="<portlet:namespace/>languageId" />
	<input type="hidden" name="<portlet:namespace/>selectedFeatureId" value="<%=selectedFeatureId%>" />
</form>

<%
	}
%>
<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/codemirror.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/javascript.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jump-to-line.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/matchesonscrollbar.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/match-highlighter.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/search.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/searchcursor.js"></script>

<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/lodash.js"></script>

<script>
	var clickedLang = document.getElementById("clickedLang");
	var validateButton = document.getElementById("validateButton");
	var searchCursor = null;
	var codeMirrors = new Map();
	var initialCodeMirrorsState = new Map();
	var languagesIDs = Array.from(document.querySelectorAll(".languagesIDs textarea"));

	function onPageChange(selectElement) {
		var selectedFeatureId = selectElement.value;
		var baseUrl = '<%=pageChangeURL%>';
		window.location.href = baseUrl + '&<portlet:namespace/>selectedFeatureId=' + selectedFeatureId;
	}

	if(languagesIDs.length > 0){
		languagesIDs.map(function(ele){
			var editor = CodeMirror.fromTextArea(document
					.getElementById(ele.id.slice(0,-5)+"TextArea"), {
				lineNumbers : true,
				mode : "application/json",
				theme : "dracula",
				search : true,
				readOnly : <%= isOther ? "true" : "false" %>,
			});
			editor.setValue(ele.value);
			codeMirrors.set(ele.id.slice(0,-5),editor);
			initialCodeMirrorsState.set(ele.id.slice(0,-5), ele.value);
		});

		document.getElementById('clickedLang').value=languagesIDs[0].id.slice(0,-5);

	}

	function checkShowLineNumbers(checkBox) {
		var isChecked = checkBox.checked;
		var id = checkBox.id.slice(0, -11);
		var codeMirror = codeMirrors.get(id);
		codeMirror.setOption("lineNumbers", isChecked);
		codeMirrors.set(id,codeMirror);
	}

	function checkReadOnly(checkBox) {
		var isChecked = checkBox.checked;
		var id = checkBox.id.slice(0, -8);
		var codeMirror = codeMirrors.get(id);
		codeMirror.setOption("readOnly", !isChecked);
		codeMirrors.set(id,codeMirror);
	}

	function createCodeMirror(lang){
		var textareaId = lang + "TextArea";
		var editor = CodeMirror.fromTextArea(document
				.getElementById(textareaId), {
			lineNumbers : true,
			mode : "application/json",
			theme : "dracula",
			search : true,
			readOnly : true,
		});
		editor.setValue(document.getElementById(lang+"Value").value);
		codeMirrors.set(lang,editor);
	}

	function setClickedLang(e){
		var lang = e.innerText.trim();
		document.getElementById('clickedLang').value=lang;
		setTimeout(()=>{codeMirrors.get(lang).refresh()},1);
	}

	function checkJSONKeys() {
		let result = [];
		const codeMirrorsArray = Array.from(codeMirrors.values());

		for (let i = 0; i < codeMirrorsArray.length; i++) {
			const jsonObject1 = JSON.parse(codeMirrorsArray[i].getValue());

			for (let j = 0; j < codeMirrorsArray.length; j++) {
				const jsonObject2 = JSON.parse(codeMirrorsArray[j].getValue());

				result.push(..._.difference(Object.keys(jsonObject1), (Object.keys(jsonObject2))));
			}
		}
		return new Set(result); // All pairs are equal
	}

function changeDetect() {
    console.log("========== CHANGE DETECTION START ==========");

    initialCodeMirrorsState.forEach(function (initialJSONString, langKey) {
        // Ensure key is string (extra safety)
        langKey = String(langKey).trim();

        const currentEditor = codeMirrors.get(langKey);
        if (!currentEditor) {
            console.warn("No editor found for language:", langKey);
            return;
        }

        const currentJSONString = currentEditor.getValue();

        // If completely identical (including formatting)
        if (initialJSONString === currentJSONString) {
            console.log("[" + langKey + "] No changes detected.");
            return;
        }

        try {
            const initialData = JSON.parse(initialJSONString || "{}");
            const currentData = JSON.parse(currentJSONString || "{}");

            const initialKeys = Object.keys(initialData);
            const currentKeys = Object.keys(currentData);

            const addedKeys = _.difference(currentKeys, initialKeys);
            const deletedKeys = _.difference(initialKeys, currentKeys);
            const commonKeys = _.intersection(initialKeys, currentKeys);

            const changedValues = [];
            commonKeys.forEach(function (key) {
                if (initialData[key] !== currentData[key]) {
                    changedValues.push({
                        key: key,
                        oldValue: initialData[key],
                        newValue: currentData[key]
                    });
                }
            });

            // If only formatting changed
            if (
                addedKeys.length === 0 &&
                deletedKeys.length === 0 &&
                changedValues.length === 0
            ) {
                console.log("[" + langKey + "] No functional changes (formatting only).");
                return;
            }

            console.log("---------- Changes for [" + langKey + "] ----------");

            if (addedKeys.length > 0) {
                console.log("Added Keys:");
                addedKeys.forEach(function (key) {
                    console.log("Key:", key, "| New Value:", currentData[key]);
                });
            }

            if (deletedKeys.length > 0) {
                console.log("Deleted Keys:");
                deletedKeys.forEach(function (key) {
                    console.log("Key:", key, "| Old Value:", initialData[key]);
                });
            }

            if (changedValues.length > 0) {
                console.log("Changed Values:");
                changedValues.forEach(function (item) {
                    console.log("Key:", item.key, "| Old:", item.oldValue, "| New:", item.newValue);
                });
            }
        } catch (e) {
            console.error("[" + langKey + "] JSON parsing failed:", e.message);
        }
    });

    console.log("========== CHANGE DETECTION END ==========");
}


	function validate(update=false){
		var lang = "";
		try {
			codeMirrors.forEach((value,key)=>{
				lang = key;
				// Try to parse the JSON content
				const parsedJSON = JSON.parse(value.getValue());
				if(parsedJSON[""])
					throw {"message":"Invalid Empty key with value '"+ parsedJSON[""] + "'"};
				const formattedJSON = JSON.stringify(parsedJSON, null, 2);
				value.setValue(formattedJSON);
				codeMirrors.set(key,value);
			});
			var keysResult = checkJSONKeys();
			if(keysResult.size > 0) {
				setModalContent("Validation Error",
						"Check following keys are existing in all languages:<br>"+Array.from(keysResult).join("<br>"));
				document.getElementById('confirmation').value="error";
				return false;
			}
			else {
				changeDetect();
				document.getElementById('confirmation').value="done";
				if(!update)
					setModalContent("Validation Successful",
							"JSON has been validated successfully in all languages");
				return true;
			}
		}
		catch (error) {
			setModalContent("Validation Error", error.message+" in "+lang+" content");
			document.getElementById('confirmation').value="error";
			return false;
		}
	}


	function openModal() {
		$("#localizationErrorModal").modal("show");
		$("#localizationErrorModal").removeClass("hide");
	}

	function closeModal() {
		$("#localizationErrorModal").modal("hide");
		$("#localizationErrorModal").addClass("hide");
	}

	function openConfirmModal() {
		$("#localizationConfirmModal").modal("show");
		$("#localizationConfirmModal").removeClass("hide");
	}

	function closeConfirmModal() {
		$("#localizationConfirmModal").modal("hide");
		$("#localizationConfirmModal").addClass("hide");
	}

	function openRollbackModal() {
		$("#localizationRollbackModal").modal("show");
		$("#localizationRollbackModal").removeClass("hide");
	}

	function closeRollbackModal() {
		$("#localizationRollbackModal").modal("hide");
		$("#localizationRollbackModal").addClass("hide");
	}

	function rollBackLocalization(actionURL){
		document.getElementById("languageId").value = document.getElementById("clickedLang").value;
		document.getElementById("localizationRollbackForm").submit();

	}

	function setModalContent(title, body) {
		document.getElementById("localizationErrorModalTitle").textContent = title;
		document.getElementById("localizationErrorModalBody").innerHTML = body;
		openModal();

	}

	function codeMirrorSearch(searchButton) {
		var lang = searchButton.id.slice(0,-6);
		var searchInputId = lang+"SearchInput";
		var searchTerm = document.getElementById(searchInputId).value;

		// Create a search cursor for the search term
		searchCursor = codeMirrors.get(lang).getSearchCursor(searchTerm);
		// Clear search highlights
		codeMirrors.get(lang).getAllMarks().forEach(function (mark) {
			mark.clear();
		});
		// Find the first occurrence of the search term
		while (searchCursor.findNext()) {
			codeMirrors.get(lang).markText(searchCursor.from(), searchCursor.to(), {
				className : "cm-overlay cm-searching highlighted", // Apply a CSS class to highlight the matches
			});
		}
	};

	function codeMirrorFindNext(findNextButton) {
		var lang = findNextButton.id.slice(0,-8);
		var searchInputId = lang+"SearchInput";
		var searchTerm = document.getElementById(searchInputId).value;
		if (searchCursor && searchTerm) {
			// Move to the next match
			if (searchCursor.findNext()) {
				// Set the selection to highlight the found text
				codeMirrors.get(lang).setSelection(searchCursor.from(), searchCursor
						.to());
			} else {
				// If no more matches, reset the cursor to the beginning
				searchCursor = codeMirrors.get(lang).getSearchCursor(searchTerm);
				if (searchCursor.findNext()) {
					// Set the selection to highlight the found text
					codeMirrors.get(lang).setSelection(searchCursor.from(), searchCursor
							.to());
				}
			}
		}
	}

	function codeMirrorFindPrev(prevButton) {
		var lang = prevButton.id.slice(0,-8);
		var searchInputId = lang+"SearchInput";
		var searchTerm = document.getElementById(searchInputId).value;

		if (searchCursor && searchTerm) {
			// Move to the next match
			if (searchCursor.findPrevious()) {
				// Set the selection to highlight the found text
				codeMirrors.get(lang).setSelection(searchCursor.from(), searchCursor
						.to());
			} else {
				// If no more matches, reset the cursor to the beginning
				searchCursor = codeMirrors.get(lang).getSearchCursor(searchTerm);
				while (searchCursor.findNext()) {
				}
				if (searchCursor.findPrevious()) {
					codeMirrors.get(lang).setSelection(searchCursor.from(), searchCursor
							.to());
				}

			}
		}
	}

	function codeMirrorReplace(replaceOneButton) {
		var lang = replaceOneButton.id.slice(0,-10);
		var replaceTerm = document.getElementById(lang+"ReplaceInput").value;
		var searchTerm = document.getElementById(lang+"SearchInput").value;
		if (!searchCursor || !searchCursor.from()) {
			searchCursor = codeMirrors.get(lang).getSearchCursor(searchTerm);
			try {
				searchCursor.findNext();
			} catch (error) {
				console.log(error.meesage);
			}

			console.log("New Cursor")
		}
		if (searchCursor.from() && replaceTerm) {
			codeMirrors.get(lang).setSelection(searchCursor.from(), searchCursor.to());
			searchCursor.replace(replaceTerm);
			try {
				searchCursor.findNext();
				codeMirrors.get(lang).setSelection(searchCursor.from(), searchCursor
						.to());
			} catch (error) {
				console.log(error.meesage);
			}
		}
	}

	function codeMirrorReplaceAll(replaceAllButton) {
		var lang = replaceAllButton.id.slice(0,-10);
		var replaceTerm = document.getElementById(lang+"ReplaceInput").value;
		var searchTerm = document.getElementById(lang+"SearchInput").value;
		searchCursor =codeMirrors.get(lang).getSearchCursor(searchTerm);
		if (searchCursor && replaceTerm) {
			while (searchCursor.findNext()) {
				codeMirrors.get(lang).setSelection(searchCursor.from(), searchCursor
						.to());
				searchCursor.replace(replaceTerm);
			}
		}
	}

	function clearSearch(clearButton){
		var lang = clearButton.id.slice(0,-5);
		document.getElementById(lang+"ReplaceInput").value="";
		document.getElementById(lang+"SearchInput").value="";
		codeMirrors.get(lang).getAllMarks().forEach(function (mark) {
			mark.clear(); // Clear search highlights
		});
	}

	function updateLocalization(){
		closeConfirmModal();
		if(validate(update=true)){
			document.getElementById("localizationUpdateForm").submit();
		}
	}


	// Export functions - collect all localization IDs from all languages
	function openExportModal() {
		// Get all language names
		var languagesNames = [];
		<%
			for (int i = 0; i < languagesNames.size(); i++) {
		%>
		languagesNames.push('<%=languagesNames.get(i)%>');
		<%
			}
		%>

		// Collect all localizationIds
		var localizationIds = [];
		var hasAtLeastOne = false;

		for (var i = 0; i < languagesNames.length; i++) {
			var localizationIdField = document.getElementById(languagesNames[i] + 'LocalizationId');
			if (localizationIdField && localizationIdField.value && localizationIdField.value != '0') {
				localizationIds.push(localizationIdField.value);
				hasAtLeastOne = true;
			}
		}

		if (!hasAtLeastOne) {
			alert('No localizations available to export.');
			return;
		}

		// Store the localizationIds for later use (as comma-separated string)
		document.getElementById('exportLocalizationIds').value = localizationIds.join(',');

		// Show the export summary modal
		$("#telemoneyExportModal").modal("show");
		$("#telemoneyExportModal").removeClass("hide");
	}

	function confirmExport() {
		var summary = document.getElementById('exportSummary').value.trim();
		var localizationIdsStr = document.getElementById('exportLocalizationIds').value;

		if (!localizationIdsStr || localizationIdsStr == '') {
			alert('No valid localizations to export.');
			return;
		}

		var localizationIds = localizationIdsStr.split(',');
		var exportForm = document.getElementById('exportLocalizationForm');
		// Clear previous hidden inputs
		var container = document.getElementById('exportLocalizationIdsContainer');
		container.innerHTML = '';

		// Add all localization IDs
		for (var i = 0; i < localizationIds.length; i++) {
			var localizationInput = document.createElement('input');
			localizationInput.type = 'hidden';
			localizationInput.name = '<portlet:namespace/>localizationIds';
			localizationInput.value = localizationIds[i];
			container.appendChild(localizationInput);
		}

		// Add summary
		var summaryInput = document.createElement('input');
		summaryInput.type = 'hidden';
		summaryInput.name = '<portlet:namespace/>exportSummary';
		summaryInput.value = summary;
		container.appendChild(summaryInput);

		// Close modal
		$("#telemoneyExportModal").modal("hide");
		$("#telemoneyExportModal").addClass("hide");

		// Submit form
		exportForm.submit();

		// Reset
		document.getElementById('exportSummary').value = '';
	}

	function openImportModal() {
		// Defined in importModal.jsp
	}
</script>

<!-- Export Modal -->
<div class="modal hide fade" id="telemoneyExportModal" tabindex="-1"
	 role="dialog" aria-labelledby="telemoneyExportModalTitle"
	 aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-sm" role="document" style="max-width: 450px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="telemoneyExportModalTitle">Export Localization</h5>
				<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="exportSummary">Export Summary (optional):</label>
					<textarea class="form-control" id="exportSummary" rows="3"
							  placeholder="Enter export summary..."></textarea>
				</div>
			</div>
			<div class="modal-footer justify-content-end">
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary"
						onclick="confirmExport()">Confirm Export</button>
			</div>
		</div>
	</div>
</div>

<!-- Hidden input to store all localization IDs for export -->
<input type="hidden" id="exportLocalizationIds" value="" />

<!-- Hidden form for export -->
<form action="<%=exportLocalizationURL%>" method="post" id="exportLocalizationForm" class="d-none">
	<div id="exportLocalizationIdsContainer"></div>
</form>

<!-- Import Modal (separate JSP) -->
<%@ include file="/importModal.jsp"%>

