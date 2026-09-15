package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.AppVersion;
import com.ejada.telemony.db.service.AppVersionLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class AppVersionAssetRenderer extends BaseJSPAssetRenderer<AppVersion> {

    private static final Log LOG = LogFactoryUtil.getLog(AppVersionAssetRenderer.class);

    private final AppVersion appVersion;
    private final AppVersionLocalService appVersionLocalService;

    public AppVersionAssetRenderer(AppVersion appVersion, AppVersionLocalService appVersionLocalService) {
        this.appVersion = appVersion;
        this.appVersionLocalService = appVersionLocalService;
    }

    @Override
    public AppVersion getAssetObject() {
        return appVersion;
    }

    @Override
    public long getGroupId() {
        return appVersion.getGroupId();
    }

    @Override
    public long getUserId() {
        return appVersion.getUserId();
    }

    @Override
    public String getUserName() {
        return appVersion.getUserName();
    }

    @Override
    public String getUuid() {
        return appVersion.getUuid_();
    }

    @Override
    public String getClassName() {
        return AppVersion.class.getName();
    }

    @Override
    public long getClassPK() {
        return appVersion.getVersionId();
    }

    @Override
    public String getTitle(Locale locale) {
        return "App Version";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Platform: " + appVersion.getPlatform() + ", Version: " + appVersion.getVersionNumber();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("editedAppVersion", appVersion);
        try {
            if (appVersion.getOriginalEntityId() > 0) {
                AppVersion original = appVersionLocalService.getAppVersion(appVersion.getOriginalEntityId());
                request.setAttribute("originalAppVersion", original);
            }
        } catch (PortalException e) {
            LOG.error("Unable to load original AppVersion", e);
        }

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/assets/app_version_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}

