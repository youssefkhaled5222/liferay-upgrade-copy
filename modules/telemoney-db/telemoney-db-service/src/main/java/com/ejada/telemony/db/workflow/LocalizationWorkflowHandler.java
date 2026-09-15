package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Localization;
import com.ejada.telemony.db.service.LocalizationLocalService;
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
public class LocalizationWorkflowHandler extends BaseWorkflowHandler<Localization> {
    private static final Log LOG = LogFactoryUtil.getLog(LocalizationWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Localization.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Localization";
    }

    @Override
    public Localization updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Localization Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long localizationId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

        LOG.info("Localization ID: " + localizationId + ", User ID: " + userId);

        Localization result = _localizationLocalService.updateStatus(userId, localizationId, status, serviceContext);

        LOG.info("Updated Localization Status: " + result.getStatus());
        LOG.info("============================================");

        return result;
    }

    @Reference
    private LocalizationLocalService _localizationLocalService;

}

