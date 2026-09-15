package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Persona;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Asset renderer for deleted Persona entries.
 * This renderer is used when the original Persona has been deleted
 * but there are still workflow tasks or notifications referencing it.
 */
public class DeletedPersonaAssetRenderer extends BaseJSPAssetRenderer<Persona> {

    private static final Log LOG = LogFactoryUtil.getLog(DeletedPersonaAssetRenderer.class);

    private final long classPK;

    public DeletedPersonaAssetRenderer(long classPK) {
        this.classPK = classPK;
    }

    @Override
    public Persona getAssetObject() {
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
        return Persona.class.getName();
    }

    @Override
    public long getClassPK() {
        return classPK;
    }

    @Override
    public String getTitle(Locale locale) {
        return "Persona (Deleted)";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "This Persona entry has been deleted.";
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("entryDeleted", true);
        request.setAttribute("deletedEntryId", classPK);

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/assets/persona_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}

