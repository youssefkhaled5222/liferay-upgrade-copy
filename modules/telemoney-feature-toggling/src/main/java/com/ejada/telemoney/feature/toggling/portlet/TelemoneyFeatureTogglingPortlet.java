package com.ejada.telemoney.feature.toggling.portlet;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.db.dto.BlockDTO;
import com.ejada.telemoney.feature.toggling.constants.TelemoneyFeatureTogglingPortletKeys;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.BlocksLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.FeatureLovMapLocalService;
import com.ejada.telemony.db.service.LovsLocalService;
import com.ejada.telemony.db.service.SegmentLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ShathaAR
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyFeatureToggling", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyFeatureTogglingPortletKeys.TELEMONEYFEATURETOGGLING,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user"

}, service = Portlet.class)
public class TelemoneyFeatureTogglingPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}

	private static final Log LOG = LogFactoryUtil.getLog(TelemoneyFeatureTogglingPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletSession pSession = renderRequest.getPortletSession();
		String view = "view";
		if (renderRequest.getAttribute("myview") != null)
			view = (String) renderRequest.getAttribute("myview");
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;

		List<Feature> features = _featureLocalService.getLatestApprovedByChannelId(chn);
		renderRequest.setAttribute("listOfFeatures", features);

		// Get features with pending versions
		Set<Long> featuresWithPending = getFeaturesWithPendingVersions(chn);
		renderRequest.setAttribute("featuresWithPending", featuresWithPending);

		boolean isBlueApp = false;
		try {
			Channels channel = _channelsLocalService.getChannels(chn);
			isBlueApp = channel != null && "Blue App".equalsIgnoreCase(channel.getName());
		} catch (PortalException e) {
			LOG.warn("Unable to resolve channel for feature toggling view routing. ChannelId: " + chn, e);
		}

		if (isBlueApp && (view.contains("view") || view.contains("add") || view.contains("edit-feature"))) {
			view = "blueApp/" + view;
		}

		if (view.contains("view")) {
			Map<Long, List<Segment>> featureSegmentsMap = new HashMap<>();
			for (Feature feature : features) {
				List<Segment> approvedSegments = _segmentLocalService.findSegmentsByResourceIds(
						feature.getEntityResourceId(),
						feature.getChildResourceId()
				);
				featureSegmentsMap.put(feature.getFeatureId(), approvedSegments);
			}
			renderRequest.setAttribute("featureSegmentsMap", featureSegmentsMap);
		}
		if (view.contains("add") || view.contains("edit-feature")) {
			List<Feature> allParentPages = _featureLocalService.getAllParentPages(chn);

			List<Feature> availableParentPages = new ArrayList<>();
			for (Feature parent : allParentPages) {
				if (!featuresWithPending.contains(parent.getFeatureId())) {
					availableParentPages.add(parent);
				}
			}
			renderRequest.setAttribute("parentFeatures", availableParentPages);
		}
		if (isBlueApp && (view.contains("add") || view.contains("edit-feature"))) {
			List<LovData> whitelistLovs = _lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.WHITELIST_CODE,chn);
			List<LovData> segmentsLovs = _lovsLocalService.getLatestApprovedLovDataByCode(TelemoneyConstants.SEGMENTS_CODE,chn);
			renderRequest.setAttribute("whitelistLovs", whitelistLovs);
			renderRequest.setAttribute("segmentsLovs", segmentsLovs);
		}

		 view = "/" + view + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

		dispatcher.include(renderRequest, renderResponse);
	}

	private Set<Long> getFeaturesWithPendingVersions(Long channelId) {
		Set<Long> featuresWithPending = new java.util.HashSet<>();

		Set<Long> entityResourceIdsWithPending = new HashSet<>();

		List<Feature> approvedFeatures = _featureLocalService.getLatestApprovedByChannelId(channelId);

		for (Feature approvedFeature : approvedFeatures) {
			long entityResourceId = approvedFeature.getEntityResourceId();
			long childResourceId = approvedFeature.getChildResourceId();
			boolean isChildFeature = childResourceId > 0;

			if (isChildFeature) {
				List<Feature> allVersions = _featureLocalService.getByChildResourceId(childResourceId);
				for (Feature version : allVersions) {
					if (version.getFeatureId() != approvedFeature.getFeatureId() &&
						version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
						entityResourceIdsWithPending.add(version.getEntityResourceId());
						entityResourceIdsWithPending.add(entityResourceId);
						break;
					}
				}
			} else {
				List<Feature> allVersions = _featureLocalService.getByEntityResourceId(entityResourceId);
				for (Feature version : allVersions) {
					if (version.getFeatureId() != approvedFeature.getFeatureId() &&
						version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
						entityResourceIdsWithPending.add(entityResourceId);
						break;
					}
				}
			}
			List<Feature> pendingByOriginalId = _featureLocalService.findByOriginalEntityIdAndStatus(
					approvedFeature.getFeatureId(), WorkflowConstants.STATUS_DRAFT);
			if (pendingByOriginalId != null && !pendingByOriginalId.isEmpty()) {
				for (Feature draftFeature : pendingByOriginalId) {
					entityResourceIdsWithPending.add(draftFeature.getEntityResourceId());
					entityResourceIdsWithPending.add(entityResourceId);
				}
			}

			List<Segment> allSegments = _segmentLocalService.findAllSegmentsByResourceIds(entityResourceId, childResourceId);
			for (Segment segment : allSegments) {
				if (segment.getStatus() == WorkflowConstants.STATUS_DRAFT) {
					entityResourceIdsWithPending.add(entityResourceId);
					break;
				}
			}

			List<Segment> approvedSegments = _segmentLocalService.findSegmentsByResourceIds(entityResourceId, childResourceId);
			for (Segment seg : approvedSegments) {
				List<Segment> draftSegments = _segmentLocalService.findByOriginalEntityIdAndStatus(
						seg.getSegmentId(), WorkflowConstants.STATUS_DRAFT);
				if (draftSegments != null && !draftSegments.isEmpty()) {
					entityResourceIdsWithPending.add(entityResourceId);
					break;
				}


			}
		}

		for (Feature approvedFeature : approvedFeatures) {
			long entityResourceId = approvedFeature.getEntityResourceId();

			if (entityResourceIdsWithPending.contains(entityResourceId)) {
				featuresWithPending.add(approvedFeature.getFeatureId());
			}
		}

		return featuresWithPending;
	}

	public void addFeatureView(ActionRequest actionRequest, ActionResponse actionRespons) {
		actionRequest.setAttribute("myview", "add");
	}

	public void createFeature(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, JsonProcessingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String userName = themeDisplay.getUser().getFullName();
		String featureName = ParamUtil.getString(actionRequest, "featureName");
		Boolean status = ParamUtil.getBoolean(actionRequest, "featureStatus");

		boolean isBlueApp = false;
		try {
			Channels channel = _channelsLocalService.getChannels(chn);
			isBlueApp = channel != null && "Blue App".equalsIgnoreCase(channel.getName());
		} catch (PortalException e) {
			LOG.warn("Unable to resolve channel in createFeature. ChannelId: " + chn, e);
		}

		String pageType;
		String routeId;
		long parentPage;
		List<String> whitelistLovData = null;
		List<String> segmentsLovData = null;

		if (isBlueApp) {
			pageType = "0";
			routeId = "0";
			parentPage = 0;
			String[] whitelistValues = ParamUtil.getStringValues(actionRequest, "whitelist");
			String[] segmentsValues = ParamUtil.getStringValues(actionRequest, "segments");
			whitelistLovData = whitelistValues != null ? Arrays.asList(whitelistValues) : new ArrayList<>();
			segmentsLovData = segmentsValues != null ? Arrays.asList(segmentsValues) : new ArrayList<>();
		} else {
			pageType = ParamUtil.getString(actionRequest, "pageType");
			routeId = ParamUtil.getString(actionRequest, "routeId");
			parentPage = ParamUtil.getLong(actionRequest, "parentPage");
		}

		if (containsXSS(featureName) || containsXSS(pageType) || containsXSS(routeId)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_featureLocalService.addFeature(featureName, pageType, parentPage, routeId, status, 0, chn, whitelistLovData, segmentsLovData, user, serviceContext);
		String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_FEATURE_TOGGILING)
				.concat(featureName);
		_userLogsLocalService.addUserData(userName, userAction, chn);

	}

	public void getFeatureDataForView(ActionRequest actionRequest, ActionResponse actionRespons) {

		long featureId = ParamUtil.getLong(actionRequest, "selectedFeatureId", 0);
		Blocks block;

		try {
			Feature feature = _featureLocalService.getFeature(featureId);
			block = _blocksLocalService.fetchBlocks(feature.getBlockId());
			long blockId = block != null ? block.getBlockId() : 0;
			String androidVersion = block != null ? block.getAndroidBlockVersion() : "";
			String iosVersion = block != null ? block.getIosBlockVersion() : "";
			String webVersion = block != null ? block.getWebBlockVersion() : "";
			String blockType = block != null ? block.getType() : "";
			boolean androidCheck = block != null ? block.getAndroidBlock() : false;
			boolean iosCheck = block != null ? block.getIosBlock() : false;
			boolean webCheck = block != null ? block.getWebBlock() : false;
			actionRequest.setAttribute("blockId", blockId);
			actionRequest.setAttribute("androidBlock", setBlockDate(block, "android"));
			actionRequest.setAttribute("iosBlock", setBlockDate(block, "ios"));
			actionRequest.setAttribute("webBlock", setBlockDate(block, "web"));
			actionRequest.setAttribute("androidVersion", androidVersion);
			actionRequest.setAttribute("iosVersion", iosVersion);
			actionRequest.setAttribute("webVersion", webVersion);
			actionRequest.setAttribute("androidCheck", androidCheck);
			actionRequest.setAttribute("iosCheck", iosCheck);
			actionRequest.setAttribute("webCheck", webCheck);
			actionRequest.setAttribute("blockType", blockType);
			actionRequest.setAttribute("channelId", feature.getChannelId());
			actionRequest.setAttribute("featureId", feature.getFeatureId());
			actionRequest.setAttribute("featureName", feature.getFeatureName());
			actionRequest.setAttribute("pageType", feature.getPageType());
			actionRequest.setAttribute("parentPage", feature.getParentPage());
			actionRequest.setAttribute("parentEntityResourceId", feature.getEntityResourceId());
			actionRequest.setAttribute("status", feature.getFeatureStatus()); // Use featureStatus (Boolean on/off) not workflow status
			actionRequest.setAttribute("routeId", feature.getRouteId());
			actionRequest.setAttribute("segments", _segmentLocalService.findFeatureSegments(featureId));
			actionRequest.setAttribute("hasPendingVersion", ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false));
			actionRequest.setAttribute("myview", "edit-feature");

			// Load selected whitelist/segments codes for Blue App channel
			try {
				Channels channel = _channelsLocalService.getChannels(feature.getChannelId());
				if (channel != null && "Blue App".equalsIgnoreCase(channel.getName())) {
					List<FeatureLovMap> whitelistMaps = _featureLovMapLocalService
								.findByFeatureIdAndLovType(featureId, TelemoneyConstants.WHITELIST_CODE);
					List<FeatureLovMap> segmentsMaps = _featureLovMapLocalService
								.findByFeatureIdAndLovType(featureId, TelemoneyConstants.SEGMENTS_CODE);
					List<String> selectedWhitelist = new ArrayList<>();
					for (FeatureLovMap map : whitelistMaps) {
						selectedWhitelist.add(map.getLovDataCode());
					}
					List<String> selectedSegments = new ArrayList<>();
					for (FeatureLovMap map : segmentsMaps) {
						selectedSegments.add(map.getLovDataCode());
					}
					actionRequest.setAttribute("selectedWhitelist", selectedWhitelist);
					actionRequest.setAttribute("selectedSegments", selectedSegments);
				}
			} catch (PortalException ex) {
				LOG.warn("Unable to load Blue App LOV selections. ChannelId: " + feature.getChannelId(), ex);
			}

		} catch (PortalException e) {
			e.printStackTrace();
		}

	}

	public void getSegmentDataForView(ActionRequest actionRequest, ActionResponse actionRespons) {

		long featureId = ParamUtil.getLong(actionRequest, "featureId", 0);
		long segmentId = ParamUtil.getLong(actionRequest, "selectedSegmentId", 0);
		Segment segment = _segmentLocalService.fetchSegment(segmentId);
		actionRequest.setAttribute("featureId", featureId);
		actionRequest.setAttribute("segmentId", segmentId);
		actionRequest.setAttribute("segmentName", segment.getName());
		actionRequest.setAttribute("segmentStatus", segment.getSegmentStatus());
		actionRequest.setAttribute("blockMethod", segment.getMethod());
		actionRequest.setAttribute("popUpTitle", segment.getPopUpTitle());
		actionRequest.setAttribute("popUpSubTitle", segment.getPopUpSubTitle());
		actionRequest.setAttribute("hasPendingVersion", ParamUtil.getBoolean(actionRequest, "hasPendingVersion", false));
		actionRequest.setAttribute("myview", "edit-customer-program");

	}

	public Map<String, Integer> setBlockDate(Blocks block, String platform) {
		Map<String, Integer> dates = new HashMap<>();
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		Date dateFrom = null;
		Date dateTo = null;
		if (block != null && platform.equals("android")) {
			dateFrom = block.getAndroidBlockFrom() != null ? block.getAndroidBlockFrom() : new Date();
			dateTo = block.getAndroidBlockTo() != null ? block.getAndroidBlockTo() : new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		} else if (block != null && platform.equals("ios")) {
			dateFrom = block.getIosBlockFrom() != null ? block.getIosBlockFrom() : new Date();
			dateTo = block.getIosBlockTo() != null ? block.getIosBlockTo() : new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		} else if (block != null && platform.equals("web")) {
			dateFrom = block.getWebBlockFrom() != null ? block.getWebBlockFrom() : new Date();
			dateTo = block.getWebBlockTo() != null ? block.getWebBlockTo() : new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		} else {
			dateFrom = new Date();
			dateTo = new Date();
			startCalendar.setTime(dateFrom);
			int startYear = startCalendar.get(Calendar.YEAR);
			int startMonth = startCalendar.get(Calendar.MONTH);
			int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
			endCalendar.setTime(dateTo);
			int endYear = endCalendar.get(Calendar.YEAR);
			int endMonth = endCalendar.get(Calendar.MONTH);
			int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
			dates.put("startYear", startYear);
			dates.put("startMonth", startMonth);
			dates.put("startDay", startDay);
			dates.put("endYear", endYear);
			dates.put("endMonth", endMonth);
			dates.put("endDay", endDay);
			return dates;
		}
	}

	public void editFeature(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		long featureId = ParamUtil.getLong(actionRequest, "featureId");

		if (checkHasPendingVersionForFeature(featureId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();

		long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String userName = themeDisplay.getUser().getFullName();
		actionRequest.setAttribute("parentFeatures", _featureLocalService.getAllParentPages(chn));

		boolean isBlueApp = false;
		try {
			Channels channel = _channelsLocalService.getChannels(chn);
			isBlueApp = channel != null && "Blue App".equalsIgnoreCase(channel.getName());
		} catch (PortalException e) {
			LOG.warn("Unable to resolve channel in editFeature. ChannelId: " + chn, e);
		}

		String featureName = ParamUtil.getString(actionRequest, "featureName");
		Boolean featureStatus = ParamUtil.getBoolean(actionRequest, "featureStatus");

		String pageType;
		long parentPage;
		String routeId;
		String blockType = "";
		BlockDTO createdBlockDto = null;
		List<String> whitelistLovData = null;
		List<String> segmentsLovData = null;

		if (isBlueApp) {
			pageType = "0";
			routeId = "0";
			parentPage = 0;
			String[] whitelistValues = ParamUtil.getStringValues(actionRequest, "whitelist");
			String[] segmentsValues = ParamUtil.getStringValues(actionRequest, "segments");
			whitelistLovData = whitelistValues != null ? Arrays.asList(whitelistValues) : new ArrayList<>();
			segmentsLovData = segmentsValues != null ? Arrays.asList(segmentsValues) : new ArrayList<>();

			if (containsXSS(featureName)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
		} else {
			pageType = ParamUtil.getString(actionRequest, "pageType");
			parentPage = ParamUtil.getLong(actionRequest, "parentPage");
			routeId = ParamUtil.getString(actionRequest, "routeId");
			blockType = ParamUtil.getString(actionRequest, "blockType");
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			boolean androidCheck = ParamUtil.getBoolean(actionRequest, "androidCheck", false);
			boolean iosCheck = ParamUtil.getBoolean(actionRequest, "iosCheck", false);
			boolean webCheck = ParamUtil.getBoolean(actionRequest, "webCheck", false);
			String androidStartDate, androidEndDate, androidVersion = null, iosStartDate, iosEndDate, iosVersion = null,
					webStartDate, webEndDate, webVersion = null;
			Date androidStartDateObj = null;
			Date androidEndDateObj = null;
			Date iosStartDateObj = null;
			Date iosEndDateObj = null;
			Date webStartDateObj = null;
			Date webEndDateObj = null;
			if (containsXSS(featureName) || containsXSS(pageType) || containsXSS(routeId) || containsXSS(blockType)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;
			}
			if (androidCheck) {
				androidVersion = ParamUtil.getString(actionRequest, "androidVersion");
				androidStartDate = ParamUtil.getString(actionRequest, "androidStartDate");
				androidEndDate = ParamUtil.getString(actionRequest, "androidEndDate");
				androidStartDateObj = (androidStartDate != "") ? dateFormat.parse(androidStartDate) : null;
				androidEndDateObj = (androidEndDate != "") ? dateFormat.parse(androidEndDate) : null;
			}
			if (iosCheck) {
				iosVersion = ParamUtil.getString(actionRequest, "iosVersion");
				iosStartDate = ParamUtil.getString(actionRequest, "iosStartDate");
				iosEndDate = ParamUtil.getString(actionRequest, "iosEndDate");
				iosStartDateObj = (iosStartDate != "") ? dateFormat.parse(iosStartDate) : null;
				iosEndDateObj = (iosEndDate != "") ? dateFormat.parse(iosEndDate) : null;
			}
			if (webCheck) {
				webVersion = ParamUtil.getString(actionRequest, "webVersion");
				webStartDate = ParamUtil.getString(actionRequest, "webStartDate");
				webEndDate = ParamUtil.getString(actionRequest, "webEndDate");
				webStartDateObj = (webStartDate != "") ? dateFormat.parse(webStartDate) : null;
				webEndDateObj = (webEndDate != "") ? dateFormat.parse(webEndDate) : null;
			}
			createdBlockDto = createBlockDto(chn, blockType, androidCheck, androidVersion, androidStartDateObj, androidEndDateObj, iosCheck,
					iosVersion, iosStartDateObj, iosEndDateObj, webCheck, webVersion, webStartDateObj,
					webEndDateObj);
		}

		try {
			Feature foundfeature = _featureLocalService.fetchFeature(featureId);
			if (featureName.isEmpty() || (!isBlueApp && routeId.isEmpty()))
				throw new Exception("---- Data recieved is incomplete ----");
			else if (foundfeature != null) {
				if (!isBlueApp) {
					if (foundfeature.getPageType().contains("0") && pageType.contains("1")) {
						{
							if (_featureLocalService.checkIfParentHaveChildren(foundfeature.getEntityResourceId()))
								throw new IllegalStateException("---- The parent have children and cannot be changed to a child ----");
							else if (parentPage <= 0) {
								throw new IllegalArgumentException("---- You must choose a parent page for this feature page ----");
							}
						}
					} else if (pageType.contains("0")) {
						parentPage = 0;
					}
				}

				ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
				_featureLocalService.updateFeature(featureName, pageType, parentPage, routeId, featureStatus,
						chn, createdBlockDto, whitelistLovData, segmentsLovData, foundfeature, user, serviceContext);
				String userAction = TelemoneyConstants.USER_ACTION_UPDATE
						.concat(TelemoneyConstants.USER_LOGS_FEATURE_TOGGILING).concat(featureName);
				_userLogsLocalService.addUserData(userName, userAction, chn);
			}
		} catch (Exception e) {
			if (e instanceof IllegalStateException) {
				SessionErrors.add(actionRequest, "parentHaveChildren");
			} else if (e instanceof IllegalArgumentException) {
				SessionErrors.add(actionRequest, "parentNotSelected");
			} else {
				SessionErrors.add(actionRequest, "errorUpdatingFeature");
			}
			LOG.info("Error updating feature: " + e.getMessage());
		}
	}

	public void editSegment(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		long segmentId = ParamUtil.getLong(actionRequest, "segmentId");

		if (checkHasPendingVersionForSegment(segmentId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}
		String segmentName = ParamUtil.getString(actionRequest, "segmentName");
		Boolean segmentStatus = ParamUtil.getBoolean(actionRequest, "segmentStatus");
		String blockMethod = ParamUtil.getString(actionRequest, "blockMethod");
		String popUpTitle = "";
		String popUpSubTitle = "";

		if (segmentName.isEmpty())
			throw new Exception("---- Data recieved is incomplete ----");
		if (blockMethod.contains("2")) {
			popUpTitle = ParamUtil.getString(actionRequest, "popUpTitle");
			popUpSubTitle = ParamUtil.getString(actionRequest, "popUpSubTitle");
		}
		if (segmentStatus == true) {
			blockMethod = "1";
			popUpTitle = "";
			popUpSubTitle = "";
		}
		if (containsXSS(segmentName) || containsXSS(blockMethod)|| containsXSS(popUpTitle)|| containsXSS(popUpSubTitle)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);
		_featureLocalService.updateSegment(segmentId, segmentName, segmentStatus, blockMethod, popUpTitle,
				popUpSubTitle,serviceContext,user);
	}

	public void deleteFeature(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}

		long featureId = ParamUtil.getLong(actionRequest, "deleteId");

		if (checkHasPendingVersionForFeature(featureId)) {
			SessionErrors.add(actionRequest, "hasPendingVersion");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();

		long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		String userName = themeDisplay.getUser().getFullName();

		String pageType = ParamUtil.getString(actionRequest, "deletePageType");
		if(pageType.contains("0") && _featureLocalService.isLinkedToLocalization(featureId,chn)) {
			SessionErrors.add(actionRequest, "linkedToLocalization");
			return;
		}
		if(pageType.contains("0") && _featureLocalService.isLinkedToResources(featureId,chn)) {
			SessionErrors.add(actionRequest, "linkedToResource");
			return;
		}
		Feature foundFeature = _featureLocalService.fetchFeature(featureId);
		ServiceContext serviceContext =createServiceContextForWorkflow(actionRequest);
		_featureLocalService.handleDeleteFeature(foundFeature,serviceContext,user);
		String featureName = foundFeature.getFeatureName();
		String userAction = TelemoneyConstants.USER_ACTION_DELETE
				.concat(TelemoneyConstants.USER_LOGS_FEATURE_TOGGILING).concat(featureName);
		_userLogsLocalService.addUserData(user.getFullName(), userAction, foundFeature.getChannelId());
	}
	
	public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		
		String searchInput = ParamUtil.getString(actionRequest, "searchInput");
		
		System.out.println("searchInput " + searchInput);
		
		DynamicQuery dynamicQuery = _featureLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("channelId", chn));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		dynamicQuery.add(RestrictionsFactoryUtil.like("featureName", "%" + searchInput + "%"));

		dynamicQuery.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("childResourceId"));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("version"));

		List<Feature> allApprovedMatches = _featureLocalService.dynamicQuery(dynamicQuery);

		Map<String, Feature> latestByLogicalKey = new LinkedHashMap<>();
		for (Feature feature : allApprovedMatches) {
			String key = feature.getEntityResourceId() + "_" + feature.getChildResourceId();
			if (!latestByLogicalKey.containsKey(key)) {
				latestByLogicalKey.put(key, feature);
			}
		}

		List<Feature> filteredFeatures = new ArrayList<>(latestByLogicalKey.values());
		
		actionRequest.setAttribute("searchInput", searchInput);
		actionRequest.setAttribute("filteredFeatures", filteredFeatures);
	} 
	
	public void reset(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		actionRequest.setAttribute("searchInput", "");
		actionRequest.setAttribute("reset", "true");
		System.out.print("reset action");
	//	actionRequest.setAttribute("listOfFeatures", _featureLocalService.getbyChannelId(chn));
	}

	private boolean checkHasPendingVersionForFeature(long featureId) {
		try {
			Feature feature = _featureLocalService.getFeature(featureId);
			long entityResourceId = feature.getEntityResourceId();
			long childResourceId = feature.getChildResourceId();
			boolean isChildFeature = childResourceId > 0;

			if (isChildFeature) {
				List<Feature> allVersions = _featureLocalService.getByChildResourceId(childResourceId);
				for (Feature version : allVersions) {
					if (version.getFeatureId() != featureId &&
						version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
						return true;
					}
				}
			} else {
				List<Feature> allVersions = _featureLocalService.getByEntityResourceId(entityResourceId);
				for (Feature version : allVersions) {
					if (version.getFeatureId() != featureId &&
						version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
						return true;
					}
				}
			}

			// Check by originalEntityId - handles page type changes and parent changes
			List<Feature> pendingByOriginalId = _featureLocalService.findByOriginalEntityIdAndStatus(
					featureId, WorkflowConstants.STATUS_DRAFT);
			if (pendingByOriginalId != null && !pendingByOriginalId.isEmpty()) {
				return true;
			}

			// Check if any segment for this feature has DRAFT status
			List<Segment> allSegments = _segmentLocalService.findAllSegmentsByResourceIds(entityResourceId, childResourceId);
			for (Segment segment : allSegments) {
				if (segment.getStatus() == WorkflowConstants.STATUS_DRAFT) {
					return true;
				}
			}

			// Check for pending segments by originalEntityId (for segment update workflow)
			List<Segment> approvedSegments = _segmentLocalService.findSegmentsByResourceIds(entityResourceId, childResourceId);
			for (Segment seg : approvedSegments) {
				List<Segment> draftSegments = _segmentLocalService.findByOriginalEntityIdAndStatus(
						seg.getSegmentId(), WorkflowConstants.STATUS_DRAFT);
				if (draftSegments != null && !draftSegments.isEmpty()) {
					return true;
				}
			}
		} catch (PortalException e) {
			LOG.error("Error checking pending version for feature: " + featureId, e);
		}
		return false;
	}

	private boolean checkHasPendingVersionForSegment(long segmentId) {
		try {
			Segment segment = _segmentLocalService.fetchSegment(segmentId);
			if (segment == null) {
				return false;
			}
			long entityResourceId = segment.getEntityResourceId();
			long childResourceId = segment.getChildResourceId();

			// Check if any Feature version with same resource IDs is DRAFT
			boolean isChildFeature = childResourceId > 0;
			if (isChildFeature) {
				List<Feature> allVersions = _featureLocalService.getByChildResourceId(childResourceId);
				for (Feature version : allVersions) {
					if (version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
						return true;
					}
				}
			} else {
				List<Feature> allVersions = _featureLocalService.getByEntityResourceId(entityResourceId);
				for (Feature version : allVersions) {
					if (version.getStatus() == WorkflowConstants.STATUS_DRAFT) {
						return true;
					}
				}
			}

			List<Segment> allSegments = _segmentLocalService.findAllSegmentsByResourceIds(entityResourceId, childResourceId);
			for (Segment seg : allSegments) {
				if (seg.getStatus() == WorkflowConstants.STATUS_DRAFT) {
					return true;
				}
			}

			List<Segment> approvedSegments = _segmentLocalService.findSegmentsByResourceIds(entityResourceId, childResourceId);
			for (Segment seg : approvedSegments) {
				List<Segment> draftSegments = _segmentLocalService.findByOriginalEntityIdAndStatus(
						seg.getSegmentId(), WorkflowConstants.STATUS_DRAFT);
				if (draftSegments != null && !draftSegments.isEmpty()) {
					return true;
				}
			}
		} catch (Exception e) {
			LOG.error("Error checking pending version for segment: " + segmentId, e);
		}
		return false;
	}

	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Persona.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}
	private BlockDTO createBlockDto(long channelId, String type, boolean androidBlock,
									String androidBlockVersion, Date androidBlockFrom, Date androidBlockTo,
									boolean iosBlock, String iosBlockVersion, Date iosBlockFrom,
									Date iosBlockTo, boolean webBlock, String webBlockVersion,
									Date webBlockFrom, Date webBlockTo){
		BlockDTO blocksDTO = new BlockDTO();
		blocksDTO.setChannelId(channelId);
		blocksDTO.setType(type);
		blocksDTO.setAndroidBlock(androidBlock);
		blocksDTO.setAndroidBlockVersion(androidBlockVersion);
		blocksDTO.setAndroidBlockFrom(androidBlockFrom);
		blocksDTO.setAndroidBlockTo(androidBlockTo);
		blocksDTO.setIosBlock(iosBlock);
		blocksDTO.setIosBlockVersion(iosBlockVersion);
		blocksDTO.setIosBlockFrom(iosBlockFrom);
		blocksDTO.setIosBlockTo(iosBlockTo);
		blocksDTO.setWebBlock(webBlock);
		blocksDTO.setWebBlockVersion(webBlockVersion);
		blocksDTO.setWebBlockFrom(webBlockFrom);
		blocksDTO.setWebBlockTo(webBlockTo);
		return blocksDTO;
	}

	@Reference
	private FeatureLocalService _featureLocalService;

	@Reference
	private SegmentLocalService _segmentLocalService;

	@Reference
	private BlocksLocalService _blocksLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Reference
	private LovsLocalService _lovsLocalService;

	@Reference
	private FeatureLovMapLocalService _featureLovMapLocalService;
}
