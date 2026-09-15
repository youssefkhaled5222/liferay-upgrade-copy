package com.ejada.telemoney.app.config.portlet.action;

import com.ejada.telemoney.app.config.constants.TelemoneyAppConfigPortletKeys;
import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppEnvironmentLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TelemoneyAppConfigPortletKeys.TELEMONEYAPPCONFIG,
		"mvc.command.name=deleteAppConfig"
	},
	service = MVCActionCommand.class
)
public class DeleteAppConfigMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(
		DeleteAppConfigMVCActionCommand.class);

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		try {
			long environmentId = ParamUtil.getLong(
				actionRequest, "selectedEnvironmentId");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				AppEnvironment.class.getName(), actionRequest);

			_appEnvironmentLocalService.deleteAppEnvironment(
				environmentId, serviceContext, user);
		}
		catch (Exception exception) {
			LOG.error("Error in deleteAppConfig", exception);
			actionRequest.setAttribute("errorMessage", exception.getMessage());
			SessionErrors.add(actionRequest, "error");
		}
	}

	@Reference
	private AppEnvironmentLocalService _appEnvironmentLocalService;

}
