package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.AppVersion;
import com.ejada.telemony.db.service.AppVersionLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true, service = com.liferay.portal.kernel.workflow.WorkflowHandler.class)
public class AppVersionWorkflowHandler extends BaseWorkflowHandler<AppVersion> {

    private static final Log LOG = LogFactoryUtil.getLog(AppVersionWorkflowHandler.class);

    @Override
    public String getClassName() {
        return AppVersion.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "AppVersion";
    }

    @Override
    public AppVersion updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== AppVersion Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long versionId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        ServiceContext serviceContext = (ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

        LOG.info("AppVersion ID: " + versionId + ", User ID: " + userId);

        AppVersion result = _appVersionLocalService.updateStatus(userId, versionId, status, serviceContext);

        LOG.info("Updated AppVersion Status: " + result.getStatus());
        LOG.info("============================================");

        return result;
    }

    @Reference
    private AppVersionLocalService _appVersionLocalService;
}
