package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Themes;
import com.ejada.telemony.db.service.ThemesLocalService;
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
public class ThemesWorkflowHandler extends BaseWorkflowHandler<Themes> {
    private static final Log LOG = LogFactoryUtil.getLog(ThemesWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Themes.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Themes";
    }

    @Override
    public Themes updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Themes Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long themeId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

        LOG.info("Theme ID: " + themeId + ", User ID: " + userId);

        Themes result = _themesLocalService.updateStatus(userId, themeId, status, serviceContext);

        LOG.info("Updated Theme Status: " + result.getStatus());
        LOG.info("====================================================");

        return result;
    }

    @Reference
    private ThemesLocalService _themesLocalService;
}
