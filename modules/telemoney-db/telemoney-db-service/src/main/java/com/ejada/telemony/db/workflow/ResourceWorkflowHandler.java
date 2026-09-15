package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Resource;
import com.ejada.telemony.db.service.ResourceLocalService;
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
public class ResourceWorkflowHandler extends BaseWorkflowHandler<Resource> {
    private static final Log LOG = LogFactoryUtil.getLog(ResourceWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Resource.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Resource";
    }

    @Override
    public Resource updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Resource Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourceId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

        LOG.info("Resource ID: " + resourceId + ", User ID: " + userId);

        Resource result = _resourceLocalService.updateStatus(userId, resourceId, status, serviceContext);

        LOG.info("Updated Resource Status: " + result.getStatus());
        LOG.info("============================================");

        return result;
    }

    @Reference
    private ResourceLocalService _resourceLocalService;

}

