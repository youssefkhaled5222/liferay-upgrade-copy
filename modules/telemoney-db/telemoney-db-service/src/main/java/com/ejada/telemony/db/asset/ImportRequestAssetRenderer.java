package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.service.ImportRequestLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;

public class ImportRequestAssetRenderer extends BaseJSPAssetRenderer<ImportRequest> {

    private static final Log LOG = LogFactoryUtil.getLog(ImportRequestAssetRenderer.class);

    private final ImportRequest _importRequest;
    private final long _classPK;
    private final ImportRequestLocalService _importRequestLocalService;

    public ImportRequestAssetRenderer(ImportRequest importRequest, long classPK,
                                       ImportRequestLocalService importRequestLocalService) {
        _importRequest = importRequest;
        _classPK = classPK;
        _importRequestLocalService = importRequestLocalService;
    }

    @Override
    public ImportRequest getAssetObject() {
        return _importRequest;
    }

    @Override
    public long getGroupId() {
        return _importRequest != null ? _importRequest.getGroupId() : 0;
    }

    @Override
    public long getUserId() {
        return _importRequest != null ? _importRequest.getUserId() : 0;
    }

    @Override
    public String getUserName() {
        return _importRequest != null ? _importRequest.getUserName() : "";
    }

    @Override
    public String getUuid() {
        return _importRequest != null ? _importRequest.getUuid_() : "";
    }

    @Override
    public String getClassName() {
        return ImportRequest.class.getName();
    }

    @Override
    public long getClassPK() {
        return _classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        if (_importRequest == null) {
            return "Import Request (Deleted)";
        }
        return "Import Request - " + _importRequest.getType();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        if (_importRequest == null) {
            return "This import request (ID: " + _classPK + ") has been deleted.";
        }
        return "Import: " + _importRequest.getFileName() + " (Type: " + _importRequest.getType() + ")";
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (!TEMPLATE_FULL_CONTENT.equals(template)) {
            return StringPool.BLANK;
        }

        if (_importRequest == null) {
            request.setAttribute("isDeleted", true);
            request.setAttribute("deletedEntryId", _classPK);

            // Try to resolve entry name from AssetEntry
            String deletedEntryName = null;
            try {
                AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
                        ImportRequest.class.getName(), _classPK);
                if (assetEntry != null && assetEntry.getTitle() != null && !assetEntry.getTitle().isEmpty()) {
                    deletedEntryName = assetEntry.getTitle();
                }
            } catch (Exception e) {
                LOG.warn("Could not resolve asset entry name for classPK: " + _classPK, e);
            }
            request.setAttribute("deletedEntryName", deletedEntryName);

            return "/asset/import_request_full_content.jsp";
        }

        request.setAttribute("importRequest", _importRequest);

        // Get workflow status
        int status = _importRequest.getStatus();

        // Workflow states
        boolean isApproved = status == WorkflowConstants.STATUS_APPROVED ;
        boolean isRejected = status == WorkflowConstants.STATUS_DENIED;

        // Set workflow state attributes for JSP
        request.setAttribute("isAlreadyApproved", isApproved);
        request.setAttribute("isRejected", isRejected);

        try {
            Map<String, String> viewData = _importRequestLocalService.getImportRequestViewData(
                    _importRequest.getId());

            request.setAttribute("metadataJson", viewData.get("metadataJson"));
            request.setAttribute("changeLogJson", viewData.get("changeLogJson"));
            request.setAttribute("enrichedDataJson", viewData.get("enrichedDataJson"));

        } catch (Exception e) {
            LOG.error("Failed to read zip file for ImportRequest ID: " + _importRequest.getId(), e);
            request.setAttribute("zipReadError", true);
        }

        return "/asset/import_request_full_content.jsp";
    }
}

