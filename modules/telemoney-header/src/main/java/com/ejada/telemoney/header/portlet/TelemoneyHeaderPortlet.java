package com.ejada.telemoney.header.portlet;

import com.ejada.telemoney.common.configs.enums.ACCESS;
import com.ejada.telemoney.common.configs.services.RoleChannelMapService;
import com.ejada.telemoney.header.constants.TelemoneyHeaderPortletKeys;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author rmostafa
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyHeader", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyHeaderPortletKeys.TELEMONEYHEADER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyHeaderPortlet extends MVCPortlet {

	@Reference
	private RoleChannelMapService _Role_channelMapService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String myview = "view";

		PortletSession pSession = renderRequest.getPortletSession();
		Object sessionChnObj = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE);
		Long chn = sessionChnObj != null ? (Long) sessionChnObj : null;

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay != null && themeDisplay.isSignedIn() ? themeDisplay.getUser() : null;
		List<Channels> allChannels = _channelsLocalService.findByStatus(WorkflowConstants.STATUS_APPROVED);
		ArrayList<Channels> mappedChannels = new ArrayList<>();
		chn = getMappedChannels(mappedChannels,user,allChannels,sessionChnObj,chn);

		Channels channel = null;
		if (chn != null) {
			try {
				channel = _channelsLocalService.getChannels(chn);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String name = channel != null ? channel.getName() : "no channel";
		renderRequest.setAttribute("channels", mappedChannels);
		renderRequest.setAttribute("chn", name);
		if (channel != null) {
			pSession.setAttribute("LIFERAY_SHARED_ChannelId", channel.getChannelId(), PortletSession.APPLICATION_SCOPE);
		} else {
			pSession.removeAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE);
		}
		String view = "/" + myview + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

		dispatcher.include(renderRequest, renderResponse);
	}

	public void getChannelId(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long channelId = ParamUtil.getLong(actionRequest, "channelId", 1);
		Long typeId = (long) 1;
		pSession.setAttribute("LIFERAY_SHARED_ChannelId", channelId, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_TypeId", typeId, PortletSession.APPLICATION_SCOPE);

	}
	private Long  getMappedChannels( ArrayList<Channels> mappedChannels,User user, List<Channels> allChannels,Object sessionChnObj,Long chn)
	{

		if (user != null && user.getRoles() != null) {
			List<String> roleNames = user.getRoles().stream()
					.map(Role::getName)
					.collect(Collectors.toList());
			Set<String> allowedChannels = _Role_channelMapService.getChannelsByRole(roleNames);
			if (allowedChannels.contains(ACCESS.FULL_ACCESS.toString())) {
				mappedChannels.addAll(allChannels);
			}else if (allowedChannels.contains(ACCESS.NO_ACCESS.toString())) {
				chn = null;
			}
			else if (!allowedChannels.isEmpty()) {
				for (Channels channel : allChannels) {
					if (allowedChannels.contains(channel.getName().toLowerCase())) {
						mappedChannels.add(channel);
					}
				}
			}
			if (mappedChannels.isEmpty()) {
				chn = null;
			} else {
				final Long currentChn = chn;
				boolean stillAllowed = currentChn != null
						&& mappedChannels.stream().anyMatch(c -> c.getChannelId() == currentChn.longValue());

				if (chn == null || sessionChnObj == null || !stillAllowed) {
					chn = mappedChannels.get(0).getChannelId();
				}
			}
		}
		return chn;
	}

	@Reference
	private ChannelsLocalService _channelsLocalService;
}