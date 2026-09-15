package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Resource;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class DeletedResourceAssetRenderer extends BaseJSPAssetRenderer<Resource> {

    private static final Log LOG = LogFactoryUtil.getLog(DeletedResourceAssetRenderer.class);

    private final long classPK;

    public DeletedResourceAssetRenderer(long classPK) {
        this.classPK = classPK;
    }

    @Override
    public Resource getAssetObject() {
        return null;
    }

    @Override
    public long getGroupId() {
        return 0;
    }

    @Override
    public long getUserId() {
        return 0;
    }

    @Override
    public String getUserName() {
        return StringPool.BLANK;
    }

    @Override
    public String getUuid() {
        return StringPool.BLANK;
    }

    @Override
    public String getClassName() {
        return Resource.class.getName();
    }

    @Override
    public long getClassPK() {
        return classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        return "Resource (Deleted)";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "This Resource entry has been deleted.";
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("entryDeleted", true);
        request.setAttribute("deletedEntryId", classPK);

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/assets/resource_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}

