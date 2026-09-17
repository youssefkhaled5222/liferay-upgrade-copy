package com.ejada.telemoney.resources.portlet.action;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.resources.constants.TelemoneyResourcesPortletKeys;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Searches Blue App resources.
 *
 * <p>
 * Blue App resources are attachments, so the search matches the attachment
 * file name shown on the card, and only within the page being viewed.
 * </p>
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

		long selectedFeatureId = ParamUtil.getLong(
			actionRequest, "selectedFeatureId", 0);

		// The search runs from a page and must come back to it, otherwise the
		// render falls back to the first page and filters the results by it.
		actionRequest.setAttribute("selectedFeatureId", selectedFeatureId);
		actionRequest.setAttribute("searchPerformed", Boolean.TRUE);

		try {
			String term = searchTerm.trim().toLowerCase(Locale.ROOT);

			List<Resource> searchResult = new ArrayList<>();

			Map<Resource, Boolean> resources =
				_resourcesLocalService.getLatestApprovedByChannelIdWithPending(
					chn);

			for (Resource resource : resources.keySet()) {

				// A Blue App resource belongs to one page, and the list only
				// ever shows the selected one.
				if ((selectedFeatureId > 0) &&
					(resource.getFeatureId() != selectedFeatureId)) {

					continue;
				}

				// Blue App resources are attachments, so the searchable text is
				// the file name shown on the card.
				String attachName = resource.getAttachName(
					TelemoneyConstants.LANGUAGE_ENGLISH_NAME);

				if (attachName == null) {
					continue;
				}

				if (term.isEmpty() ||
					attachName.toLowerCase(Locale.ROOT).contains(term)) {

					searchResult.add(resource);
				}
			}

			actionRequest.setAttribute("searchResult", searchResult);
		}
		catch (Exception exception) {
			LOG.error(
				"Error while searching Blue App resources by file name",
				exception);
		}
	}

	@Reference
	private ResourceLocalService _resourcesLocalService;

}

