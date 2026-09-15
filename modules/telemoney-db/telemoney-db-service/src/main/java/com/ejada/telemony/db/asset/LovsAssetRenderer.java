package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.LovData;
import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.LanguagesLocalService;
import com.ejada.telemony.db.service.LovDataLocalService;
import com.ejada.telemony.db.service.LovsLocalService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LovsAssetRenderer extends BaseJSPAssetRenderer<Lovs> {
    private static final Log LOG = LogFactoryUtil.getLog(LovsAssetRenderer.class);

    private final Lovs _lovs;
    private final long _classPK;
    private final LovsLocalService lovsLocalService;
    private final LovDataLocalService lovDataLocalService;
    private final ChannelsLocalService channelsLocalService;
    private final LanguagesLocalService languagesLocalService;

    public LovsAssetRenderer(Lovs lovs, long classPK, LovsLocalService lovsLocalService,
                             LovDataLocalService lovDataLocalService, ChannelsLocalService channelsLocalService, LanguagesLocalService languagesLocalService) {
        _lovs = lovs;
        _classPK = classPK;
        this.lovsLocalService = lovsLocalService;
        this.lovDataLocalService = lovDataLocalService;
        this.channelsLocalService = channelsLocalService;
        this.languagesLocalService = languagesLocalService;
    }

    @Override
    public Lovs getAssetObject() {
        return _lovs;
    }

    @Override
    public long getGroupId() {
        return _lovs != null ? _lovs.getGroupId() : 0;
    }

    @Override
    public long getUserId() {
        return _lovs != null ? _lovs.getUserId() : 0;
    }

    @Override
    public String getUserName() {
        return _lovs != null ? _lovs.getUserName() : "";
    }

    @Override
    public String getUuid() {
        return _lovs != null ? _lovs.getUuid_() : "";
    }

    @Override
    public String getClassName() {
        return Lovs.class.getName();
    }

    @Override
    public long getClassPK() {
        return _classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        return _lovs != null ? "LOV" : "LOV (Deleted)";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        if (_lovs == null) {
            return "This LOV has been deleted.";
        }
        return "Code: " + _lovs.getCode();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (!TEMPLATE_FULL_CONTENT.equals(template)) {
            return StringPool.BLANK;
        }
        LOG.info(_lovs.getUserId() + " - Setting LOV attributes for LOV ID: " + _lovs.getId());

        // Handle deleted LOV case
        if (_lovs == null) {
            request.setAttribute("isDeleted", true);
            return "/asset/lov_full_content.jsp";
        }

        int status = _lovs.getStatus();
        String workflowAction = _lovs.getWorkflowAction();

        LOG.info("=== LovsAssetRenderer ===");
        LOG.info("LOV ID: " + _lovs.getId() + ", Status: " + status + ", Workflow Action: " + workflowAction);

        // Determine operation type using workflowAction
        boolean isAddLov = Constants.ADD_LOV.equals(workflowAction);
        boolean isUpdateLov = Constants.UPDATE_LOV.equals(workflowAction);
        boolean isDeleteLov = Constants.DELETE_LOV.equals(workflowAction);
        boolean isAddLovData = Constants.ADD_LOV_DATA.equals(workflowAction);
        boolean isUpdateLovData = Constants.UPDATE_LOV_DATA.equals(workflowAction);
        boolean isDeleteLovData = Constants.DELETE_LOV_DATA.equals(workflowAction);

        // Workflow states
        boolean isApproved = status == WorkflowConstants.STATUS_APPROVED || status == WorkflowConstants.STATUS_INACTIVE;
        boolean isRejected = status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_IN_TRASH;

        // Set attributes for JSP
        request.setAttribute("workflowAction", workflowAction);
        request.setAttribute("isAlreadyApproved", isApproved);
        request.setAttribute("isRejected", isRejected);

        // LOV operations
        request.setAttribute("isAddLov", isAddLov);
        request.setAttribute("isUpdateLov", isUpdateLov);
        request.setAttribute("isDeleteLov", isDeleteLov);

        // LOV data operations
        request.setAttribute("isAddLovData", isAddLovData);
        request.setAttribute("isUpdateLovData", isUpdateLovData);
        request.setAttribute("isDeleteLovData", isDeleteLovData);

        LOG.info("Operation: " + workflowAction);

        // Set channel name
        setChannelName(request, _lovs.getChannelId(), "channelName");

        // Set current LOV attributes
        setLovAttributes(request, workflowAction);

        // For update/delete operations, fetch the original LOV
        if (_lovs.getOriginalEntityId() != 0L) {
            setOriginalLovAttributes(request, workflowAction);
        }

        return "/asset/lov_full_content.jsp";
    }

    private void setLovAttributes(HttpServletRequest request, String workflowAction) {
        request.setAttribute("lov", _lovs);
        // Set LOV localizations
        setLovLocalizations(request, _lovs.getId(), "lovLocalizations");

        // Determine which LOV to fetch data from (used for DELETE_LOV to get original data)
        long lovIdForData;
        if (Constants.DELETE_LOV.equals(workflowAction) && _lovs.getOriginalEntityId() != 0L) {
            lovIdForData = _lovs.getOriginalEntityId();
        } else {
            lovIdForData = _lovs.getId();
        }

        // Get LOV data for LOV data operations
        if (Constants.ADD_LOV_DATA.equals(workflowAction) ||
            Constants.UPDATE_LOV_DATA.equals(workflowAction) ||
            Constants.DELETE_LOV_DATA.equals(workflowAction)) {

            List<LovData> lovDataList = lovDataLocalService.findLovDataByLovId(_lovs.getId());

            if (!lovDataList.isEmpty()) {
                request.setAttribute("lovDataList", lovDataList);
                setLovDataLocalizations(request, lovDataList, "lovDataLocalizations");
            }
        }
    }

    private void setOriginalLovAttributes(HttpServletRequest request, String workflowAction) {
        try {
            Lovs originalLov = lovsLocalService.getLovs(_lovs.getOriginalEntityId());
            request.setAttribute("originalLov", originalLov);

            // Set original channel name
            setChannelName(request, originalLov.getChannelId(), "originalChannelName");

            // Set original LOV localizations
            setLovLocalizations(request, originalLov.getId(), "originalLovLocalizations");

            // For LOV data operations, get the original LOV data
            if (Constants.UPDATE_LOV_DATA.equals(workflowAction) ||
                Constants.DELETE_LOV_DATA.equals(workflowAction)) {

                // Get the draft data (from current LOV)
                List<LovData> draftDataList = lovDataLocalService.findLovDataByLovId(_lovs.getId());
                if (!draftDataList.isEmpty()) {
                    LovData draftData = draftDataList.get(0);
                    if (draftData.getOriginalEntityId() != 0L) {
                        try {
                            LovData originalData = lovDataLocalService.getLovData(draftData.getOriginalEntityId());
                            List<LovData> originalDataList = new ArrayList<>();
                            originalDataList.add(originalData);
                            request.setAttribute("originalLovDataList", originalDataList);
                            setLovDataLocalizations(request, originalDataList, "originalLovDataLocalizations");
                        } catch (PortalException e) {
                            LOG.error("Original LOV data not found", e);
                        }
                    }
                }
            }

        } catch (PortalException e) {
            LOG.error("Original LOV not found for originalEntityId: " + _lovs.getOriginalEntityId(), e);
        }
    }

    private void setChannelName(HttpServletRequest request, long channelId, String attributeName) {
        try {
            Channels channel = channelsLocalService.getChannels(channelId);
            request.setAttribute(attributeName, channel.getName());
        } catch (PortalException e) {
            request.setAttribute(attributeName, String.valueOf(channelId));
        }
    }

    private void setLovLocalizations(HttpServletRequest request, long lovId, String attributeName) {
        try {
            Lovs lov = lovsLocalService.getLovs(lovId);
            Map<String, String> localizationsMap = new HashMap<>();

            for (Languages language : languagesLocalService.getbyChannelId(lov.getChannelId())) {
                String langName = language.getLangName();
                String name = lov.getName(langName);
                if (name != null && !name.isEmpty()) {
                    localizationsMap.put(langName, name);
                }
            }

            request.setAttribute(attributeName, localizationsMap);
        } catch (PortalException e) {
            LOG.error("Error getting LOV localizations for LOV ID: " + lovId, e);
        }
    }

    private void setLovDataLocalizations(HttpServletRequest request, List<LovData> lovDataList, String attributeName) {
        Map<Long, Map<String, String>> localizationsMap = new HashMap<>();

        for (LovData lovData : lovDataList) {
            Map<String, String> dataLocMap = new HashMap<>();

            try {
                // Get all available languages for this LOV's channel
                Lovs lov = lovsLocalService.getLovs(lovData.getLovId());
                for (Languages language : languagesLocalService.getbyChannelId(lov.getChannelId())) {
                    String langName = language.getLangName();
                    String description = lovData.getRecordDescription(langName);
                    if (description != null) {
                        dataLocMap.put(langName, description);
                    }
                }
            } catch (PortalException e) {
                LOG.error("Error getting channel languages for LOV data ID: " + lovData.getId(), e);
                String[] defaultLanguages = {"English", "Arabic"};
                for (String lang : defaultLanguages) {
                    String description = lovData.getRecordDescription(lang);
                    if (description != null) {
                        dataLocMap.put(lang, description);
                    }
                }
            }

            localizationsMap.put(lovData.getId(), dataLocMap);
        }

        request.setAttribute(attributeName, localizationsMap);
    }
}

