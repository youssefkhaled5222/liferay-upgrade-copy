package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_configuration_entity_ConfigurationEntityPortlet",
                "search.class.name=com.ejada.telemony.db.model.ConfigurationEntity"
        },
        service = AssetRendererFactory.class
)
public class ConfigurationEntityAssetRendererFactory
        extends BaseAssetRendererFactory<ConfigurationEntity> {

    @Reference
    private ConfigurationEntityLocalService configurationEntityLocalService;

    public ConfigurationEntityAssetRendererFactory() {
        setClassName(ConfigurationEntity.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_configuration_entity_ConfigurationEntityPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<ConfigurationEntity> getAssetRenderer(long classPK, int type) {
        ConfigurationEntity configurationEntity = configurationEntityLocalService.fetchConfigurationEntity(classPK);

        return new ConfigurationEntityAssetRenderer(configurationEntity, classPK);
    }

    @Override
    public String getType() {
        return "ConfigurationEntity";
    }
}



