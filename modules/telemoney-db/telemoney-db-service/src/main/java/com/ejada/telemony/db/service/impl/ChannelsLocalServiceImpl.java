	/**
	 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
	 *
	 * This library is free software; you can redistribute it and/or modify it under
	 * the terms of the GNU Lesser General Public License as published by the Free
	 * Software Foundation; either version 2.1 of the License, or (at your option)
	 * any later version.
	 *
	 * This library is distributed in the hope that it will be useful, but WITHOUT
	 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
	 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
	 * details.
	 */

	package com.ejada.telemony.db.service.impl;

	import com.ejada.telemony.db.constants.Constants;
	import com.ejada.telemony.db.exception.NoSuchChannelsException;
	import com.ejada.telemony.db.model.Channels;
	import com.ejada.telemony.db.model.Persona;
	import com.ejada.telemony.db.service.ChannelsLocalServiceUtil;
	import com.ejada.telemony.db.service.base.ChannelsLocalServiceBaseImpl;
	import com.liferay.asset.kernel.service.AssetEntryLocalService;
	import com.liferay.portal.kernel.exception.PortalException;
	import com.liferay.portal.kernel.exception.SystemException;
	import com.liferay.portal.kernel.log.Log;
	import com.liferay.portal.kernel.log.LogFactoryUtil;
	import com.liferay.portal.kernel.model.User;
	import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
	import com.liferay.portal.kernel.service.ServiceContext;
	import com.liferay.portal.kernel.service.UserLocalServiceUtil;
	import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
	import com.liferay.portal.kernel.workflow.WorkflowConstants;
	import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
	import com.liferay.asset.kernel.model.AssetEntry;
	import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
	import com.liferay.portal.kernel.util.ContentTypes;
	import org.osgi.service.component.annotations.Reference;

	import java.util.UUID;

	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.Date;
	import java.util.List;

	import javax.ws.rs.NotFoundException;

	/**
	 * The implementation of the channels local service.
	 *
	 * <p>
	 * All custom service methods should be put in this class. Whenever methods are
	 * added, rerun ServiceBuilder to copy their definitions into the
	 * <code>com.ejada.telemony.db.service.ChannelsLocalService</code> interface.
	 *
	 * <p>
	 * This is a local service. Methods of this service will not have security
	 * checks based on the propagated JAAS credentials because this service can only
	 * be accessed from within the same VM.
	 * </p>
	 *
	 * @author Brian Wing Shun Chan
	 * @see ChannelsLocalServiceBaseImpl
	 */
	public class ChannelsLocalServiceImpl extends ChannelsLocalServiceBaseImpl{

		/*
		 * NOTE FOR DEVELOPERS:
		 *
		 * Never reference this class directly. Use
		 * <code>com.ejada.telemony.db.service.ChannelsLocalService</code> via injection
		 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
		 * <code>com.ejada.telemony.db.service.ChannelsLocalServiceUtil</code>.
		 */
		private static final Log LOG = LogFactoryUtil.getLog(ChannelsLocalServiceImpl.class);

		public Channels add(String name, String desc, String type, ServiceContext serviceContext, User user) throws Exception {
			try {
				if (checkChannelName(name))
					throw new Exception("The channel name already exists");
				Channels newChannel = ChannelsLocalServiceUtil.createChannels(counterLocalService.increment());
				newChannel.setName(name);
				newChannel.setDescription(desc);
				newChannel.setType(type);


				newChannel = ChannelsLocalServiceUtil.updateChannels(newChannel);
				startWorkflow(newChannel, serviceContext, user, Constants.CREATE);

				return newChannel;
			} catch (Exception e) {
				LOG.info("----------------Channel Failed-----------------");
				LOG.error(e);
				throw new Exception(e.getMessage());
			}
		}
		public Channels updateStatus(long userId, long channelId, int status,
									 ServiceContext serviceContext) throws Exception {
			Channels channel = channelsPersistence.findByPrimaryKey(channelId);
			channel.setStatus(status);
			channel.setModifiedDate(new Date());
			channel.setStatusByUserId(userId);
			if (serviceContext != null && userId > 0) {
				channel.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
			}
			channel.setStatusDate(new Date());

			channelsPersistence.update(channel);
			if (status == WorkflowConstants.STATUS_APPROVED) {
				if (serviceContext.getAttribute((Constants.OPERATION_TYPE)).equals(Constants.CREATE)) {
					LOG.info("---------------- Add Default Light Theme -----------------");
					themesLocalService.addDefaultLightTheme(channel.getChannelId());


					LOG.info("---------------- Add Default Dark Theme -----------------");
					themesLocalService.addDefaultDarkTheme(channel.getChannelId());

					LOG.info("---------------- Add Default Language (English) -----------------");
					languagesLocalService.addDefaultLanguage(channel.getChannelId());

					LOG.info("---------------- Add Default Persona  -----------------");
					personaLocalService.addDefualtPersona(channel.getChannelId());
				}
				LOG.info("Channel approved: " + channel.getName());
			}
			else if (status == WorkflowConstants.STATUS_PENDING) {
				LOG.info("Channel pending: " + channel.getName());
			}
			else {
			channelsPersistence.remove(channel);
			LOG.info("Channel rejected: " + channel.getName());
			}

		return channel;
		}

		public List<Channels> findAll() {
			return channelsPersistence.findAll();
		}
		public List<Channels> findByStatus(int status) {
			return channelsPersistence.findByStatus(status);
		}

		public boolean ifExist(long channelId) {
			Channels foundChannel;
			try {
				foundChannel = channelsPersistence.findByPrimaryKey(channelId);
				if (foundChannel != null)
					return true;
			} catch (NoSuchChannelsException e) {
				e.printStackTrace();
			}
			return false;

		}

		public Channels findOne(long channelId) {
			Channels foundChannel;
			try {
				foundChannel = channelsPersistence.findByPrimaryKey(channelId);
				if (foundChannel != null)
					return foundChannel;
			} catch (NoSuchChannelsException e) {
				e.printStackTrace();
			}
			throw new NotFoundException();

		}

		public boolean checkChannelName(String channelName) {
			List<Channels> result = findByNameAndStatus(channelName);
			if (result.size() > 0)
				return true;
			return false;
		}

		public Channels getByName(String channelName) {
			List<Channels> result = findByNameAndStatus(channelName);
			if (result != null && !result.isEmpty()) {
				return result.get(0);
			}
			return null;
		}

		private void startWorkflow(Channels channel, ServiceContext serviceContext, User user, String type) throws PortalException {


			serviceContext.setAttribute("entityType", "Channel");
			serviceContext.setAttribute("userName", user.getFullName());
			serviceContext.setAttribute("requestId", channel.getChannelId());
			serviceContext.setAttribute(Constants.OPERATION_TYPE, type);


			channel.setStatus(WorkflowConstants.STATUS_DRAFT);
			channel.setGroupId(serviceContext.getScopeGroupId());
			channel.setCompanyId(serviceContext.getCompanyId());
			channel.setUserId(serviceContext.getUserId());
			channel.setUserName(user.getFullName());
			channel.setCreateDate(new Date());
			channel.setModifiedDate(new Date());
			channel.setUuid_(PortalUUIDUtil.generate());

			if (serviceContext.getScopeGroupId() <= 0) {
				serviceContext.setScopeGroupId(
						GroupLocalServiceUtil.getCompanyGroup(
								serviceContext.getCompanyId()
						).getGroupId()
				);
			}
			AssetEntryLocalServiceUtil.updateEntry(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(),
					Channels.class.getName(),
					channel.getChannelId(),
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames()
			);

			serviceContext.setAssetCategoryIds(null);
			serviceContext.setAssetTagNames(null);

			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					serviceContext.getCompanyId(),
					serviceContext.getScopeGroupId(),
					serviceContext.getUserId(),
					Channels.class.getName(),
					channel.getPrimaryKey(),
					channel,
					serviceContext
			);

		}
		private List<Channels> findByNameAndStatus(String channelName) {
			// retrieve all status except denied
			return channelsPersistence.findByNameAndStatus(channelName, WorkflowConstants.STATUS_DENIED);
		}
	}