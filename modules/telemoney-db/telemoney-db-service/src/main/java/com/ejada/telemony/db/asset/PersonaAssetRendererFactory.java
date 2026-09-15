package com.ejada.telemony.db.asset;


import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_ejada_telemoney_persona_TelemoneyPersonaPortlet",
                "search.class.name=com.ejada.telemony.db.model.Persona"
        },
        service = AssetRendererFactory.class
)
public class PersonaAssetRendererFactory  extends BaseAssetRendererFactory<Persona> {

    private static final Log LOG = LogFactoryUtil.getLog(PersonaAssetRendererFactory.class);

    @Reference
    private PersonaLocalService personaLocalService;

    public PersonaAssetRendererFactory() {
        setClassName(Persona.class.getName());
        setCategorizable(false);
        setLinkable(true);
        setPortletId("com_ejada_telemoney_persona_TelemoneyPersonaPortlet");
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Persona> getAssetRenderer(
            long classPK, int type) throws PortalException {

        try {
            Persona persona = personaLocalService.getPersona(classPK);
            return new PersonaAssetRenderer(persona, personaLocalService);
        } catch (PortalException e) {
            return new DeletedPersonaAssetRenderer(classPK);
        }
    }

    @Override
    public String getType() {
        return "Persona";
    }
}
