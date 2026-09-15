package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class LanguagesAssetRenderer extends BaseJSPAssetRenderer<Languages> {

    private static final Log LOG = LogFactoryUtil.getLog(LanguagesAssetRenderer.class);

    private final Languages language;
    private final LanguagesLocalService languagesLocalService;

    public LanguagesAssetRenderer(Languages language, LanguagesLocalService languagesLocalService) {
        this.language = language;
        this.languagesLocalService = languagesLocalService;
    }

    @Override
    public Languages getAssetObject() {
        return language;
    }

    @Override
    public long getGroupId() {
        return language.getGroupId();
    }

    @Override
    public long getUserId() {
        return language.getUserId();
    }

    @Override
    public String getUserName() {
        return language.getUserName();
    }

    @Override
    public String getUuid() {
        return language.getUuid_();
    }

    @Override
    public String getClassName() {
        return Languages.class.getName();
    }

    @Override
    public long getClassPK() {
        return language.getLanguageId();
    }

    @Override
    public String getTitle(Locale locale) {
        return "Language";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Name: " + language.getLangName();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("editedLanguage", language);
        try {
            if (language.getOriginalEntityId() > 0) {
                Languages original = languagesLocalService.getLanguages(language.getOriginalEntityId());
                request.setAttribute("originalLanguage", original);
            }
        } catch (PortalException e) {
            LOG.error("Unable to load original Language", e);
        }

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/asset/language_full_content.jsp";
        }

        return StringPool.BLANK;
    }
}
