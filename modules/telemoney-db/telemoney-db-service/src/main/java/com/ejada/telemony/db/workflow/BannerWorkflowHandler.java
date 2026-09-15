package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Banner;
import com.ejada.telemony.db.service.BannerLocalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;


@Component(
        immediate = true,
        service = WorkflowHandler.class
)
public class BannerWorkflowHandler extends BaseWorkflowHandler<Banner> {
    private static final Log LOG = LogFactoryUtil.getLog(BannerWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Banner.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Banner";
    }

    @Override
    public Banner updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long bannerId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);


        LOG.info("Banner ID: " + bannerId + ", User ID: " + userId);

        Banner result = null;
            try {
                result = _bannerLocalService.updateStatus(userId, bannerId, status, serviceContext);
            } catch (Exception e) {
                LOG.info("Banner is not found with ID: " + bannerId);
            }


        LOG.info("============================================");

        return result;
    }

    @Reference
    private BannerLocalService _bannerLocalService;

}

