package com.ejada.telemoney.app.config.portlet.action;

import com.ejada.telemoney.app.config.constants.TelemoneyAppConfigPortletKeys;
import com.ejada.telemony.db.model.AppConfigItem;
import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppConfigItemLocalService;
import com.ejada.telemony.db.service.AppEnvironmentLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TelemoneyAppConfigPortletKeys.TELEMONEYAPPCONFIG,
		"mvc.command.name=editAppConfig"
	},
	service = MVCActionCommand.class
)
public class EditAppConfigMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(
		EditAppConfigMVCActionCommand.class);

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long environmentId = ParamUtil.getLong(
				actionRequest, "environmentId");
			String environmentName = ParamUtil.getString(
				actionRequest, "environmentName");
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
			serviceContext.setAttribute("forceDraft", true);

			AppEnvironment record = _appEnvironmentLocalService.fetchAppEnvironment(
				environmentId);

			if (record == null) {
				throw new IllegalArgumentException("Invalid environmentId");
			}

			AppEnvironment targetEnvironment =
				_appEnvironmentLocalService.updateAppEnvironment(
					environmentId, channelId, environmentName, serviceContext);

			if (targetEnvironment == null) {
				throw new IllegalStateException("Failed to create update draft");
			}

			List<AppConfigItem> existingItems =
				_appConfigItemLocalService.getAppConfigItemsByEnvironmentId(
					targetEnvironment.getEnvironmentId());

			for (AppConfigItem existingItem : existingItems) {
				_appConfigItemLocalService.deleteAppConfigItem(existingItem);
			}

			_helper.saveConfigItems(
				targetEnvironment.getEnvironmentId(),
				itemKeys, itemTypes, itemValues);
		}
		catch (IllegalArgumentException illegalArgumentException) {
			LOG.error(
				"Duplicate config key in editAppConfig: " +
					illegalArgumentException.getMessage(),
				illegalArgumentException);
			SessionErrors.add(actionRequest, "duplicateConfigKey");
			actionResponse.setRenderParameter("myView", "edit");
			actionResponse.setRenderParameter(
				"environmentId",
				String.valueOf(ParamUtil.getLong(actionRequest, "environmentId")));
		}
		catch (Exception exception) {
			LOG.error("Error in editAppConfig", exception);
			actionRequest.setAttribute("errorMessage", exception.getMessage());
			SessionErrors.add(actionRequest, "error");
			actionResponse.setRenderParameter("myView", "edit");
			actionResponse.setRenderParameter(
				"environmentId",
				String.valueOf(ParamUtil.getLong(actionRequest, "environmentId")));
		}
	}

	@Reference
	private AppConfigActionHelper _helper;

	@Reference
	private AppConfigItemLocalService _appConfigItemLocalService;

	@Reference
	private AppEnvironmentLocalService _appEnvironmentLocalService;

}
