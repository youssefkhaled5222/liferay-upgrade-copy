package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_channels_TelemoneyChannelsPortlet",
                "search.class.name=com.ejada.telemony.db.model.Channels"
        },
        service = AssetRendererFactory.class
)
public class ChannelsAssetRendererFactory
        extends BaseAssetRendererFactory<Channels> {

    @Reference
    private ChannelsLocalService channelsLocalService;

    public ChannelsAssetRendererFactory() {
        setClassName(Channels.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_channels_TelemoneyChannelsPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Channels> getAssetRenderer(
            long classPK, int type) throws PortalException {

        Channels channel = channelsLocalService.getChannels(classPK);
        return new ChannelsAssetRenderer(channel);
    }

    @Override
    public String getType() {
        return "channels";
    }
}

