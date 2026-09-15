package com.ejada.telemoney.blocks.portlet;

import com.ejada.telemoney.blocks.constants.TelemoneyBlocksPortletKeys;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.model.Blocks;
import com.ejada.telemony.db.service.BlocksLocalService;
import com.ejada.telemony.db.service.BlocksLocalServiceUtil;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Shatha AR
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyBlocks", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyBlocksPortletKeys.TELEMONEYBLOCKS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyBlocksPortlet extends MVCPortlet {

	public void addBlock(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String userName = themeDisplay.getUser().getFullName();
		try {

_blocksLocalService.add(ParamUtil.getLong(actionRequest, "channelId"),
		ParamUtil.getString(actionRequest, "type"), ParamUtil.getBoolean(actionRequest, "androidBlock"),
		ParamUtil.getString(actionRequest, "androidBlockVersion"),
		ParamUtil.getDate(actionRequest, "androidBlockFrom", new SimpleDateFormat("yyyy-MM-dd")),
		ParamUtil.getDate(actionRequest, "androidBlockTo", new SimpleDateFormat("yyyy-MM-dd")),
		ParamUtil.getBoolean(actionRequest, "iosBlock"),
		ParamUtil.getString(actionRequest, "iosBlockVersion"),
		ParamUtil.getDate(actionRequest, "iosBlockFrom", new SimpleDateFormat("yyyy-MM-dd")),
		ParamUtil.getDate(actionRequest, "iosBlockTo", new SimpleDateFormat("yyyy-MM-dd")),
		false, "", null, null);
			String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_BLOCK);
			_userLogsLocalService.addUserData(userName, userAction, chn);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateBlock(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String userName = themeDisplay.getUser().getFullName();
		long blockId = ParamUtil.getLong(actionRequest, "blockId");
		Blocks blockToUpdate = BlocksLocalServiceUtil.fetchBlocks(blockId);
		if (blockToUpdate != null) {
			blockToUpdate.setChannelId(ParamUtil.getLong(actionRequest, "channelId"));
			blockToUpdate.setType(ParamUtil.getString(actionRequest, "type"));
			blockToUpdate.setAndroidBlock(ParamUtil.getBoolean(actionRequest, "androidBlock"));
			blockToUpdate.setAndroidBlockVersion(ParamUtil.getString(actionRequest, "androidBlockVersion"));
			blockToUpdate.setAndroidBlockFrom(
					ParamUtil.getDate(actionRequest, "androidBlockFrom", new SimpleDateFormat("yyyy-MM-dd")));
			blockToUpdate.setAndroidBlockTo(
					ParamUtil.getDate(actionRequest, "androidBlockTo", new SimpleDateFormat("yyyy-MM-dd")));
			blockToUpdate.setAndroidBlock(ParamUtil.getBoolean(actionRequest, "iosBlock"));
			blockToUpdate.setAndroidBlockVersion(ParamUtil.getString(actionRequest, "iosBlockVersion"));
			blockToUpdate.setAndroidBlockFrom(
					ParamUtil.getDate(actionRequest, "iosBlockFrom", new SimpleDateFormat("yyyy-MM-dd")));
			blockToUpdate.setAndroidBlockTo(
					ParamUtil.getDate(actionRequest, "iosBlockTo", new SimpleDateFormat("yyyy-MM-dd")));

			try {
				System.out.println((_blocksLocalService.update(blockToUpdate)));
				String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_BLOCK);
				_userLogsLocalService.addUserData(userName, userAction, chn);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute("listOfBlocks", _blocksLocalService.findAll());
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private BlocksLocalService _blocksLocalService;
	@Reference
	private UserLogsLocalService _userLogsLocalService;
}