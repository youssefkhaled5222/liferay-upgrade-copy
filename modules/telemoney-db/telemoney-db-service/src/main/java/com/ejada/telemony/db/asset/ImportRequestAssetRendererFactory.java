package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.service.ImportRequestLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_importRequest_TelemoneyImportRequestPortlet",
                "search.class.name=com.ejada.telemony.db.model.ImportRequest"
        },
        service = AssetRendererFactory.class
)
public class ImportRequestAssetRendererFactory extends BaseAssetRendererFactory<ImportRequest> {

    @Reference
    private ImportRequestLocalService importRequestLocalService;

    public ImportRequestAssetRendererFactory() {
        setClassName(ImportRequest.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_importRequest_TelemoneyImportRequestPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<ImportRequest> getAssetRenderer(long classPK, int type) {
        ImportRequest importRequest = importRequestLocalService.fetchImportRequest(classPK);

        return new ImportRequestAssetRenderer(importRequest, classPK, importRequestLocalService);
    }

    @Override
    public String getType() {
        return "ImportRequest";
    }
}



