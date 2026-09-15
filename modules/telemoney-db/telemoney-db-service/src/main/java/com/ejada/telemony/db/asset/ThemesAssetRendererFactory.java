package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Themes;
import com.ejada.telemony.db.service.ThemesLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_themes_TelemoneyThemesPortlet",
                "search.class.name=com.ejada.telemony.db.model.Themes"
        },
        service = AssetRendererFactory.class
)
public class ThemesAssetRendererFactory extends BaseAssetRendererFactory<Themes> {

    private static final Log LOG = LogFactoryUtil.getLog(ThemesAssetRendererFactory.class);

    @Reference
    private ThemesLocalService themesLocalService;

    public ThemesAssetRendererFactory() {
        setClassName(Themes.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_themes_TelemoneyThemesPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Themes> getAssetRenderer(
            long classPK, int type) throws PortalException {

        try {
            Themes themes = themesLocalService.getThemes(classPK);
            return new ThemesAssetRenderer(themes, themesLocalService);
        } catch (PortalException e) {
            return new DeletedThemesAssetRenderer(classPK);
        }
    }

    @Override
    public String getType() {
        return "Themes";
    }
}
