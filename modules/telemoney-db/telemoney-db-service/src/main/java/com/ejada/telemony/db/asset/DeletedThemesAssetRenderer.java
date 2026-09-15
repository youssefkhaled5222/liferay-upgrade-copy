package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Themes;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Asset renderer for deleted Themes entries.
 * This renderer is used when the original Theme has been deleted
 * but there are still workflow tasks or notifications referencing it.
 */
public class DeletedThemesAssetRenderer extends BaseJSPAssetRenderer<Themes> {

    private static final Log LOG = LogFactoryUtil.getLog(DeletedThemesAssetRenderer.class);

    private final long classPK;

    public DeletedThemesAssetRenderer(long classPK) {
        this.classPK = classPK;
    }

    @Override
    public Themes getAssetObject() {
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
        return Themes.class.getName();
    }

    @Override
    public long getClassPK() {
        return classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        return "Themes (Deleted)";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "This Theme entry has been deleted.";
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("entryDeleted", true);
        request.setAttribute("deletedEntryId", classPK);

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/asset/themes_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}
