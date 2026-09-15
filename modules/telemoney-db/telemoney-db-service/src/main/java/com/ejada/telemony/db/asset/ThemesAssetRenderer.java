package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Themes;
import com.ejada.telemony.db.service.ThemesLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class ThemesAssetRenderer extends BaseJSPAssetRenderer<Themes> {

    private static final Log LOG = LogFactoryUtil.getLog(ThemesAssetRenderer.class);

    private final Themes themes;
    private final ThemesLocalService themesLocalService;

    public ThemesAssetRenderer(Themes themes, ThemesLocalService themesLocalService) {
        this.themes = themes;
        this.themesLocalService = themesLocalService;
    }

    @Override
    public Themes getAssetObject() {
        return themes;
    }

    @Override
    public long getGroupId() {
        return themes.getGroupId();
    }

    @Override
    public long getUserId() {
        return themes.getUserId();
    }

    @Override
    public String getUserName() {
        return themes.getUserName();
    }

    @Override
    public String getUuid() {
        return themes.getUuid_();
    }

    @Override
    public String getClassName() {
        return Themes.class.getName();
    }

    @Override
    public long getClassPK() {
        return themes.getThemeId();
    }

    @Override
    public String getTitle(Locale locale) {
        return "Themes";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Name: " + themes.getThemeEnName();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("editedTheme", themes);
        try {
            if (themes.getOriginalEntityId() > 0) {
                Themes original = themesLocalService.getThemes(themes.getOriginalEntityId());
                request.setAttribute("originalTheme", original);
            }
        } catch (PortalException e) {
            LOG.error("Unable to load original Theme", e);
        }

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/asset/themes_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}
