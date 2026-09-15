package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.impl.ChannelsLocalServiceImpl;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;
import java.util.Locale;

public class ChannelsAssetRenderer extends BaseJSPAssetRenderer<Channels> {
    private static final Log LOG = LogFactoryUtil.getLog(ChannelsAssetRenderer.class);

    private final Channels _channels;

    public ChannelsAssetRenderer(Channels channels) {
        _channels = channels;
    }

    @Override
    public Channels getAssetObject() {
        return _channels;
    }

    @Override
    public long getGroupId() {
        return _channels.getGroupId();
    }

    @Override
    public long getUserId() {
        return _channels.getUserId();
    }

    @Override
    public String getUserName() {
        return _channels.getUserName();
    }

    @Override
    public String getUuid() {
        return _channels.getUuid_();
    }


    @Override
    public String getClassName() {
        return Channels.class.getName();
    }

    @Override
    public long getClassPK() {
        return _channels.getChannelId();
    }

    @Override
    public String getTitle(Locale locale) {
        return "Channel";
    }

    @Override
    public String getSummary(
            PortletRequest portletRequest,
            PortletResponse portletResponse) {

        return "Name: " + _channels.getName() +
                ", Type: " + _channels.getType()+
                ", Description: " + _channels.getDescription();

    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("CHANNEL", _channels);

        if (TEMPLATE_FULL_CONTENT.equals(template)){
            return "/asset/channel_full_content.jsp";
        }

        return StringPool.BLANK;
    }

}

