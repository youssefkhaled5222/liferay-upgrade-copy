package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.model.ResourceLocalization;
import com.ejada.telemony.db.service.ChannelsLocalServiceUtil;
import com.ejada.telemony.db.service.ResourceLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

public class ResourceAssetRenderer extends BaseJSPAssetRenderer<Resource> {

    private static final Log LOG = LogFactoryUtil.getLog(ResourceAssetRenderer.class);

    private final Resource resource;
    private final ResourceLocalService resourceLocalService;

    public ResourceAssetRenderer(Resource resource, ResourceLocalService resourceLocalService) {
        this.resource = resource;
        this.resourceLocalService = resourceLocalService;
    }

    @Override
    public Resource getAssetObject() {
        return resource;
    }

    @Override
    public long getGroupId() {
        return resource.getGroupId();
    }

    @Override
    public long getUserId() {
        return resource.getUserId();
    }

    @Override
    public String getUserName() {
        return resource.getUserName();
    }

    @Override
    public String getUuid() {
        return resource.getUuid_();
    }

    @Override
    public String getClassName() {
        return Resource.class.getName();
    }

    @Override
    public long getClassPK() {
        return resource.getResourceId();
    }

    @Override
    public String getTitle(Locale locale) {
        return "Resource";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Resource Code: " + resource.getResourceCode();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("editedResource", resource);

        // Resolve channel name for edited resource
        try {
            Channels editedChannel = ChannelsLocalServiceUtil.getChannels(resource.getChannelId());
            request.setAttribute("channelName", editedChannel.getName());
        } catch (Exception e) {
            LOG.error("Unable to load channel for edited Resource", e);
        }

        // Pass edited resource localizations
        List<ResourceLocalization> editedLocalizations = resourceLocalService.getResourceLocalizations(resource.getResourceId());
        request.setAttribute("editedLocalizations", editedLocalizations);

        try {
            if (resource.getOriginalEntityId() > 0) {
                Resource original = resourceLocalService.getResource(resource.getOriginalEntityId());
                request.setAttribute("originalResource", original);

                // Resolve channel name for original resource
                try {
                    Channels originalChannel = ChannelsLocalServiceUtil.getChannels(original.getChannelId());
                    request.setAttribute("originalChannelName", originalChannel.getName());
                } catch (Exception e) {
                    LOG.error("Unable to load channel for original Resource", e);
                }

                // Pass original resource localizations
                List<ResourceLocalization> originalLocalizations = resourceLocalService.getResourceLocalizations(original.getResourceId());
                request.setAttribute("originalLocalizations", originalLocalizations);
            }
        } catch (PortalException e) {
            LOG.error("Unable to load original Resource", e);
        }

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/assets/resource_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}

