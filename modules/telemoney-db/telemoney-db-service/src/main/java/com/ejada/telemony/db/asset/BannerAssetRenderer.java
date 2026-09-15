package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.Banner;
import com.ejada.telemony.db.model.BannerContent;
import com.ejada.telemony.db.model.BannerContentLocalization;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.service.BannerContentLocalService;
import com.ejada.telemony.db.service.BannerLocalService;
import com.ejada.telemony.db.service.BlocksLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class BannerAssetRenderer extends BaseJSPAssetRenderer<Banner> {
    private static final Log LOG = LogFactoryUtil.getLog(BannerAssetRenderer.class);

    private final Banner _banner;
    private final long _classPK;
    private final BannerLocalService bannerLocalService;
    private final BannerContentLocalService bannerContentLocalService;
    private final BlocksLocalService blocksLocalService;
    private final PersonaLocalService personaLocalService;
    private final FeatureLocalService featureLocalService;
    private final ChannelsLocalService channelsLocalService;

    public BannerAssetRenderer(Banner banner, long classPK, BannerLocalService bannerLocalService,
            BannerContentLocalService bannerContentLocalService,
            BlocksLocalService blocksLocalService, PersonaLocalService personaLocalService,
            FeatureLocalService featureLocalService, ChannelsLocalService channelsLocalService) {
        _banner = banner;
        _classPK = classPK;
        this.bannerLocalService = bannerLocalService;
        this.bannerContentLocalService = bannerContentLocalService;
        this.blocksLocalService = blocksLocalService;
        this.personaLocalService = personaLocalService;
        this.featureLocalService = featureLocalService;
        this.channelsLocalService = channelsLocalService;
    }

    @Override
    public Banner getAssetObject() {
        return _banner;
    }

    @Override
    public long getGroupId() {
        return _banner != null ? _banner.getGroupId() : 0;
    }

    @Override
    public long getUserId() {
        return _banner != null ? _banner.getUserId() : 0;
    }

    @Override
    public String getUserName() {
        return _banner != null ? _banner.getUserName() : "";
    }

    @Override
    public String getUuid() {
        return _banner != null ? _banner.getUuid_() : "";
    }

    @Override
    public String getClassName() {
        return Banner.class.getName();
    }

    @Override
    public long getClassPK() {
        return _classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        return _banner != null ? "Banner" : "Banner (Deleted)";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        if (_banner == null) {
            return "This banner has been deleted.";
        }
        return "Name: " + _banner.getBannerName();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (!TEMPLATE_FULL_CONTENT.equals(template)) {
            return StringPool.BLANK;
        }

        // Handle deleted banner case
        if (_banner == null) {
            request.setAttribute("isDeleted", true);
            return "/asset/banner_full_content.jsp";
        }

        int status = _banner.getStatus();
        String workflowAction = _banner.getWorkflowAction();


        // Determine operation type using workflowAction
        boolean isAddBanner = Constants.ADD_BANNER.equals(workflowAction);
        boolean isUpdateBanner = Constants.UPDATE_BANNER.equals(workflowAction);
        boolean isDeleteBanner = Constants.DELETE_BANNER.equals(workflowAction);
        boolean isAddBannerContent = Constants.ADD_BANNER_CONTENT.equals(workflowAction);
        boolean isUpdateBannerContent = Constants.UPDATE_BANNER_CONTENT.equals(workflowAction);
        boolean isDeleteBannerContent = Constants.DELETE_BANNER_CONTENT.equals(workflowAction);

        // Workflow states
        boolean isApproved = status == WorkflowConstants.STATUS_APPROVED || status == WorkflowConstants.STATUS_INACTIVE;
        boolean isRejected = status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_IN_TRASH;

        // Set attributes for JSP
        request.setAttribute("workflowAction", workflowAction);
        request.setAttribute("isAlreadyApproved", isApproved);
        request.setAttribute("isRejected", isRejected);

        // Banner operations
        request.setAttribute("isAddBanner", isAddBanner);
        request.setAttribute("isUpdateBanner", isUpdateBanner);
        request.setAttribute("isDeleteBanner", isDeleteBanner);

        // Banner content operations
        request.setAttribute("isAddBannerContent", isAddBannerContent);
        request.setAttribute("isUpdateBannerContent", isUpdateBannerContent);
        request.setAttribute("isDeleteBannerContent", isDeleteBannerContent);


        // Set feature route ID to name map for URL display
        setFeaturesMap(request, _banner.getChannelId());

        // Set channel name
        setChannelName(request, _banner.getChannelId(), "channelName");

        // Set current banner attributes
        setBannerAttributes(request, workflowAction);

        // For update/delete operations, fetch the original banner
        if (_banner.getOriginalEntityId() != 0L) {
            setOriginalBannerAttributes(request, workflowAction);
        }

        return "/asset/banner_full_content.jsp";
    }

    private void setBannerAttributes(HttpServletRequest request, String workflowAction) {
        request.setAttribute("banner", _banner);

        // Set persona names
        setPersonaAttribute(request, _banner.getPersona(), "personaName");

        // Set block
        setBlockAttribute(request, _banner.getBlockId(), "block");

        // Determine which banner to fetch contents from
        long bannerIdForContents = _banner.getBannerId();

        // For DELETE_BANNER, get contents from original banner (trash banner doesn't have contents)
        if (Constants.DELETE_BANNER.equals(workflowAction) && _banner.getOriginalEntityId() != 0L) {
            bannerIdForContents = _banner.getOriginalEntityId();
        }

        List<BannerContent> bannerContents = bannerContentLocalService.getByBannerId(bannerIdForContents);


        if (!bannerContents.isEmpty()) {
            request.setAttribute("bannerContents", bannerContents);
            setBannerContentLocalizations(request, bannerContents, "bannerContentLocalization");
        }
    }

    private void setOriginalBannerAttributes(HttpServletRequest request, String workflowAction) {
        try {
            Banner originalBanner = bannerLocalService.getBanner(_banner.getOriginalEntityId());
            request.setAttribute("originalBanner", originalBanner);

            // Set original channel name
            setChannelName(request, originalBanner.getChannelId(), "originalChannelName");

            // Set original persona names
            setPersonaAttribute(request, originalBanner.getPersona(), "originalPersonaName");

            // Set original block
            setBlockAttribute(request, originalBanner.getBlockId(), "originalBlock");

            // Get original banner contents (only for banner update operations)
            if (Constants.UPDATE_BANNER.equals(workflowAction)) {
                // For UPDATE_BANNER, fetch by entityResourceId to get the correct approved contents
                // The originalEntityId in draft content points to contents fetched by entityResourceId
                List<BannerContent> originalBannerContents = bannerContentLocalService
                        .getByEntityResourceIdAndStatusApproved(originalBanner.getEntityResourceId());


                if (!originalBannerContents.isEmpty()) {
                    request.setAttribute("originalBannerContents", originalBannerContents);
                    setBannerContentLocalizations(request, originalBannerContents, "originalBannerContentLocalization");
                }
            }

            // For content operations, get the original content
            if (Constants.UPDATE_BANNER_CONTENT.equals(workflowAction) ||
                Constants.DELETE_BANNER_CONTENT.equals(workflowAction)) {
                // Get the draft content (from current banner)
                List<BannerContent> draftContents = bannerContentLocalService.getByBannerId(_banner.getBannerId());
                if (!draftContents.isEmpty()) {
                    BannerContent draftContent = draftContents.get(0);
                    if (draftContent.getOriginalEntityId() != 0L) {
                        try {
                            BannerContent originalContent = bannerContentLocalService.getBannerContent(draftContent.getOriginalEntityId());
                            List<BannerContent> originalContentList = new ArrayList<>();
                            originalContentList.add(originalContent);
                            request.setAttribute("originalBannerContents", originalContentList);
                            setBannerContentLocalizations(request, originalContentList, "originalBannerContentLocalization");
                        } catch (PortalException e) {
                            LOG.error("Original banner content not found", e);
                        }
                    }
                }
            }

        } catch (PortalException e) {
            LOG.error("Original banner not found for originalEntityId: " + _banner.getOriginalEntityId(), e);
        }
    }

    private void setChannelName(HttpServletRequest request, long channelId, String attributeName) {
        try {
            Channels channel = channelsLocalService.getChannels(channelId);
            request.setAttribute(attributeName, channel.getName());
        } catch (PortalException e) {
            LOG.info("Channel not found for Channel ID: " + channelId);
            request.setAttribute(attributeName, String.valueOf(channelId));
        }
    }

    private void setPersonaAttribute(HttpServletRequest request, String personaJsonArray, String attributeName) {
        List<String> personaNames = new ArrayList<>();

        try {
            if (personaJsonArray != null && !personaJsonArray.isEmpty()) {
                JSONArray jsonArray = JSONFactoryUtil.createJSONArray(personaJsonArray);

                for (int i = 0; i < jsonArray.length(); i++) {
                    String personaIdStr = jsonArray.getString(i);
                    try {
                        long personaId = Long.parseLong(personaIdStr);
                        Persona persona = personaLocalService.getPersona(personaId);
                        personaNames.add(persona.getName());
                    } catch (PortalException | NumberFormatException e) {
                        LOG.info("Persona not found for Persona ID: " + personaIdStr);
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Error parsing persona JSON array: " + personaJsonArray, e);
        }

        request.setAttribute(attributeName, personaNames);
    }

    private void setBlockAttribute(HttpServletRequest request, long blockId, String attributeName) {
        try {
            request.setAttribute(attributeName, blocksLocalService.getBlocks(blockId));
        } catch (PortalException e) {
            LOG.info("Block not found for Block ID: " + blockId);
        }
    }

    private void setBannerContentLocalizations(HttpServletRequest request,
            List<BannerContent> bannerContents, String attributeName) {
        Map<Long, List<BannerContentLocalization>> localizationsMap = new HashMap<>();

        for (BannerContent bannerContent : bannerContents) {
            List<BannerContentLocalization> localizations =
                    bannerContentLocalService.getBannerContentLocalizations(bannerContent.getContentId());
            localizationsMap.put(bannerContent.getContentId(), localizations);
        }

        request.setAttribute(attributeName, localizationsMap);
    }

    private void setFeaturesMap(HttpServletRequest request, long channelId) {
        Map<String, String> featureRouteToNameMap = new HashMap<>();
        try {
            List<Feature> features = featureLocalService.getLatestApprovedByChannelId(channelId);
            for (Feature feature : features) {
                if (feature.getRouteId() != null && feature.getFeatureName() != null) {
                    featureRouteToNameMap.put(feature.getRouteId(), feature.getFeatureName());
                }
            }
        } catch (Exception e) {
            LOG.error("Error loading features for channel ID: " + channelId, e);
        }
        request.setAttribute("featureRouteToNameMap", featureRouteToNameMap);
    }
}
