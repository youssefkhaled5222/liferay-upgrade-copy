package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Localization;
import com.ejada.telemony.db.service.LocalizationLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

public class LocalizationAssetRenderer extends BaseJSPAssetRenderer<Localization> {

    private static final Log LOG = LogFactoryUtil.getLog(LocalizationAssetRenderer.class);

    private final Localization localization;
    private final LocalizationLocalService localizationLocalService;

    public LocalizationAssetRenderer(Localization localization, LocalizationLocalService localizationLocalService) {
        this.localization = localization;
        this.localizationLocalService = localizationLocalService;
    }

    @Override
    public Localization getAssetObject() {
        return localization;
    }

    @Override
    public long getGroupId() {
        return localization.getGroupId();
    }

    @Override
    public long getUserId() {
        return localization.getUserId();
    }

    @Override
    public String getUserName() {
        return localization.getUserName();
    }

    @Override
    public String getUuid() {
        return localization.getUuid_();
    }

    @Override
    public String getClassName() {
        return Localization.class.getName();
    }

    @Override
    public long getClassPK() {
        return localization.getLocalizationId();
    }

    @Override
    public String getTitle(Locale locale) {
        return "Localization";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Localization Update - Feature ID: " + localization.getFeatureId();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        // Set the current localization
        request.setAttribute("currentLocalization", localization);

        // Get all localizations with the same workflowBatchId
        String workflowBatchId = localization.getWorkflowBatchId();
        if (workflowBatchId != null && !workflowBatchId.isEmpty()) {
            List<Localization> batchLocalizations = localizationLocalService.getByWorkflowBatchId(workflowBatchId);
            request.setAttribute("batchLocalizations", batchLocalizations);
        }

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/assets/localization_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}



