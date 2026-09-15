package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.service.FeatureLocalService;
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
public class FeatureTogglingWorkflowHandler extends BaseWorkflowHandler<Feature> {
    private static final Log LOG = LogFactoryUtil.getLog(FeatureTogglingWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Feature.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Feature";
    }

    @Override
    public Feature updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long featureId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);


        LOG.info("Feature ID: " + featureId + ", User ID: " + userId);

        Feature result = null;
            try {
                result = _featureLocalService.updateStatus(userId, featureId, status, serviceContext);
            } catch (Exception e) {
                LOG.info("Error while updating status: " + e.getMessage());
            }


        LOG.info("============================================");

        return result;
    }

    @Reference
    private FeatureLocalService _featureLocalService;

}

