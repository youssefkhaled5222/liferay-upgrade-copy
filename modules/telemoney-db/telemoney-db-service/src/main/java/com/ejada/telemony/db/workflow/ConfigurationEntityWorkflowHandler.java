package com.ejada.telemony.db.workflow;


import com.ejada.telemony.db.model.AppVersion;
import com.ejada.telemony.db.model.ConfigurationEntity;
import com.ejada.telemony.db.service.ConfigurationEntityLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@Component(
        immediate = true,
        service = com.liferay.portal.kernel.workflow.WorkflowHandler.class
)

public class ConfigurationEntityWorkflowHandler  extends BaseWorkflowHandler<ConfigurationEntity> {
    private static final Log LOG = LogFactoryUtil.getLog(ConfigurationEntityWorkflowHandler.class);

    @Override
    public String getClassName() {
        return ConfigurationEntity.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "ConfigurationEntity";
    }

    @Override
    public ConfigurationEntity updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {

        LOG.info("========== Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long entityId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);


        LOG.info("ConfigurationEntity ID: " + entityId + ", User ID: " + userId);

        ConfigurationEntity result = null;
        try {
            result = _configurationEntityLocalService.updateStatus(userId, entityId, status, serviceContext);
        } catch (Exception e) {
            LOG.error("Unexpected error while updating status: " + e.getMessage(), e);
            throw new WorkflowException("Failed to update ConfigurationEntity status: " + e.getMessage(), e);
        }


        LOG.info("============================================");

        return result;
    }


    @Reference
    private ConfigurationEntityLocalService _configurationEntityLocalService;


}
