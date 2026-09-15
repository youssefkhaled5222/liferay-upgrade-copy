package com.ejada.telemoney.resources.portlet.action;

import com.ejada.telemoney.resources.constants.TelemoneyResourcesPortletKeys;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Searches Blue App resources. Blue App only searches by name.
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TelemoneyResourcesPortletKeys.TELEMONEYRESOURCES,
		"mvc.command.name=searchBlueAppResource"
	},
	service = MVCActionCommand.class
)
public class SearchBlueAppResourceMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(
		SearchBlueAppResourceMVCActionCommand.class);

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute(
			"LIFERAY_SHARED_ChannelId",
			PortletSession.APPLICATION_SCOPE) != null
				? (Long)pSession.getAttribute(
					"LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;

		String searchTerm = ParamUtil.getString(actionRequest, "searchTerm");

		try {
			List<Resource> searchResult =
				_resourcesLocalService.getByResourceCodeByNameLatestApproved(
					searchTerm, chn);

			actionRequest.setAttribute("searchResult", searchResult);
		}
		catch (Exception exception) {
			LOG.error(
				"Error while searching Blue App resources by name", exception);
		}
	}

	@Reference
	private ResourceLocalService _resourcesLocalService;

}

