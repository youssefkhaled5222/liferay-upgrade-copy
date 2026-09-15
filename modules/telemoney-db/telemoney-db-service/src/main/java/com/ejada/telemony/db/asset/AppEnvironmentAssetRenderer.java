package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.AppConfigItem;
import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppConfigItemLocalService;
import com.ejada.telemony.db.service.AppEnvironmentLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

public class AppEnvironmentAssetRenderer
	extends BaseJSPAssetRenderer<AppEnvironment> {

	private static final Log LOG = LogFactoryUtil.getLog(
		AppEnvironmentAssetRenderer.class);

	private final AppEnvironment _appEnvironment;
	private final AppConfigItemLocalService _appConfigItemLocalService;
	private final AppEnvironmentLocalService _appEnvironmentLocalService;

	public AppEnvironmentAssetRenderer(
		AppEnvironment appEnvironment,
		AppConfigItemLocalService appConfigItemLocalService,
		AppEnvironmentLocalService appEnvironmentLocalService) {

		_appEnvironment = appEnvironment;
		_appConfigItemLocalService = appConfigItemLocalService;
		_appEnvironmentLocalService = appEnvironmentLocalService;
	}

	@Override
	public AppEnvironment getAssetObject() {
		return _appEnvironment;
	}

	@Override
	public long getGroupId() {
		return _appEnvironment.getGroupId();
	}

	@Override
	public long getUserId() {
		return _appEnvironment.getUserId();
	}

	@Override
	public String getUserName() {
		return _appEnvironment.getUserName();
	}

	@Override
	public String getUuid() {
		return _appEnvironment.getUuid_();
	}

	@Override
	public String getClassName() {
		return AppEnvironment.class.getName();
	}

	@Override
	public long getClassPK() {
		return _appEnvironment.getEnvironmentId();
	}

	@Override
	public String getTitle(Locale locale) {
		return "App Config";
	}

	@Override
	public String getSummary(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		return "Environment: " + _appEnvironment.getEnvironmentName();
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		request.setAttribute("editedAppEnvironment", _appEnvironment);
		request.setAttribute(
			"editedConfigItems",
			_appConfigItemLocalService.getAppConfigItemsByEnvironmentId(
				_appEnvironment.getEnvironmentId()));

		List<AppConfigItem> originalConfigItems = Collections.emptyList();

		try {
			if (_appEnvironment.getOriginalEntityId() > 0) {
				AppEnvironment original =
					_appEnvironmentLocalService.getAppEnvironment(
						_appEnvironment.getOriginalEntityId());

				request.setAttribute("originalAppEnvironment", original);

				originalConfigItems =
					_appConfigItemLocalService.getAppConfigItemsByEnvironmentId(
						original.getEnvironmentId());
			}
		}
		catch (PortalException portalException) {
			LOG.error("Unable to load original AppEnvironment", portalException);
		}

		request.setAttribute("originalConfigItems", originalConfigItems);

		if (TEMPLATE_FULL_CONTENT.equals(template)) {
			return "/assets/app_environment_full_content.jsp";
		}

		return StringPool.BLANK;
	}

}
