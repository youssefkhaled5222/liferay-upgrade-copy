package com.ejada.telemoney.resources.portlet.action;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.resources.constants.TelemoneyResourcesPortletKeys;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Deletes a Blue App resource. The deletion goes through the same approval
 * workflow as any other resource.
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TelemoneyResourcesPortletKeys.TELEMONEYRESOURCES,
		"mvc.command.name=deleteBlueAppResource"
	},
	service = MVCActionCommand.class
)
public class DeleteBlueAppResourceMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(
		DeleteBlueAppResourceMVCActionCommand.class);

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(
			role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(
			role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");

			return;
		}

		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute(
			"LIFERAY_SHARED_ChannelId",
			PortletSession.APPLICATION_SCOPE) != null
				? (Long)pSession.getAttribute(
					"LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;

		String userName = user.getFullName();

		long resourceId = ParamUtil.getLong(
			actionRequest, "selectedResourceId");

		Resource resource = _resourcesLocalService.fetchResource(resourceId);

		if (resource == null) {
			return;
		}

		String resourceName = resource.getName();
		String resourceType = TelemoneyConstants.getResourceTypeValue(
			resource.getResourceType());

		String userAction = TelemoneyConstants.USER_ACTION_DELETE.concat(
			resourceType.concat(
				TelemoneyConstants.USER_LOGS_RESOURCE)).concat(
					(resourceName != null) ? resourceName : "");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Resource.class.getName(), actionRequest);

			serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);

			_resourcesLocalService.resourceDelete(
				resourceId, serviceContext, user);

			_userLogsLocalService.addUserData(userName, userAction, chn);
		}
		catch (Exception exception) {
			LOG.error("Error while deleting a Blue App resource", exception);
			actionRequest.setAttribute("errorMsg", exception.getMessage());
			SessionErrors.add(actionRequest, "error");
		}
	}

	@Reference
	private ResourceLocalService _resourcesLocalService;

	@Reference
	private UserLogsLocalService _userLogsLocalService;

}

