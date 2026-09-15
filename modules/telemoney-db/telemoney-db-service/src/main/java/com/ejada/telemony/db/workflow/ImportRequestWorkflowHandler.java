package com.ejada.telemony.db.workflow;


import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.service.ImportRequestLocalService;
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

@Component(immediate = true, service = com.liferay.portal.kernel.workflow.WorkflowHandler.class)
public class ImportRequestWorkflowHandler extends BaseWorkflowHandler<ImportRequest> {


    private static final Log LOG = LogFactoryUtil.getLog(ImportRequestWorkflowHandler.class);

    @Override
    public String getClassName() {
        return ImportRequest.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "ImportRequest";
    }

    @Override
    public ImportRequest updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== ImportRequest Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long importRequestId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        ServiceContext serviceContext = (ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

        LOG.info("ImportRequest ID: " + importRequestId + ", User ID: " + userId);

        ImportRequest result = _importRequestLocalService.updateStatus(userId, importRequestId, status, serviceContext);

        LOG.info("============================================");

        return result;
    }

    @Reference
    private ImportRequestLocalService _importRequestLocalService;
}
