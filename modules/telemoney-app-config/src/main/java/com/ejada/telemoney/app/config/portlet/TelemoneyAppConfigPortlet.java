package com.ejada.telemoney.app.config.portlet;

import com.ejada.telemoney.app.config.constants.TelemoneyAppConfigPortletKeys;
import com.ejada.telemoney.app.config.utils.Messages;
import com.ejada.telemony.db.model.AppConfigItem;
import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppConfigItemLocalService;
import com.ejada.telemony.db.service.AppEnvironmentLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyAppConfig",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyAppConfigPortletKeys.TELEMONEYAPPCONFIG,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TelemoneyAppConfigPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(
		TelemoneyAppConfigPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			PortletSession pSession = renderRequest.getPortletSession();
			Long channelId =
				pSession.getAttribute(
					"LIFERAY_SHARED_ChannelId",
					PortletSession.APPLICATION_SCOPE) != null
				? (Long)pSession.getAttribute(
					"LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1L;

			String myView = "view";
			String page = renderRequest.getParameter("myView");

			if (Objects.equals(page, "add")) {
				myView = "add";
			}
			else if (Objects.equals(page, "edit")) {
				myView = "edit";

				long environmentId = ParamUtil.getLong(
					renderRequest, "environmentId");
				AppEnvironment record =
					_appEnvironmentLocalService.fetchAppEnvironment(
						environmentId);
				List<AppConfigItem> configItems =
					_appConfigItemLocalService.getAppConfigItemsByEnvironmentId(
						environmentId);

				renderRequest.setAttribute("record", record);
				renderRequest.setAttribute("configItems", configItems);
			}
			else {
				Map<AppEnvironment, Boolean> recordsWithPending =
					_appEnvironmentLocalService
						.getLatestApprovedByChannelIdWithPending(channelId);

				List<AppEnvironment> records = new ArrayList<>(
					recordsWithPending.keySet());

				renderRequest.setAttribute("recordsWithPending", recordsWithPending);
				renderRequest.setAttribute("records", records);
			}

			String view = "/" + myView + ".jsp";
			PortletRequestDispatcher dispatcher =
				getPortletContext().getRequestDispatcher(view);
			dispatcher.include(renderRequest, renderResponse);
		}
		catch (Exception exception) {
			LOG.error("Error in doView", exception);
			SessionErrors.add(renderRequest, "error");
			renderRequest.setAttribute("errorMessage", Messages.GENERIC_ERROR);
		}
	}

	@Reference
	private AppConfigItemLocalService _appConfigItemLocalService;

	@Reference
	private AppEnvironmentLocalService _appEnvironmentLocalService;

}
