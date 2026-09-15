package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class PersonaAssetRenderer extends BaseJSPAssetRenderer<Persona> {

    private static final Log LOG = LogFactoryUtil.getLog(PersonaAssetRenderer.class);

    private final Persona persona;
    private final PersonaLocalService personaLocalService;

    public PersonaAssetRenderer(Persona persona, PersonaLocalService personaLocalService) {
        this.persona = persona;
        this.personaLocalService = personaLocalService;
    }

    @Override
    public Persona getAssetObject() {
        return persona;
    }

    @Override
    public long getGroupId() {
        return persona.getGroupId();
    }

    @Override
    public long getUserId() {
        return persona.getUserId();
    }

    @Override
    public String getUserName() {
        return persona.getUserName();
    }

    @Override
    public String getUuid() {
        return persona.getUuid_();
    }

    @Override
    public String getClassName() {
        return Persona.class.getName();
    }

    @Override
    public long getClassPK() {
        return persona.getPersonaId();
    }

    @Override
    public String getTitle(Locale locale) {
        return "Persona";
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Name: " + persona.getName();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        request.setAttribute("editedPersona", persona);
        try {
            if (persona.getOriginalEntityId() > 0) {
                Persona original = personaLocalService.getPersona(persona.getOriginalEntityId());
                request.setAttribute("originalPersona", original);
            }
        } catch (PortalException e) {
            LOG.error("Unable to load original Persona", e);
        }

        if (TEMPLATE_FULL_CONTENT.equals(template)) {
            return "/assets/persona_full_content.jsp";
        }
        return StringPool.BLANK;
    }
}
