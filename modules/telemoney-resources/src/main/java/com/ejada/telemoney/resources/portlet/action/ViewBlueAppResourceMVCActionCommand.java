package com.ejada.telemoney.resources.portlet.action;

import com.ejada.telemoney.resources.constants.TelemoneyResourcesPortletKeys;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.model.ResourceLocalization;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Loads a Blue App resource into the Blue App add / edit screen.
 *
 * <p>
 * Every localized value is loaded, one entry per language, exactly like the
 * shared resource screen does.
 * </p>
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TelemoneyResourcesPortletKeys.TELEMONEYRESOURCES,
		"mvc.command.name=viewBlueAppResource"
	},
	service = MVCActionCommand.class
)
public class ViewBlueAppResourceMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(
		ViewBlueAppResourceMVCActionCommand.class);

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

		Long resourceId = ParamUtil.getLong(
			actionRequest, "selectedResourceId", 0);

		List<Languages> languages = _languagesLocalService.getbyChannelId(chn);

		Map<String, String> nameValues = new HashMap<>();
		Map<String, String> attachfilesName = new HashMap<>();
		Map<String, String> attachValues = new HashMap<>();

		for (Languages langName : languages) {
			ResourceLocalization resourceLocalization =
				_resourcesLocalService.fetchResourceLocalization(
					resourceId, langName.getLangName());

			if (resourceLocalization == null) {
				continue;
			}

			nameValues.put(
				langName.getLangName(), resourceLocalization.getName());
			attachfilesName.put(
				langName.getLangName(), resourceLocalization.getAttachName());
			attachValues.put(
				langName.getLangName(), resourceLocalization.getAttach());
		}

		try {
			Resource resource = _resourcesLocalService.getResource(resourceId);

			actionRequest.setAttribute("resourceId", resourceId);
			actionRequest.setAttribute(
				"resourceCode", resource.getResourceCode());
			actionRequest.setAttribute(
				"selectedFeatureId", resource.getFeatureId());
			actionRequest.setAttribute("nameValues", nameValues);
			actionRequest.setAttribute("attachfilesName", attachfilesName);
			actionRequest.setAttribute("attachValues", attachValues);

			actionRequest.setAttribute(
				"action",
				ParamUtil.getString(actionRequest, "action", "update"));
			actionRequest.setAttribute("myView", "add");
		}
		catch (Exception exception) {
			LOG.error(
				"Unable to load the Blue App resource " + resourceId, exception);
		}
	}

	@Reference
	private LanguagesLocalService _languagesLocalService;

	@Reference
	private ResourceLocalService _resourcesLocalService;

}

