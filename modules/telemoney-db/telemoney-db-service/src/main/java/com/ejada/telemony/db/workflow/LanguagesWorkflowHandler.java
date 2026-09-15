package com.ejada.telemony.db.workflow;


import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.model.Languages;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;



@Component(
        immediate = true,
        service = com.liferay.portal.kernel.workflow.WorkflowHandler.class
)
public class LanguagesWorkflowHandler extends BaseWorkflowHandler<Languages> {
    private static final Log LOG = LogFactoryUtil.getLog(LanguagesWorkflowHandler.class);
    @Override
    public String getClassName() {
        return Languages.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Languages";
    }

    @Override
    public Languages updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long languageId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);



        LOG.info("Language ID: " + languageId + ", User ID: " + userId);

        Languages result;
        try {
            result = _languagesLocalService.updateStatus(userId, languageId, status, serviceContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        LOG.info("Updated language Status: " + result.getStatus());
        LOG.info("============================================");

        return null;
    }
    @Reference
    private com.ejada.telemony.db.service.LanguagesLocalService _languagesLocalService;

}
