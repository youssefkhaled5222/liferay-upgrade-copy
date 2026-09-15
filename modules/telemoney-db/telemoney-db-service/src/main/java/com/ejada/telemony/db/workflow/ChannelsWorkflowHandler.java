package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.Channels;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.impl.ChannelsLocalServiceImpl;
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
public class ChannelsWorkflowHandler extends BaseWorkflowHandler<Channels> {
    private static final Log LOG = LogFactoryUtil.getLog(ChannelsWorkflowHandler.class);

    @Override
    public String getClassName() {
        return Channels.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "Channels";
    }

    @Override
    public Channels updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        LOG.info("========== Workflow Handler Called ==========");
        LOG.info("Status Code: " + status);

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long channelId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                WorkflowConstants.CONTEXT_SERVICE_CONTEXT);


        LOG.info("Channel ID: " + channelId + ", User ID: " + userId);

        Channels result;
        try {
            result = _channelsLocalService.updateStatus(userId, channelId, status, serviceContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        LOG.info("Updated Channel Status: " + result.getStatus());
        LOG.info("============================================");

        return result;
    }

    @Reference
    private ChannelsLocalService _channelsLocalService;

}
