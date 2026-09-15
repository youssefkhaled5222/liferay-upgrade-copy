package com.ejada.telemoney.channels.portlet;

import com.ejada.telemoney.channels.constants.TelemoneyChannelsPortletKeys;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
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
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author rmostafa
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyChannels", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyChannelsPortletKeys.TELEMONEYCHANNELS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyChannelsPortlet extends MVCPortlet {
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	public void addChannel(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			List<Role> roles = user.getRoles();
			boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
			if (!isAdministrator ) {
				SessionErrors.add(actionRequest, "notAuthorized");
				return;
			}

			String channelName = ParamUtil.getString(actionRequest, "channelName");
			String channelType = ParamUtil.getString(actionRequest, "channelType");
			String channelEnDesc = ParamUtil.getString(actionRequest, "channelEnDesc");
			if (containsXSS(channelName) || containsXSS(channelType) || containsXSS(channelEnDesc)) {
				SessionErrors.add(actionRequest, "xssDetected");
				return;	
			}
			ServiceContext serviceContext = createServiceContextForWorkflow(actionRequest);

			_channelsLocalService.add(channelName, channelEnDesc, channelType,serviceContext,user);

		} catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("errorMessage", e.getMessage());
		}

	}

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}
	private ServiceContext createServiceContextForWorkflow(ActionRequest actionRequest) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Channels.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		return serviceContext;
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute("listOfChannels", _channelsLocalService.findByStatus(WorkflowConstants.STATUS_APPROVED));
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private ChannelsLocalService _channelsLocalService;
}