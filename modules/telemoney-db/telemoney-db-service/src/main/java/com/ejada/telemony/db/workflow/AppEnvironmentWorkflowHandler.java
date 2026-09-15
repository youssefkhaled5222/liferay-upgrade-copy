package com.ejada.telemony.db.workflow;

import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppEnvironmentLocalService;
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
public class AppEnvironmentWorkflowHandler
	extends BaseWorkflowHandler<AppEnvironment> {

	private static final Log LOG = LogFactoryUtil.getLog(
		AppEnvironmentWorkflowHandler.class);

	@Override
	public String getClassName() {
		return AppEnvironment.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return "AppEnvironment";
	}

	@Override
	public AppEnvironment updateStatus(
			int status, Map<String, Serializable> workflowContext)
		throws PortalException {

		LOG.info("========== AppEnvironment Workflow Handler Called ==========");
		LOG.info("Status Code: " + status);

		long userId = GetterUtil.getLong(
			(String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long environmentId = GetterUtil.getLong(
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		ServiceContext serviceContext = (ServiceContext)workflowContext.get(
			WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

		LOG.info(
			"AppEnvironment ID: " + environmentId + ", User ID: " + userId);

		AppEnvironment result = _appEnvironmentLocalService.updateStatus(
			userId, environmentId, status, serviceContext);

		LOG.info("Updated AppEnvironment Status: " + result.getStatus());
		LOG.info("============================================");

		return result;
	}

	@Reference
	private AppEnvironmentLocalService _appEnvironmentLocalService;

}
