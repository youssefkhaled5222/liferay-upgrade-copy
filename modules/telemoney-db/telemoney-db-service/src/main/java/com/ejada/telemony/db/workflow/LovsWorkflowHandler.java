package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.service.LovsLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class LovsWorkflowHandler extends BaseWorkflowHandler<Lovs> {
    private static final Log LOG = LogFactoryUtil.getLog(LovsWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Lovs.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Lovs";
    }

    @Override
    public Lovs updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long lovId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);


        LOG.info("Lov ID: " + lovId + ", User ID: " + userId);

        Lovs result = null;
            try {
                result = _lovsLocalService.updateStatus(userId, lovId, status, serviceContext);
            } catch (Exception e) {
                LOG.info("Error while updating status: " + e.getMessage());
            }


        LOG.info("============================================");

        return result;
    }

    @Reference
    private LovsLocalService _lovsLocalService;

}

