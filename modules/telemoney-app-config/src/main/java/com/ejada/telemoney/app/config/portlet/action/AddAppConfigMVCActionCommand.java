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
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TelemoneyAppConfigPortletKeys.TELEMONEYAPPCONFIG,
		"mvc.command.name=addAppConfig"
	},
	service = MVCActionCommand.class
)
public class AddAppConfigMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(
		AddAppConfigMVCActionCommand.class);

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		try {
			String[] itemKeys = ParamUtil.getStringValues(
				actionRequest, "itemKey");
			String[] itemTypes = ParamUtil.getStringValues(
				actionRequest, "itemType");
			String[] itemValues = ParamUtil.getStringValues(
				actionRequest, "itemValue");

			_helper.validateNoDuplicateKeys(itemKeys, itemValues);

			PortletSession pSession = actionRequest.getPortletSession();
			Long channelId = _helper.getChannelIdFromSession(pSession);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				AppEnvironment.class.getName(), actionRequest);
			String environmentName = ParamUtil.getString(
				actionRequest, "environmentName");

			AppEnvironment appEnvironment =
				_appEnvironmentLocalService.addAppEnvironment(
					channelId, environmentName, serviceContext, user);

			if (appEnvironment != null) {
				_helper.saveConfigItems(
					appEnvironment.getEnvironmentId(),
					itemKeys, itemTypes, itemValues);
			}
		}
		catch (IllegalArgumentException illegalArgumentException) {
			LOG.error(
				"Duplicate config key in addAppConfig: " +
					illegalArgumentException.getMessage(),
				illegalArgumentException);
			SessionErrors.add(actionRequest, "duplicateConfigKey");
			actionResponse.setRenderParameter("myView", "add");
		}
		catch (Exception exception) {
			LOG.error("Error in addAppConfig", exception);
			actionRequest.setAttribute("errorMessage", exception.getMessage());
			SessionErrors.add(actionRequest, "error");
			actionResponse.setRenderParameter("myView", "add");
		}
	}

	@Reference
	private AppConfigActionHelper _helper;

	@Reference
	private AppEnvironmentLocalService _appEnvironmentLocalService;

}
