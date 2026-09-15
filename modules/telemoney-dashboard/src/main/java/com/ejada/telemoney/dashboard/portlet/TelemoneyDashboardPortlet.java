package com.ejada.telemoney.dashboard.portlet;

import com.ejada.telemoney.dashboard.constants.TelemoneyDashboardPortletKeys;
import com.ejada.telemony.db.model.UserLogs;
import com.ejada.telemony.db.service.BannerLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.LocalizationLocalService;
import com.ejada.telemony.db.service.LovsLocalService;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.ejada.telemony.db.service.ThemesLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author rmostafa
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyDashboard", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyDashboardPortletKeys.TELEMONEYDASHBOARD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyDashboardPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletSession pSession = renderRequest.getPortletSession();
		Long channelId = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;

		String myview = "view";
		String view = "/" + myview + ".jsp";

		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

		List<UserLogs> userLogs = new ArrayList<>(_userLogsLocalService.getbyChannelId(channelId));
		int start = Math.max(userLogs.size() - 10, 0);
		userLogs = userLogs.subList(start, userLogs.size());
		try {
			Collections.reverse(userLogs);
			if (userLogs.isEmpty()) {
				System.out.println("The userlogs list is empty.");
			} else {
				renderRequest.setAttribute("list_of_logs", userLogs);
			}
			int numberOfPersona = _personaLocalService.getLatestApprovedByChannelId(channelId).size();
			if (numberOfPersona > 0) {
				renderRequest.setAttribute("getNumberOfPersona", numberOfPersona);
			} else {
				System.out.println("There is no Persona in this channel");
				renderRequest.setAttribute("getNumberOfPersona", 0);

			}
			int numberOfThemes = _themesLocalService.getLatestApprovedByChannelId(channelId).size();
			if (numberOfThemes > 0) {
				renderRequest.setAttribute("getNumberOfThemes", numberOfThemes);
			} else {
				System.out.println("There is no Theme in this channel");
				renderRequest.setAttribute("getNumberOfThemes", 0);

			}
			int numberOfBanner = _bannerLocalService.getLatestApprovedByChannelId(channelId).size();
			if (numberOfBanner > 0) {
				renderRequest.setAttribute("getNumberOfBanner", numberOfBanner);
			} else {
				System.out.println("There is no Banner in this channel");
				renderRequest.setAttribute("getNumberOfBanner", 0);

			}
			int numberOfLanguages = _languagesLocalService.getLatestApprovedByChannelId(channelId).size();
			if (numberOfLanguages > 0) {
				renderRequest.setAttribute("getNnumberOfLanguages", numberOfLanguages);
			} else {
				System.out.println("There is no Language in this channel");
				renderRequest.setAttribute("getNnumberOfLanguages", 0);

			}
			int numberOfLOV = _lovsLocalService.getLatestApprovedByChannelId(channelId).size();
			if (numberOfLOV > 0) {
				renderRequest.setAttribute("getNnumberOfLOV", numberOfLOV);
			} else {
				System.out.println("There is no ListOfValue in this channel");
				renderRequest.setAttribute("getNnumberOfLOV", 0);

			}
			int numberOfResources = _resourcesLocalService.getLatestApprovedByChannelId(channelId).size();
			if (numberOfResources > 0) {
				renderRequest.setAttribute("getNnumberOfResources", numberOfResources);
			} else {
				System.out.println("There is no Resource in this channel");
				renderRequest.setAttribute("getNnumberOfResources", 0);

			}

			int numberOfFToggiling = _featureLocalServiceImpl.getLatestApprovedByChannelId(channelId).size();
			if (numberOfFToggiling > 0) {
				renderRequest.setAttribute("getNnumberOfFT", numberOfFToggiling);
			} else {
				System.out.println("There is no Feature Toggiling in this channel");
				renderRequest.setAttribute("getNnumberOfFT", 0);

			}


			int numberOfLocalization =  _languagesLocalService.getLatestApprovedByChannelId(channelId).size();
//			int numberOfLocalization = _localizationLocalService.getbyChannelId(channelId).size();
			if (numberOfLocalization > 0) {
				renderRequest.setAttribute("numberOfLocalization", numberOfLocalization);
			} else {
				System.out.println("There is no Localization in this channel");
				renderRequest.setAttribute("numberOfLocalization", 0);

			}
		} catch (NullPointerException e) {
			System.out.println("channelId is null");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
		dispatcher.forward(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);

	}

	@Reference
	private PersonaLocalService _personaLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

	@Reference
	private ThemesLocalService _themesLocalService;

	@Reference
	private BannerLocalService _bannerLocalService;

	@Reference
	private LanguagesLocalService _languagesLocalService;

	@Reference
	private LovsLocalService _lovsLocalService;

	@Reference
	private ResourceLocalService _resourcesLocalService;

	@Reference
	private FeatureLocalService _featureLocalServiceImpl;

	@Reference
	private LocalizationLocalService _localizationLocalService;
	}