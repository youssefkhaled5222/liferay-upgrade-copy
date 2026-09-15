package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Languages;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Asset renderer for deleted Languages entries.
 * This renderer is used when the original Language has been deleted
 * but there are still workflow tasks or notifications referencing it.
 */
public class DeletedLanguagesAssetRenderer extends BaseJSPAssetRenderer<Languages> {

    private static final Log LOG = LogFactoryUtil.getLog(DeletedLanguagesAssetRenderer.class);

    private final long classPK;

    public DeletedLanguagesAssetRenderer(long classPK) {
        this.classPK = classPK;
    }

    @Override
    public Languages getAssetObject() {
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
        return Languages.class.getName();
    }

    @Override
    public long getClassPK() {
        return classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        return "Language (Deleted)";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "This Language entry has been deleted.";
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("entryDeleted", true);
        request.setAttribute("deletedEntryId", classPK);

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/asset/language_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}
