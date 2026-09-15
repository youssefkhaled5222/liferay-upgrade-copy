package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.service.PersonaLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;


@Component(
        immediate = true,
        service = com.liferay.portal.kernel.workflow.WorkflowHandler.class
)
public class PersonaWorkflowHandler extends BaseWorkflowHandler<Persona> {
    private static final Log LOG = LogFactoryUtil.getLog(PersonaWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Persona.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Persona";
    }

    @Override
    public Persona updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long personaId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);


        LOG.info("Persona ID: " + personaId + ", User ID: " + userId);

        Persona result = _personaLocalService.updateStatus(userId, personaId, status, serviceContext);

        LOG.info("============================================");

        return result;
    }

    @Reference
    private PersonaLocalService _personaLocalService ;

}

