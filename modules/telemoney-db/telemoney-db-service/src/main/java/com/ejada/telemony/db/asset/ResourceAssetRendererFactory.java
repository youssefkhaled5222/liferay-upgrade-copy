package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.service.ResourceLocalService;
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
                "javax.portlet.name=com_ejada_telemoney_resources_TelemoneyResourcesPortlet",
                "search.class.name=com.ejada.telemony.db.model.Resource"
        },
        service = AssetRendererFactory.class
)
public class ResourceAssetRendererFactory extends BaseAssetRendererFactory<Resource> {

    private static final Log LOG = LogFactoryUtil.getLog(ResourceAssetRendererFactory.class);

    @Reference
    private ResourceLocalService resourceLocalService;

    public ResourceAssetRendererFactory() {
        setClassName(Resource.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_resources_TelemoneyResourcesPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Resource> getAssetRenderer(
            long classPK, int type) throws PortalException {

        try {
            Resource resource = resourceLocalService.getResource(classPK);
            return new ResourceAssetRenderer(resource, resourceLocalService);
        } catch (PortalException e) {
            return new DeletedResourceAssetRenderer(classPK);
        }
    }

    @Override
    public String getType() {
        return "Resource";
    }
}

