/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.AppEnvironment;
import com.ejada.telemony.db.service.AppEnvironmentLocalServiceUtil;
import com.ejada.telemony.db.service.base.AppEnvironmentLocalServiceBaseImpl;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

/**
 * @author Brian Wing Shun Chan
 */
public class AppEnvironmentLocalServiceImpl
	extends AppEnvironmentLocalServiceBaseImpl {

	private static final Log LOG = LogFactoryUtil.getLog(
		AppEnvironmentLocalServiceImpl.class);

	public AppEnvironment addAppEnvironment(
		Long channelId, ServiceContext serviceContext, User user, String environmentName) {

		if (channelId == null) {
			LOG.info("Invalid input: channelId is null.");
			throw new BadRequestException("Invalid input: channelId is null.");
		}

		DynamicQuery channelEnvCheck = DynamicQueryFactoryUtil.forClass(
			AppEnvironment.class, getClassLoader());

		channelEnvCheck.add(PropertyFactoryUtil.forName("channelId").eq(channelId));
		channelEnvCheck.add(
			PropertyFactoryUtil.forName("environmentName").eq(
				environmentName));

		if (!AppEnvironmentLocalServiceUtil.dynamicQuery(channelEnvCheck).isEmpty()) {
			LOG.info("AppEnvironment Exists");
			throw new NotFoundException("AppEnvironment Exists");
		}

		AppEnvironment appEnvironment = createAppEnvironment(
			counterLocalService.increment());

		appEnvironment.setChannelId(channelId);
		appEnvironment.setEntityResourceId(appEnvironment.getEnvironmentId());
		appEnvironment.setVersion(
			getMaxVersion(appEnvironment.getEntityResourceId()) + 1);

		prepareForWorkflow(
			appEnvironment, serviceContext, user, 0L, Constants.ADD);

		AppEnvironment savedAppEnvironment = appEnvironmentPersistence.update(
			appEnvironment);

		startWorkflow(savedAppEnvironment, serviceContext, user);
		LOG.info(
			"AppEnvironment created with ID " +
				savedAppEnvironment.getEnvironmentId());

		return savedAppEnvironment;
	}

	public AppEnvironment updateAppEnvironment(
		Long environmentId, Long channelId, ServiceContext serviceContext) {

		AppEnvironment original = appEnvironmentPersistence.fetchByPrimaryKey(
			environmentId);

		if (original == null) {
			LOG.info("No AppEnvironment found for id " + environmentId);
			return null;
		}

		if (hasPendingDraft(original.getEntityResourceId())) {
			throw new BadRequestException(
				"This AppEnvironment is currently locked because there is a pending change awaiting approval.");
		}

		try {
			AppEnvironment draft = createAppEnvironment(
				counterLocalService.increment());

			draft.setChannelId(channelId);
			draft.setEntityResourceId(original.getEntityResourceId());
			draft.setVersion(getMaxVersion(original.getEntityResourceId()) + 1);

			User user = resolveUser(serviceContext);

			if (isAppEnvironmentUpdated(original, draft)) {
				prepareForWorkflow(
					draft, serviceContext, user, original.getEnvironmentId(),
					Constants.UPDATE);

				AppEnvironment savedDraft = appEnvironmentPersistence.update(draft);

				startWorkflow(savedDraft, serviceContext, user);
				LOG.info(
					"Draft AppEnvironment created for update of ID " +
						environmentId + " -> draft ID " +
							savedDraft.getEnvironmentId());

				return savedDraft;
			}

			LOG.info("No changes detected for AppEnvironment ID " + environmentId);
			return original;
		}
		catch (Exception exception) {
			LOG.error(
				"Error updating AppEnvironment with id " + environmentId + ": " +
					exception.getMessage());
			return null;
		}
	}

	public void deleteAppEnvironment(
		Long environmentId, ServiceContext serviceContext, User user) {

		try {
			AppEnvironment original = appEnvironmentPersistence.fetchByPrimaryKey(
				environmentId);

			if (original == null) {
				LOG.info("No AppEnvironment found for id " + environmentId);
				return;
			}

			if (hasPendingDraft(original.getEntityResourceId())) {
				throw new BadRequestException(
					"This AppEnvironment is currently locked because there is a pending change awaiting approval.");
			}

			AppEnvironment draft = createAppEnvironment(
				counterLocalService.increment());

			draft.setChannelId(original.getChannelId());
			draft.setEntityResourceId(original.getEntityResourceId());
			draft.setVersion(getMaxVersion(original.getEntityResourceId()) + 1);
			draft.setEnvironmentName(original.getEnvironmentName());

			prepareForWorkflow(
				draft, serviceContext, user, environmentId, Constants.DELETE);

			AppEnvironment savedDraft = appEnvironmentPersistence.update(draft);

			startWorkflow(savedDraft, serviceContext, user);
			LOG.info(
				"Draft AppEnvironment created for delete of ID " +
					environmentId);
		}
		catch (Exception exception) {
			LOG.error(
				"Error deleting AppEnvironment with ID " + environmentId + ": " +
					exception.getMessage());
			throw new RuntimeException(exception);
		}
	}

	public AppEnvironment updateStatus(
			long userId, long environmentId, int status,
			ServiceContext serviceContext)
		throws PortalException {

		AppEnvironment draft = appEnvironmentPersistence.findByPrimaryKey(
			environmentId);
		draft.setStatusDate(new Date());
		draft.setModifiedDate(new Date());
		draft = appEnvironmentPersistence.update(draft);

		if (status == WorkflowConstants.STATUS_APPROVED || status == WorkflowConstants.STATUS_DENIED) {
			draft.setStatusByUserId(userId);
			if (userId > 0) {
				draft.setStatusByUserName(
						UserLocalServiceUtil.getUser(userId).getFullName());
			}
		}

		if (status == WorkflowConstants.STATUS_APPROVED) {
			String workflowAction = draft.getWorkflowAction();

			if (Constants.DELETE.equalsIgnoreCase(workflowAction)) {
				long entityResourceId = draft.getEntityResourceId();
				List<AppEnvironment> entityRecords =
					appEnvironmentPersistence.findByEntityResourceId(entityResourceId);

				for (AppEnvironment entityRecord : entityRecords) {
					appConfigItemPersistence.removeByenvironmentId(
						entityRecord.getEnvironmentId());
				}

				appEnvironmentPersistence.removeByEntityResourceId(entityResourceId);

				return draft;
			}

			if (Constants.UPDATE.equalsIgnoreCase(workflowAction)) {
				draft.setStatus(status);
				appEnvironmentPersistence.update(draft);
				return draft;
			}

			if (Constants.ADD.equalsIgnoreCase(workflowAction)) {
				draft.setStatus(status);
				appEnvironmentPersistence.update(draft);
				return draft;
			}

			return draft;
		}

		if ((status == WorkflowConstants.STATUS_DENIED) ||
			(status == WorkflowConstants.STATUS_EXPIRED)) {

			draft.setStatus(status);
			appEnvironmentPersistence.update(draft);
		}

		return draft;
	}

	public List<AppEnvironment> getLatestApprovedByChannelId(long channelId) {
		DynamicQuery dynamicQuery = dynamicQuery();

		dynamicQuery.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"status", WorkflowConstants.STATUS_APPROVED));

		dynamicQuery.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("version"));

		List<AppEnvironment> allApproved =
			appEnvironmentPersistence.findWithDynamicQuery(dynamicQuery);

		Map<Long, AppEnvironment> latestByResource = new LinkedHashMap<>();

		for (AppEnvironment appEnvironment : allApproved) {
			if (!latestByResource.containsKey(
					appEnvironment.getEntityResourceId())) {

				latestByResource.put(
					appEnvironment.getEntityResourceId(), appEnvironment);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}

	public Map<AppEnvironment, Boolean> getLatestApprovedByChannelIdWithPending(
		long channelId) {

		List<AppEnvironment> latestApproved = getLatestApprovedByChannelId(
			channelId);

		Map<AppEnvironment, Boolean> result = new LinkedHashMap<>();

		for (AppEnvironment appEnvironment : latestApproved) {
			boolean pending = hasPendingDraft(
				appEnvironment.getEntityResourceId());
			result.put(appEnvironment, pending);
		}

		return result;
	}

	private User resolveUser(ServiceContext serviceContext) {
		if ((serviceContext == null) || (serviceContext.getUserId() <= 0)) {
			return null;
		}

		try {
			return UserLocalServiceUtil.getUser(serviceContext.getUserId());
		}
		catch (PortalException portalException) {
			LOG.error("Unable to fetch user for workflow", portalException);
			return null;
		}
	}

	private void prepareForWorkflow(
		AppEnvironment appEnvironment, ServiceContext serviceContext, User user,
		Long originalId, String operationType) {

		if (Constants.ADD.equals(operationType)) {
			appEnvironment.setWorkflowAction("ADD");
		}
		else if (Constants.UPDATE.equals(operationType)) {
			appEnvironment.setWorkflowAction("UPDATE");
		}
		else if (Constants.DELETE.equals(operationType)) {
			appEnvironment.setWorkflowAction("DELETE");
		}
		else {
			appEnvironment.setWorkflowAction("ADD");
		}

		if (serviceContext != null) {
			appEnvironment.setGroupId(serviceContext.getScopeGroupId());
			appEnvironment.setCompanyId(serviceContext.getCompanyId());
			appEnvironment.setUserId(serviceContext.getUserId());
			appEnvironment.setUserName(user != null ? user.getFullName() : "");
			serviceContext.setAttribute(Constants.ENTITY_TYPE, "AppEnvironment");
			serviceContext.setAttribute(
				Constants.USER_NAME, user != null ? user.getFullName() : "");
			serviceContext.setAttribute(
				Constants.REQUEST_ID, appEnvironment.getEnvironmentId());

			if (serviceContext.getScopeGroupId() <= 0) {
				try {
					serviceContext.setScopeGroupId(
						GroupLocalServiceUtil.getCompanyGroup(
							serviceContext.getCompanyId()
						).getGroupId());
				}
				catch (PortalException portalException) {
					LOG.error("Unable to resolve company group", portalException);
				}
			}

			try {
				AssetEntryLocalServiceUtil.updateEntry(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(),
					AppEnvironment.class.getName(),
					appEnvironment.getEnvironmentId(),
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames());
			}
			catch (PortalException portalException) {
				LOG.error("Error updating asset entry", portalException);
			}
		}

		if (appEnvironment.getCreateDate() == null) {
			appEnvironment.setCreateDate(new Date());
		}

		appEnvironment.setModifiedDate(new Date());

		if ((appEnvironment.getUuid_() == null) ||
			appEnvironment.getUuid_().isEmpty()) {

			appEnvironment.setUuid_(PortalUUIDUtil.generate());
		}

		appEnvironment.setOriginalEntityId(originalId);
		appEnvironment.setStatus(WorkflowConstants.STATUS_DRAFT);
		appEnvironment.setStatusDate(new Date());
	}

	private void startWorkflow(
		AppEnvironment appEnvironment, ServiceContext serviceContext,
		User user) {

		if ((serviceContext == null) || (user == null)) {
			return;
		}

		try {
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(), serviceContext.getUserId(),
				AppEnvironment.class.getName(),
				appEnvironment.getEnvironmentId(), appEnvironment,
				serviceContext);
		}
		catch (PortalException portalException) {
			LOG.error(
				"Failed to start workflow for AppEnvironment " +
					appEnvironment.getEnvironmentId(),
				portalException);
		}
	}

	private boolean isAppEnvironmentUpdated(
		AppEnvironment original, AppEnvironment draft) {

		return !Objects.equals(
				original.getChannelId(), draft.getChannelId()) ||
			!Objects.equals(
				original.getEnvironmentName(), draft.getEnvironmentName());
	}

	private int getMaxVersion(long entityResourceId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			AppEnvironment.class, getClassLoader());

		query.add(
			RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		query.setProjection(ProjectionFactoryUtil.max("version"));

		List<Integer> results = AppEnvironmentLocalServiceUtil.dynamicQuery(query);

		if ((results != null) && !results.isEmpty() && (results.get(0) != null)) {
			return results.get(0);
		}

		return 0;
	}

	private boolean hasPendingDraft(long entityResourceId) {
		try {
			List<AppEnvironment> environments =
				appEnvironmentPersistence.findByEntityResourceId(entityResourceId);

			for (AppEnvironment appEnvironment : environments) {
				if (appEnvironment.getStatus() ==
						WorkflowConstants.STATUS_DRAFT) {

					return true;
				}
			}

			return false;
		}
		catch (Exception exception) {
			LOG.error(
				"Unable to evaluate pending drafts for entityResourceId " +
					entityResourceId,
				exception);
			return true;
		}
	}

	public AppEnvironment addAppEnvironment(
		Long channelId, String environmentName, ServiceContext serviceContext,
		User user) {

		AppEnvironment appEnvironment = addAppEnvironment(
			channelId, serviceContext, user, environmentName);

		if (appEnvironment != null) {
			appEnvironment.setEnvironmentName(environmentName);
			appEnvironment = appEnvironmentPersistence.update(appEnvironment);
		}

		return appEnvironment;
	}

	public AppEnvironment updateAppEnvironment(
		Long environmentId, Long channelId, String environmentName,
		ServiceContext serviceContext) {

		AppEnvironment original = appEnvironmentPersistence.fetchByPrimaryKey(
			environmentId);

		if (original == null) {
			LOG.info("No AppEnvironment found for id " + environmentId);
			return null;
		}

		if (hasPendingDraft(original.getEntityResourceId())) {
			throw new BadRequestException(
				"This AppEnvironment is currently locked because there is a pending change awaiting approval.");
		}

		try {
			AppEnvironment draft = createAppEnvironment(
				counterLocalService.increment());

			draft.setChannelId(channelId);
			draft.setEnvironmentName(environmentName);
			draft.setEntityResourceId(original.getEntityResourceId());
			draft.setVersion(getMaxVersion(original.getEntityResourceId()) + 1);

			User user = resolveUser(serviceContext);

			boolean forceDraft =
				(serviceContext != null) &&
					Boolean.TRUE.equals(serviceContext.getAttribute("forceDraft"));

			if (isAppEnvironmentUpdated(original, draft) || forceDraft) {
				prepareForWorkflow(
					draft, serviceContext, user, original.getEnvironmentId(),
					Constants.UPDATE);

				AppEnvironment savedDraft = appEnvironmentPersistence.update(
					draft);

				startWorkflow(savedDraft, serviceContext, user);
				LOG.info(
					"Draft AppEnvironment created for update of ID " +
						environmentId + " -> draft ID " +
							savedDraft.getEnvironmentId());

				return savedDraft;
			}

			LOG.info(
				"No changes detected for AppEnvironment ID " + environmentId);

			return original;
		}
		catch (Exception exception) {
			LOG.error(
				"Error updating AppEnvironment with id " + environmentId +
					": " + exception.getMessage());

			return null;
		}
	}

}
