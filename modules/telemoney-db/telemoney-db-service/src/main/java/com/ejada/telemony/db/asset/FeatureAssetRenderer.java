package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.model.Blocks;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.model.FeatureLovMap;
import com.ejada.telemony.db.model.Segment;
import com.ejada.telemony.db.service.BlocksLocalService;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.FeatureLocalService;
import com.ejada.telemony.db.service.FeatureLovMapLocalService;
import com.ejada.telemony.db.service.SegmentLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FeatureAssetRenderer extends BaseJSPAssetRenderer<Feature> {
    private static final Log LOG = LogFactoryUtil.getLog(FeatureAssetRenderer.class);

    private final Feature _feature;
    private final long _classPK;
    private final FeatureLocalService featureLocalService;
    private final SegmentLocalService segmentLocalService;
    private final ChannelsLocalService channelsLocalService;
    private final BlocksLocalService blocksLocalService;
    private final FeatureLovMapLocalService featureLovMapLocalService;

    public FeatureAssetRenderer(Feature feature, long classPK, FeatureLocalService featureLocalService,
                                SegmentLocalService segmentLocalService, ChannelsLocalService channelsLocalService,
                                BlocksLocalService blocksLocalService, FeatureLovMapLocalService featureLovMapLocalService) {
        _feature = feature;
        _classPK = classPK;
        this.featureLocalService = featureLocalService;
        this.segmentLocalService = segmentLocalService;
        this.channelsLocalService = channelsLocalService;
        this.blocksLocalService = blocksLocalService;
        this.featureLovMapLocalService = featureLovMapLocalService;
    }

    @Override
    public Feature getAssetObject() {
        return _feature;
    }

    @Override
    public long getGroupId() {
        return _feature != null ? _feature.getGroupId() : 0;
    }

    @Override
    public long getUserId() {
        return _feature != null ? _feature.getUserId() : 0;
    }

    @Override
    public String getUserName() {
        return _feature != null ? _feature.getUserName() : "";
    }

    @Override
    public String getUuid() {
        return _feature != null ? _feature.getUuid_() : "";
    }

    @Override
    public String getClassName() {
        return Feature.class.getName();
    }

    @Override
    public long getClassPK() {
        return _classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        return _feature != null ? "Feature Toggling: " + _feature.getFeatureName() : "Feature (Deleted)";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        if (_feature == null) {
            return "This Feature has been deleted.";
        }
        return "Feature: " + _feature.getFeatureName();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (!TEMPLATE_FULL_CONTENT.equals(template)) {
            return StringPool.BLANK;
        }

        // Handle deleted Feature case
        if (_feature == null) {
            request.setAttribute("isDeleted", true);
            return "/asset/feature_toggling_full_content.jsp";
        }

        int status = _feature.getStatus();
        String workflowAction = _feature.getWorkflowAction();


        // Determine operation type using workflowAction
        boolean isAddFeature = Constants.ADD_FEATURE.equals(workflowAction);
        boolean isUpdateFeature = Constants.UPDATE_FEATURE.equals(workflowAction);
        boolean isDeleteFeature = Constants.DELETE_FEATURE.equals(workflowAction);
        boolean isUpdateSegment = Constants.UPDATE_SEGMENT.equals(workflowAction);

        // Workflow states
        boolean isApproved = status == WorkflowConstants.STATUS_APPROVED || status == WorkflowConstants.STATUS_INACTIVE;
        boolean isRejected = status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_IN_TRASH;

        // Set attributes for JSP
        request.setAttribute("workflowAction", workflowAction);
        request.setAttribute("isAlreadyApproved", isApproved);
        request.setAttribute("isRejected", isRejected);

        // Feature operations
        request.setAttribute("isAddFeature", isAddFeature);
        request.setAttribute("isUpdateFeature", isUpdateFeature);
        request.setAttribute("isDeleteFeature", isDeleteFeature);
        request.setAttribute("isUpdateSegment", isUpdateSegment);


        // Set channel name
        setChannelName(request, _feature.getChannelId(), "channelName");

        // Set current Feature attributes
        setFeatureAttributes(request, workflowAction);

        // For update/delete operations, fetch the original Feature
        if (_feature.getOriginalEntityId() != 0L) {
            setOriginalFeatureAttributes(request, workflowAction);
        }

        // For UPDATE_SEGMENT, find the segment data even if feature.originalEntityId is 0
        // This handles the case where only the segment is being updated, not the feature itself
        if (isUpdateSegment) {
            setSegmentUpdateAttributes(request);
        }

        // Blue App features use a simplified view showing Whitelist/Segments LOV selections
        if (isBlueAppChannel(_feature.getChannelId())) {
            setBlueAppLovAttributes(request);
            return "/asset/blueApp/feature_toggling_full_content.jsp";
        }

        return "/asset/feature_toggling_full_content.jsp";
    }

    private boolean isBlueAppChannel(long channelId) {
        try {
            Channels channel = channelsLocalService.getChannels(channelId);
            return channel != null && "Blue App".equalsIgnoreCase(channel.getName());
        } catch (PortalException e) {
            LOG.info("Channel not found for BlueApp check. Channel ID: " + channelId);
            return false;
        }
    }

    private List<String> getLovCodes(long featureId, String lovType) {
        List<String> codes = new ArrayList<>();
        List<FeatureLovMap> maps = featureLovMapLocalService.findByFeatureIdAndLovType(featureId, lovType);
        if (maps != null) {
            for (FeatureLovMap map : maps) {
                codes.add(map.getLovDataCode());
            }
        }
        return codes;
    }

    private void setBlueAppLovAttributes(HttpServletRequest request) {
        request.setAttribute("whitelistCodes", getLovCodes(_feature.getFeatureId(), TelemoneyConstants.WHITELIST_CODE));
        request.setAttribute("segmentsCodes", getLovCodes(_feature.getFeatureId(), TelemoneyConstants.SEGMENTS_CODE));

        if (_feature.getOriginalEntityId() != 0L) {
            request.setAttribute("originalWhitelistCodes", getLovCodes(_feature.getOriginalEntityId(), TelemoneyConstants.WHITELIST_CODE));
            request.setAttribute("originalSegmentsCodes", getLovCodes(_feature.getOriginalEntityId(), TelemoneyConstants.SEGMENTS_CODE));
        }
    }

    /**
     * Sets segment update attributes - finds the draft segment and its original
     * This is called for UPDATE_SEGMENT workflow action
     */
    private void setSegmentUpdateAttributes(HttpServletRequest request) {
        // First try to find segments by featureId directly
        List<Segment> featureSegments = segmentLocalService.findSegmentsByFeatureId(_feature.getFeatureId());



        if (featureSegments != null && !featureSegments.isEmpty()) {
            for (Segment segment : featureSegments) {


                // Find the draft segment (the one with originalEntityId pointing to the original segment)
                if (segment.getOriginalEntityId() > 0) {
                    request.setAttribute("draftSegment", segment);

                    try {
                        Segment originalSegment = segmentLocalService.getSegment(segment.getOriginalEntityId());
                        request.setAttribute("originalSegment", originalSegment);
                    } catch (PortalException e) {
                        LOG.error("Original segment not found for segment ID: " + segment.getOriginalEntityId(), e);
                    }
                    return; // Found the draft segment, exit
                }
            }
        }

        // If not found by featureId, try using entityResourceId and childResourceId
        List<Segment> allSegments = segmentLocalService.findAllSegmentsByResourceIds(
                _feature.getEntityResourceId(),
                _feature.getChildResourceId());



        if (allSegments != null && !allSegments.isEmpty()) {
            for (Segment segment : allSegments) {
                // Find segments that are in draft/pending status with an originalEntityId
                if (segment.getOriginalEntityId() > 0 &&
                    (segment.getStatus() == WorkflowConstants.STATUS_DRAFT ||
                     segment.getStatus() == WorkflowConstants.STATUS_PENDING)) {

                    request.setAttribute("draftSegment", segment);

                    try {
                        Segment originalSegment = segmentLocalService.getSegment(segment.getOriginalEntityId());
                        request.setAttribute("originalSegment", originalSegment);
                    } catch (PortalException e) {
                        LOG.error("Original segment not found for segment ID: " + segment.getOriginalEntityId(), e);
                    }
                    return; // Found the draft segment, exit
                }
            }
        }

    }

    private void setFeatureAttributes(HttpServletRequest request, String workflowAction) {
        request.setAttribute("feature", _feature);

        // Set page type display
        String pageType = _feature.getPageType();
        request.setAttribute("pageTypeDisplay", "0".equals(pageType) ? "Parent Page" : "Child Page");

        // Get parent feature name if it's a child page
        if (!"0".equals(pageType) && _feature.getParentPage() > 0) {
            try {
                Feature parentFeature = featureLocalService.fetchFeature(_feature.getParentPage());
                if (parentFeature != null) {
                    request.setAttribute("parentFeatureName", parentFeature.getFeatureName());
                }
            } catch (Exception e) {
                LOG.error("Parent feature not found for parent page: " + _feature.getParentPage(), e);
            }
        }

        // Get block details if exists
        if (_feature.getBlockId() > 0) {
            try {
                Blocks block = blocksLocalService.fetchBlocks(_feature.getBlockId());
                if (block != null) {
                    request.setAttribute("block", block);
                } else {
                    LOG.warn("Block not found for block ID: " + _feature.getBlockId());
                }
            } catch (Exception e) {
                LOG.error("Block not found for block ID: " + _feature.getBlockId(), e);
            }
        }

        List<Segment> segments = segmentLocalService.findFeatureSegments(_feature.getFeatureId());
        if (segments != null && !segments.isEmpty()) {
            request.setAttribute("segments", segments);
        }
    }

    private void setOriginalFeatureAttributes(HttpServletRequest request, String workflowAction) {
        try {
            Feature originalFeature = featureLocalService.fetchFeature(_feature.getOriginalEntityId());
            if (originalFeature != null) {
                request.setAttribute("originalFeature", originalFeature);

                // Set original channel name
                setChannelName(request, originalFeature.getChannelId(), "originalChannelName");

                // Set original page type display
                String originalPageType = originalFeature.getPageType();
                request.setAttribute("originalPageTypeDisplay", "0".equals(originalPageType) ? "Parent Page" : "Child Page");

                // Get original parent feature name if it's a child page
                if (!"0".equals(originalPageType) && originalFeature.getParentPage() > 0) {
                    try {
                        Feature originalParentFeature = featureLocalService.fetchFeature(originalFeature.getParentPage());
                        if (originalParentFeature != null) {
                            request.setAttribute("originalParentFeatureName", originalParentFeature.getFeatureName());
                        }
                    } catch (Exception e) {
                        LOG.error("Original parent feature not found", e);
                    }
                }

                // Get original block details if exists
                if (originalFeature.getBlockId() > 0) {
                    try {
                        Blocks originalBlock = blocksLocalService.fetchBlocks(originalFeature.getBlockId());
                        if (originalBlock != null) {
                            request.setAttribute("originalBlock", originalBlock);
                        } else {
                            LOG.warn("Original block not found for block ID: " + originalFeature.getBlockId());
                        }
                    } catch (Exception e) {
                        LOG.error("Original block not found", e);
                    }
                }

                // Get original segments
                List<Segment> originalSegments = segmentLocalService.findFeatureSegments(originalFeature.getFeatureId());
                if (originalSegments != null && !originalSegments.isEmpty()) {
                    request.setAttribute("originalSegments", originalSegments);
                }

                // For UPDATE_SEGMENT, find the specific segment being updated
                if (Constants.UPDATE_SEGMENT.equals(workflowAction)) {
                    List<Segment> draftSegments = segmentLocalService.findFeatureSegments(_feature.getFeatureId());
                    if (draftSegments != null && !draftSegments.isEmpty()) {
                        for (Segment draftSegment : draftSegments) {
                            if (draftSegment.getOriginalEntityId() > 0) {
                                request.setAttribute("draftSegment", draftSegment);
                                try {
                                    Segment originalSegment = segmentLocalService.getSegment(draftSegment.getOriginalEntityId());
                                    request.setAttribute("originalSegment", originalSegment);
                                } catch (PortalException e) {
                                    LOG.error("Original segment not found for segment ID: " + draftSegment.getOriginalEntityId(), e);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Original Feature not found for originalEntityId: " + _feature.getOriginalEntityId(), e);
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
}

