package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.service.LanguagesLocalService;
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
                "javax.portlet.name=com_ejada_telemoney_languages_TelemoneyLanguagesPortlet",
                "search.class.name=com.ejada.telemony.db.model.Languages"
        },
        service = AssetRendererFactory.class
)
public class LanguagesAssetRendererFactory extends BaseAssetRendererFactory<Languages> {

    private static final Log LOG = LogFactoryUtil.getLog(LanguagesAssetRendererFactory.class);

    @Reference
    private LanguagesLocalService languagesLocalService;

    public LanguagesAssetRendererFactory() {
        setClassName(Languages.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_languages_TelemoneyLanguagesPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Languages> getAssetRenderer(
            long classPK, int type) throws PortalException {

        try {
            Languages language = languagesLocalService.getLanguages(classPK);
            return new LanguagesAssetRenderer(language, languagesLocalService);
        } catch (PortalException e) {
            return new DeletedLanguagesAssetRenderer(classPK);
        }
    }

    @Override
    public String getType() {
        return "Language";
    }
}
