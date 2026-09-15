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

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemoney.db.dto.BlockDTO;
import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.mapper.FeatureMapper;
import com.ejada.telemony.db.mapper.SegmentMapper;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.BlocksLocalServiceUtil;
import com.ejada.telemony.db.service.FeatureLocalServiceUtil;
import com.ejada.telemony.db.service.GlobalVersionLocalServiceUtil;
import com.ejada.telemony.db.service.SegmentLocalServiceUtil;
import com.ejada.telemony.db.service.base.FeatureLocalServiceBaseImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.*;

/**
 * The implementation of the feature local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.FeatureLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLocalServiceBaseImpl
 */
public class FeatureLocalServiceImpl extends FeatureLocalServiceBaseImpl {

	private static final Log LOG = LogFactoryUtil.getLog(FeatureLocalServiceImpl.class);

	private boolean isBlueAppChannel(long channelId) {
		try {
			Channels channel = channelsLocalService.getChannels(channelId);
			return channel != null && "Blue App".equalsIgnoreCase(channel.getName());
		} catch (PortalException e) {
			LOG.warn("Unable to resolve channel for BlueApp check. ChannelId: " + channelId, e);
			return false;
		}
	}

	public void addFeature(
			String featureName,
			String pageType,
			long parentPage,
			String routeId,
			Boolean status,
			long blockId,
			long channelId, List<String> whitelistLovData, List<String> segmentsLovData,User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {

		boolean isBlueApp = isBlueAppChannel(channelId);

		Feature newFeature = this.featurePersistence.create(counterLocalService.increment());
		newFeature.setFeatureName(featureName);
		newFeature.setFeatureStatus(status);
		newFeature.setChannelId(channelId);

		if (isBlueApp) {
			// Blue App features are always parent, no block, no routeId, no default segments
			newFeature.setPageType("0");
			newFeature.setParentPage(0);
			newFeature.setRouteId(null);
			newFeature.setBlockId(0);
			newFeature.setEntityResourceId(newFeature.getFeatureId());
			newFeature.setChildResourceId(0L);
		} else {
			newFeature.setPageType(pageType);
			newFeature.setParentPage(parentPage);
			newFeature.setRouteId(routeId);
			newFeature.setBlockId(blockId);
			if (pageType.equals("0")) {
				newFeature.setEntityResourceId(newFeature.getFeatureId());
				newFeature.setChildResourceId(0L);
			} else {
				Feature parentFeature = FeatureLocalServiceUtil.fetchFeature(parentPage);
				newFeature.setEntityResourceId(parentFeature.getEntityResourceId());
				newFeature.setChildResourceId(newFeature.getFeatureId());
			}
		}
		newFeature.setVersion(1);
		newFeature.setWorkflowAction(Constants.ADD_FEATURE);

		this.featurePersistence.update(newFeature);


		if ((whitelistLovData != null && !whitelistLovData.isEmpty())  || (segmentsLovData != null && !segmentsLovData.isEmpty()))
		{
			long whitelistLovEntityResourceId = 0;
			long segmentsLovEntityResourceId = 0;

			if (whitelistLovData != null && !whitelistLovData.isEmpty()) {
				List<Lovs> whitelistLovs = lovsLocalService.getLatestApprovedByChannelIdAndCode(channelId, TelemoneyConstants.WHITELIST_CODE);
				if (!whitelistLovs.isEmpty()) {
					whitelistLovEntityResourceId = whitelistLovs.get(0).getEntityResourceId();
				}
			}
			if (segmentsLovData != null && !segmentsLovData.isEmpty()) {
				List<Lovs> segmentsLovs = lovsLocalService.getLatestApprovedByChannelIdAndCode(channelId, TelemoneyConstants.SEGMENTS_CODE);
				if (!segmentsLovs.isEmpty()) {
					segmentsLovEntityResourceId = segmentsLovs.get(0).getEntityResourceId();
				}
			}

			for (String dataCode : whitelistLovData) {
				FeatureLovMap featureLovMap = this.featureLovMapPersistence.create(counterLocalService.increment());
				featureLovMap.setFeatureId(newFeature.getFeatureId());
				featureLovMap.setFeatureEntityResourceId(newFeature.getEntityResourceId());
				featureLovMap.setLovEntityResourceId(whitelistLovEntityResourceId);
				featureLovMap.setLovDataCode(dataCode);
				featureLovMap.setLovType(TelemoneyConstants.WHITELIST_CODE);
				this.featureLovMapPersistence.update(featureLovMap);
			}

			for (String dataCode : segmentsLovData) {
				FeatureLovMap featureLovMap = this.featureLovMapPersistence.create(counterLocalService.increment());
				featureLovMap.setFeatureId(newFeature.getFeatureId());
				featureLovMap.setFeatureEntityResourceId(newFeature.getEntityResourceId());
				featureLovMap.setLovEntityResourceId(segmentsLovEntityResourceId);
				featureLovMap.setLovDataCode(dataCode);
				featureLovMap.setLovType(TelemoneyConstants.SEGMENTS_CODE);
				this.featureLovMapPersistence.update(featureLovMap);
			}
		} else if (!isBlueApp) {
			for (String segmentName : TelemoneyConstants.SEGMENT_NAMES) {
				Segment createdSegment = this.segmentPersistence.create(counterLocalService.increment());
				createdSegment.setFeatureId(newFeature.getFeatureId());
				createdSegment.setName(segmentName);
				createdSegment.setSegmentStatus(true);
				createdSegment.setMethod("1");
				if (newFeature.getPageType().equals("0")) {
					createdSegment.setChildResourceId(0L);
				} else {
					createdSegment.setChildResourceId(newFeature.getChildResourceId());
				}
				createdSegment.setEntityResourceId(newFeature.getEntityResourceId());
				createdSegment.setStatus(WorkflowConstants.STATUS_DRAFT);
				createdSegment.setOriginalEntityId(0L);
				this.segmentPersistence.update(createdSegment);
			}
		}
		startWorkflow(newFeature, serviceContext, user, 0L, Constants.CREATE, Constants.FEATURE);
	}

	public void updateFeature(
			String featureName,
			String pageType,
			long parentPage,
			String routeId,
			Boolean status,
			Long channelId, BlockDTO blockDTO,
			List<String> whitelistLovData, List<String> segmentsLovData,
			Feature originalFeature, User user, ServiceContext serviceContext) throws PortalException, JsonProcessingException {

		boolean isBlueApp = isBlueAppChannel(channelId);

		Feature draftFeature = this.featurePersistence.create(counterLocalService.increment());
		draftFeature.setFeatureName(featureName);
		draftFeature.setFeatureStatus(status);
		draftFeature.setChannelId(channelId);
		draftFeature.setWorkflowAction(Constants.UPDATE_FEATURE);

		if (isBlueApp) {
			// Blue App features are always parent, no block, no routeId
			draftFeature.setPageType("0");
			draftFeature.setParentPage(0);
			draftFeature.setRouteId(null);
			draftFeature.setBlockId(0);
			draftFeature.setEntityResourceId(originalFeature.getEntityResourceId());
			draftFeature.setChildResourceId(0L);
			int nextVersion = getMaxVersionForParent(originalFeature.getEntityResourceId()) + 1;
			draftFeature.setVersion(nextVersion);

			featurePersistence.update(draftFeature);
		} else {
			Blocks originalBlock = null;
			try {
				originalBlock = blocksLocalService.getBlocks(originalFeature.getBlockId());
			} catch (Exception e) {
				LOG.info("Original feature has no block or error fetching block");
			}
			draftFeature.setPageType(pageType);
			draftFeature.setParentPage(parentPage);

			int nextVersion = (draftFeature.getPageType().equals("0"))
					? getMaxVersionForParent(originalFeature.getEntityResourceId()) + 1
					: getMaxVersionForChild(originalFeature.getChildResourceId()) + 1;

			draftFeature.setVersion(nextVersion);


			Feature parentFeature = FeatureLocalServiceUtil.fetchFeature(parentPage);

			featurePersistence.update(draftFeature);
			if (!Objects.equals(draftFeature.getPageType(), originalFeature.getPageType())) {
				applyPageTypeChange(draftFeature, originalFeature, parentFeature);
			} else if (Objects.nonNull(parentFeature) && !Objects.equals(parentFeature.getEntityResourceId(), originalFeature.getEntityResourceId())) {
				draftFeature.setEntityResourceId(parentFeature.getEntityResourceId());
				draftFeature.setChildResourceId(draftFeature.getFeatureId());
				draftFeature.setVersion(1);
				segmentCreationOnPageChange(originalFeature, draftFeature, parentFeature);
			} else {
				if (draftFeature.getPageType().equals("0")) {
					draftFeature.setEntityResourceId(originalFeature.getEntityResourceId());
					draftFeature.setChildResourceId(0L);
				} else {
					draftFeature.setEntityResourceId(originalFeature.getEntityResourceId());
					draftFeature.setChildResourceId(originalFeature.getChildResourceId());
				}

			}
			draftFeature.setRouteId(routeId);
			if (checkBlockChange(blockDTO, originalBlock)) {
				draftFeature.setBlockId(createBlockEntity(blockDTO).getBlockId());
			} else {
				draftFeature.setBlockId(originalFeature.getBlockId());
			}
			if (originalFeature.getPageType().contains("0") && originalFeature.getFeatureStatus()
					&& !draftFeature.getFeatureStatus()) {
				turnOffChildrenFeatures(draftFeature.getEntityResourceId(), draftFeature.getFeatureId());
			}
		}

		if ((whitelistLovData != null && !whitelistLovData.isEmpty()) || (segmentsLovData != null && !segmentsLovData.isEmpty()))
		{
			long whitelistLovEntityResourceId = 0;
			long segmentsLovEntityResourceId = 0;

			if (whitelistLovData != null && !whitelistLovData.isEmpty()) {
				List<Lovs> whitelistLovs = lovsLocalService.getLatestApprovedByChannelIdAndCode(channelId, TelemoneyConstants.WHITELIST_CODE);
				if (!whitelistLovs.isEmpty()) {
					whitelistLovEntityResourceId = whitelistLovs.get(0).getEntityResourceId();
				}
			}
			if (segmentsLovData != null && !segmentsLovData.isEmpty()) {
				List<Lovs> segmentsLovs = lovsLocalService.getLatestApprovedByChannelIdAndCode(channelId, TelemoneyConstants.SEGMENTS_CODE);
				if (!segmentsLovs.isEmpty()) {
					segmentsLovEntityResourceId = segmentsLovs.get(0).getEntityResourceId();
				}
			}

			if (whitelistLovData != null) {
				for (String dataCode : whitelistLovData) {
					FeatureLovMap featureLovMap = this.featureLovMapPersistence.create(counterLocalService.increment());
					featureLovMap.setFeatureId(draftFeature.getFeatureId());
					featureLovMap.setFeatureEntityResourceId(draftFeature.getEntityResourceId());
					featureLovMap.setLovEntityResourceId(whitelistLovEntityResourceId);
					featureLovMap.setLovDataCode(dataCode);
					featureLovMap.setLovType(TelemoneyConstants.WHITELIST_CODE);
					this.featureLovMapPersistence.update(featureLovMap);
				}
			}

			if (segmentsLovData != null) {
				for (String dataCode : segmentsLovData) {
					FeatureLovMap featureLovMap = this.featureLovMapPersistence.create(counterLocalService.increment());
					featureLovMap.setFeatureId(draftFeature.getFeatureId());
					featureLovMap.setFeatureEntityResourceId(draftFeature.getEntityResourceId());
					featureLovMap.setLovEntityResourceId(segmentsLovEntityResourceId);
					featureLovMap.setLovDataCode(dataCode);
					featureLovMap.setLovType(TelemoneyConstants.SEGMENTS_CODE);
					this.featureLovMapPersistence.update(featureLovMap);
				}
			}
		}

		startWorkflow(draftFeature, serviceContext, user, originalFeature.getFeatureId(), Constants.UPDATE, Constants.FEATURE);

	}
	private boolean checkBlockChange(BlockDTO blockDTO, Blocks originalBlock) {
		if (blockDTO == null && originalBlock == null) {
			return false;
		}
		if (blockDTO == null && originalBlock != null) {
			return true;
		}
		if (blockDTO != null && originalBlock == null) {
			boolean hasAnyBlockEnabled = blockDTO.isAndroidBlock() ||
										 blockDTO.isIosBlock() ||
										 blockDTO.isWebBlock();
			if (!hasAnyBlockEnabled) {
				LOG.info("BlockDTO provided but all platforms are disabled - considering no block change");
				return false;
			}
			LOG.info("Adding new block with enabled platforms - block change detected");
			return true;
		}
		boolean hasChanges = !Objects.equals(blockDTO.getType(), originalBlock.getType()) ||
							!Objects.equals(blockDTO.isAndroidBlock(), originalBlock.getAndroidBlock()) ||
							!Objects.equals(blockDTO.getAndroidBlockVersion(), originalBlock.getAndroidBlockVersion()) ||
							!Objects.equals(blockDTO.getAndroidBlockFrom(), originalBlock.getAndroidBlockFrom()) ||
							!Objects.equals(blockDTO.getAndroidBlockTo(), originalBlock.getAndroidBlockTo()) ||
							!Objects.equals(blockDTO.isIosBlock(), originalBlock.getIosBlock()) ||
							!Objects.equals(blockDTO.getIosBlockVersion(), originalBlock.getIosBlockVersion()) ||
							!Objects.equals(blockDTO.getIosBlockFrom(), originalBlock.getIosBlockFrom()) ||
							!Objects.equals(blockDTO.getIosBlockTo(), originalBlock.getIosBlockTo()) ||
							!Objects.equals(blockDTO.isWebBlock(), originalBlock.getWebBlock()) ||
							!Objects.equals(blockDTO.getWebBlockVersion(), originalBlock.getWebBlockVersion()) ||
							!Objects.equals(blockDTO.getWebBlockFrom(), originalBlock.getWebBlockFrom()) ||
							!Objects.equals(blockDTO.getWebBlockTo(), originalBlock.getWebBlockTo());
		if (hasChanges) {
			LOG.info("Block changes detected in existing block");
		} else {
			LOG.info("No block changes detected");
		}
		return hasChanges;
	}

	private void applyPageTypeChange(
			Feature draftFeature,
			Feature originalFeature, Feature parentFeature) {

		if (draftFeature.getPageType().equals("0")) {
			draftFeature.setEntityResourceId(draftFeature.getFeatureId());
			draftFeature.setChildResourceId(0L);
			draftFeature.setParentPage(0L);

		} else {
			draftFeature.setEntityResourceId(parentFeature.getEntityResourceId());
			draftFeature.setChildResourceId(draftFeature.getFeatureId());
		}
		draftFeature.setVersion(1);

		// Persist the draftFeature BEFORE creating segments to satisfy foreign key constraint
		this.featurePersistence.update(draftFeature);
		segmentCreationOnTypeChange(originalFeature, draftFeature, parentFeature);


	}

	private void segmentCreationOnTypeChange(Feature originalFeature, Feature draftFeature, Feature parentFeature)
	{
		List<Segment> segmentsList = segmentLocalService.findFeatureSegments(originalFeature.getFeatureId());
		for (Segment segment : segmentsList) {
			Segment draftSegment = segmentPersistence.create(counterLocalService.increment());
			draftSegment.setFeatureId(draftFeature.getFeatureId());
			SegmentMapper.copyDraftToOriginal(segment, draftSegment);
			draftSegment.setOriginalEntityId(segment.getSegmentId());
			if (draftFeature.getPageType().equals("0")) {
				draftSegment.setEntityResourceId(draftFeature.getFeatureId());
				draftSegment.setChildResourceId(0L);
			} else {
				draftSegment.setChildResourceId(draftFeature.getFeatureId());
				draftSegment.setEntityResourceId(parentFeature.getEntityResourceId());
			}
			draftSegment.setStatus(WorkflowConstants.STATUS_DRAFT);
			segmentPersistence.update(draftSegment);
		}

	}
	private void segmentCreationOnPageChange(Feature originalFeature, Feature draftFeature, Feature parentFeature)
	{
		List<Segment> segmentsList = segmentLocalService.findFeatureSegments(originalFeature.getFeatureId());
		for (Segment segment : segmentsList) {
			Segment draftSegment = segmentPersistence.create(counterLocalService.increment());
			draftSegment.setFeatureId(draftFeature.getFeatureId());
			SegmentMapper.copyDraftToOriginal(segment, draftSegment);
			draftSegment.setOriginalEntityId(segment.getSegmentId());
			draftSegment.setChildResourceId(draftFeature.getFeatureId());
			draftSegment.setEntityResourceId(parentFeature.getEntityResourceId());
			draftSegment.setStatus(WorkflowConstants.STATUS_DRAFT);
			segmentPersistence.update(draftSegment);
		}

	}

	public void updateSegment(long segmentId,
							  String name,
							  Boolean status,
							  String method,
							  String popUpTitle,
							  String popUpSubTitle,
							  ServiceContext serviceContext,
							  User user) throws PortalException, JsonProcessingException {
		Segment originalSegment = SegmentLocalServiceUtil.fetchSegment(segmentId);
		originalSegment.getEntityResourceId();
		Feature originalFeature = getFeatureFromSegment(originalSegment);
		Feature draftFeature = this.featurePersistence.create(counterLocalService.increment());
		if (originalFeature != null) {
			FeatureMapper.copyDraftToOriginal(originalFeature, draftFeature);
			draftFeature.setEntityResourceId(originalFeature.getEntityResourceId());
			draftFeature.setChildResourceId(originalFeature.getChildResourceId());
			if (draftFeature.getPageType().equals("0")) {
				draftFeature.setVersion(getMaxVersionForParent(originalSegment.getEntityResourceId()) + 1);
			} else {
				draftFeature.setVersion(getMaxVersionForChild(draftFeature.getChildResourceId()) + 1);
			}
			draftFeature.setWorkflowAction(Constants.UPDATE_SEGMENT);

			this.featurePersistence.update(draftFeature);

			Segment draftSegment = segmentLocalService.addSegment(draftFeature.getFeatureId(), name, status, method, popUpTitle, popUpSubTitle);
			draftSegment.setEntityResourceId(originalSegment.getEntityResourceId());
			draftSegment.setChildResourceId(originalSegment.getChildResourceId());
			draftSegment.setOriginalEntityId(segmentId);
			draftSegment.setStatus(WorkflowConstants.STATUS_DRAFT);
			segmentPersistence.update(draftSegment);
			serviceContext.setAttribute("segmentId", String.valueOf(draftSegment.getSegmentId()));

			startWorkflow(draftFeature, serviceContext, user, originalFeature.getFeatureId(), Constants.UPDATE, Constants.SEGMENT);
		}

	}


	private Feature getFeatureFromSegment(Segment segment) {

		DynamicQuery dq =
				DynamicQueryFactoryUtil.forClass(Feature.class, getClassLoader());

		dq.add(PropertyFactoryUtil.forName("entityResourceId")
				.eq(segment.getEntityResourceId()));

		dq.add(PropertyFactoryUtil.forName("status")
				.eq(WorkflowConstants.STATUS_APPROVED));

		long childResourceId = segment.getChildResourceId();

		if (childResourceId > 0) {
			dq.add(PropertyFactoryUtil.forName("childResourceId").eq(childResourceId));
		} else {
			dq.add(PropertyFactoryUtil.forName("childResourceId").eq(0L));
		}

		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Feature> features =
				FeatureLocalServiceUtil.dynamicQuery(dq, 0, 1);

		return features.isEmpty() ? null : features.get(0);
	}

	public void handleDeleteFeature(Feature originalFeature, ServiceContext serviceContext, User user) throws Exception {
		Feature draftFeature = this.featurePersistence.create(counterLocalService.increment());
		FeatureMapper.copyDraftToOriginal(originalFeature, draftFeature);
		draftFeature.setVersion(originalFeature.getVersion() + 1);
		draftFeature.setWorkflowAction(Constants.DELETE_FEATURE);
		draftFeature.setChildResourceId(originalFeature.getChildResourceId());
		draftFeature.setEntityResourceId(originalFeature.getEntityResourceId());
		startWorkflow(draftFeature, serviceContext, user, originalFeature.getFeatureId(), Constants.DELETE, Constants.FEATURE);
	}


	public void deleteFeatureWithItsSegments(long featureId, User user) throws Exception {
		try {

			Feature foundFeature = FeatureLocalServiceUtil.fetchFeature(featureId);
			boolean isBlueApp = isBlueAppChannel(foundFeature.getChannelId());
			List<Segment> linkedSegments;
			if (foundFeature.getPageType().equals("0")){
			 linkedSegments = segmentPersistence.findByEntityResourceId(foundFeature.getEntityResourceId());
			}
			else {
				linkedSegments = segmentPersistence.findBychildResourceId(foundFeature.getChildResourceId());
			}
			LOG.info("Deleting feature ID: " + featureId + " along with " + linkedSegments.size() + " linked segments");
			for (Segment s : linkedSegments) {
				segmentPersistence.remove(s);
			}
			List<Feature> linkedFeature;
			if (foundFeature.getPageType().equals("0")) {
				linkedFeature = featurePersistence.findByEntityResourceId(foundFeature.getEntityResourceId());
			} else {
				linkedFeature = featurePersistence.findByChildResourceId(foundFeature.getChildResourceId());
			}
			for (Feature f : linkedFeature) {
				Blocks foundBlock = blocksLocalService.fetchBlocks(f.getBlockId());
				if (foundBlock != null)
					blocksLocalService.deleteBlocks(foundBlock.getBlockId());
				featurePersistence.remove(f);
			}
			if (isBlueApp) {
				featureLovMapPersistence.removeByFeatureEntityResourceId(foundFeature.getEntityResourceId());
				LOG.info("Deleted FeatureLovMap entries for Blue App feature entityResourceId: " + foundFeature.getEntityResourceId());
			}
			LOG.info("Successfully deleted feature ID: " + featureId + " and its linked segments and blocks");
		} catch (Exception e) {
			LOG.info("----------------Coudn't delete the feature-----------------" + featureId);
			LOG.error(e);
			throw new Exception(e);
		}

	}


	public void delete(long featureId) throws Exception {
		try {
			Feature foundFeature = FeatureLocalServiceUtil.fetchFeature(featureId);
			if (foundFeature != null)
				featurePersistence.remove(featureId);

		} catch (Exception e) {
			LOG.info("----------------Coudn't delete the feature-----------------");
			LOG.error(e);
			throw new Exception(e);
		}

	}


	public Boolean checkIfParentHaveChildren(long entityResourceId) {

		List<Feature> features = getAllChildrenFeatures(entityResourceId, WorkflowConstants.STATUS_APPROVED);
		return !features.isEmpty();
	}

	public JSONArray getAllFeaturesForSegment(
			long channelId,
			String segmentName,
			String deviceType,
			String deviceVersion) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			DynamicQuery featureQuery = DynamicQueryFactoryUtil.forClass(Feature.class, "f", getClassLoader());
			featureQuery.add(RestrictionsFactoryUtil.eq("f.channelId", channelId));
			List<Feature> onFeatures = FeatureLocalServiceUtil.dynamicQuery(featureQuery);
			List<Feature> disabledFeatureList = new ArrayList<Feature>();
			List<Feature> enabledFeatureList = new ArrayList<Feature>();
			LOG.info("From API device type " + deviceType);
			LOG.info("From API deviceVersion " + deviceVersion);
			LOG.info("From API segmentName " + segmentName);
			if (onFeatures != null && !onFeatures.isEmpty()) {
				List<Long> onFeatureIds = new ArrayList<Long>();
				List<Long> onFeatureBlockIds = new ArrayList<Long>();
				for (Feature feature : onFeatures) {
					if (feature != null && feature.getFeatureStatus() != null && feature.getFeatureStatus() == false) {
						disabledFeatureList.add(feature);
						DynamicQuery segmenetQuery = DynamicQueryFactoryUtil.forClass(Segment.class, "s", getClassLoader());
						segmenetQuery.add(PropertyFactoryUtil.forName("s.featureId").eq(feature.getFeatureId()));
						List<Segment> desiredSegments = SegmentLocalServiceUtil.dynamicQuery(segmenetQuery);
						Segment s = desiredSegments != null ? desiredSegments.get(0) : null;
						JSONObject dataObject = JSONFactoryUtil.createJSONObject();
						dataObject.put("routeId", feature.getRouteId());
						dataObject.put("blockMethod", TelemoneyConstants.DEFAULT_OFF_FEATURE_METHOD);
						dataObject.put("popUpTitle", s != null ? s.getPopUpTitle() : "");
						dataObject.put("popUpSubTitle", s != null ? s.getPopUpSubTitle() : "");
						jsonArray.put(dataObject);
					} else if (feature != null && feature.getFeatureStatus() != null && feature.getFeatureStatus() == true) {
						enabledFeatureList.add(feature);
						onFeatureIds.add(feature.getFeatureId());
						if (feature.getBlockId() != 0)
							onFeatureBlockIds.add(feature.getBlockId());
					}
				}


				DynamicQuery blockQuery = DynamicQueryFactoryUtil.forClass(Blocks.class, "b", getClassLoader());
				blockQuery.add(PropertyFactoryUtil.forName("b.blockId").in(onFeatureBlockIds));
				if (deviceType.toLowerCase().contains("ios")) {
					blockQuery.add(RestrictionsFactoryUtil.eq("b.iosBlock", true));
					RestrictionsFactoryUtil.eq("b.iosBlockVersion", deviceVersion);
				} else if (deviceType.toLowerCase().contains("android")) {
					blockQuery.add(RestrictionsFactoryUtil.eq("b.androidBlock", true));
					RestrictionsFactoryUtil.eq("b.androidBlockVersion", deviceVersion);
				} else if (deviceType.toLowerCase().contains("web")) {
					blockQuery.add(RestrictionsFactoryUtil.eq("b.webBlock", true));
					RestrictionsFactoryUtil.eq("b.webBlockVersion", deviceVersion);
				}
				List<Blocks> blocks = BlocksLocalServiceUtil.dynamicQuery(blockQuery);

				for (Feature f : enabledFeatureList) {
					for (Blocks block : blocks)
						if (f.getBlockId() == block.getBlockId()) {
							disabledFeatureList.add(f);
							JSONObject dataObject = JSONFactoryUtil.createJSONObject();
							dataObject.put("routeId", f.getRouteId());
							dataObject.put("blockMethod", block.getType());
							dataObject.put("popUpTitle", "");
							dataObject.put("popUpSubTitle", "");
							jsonArray.put(dataObject);
						}
				}
				DynamicQuery segmenetQuery = DynamicQueryFactoryUtil.forClass(Segment.class, "s", getClassLoader());
				segmenetQuery.add(PropertyFactoryUtil.forName("s.featureId").in(onFeatureIds));
				segmenetQuery.add(RestrictionsFactoryUtil.eq("s.name", segmentName));
				segmenetQuery.add(RestrictionsFactoryUtil.eq("s.segmentStatus", false));
				List<Segment> disabledSegments = SegmentLocalServiceUtil.dynamicQuery(segmenetQuery);

				for (Feature f : enabledFeatureList)
					for (Segment s : disabledSegments)
						if (f.getFeatureId() == s.getFeatureId()) {
							disabledFeatureList.add(f);
							JSONObject dataObject = JSONFactoryUtil.createJSONObject();
							dataObject.put("routeId", f.getRouteId());
							dataObject.put("blockMethod", s.getMethod());
							dataObject.put("popUpTitle", s.getPopUpTitle());
							dataObject.put("popUpSubTitle", s.getPopUpSubTitle());
							jsonArray.put(dataObject);
						}
			}

		} catch (Exception e) {
			System.out.println("------ERROR WITH THE 'Feature Toggling' QUERY------");
			e.printStackTrace();
		}
		return jsonArray;
	}

	public List<Feature> getAllParentPages(Long channelId) {

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Feature.class, getClassLoader());

		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("pageType", "0"));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Feature> allApprovedParents =
				FeatureLocalServiceUtil.dynamicQuery(dq);


		Map<Long, Feature> latestByEntityResourceId = new LinkedHashMap<>();

		for (Feature feature : allApprovedParents) {
			long entityResId = feature.getEntityResourceId();
			if (!latestByEntityResourceId.containsKey(entityResId)) {
				latestByEntityResourceId.put(entityResId, feature);
			}
		}


		return new ArrayList<>(latestByEntityResourceId.values());
	}


	public void turnOffChildrenFeatures(long entityResourceId,long draftFeatureId) {

		List<Feature> childFeatures = getAllChildrenFeatures(entityResourceId, WorkflowConstants.STATUS_APPROVED);

		for (Feature f : childFeatures) {
			Feature draftChild = featurePersistence.create(counterLocalService.increment());
			FeatureMapper.copyDraftToOriginal(f, draftChild);
			draftChild.setParentPage(draftFeatureId);
			draftChild.setFeatureStatus(false);
			draftChild.setStatus(WorkflowConstants.STATUS_DRAFT);
			draftChild.setVersion(getMaxVersionForChild(f.getChildResourceId()) + 1);
			draftChild.setOriginalEntityId(f.getFeatureId());
			draftChild.setEntityResourceId(f.getEntityResourceId());
			draftChild.setChildResourceId(f.getChildResourceId());
			draftChild.setWorkflowAction(Constants.UPDATE_FEATURE);
			featurePersistence.update(draftChild);
		}
	}

	public List<Feature> getAllChildrenFeatures(long entityResourceId,int status) {

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Feature.class, getClassLoader());

		dq.add(RestrictionsFactoryUtil.eq("pageType", "1"));
		dq.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		dq.add(RestrictionsFactoryUtil.eq("status", status));

		dq.addOrder(OrderFactoryUtil.asc("childResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Feature> allMatchingChildren =
				FeatureLocalServiceUtil.dynamicQuery(dq);

		Map<Long, Feature> latestByChildResourceId = new LinkedHashMap<>();

		for (Feature feature : allMatchingChildren) {
			long childResId = feature.getChildResourceId();
			if (!latestByChildResourceId.containsKey(childResId)) {
				latestByChildResourceId.put(childResId, feature);
			}
		}

		return new ArrayList<>(latestByChildResourceId.values());
	}


	public boolean isLinkedToLocalization(Long featureId, Long channelId) {
		List<Languages> records = languagesLocalService.getbyChannelId(channelId);
		for (Languages record : records) {
			long maxApprovedVersion = localizationLocalService.getMaxApprovedVersionByFeature(record.getLanguageId(), channelId, featureId);
			long maxDraftVersion = localizationLocalService.getMaxDraftVersionByFeature(record.getLanguageId(), channelId, featureId);
			if (maxApprovedVersion > maxDraftVersion) {
				if (maxApprovedVersion > 0) {
					Localization local = localizationLocalService.getLocalByVersion_LangId_FeatureId(maxApprovedVersion, record.getLanguageId(), channelId, featureId).get(0);
					return !local.getLocalValue().equals("{}");
				}
			} else if (maxDraftVersion > 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isLinkedToResources(Long featureId, Long channelId) {
        return resourceLocalService.hasApprovedOrDraftVersionByFeature(featureId, channelId);
	}


	public boolean isLovDataLinkedToApprovedFeature(long lovEntityResourceId, String lovDataCode) {
		List<FeatureLovMap> candidates =
				featureLovMapPersistence.findByLovEntityResourceIdAndLovDataCode(lovEntityResourceId, lovDataCode);

		if (candidates == null || candidates.isEmpty()) {
			return false;
		}

		Set<Long> candidateFeatureIds = new HashSet<>();
		Set<Long> featureEntityResourceIds = new HashSet<>();
		for (FeatureLovMap map : candidates) {
			candidateFeatureIds.add(map.getFeatureId());
			featureEntityResourceIds.add(map.getFeatureEntityResourceId());
		}

		for (Long entityResourceId : featureEntityResourceIds) {
			Feature latestApproved = getLatestApprovedFeatureByEntityResourceId(entityResourceId);
			if (latestApproved != null && candidateFeatureIds.contains(latestApproved.getFeatureId())) {
				return true;
			}
		}
		return false;
	}

	private Feature getLatestApprovedFeatureByEntityResourceId(long entityResourceId) {
		List<Feature> versions = featurePersistence.findByEntityResourceId(entityResourceId);
		Feature latest = null;
		for (Feature feature : versions) {
			if (feature.getStatus() == WorkflowConstants.STATUS_APPROVED
					&& (latest == null || feature.getVersion() > latest.getVersion())) {
				latest = feature;
			}
		}
		return latest;
	}

	public List<Feature> findByOriginalEntityIdAndStatus(long originalEntityId, int status) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Feature.class, getClassLoader());

		dynamicQuery.add(PropertyFactoryUtil.forName("originalEntityId").eq(originalEntityId));
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(status));

		return FeatureLocalServiceUtil.dynamicQuery(dynamicQuery);
	}

	public List<Feature> getByChildResourceId(long childResourceId) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Feature.class, getClassLoader());

		dynamicQuery.add(PropertyFactoryUtil.forName("childResourceId").eq(childResourceId));

		return FeatureLocalServiceUtil.dynamicQuery(dynamicQuery);
	}

	private void startWorkflow(Feature feature, ServiceContext serviceContext, User user, Long id, String type, String entityType) throws PortalException, JsonProcessingException {


		serviceContext.setAttribute(Constants.ENTITY_TYPE, entityType);
		serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
		serviceContext.setAttribute(Constants.REQUEST_ID, feature.getFeatureId());
		serviceContext.setAttribute(Constants.OPERATION_TYPE, type);


		feature.setStatus(WorkflowConstants.STATUS_DRAFT);
		feature.setGroupId(serviceContext.getScopeGroupId());
		feature.setCompanyId(serviceContext.getCompanyId());
		feature.setUserId(user.getUserId());
		feature.setUserName(user.getFullName());
		feature.setCreateDate(new Date());
		feature.setModifiedDate(new Date());
		feature.setUuid_(PortalUUIDUtil.generate());
		feature.setOriginalEntityId(id);

		this.featurePersistence.update(feature);

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
				Feature.class.getName(),
				feature.getFeatureId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames()
		);

		serviceContext.setAssetCategoryIds(null);
		serviceContext.setAssetTagNames(null);

		LOG.info("Starting workflow");
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(),
				serviceContext.getUserId(),
				Feature.class.getName(),
				feature.getPrimaryKey(),
				feature,
				serviceContext
		);
		LOG.info("Workflow started successfully for Feature ID: " + feature.getFeatureId());

	}


	private int getMaxVersionForParent(long entityResourceId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Feature.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		query.setProjection(ProjectionFactoryUtil.max("version"));
		List<Integer> results = FeatureLocalServiceUtil.dynamicQuery(query);
		if (results != null && !results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return 0;
	}

	private int getMaxVersionForChild(long childResourceId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Feature.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("childResourceId", childResourceId));
		query.setProjection(ProjectionFactoryUtil.max("version"));
		List<Integer> results = FeatureLocalServiceUtil.dynamicQuery(query);
		if (results != null && !results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return 0;
	}

	public List<Feature> getLatestApprovedByChannelId(long channelId) {

		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq(
				"status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.asc("childResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Feature> allApproved =
				featurePersistence.findWithDynamicQuery(dq);

		Map<String, Feature> latestByLogicalKey = new LinkedHashMap<>();

		for (Feature feature : allApproved) {

			String key =
					feature.getEntityResourceId() + "_" + feature.getChildResourceId();

			if (!latestByLogicalKey.containsKey(key)) {
				latestByLogicalKey.put(key, feature);
			}
		}

		return new ArrayList<>(latestByLogicalKey.values());
	}


	public List<Feature> getByEntityResourceId(long entityResourceId) {
		return featurePersistence.findByEntityResourceId(entityResourceId);
	}

	public JSONObject getBlueAppFeatures(
			long channelId, List<String> whitelistFilter, List<String> segmentsFilter) {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		List<Feature> features = getLatestApprovedByChannelId(channelId);
		if (features == null || features.isEmpty()) {
			return jsonObject;
		}

		boolean hasWhitelistFilter = whitelistFilter != null && !whitelistFilter.isEmpty();
		boolean hasSegmentsFilter = segmentsFilter != null && !segmentsFilter.isEmpty();

		Set<String> whitelistFilterSet = hasWhitelistFilter ? new HashSet<>(whitelistFilter) : null;
		Set<String> segmentsFilterSet = hasSegmentsFilter ? new HashSet<>(segmentsFilter) : null;

		List<Long> featureIds = new ArrayList<>();
		Map<Long, Feature> featureById = new LinkedHashMap<>();
		for (Feature feature : features) {
			featureIds.add(feature.getFeatureId());
			featureById.put(feature.getFeatureId(), feature);
		}

		Map<Long, Boolean> whitelistMatchByFeature = new HashMap<>();
		Map<Long, Boolean> segmentsMatchByFeature = new HashMap<>();

		DynamicQuery mapQuery = DynamicQueryFactoryUtil.forClass(FeatureLovMap.class, "m", getClassLoader());
		mapQuery.add(PropertyFactoryUtil.forName("m.featureId").in(featureIds));
		List<FeatureLovMap> allMaps = featureLovMapPersistence.findWithDynamicQuery(mapQuery);

		for (FeatureLovMap map : allMaps) {
			long featureId = map.getFeatureId();
			String type = map.getLovType();
			String code = map.getLovDataCode();

			if (TelemoneyConstants.WHITELIST_CODE.equalsIgnoreCase(type)) {
				if (hasWhitelistFilter && whitelistFilterSet.contains(code)) {
					whitelistMatchByFeature.put(featureId, Boolean.TRUE);
				}
			} else if (TelemoneyConstants.SEGMENTS_CODE.equalsIgnoreCase(type)) {
				if (hasSegmentsFilter && segmentsFilterSet.contains(code)) {
					segmentsMatchByFeature.put(featureId, Boolean.TRUE);
				}
			}
		}

		for (Map.Entry<Long, Feature> entry : featureById.entrySet()) {
			long featureId = entry.getKey();
			Feature feature = entry.getValue();

			boolean whitelistMatch =
					!hasWhitelistFilter || whitelistMatchByFeature.getOrDefault(featureId, Boolean.FALSE);
			boolean segmentsMatch =
					!hasSegmentsFilter || segmentsMatchByFeature.getOrDefault(featureId, Boolean.FALSE);

			if (!whitelistMatch || !segmentsMatch) {
				continue;
			}

			jsonObject.put(feature.getFeatureName(), feature.getFeatureStatus());
		}

		return jsonObject;
	}

	private Blocks createBlockEntity(BlockDTO block) throws PortalException {
		Blocks createdBlock = null;
		if (block != null) {
			createdBlock = blocksLocalService.add(
					block.getChannelId(), block.getType(),
					block.isAndroidBlock(), block.getAndroidBlockVersion(),
					block.getAndroidBlockFrom(), block.getAndroidBlockTo(),
					block.isIosBlock(), block.getIosBlockVersion(),
					block.getIosBlockFrom(), block.getIosBlockTo(),
					block.isWebBlock(), block.getWebBlockVersion(),
					block.getWebBlockFrom(), block.getWebBlockTo()
			);
			LOG.info("Created new block ID: " + createdBlock.getBlockId() + " for banner");
		}
		return createdBlock;
	}

	public Feature updateStatus(long userId, long featureId, int status,
							   ServiceContext serviceContext) throws Exception {
		if (status != WorkflowConstants.STATUS_APPROVED && status != WorkflowConstants.STATUS_DENIED) {
			LOG.info("Feature ID " + featureId + " is still pending approval");
			return null;
		}


		Feature feature = featurePersistence.findByPrimaryKey(featureId);
		feature.setModifiedDate(new Date());
		feature.setStatus(status);
		feature.setStatusByUserId(userId);
		if (serviceContext != null && userId > 0) {
			feature.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
		}
		feature.setStatusDate(new Date());
		String operationType = feature.getWorkflowAction();
		LOG.info("Updating status for feature ID: " + featureId + " to " + status + " with operation type: " + operationType);

		// Process based on workflow status
		if (status == WorkflowConstants.STATUS_APPROVED) {
			handleApprovedStatus(feature, serviceContext, operationType,userId);
			bumpGlobalVersion(feature);
		} else {
			handleDeniedStatus(feature, serviceContext);
		}
		if (!operationType.equals(Constants.DELETE_FEATURE)) {
			featurePersistence.update(feature);
		}
		return feature;
	}

	private void handleApprovedStatus(Feature feature, ServiceContext serviceContext, String operationType,long userId) throws Exception {
		switch (operationType) {
			case Constants.DELETE_FEATURE:
				handleDeleteOperation(feature);
				break;

			case Constants.UPDATE_SEGMENT:
			case Constants.UPDATE_FEATURE:
				handleUpdateOperation(feature, serviceContext);
				break;
			case Constants.ADD_FEATURE:
				handleAddOperation(feature);
				LOG.info("Approving creation for feature ID: " + feature.getFeatureId());
				break;
		}

	}
	private void handleDeniedStatus(Feature feature, ServiceContext serviceContext) throws PortalException {
		if(feature.getWorkflowAction().equals(Constants.UPDATE_SEGMENT))
		{
			long segmentId = GetterUtil.getLong(serviceContext.getAttribute("segmentId"));
			Segment segment = segmentLocalService.fetchSegment(segmentId);
			segment.setStatus(WorkflowConstants.STATUS_INACTIVE);
			segmentLocalService.updateSegment(segment);
			LOG.info("Segment update denied for segment ID: " + segmentId);
		} else {
			LOG.info("Feature update denied for feature ID: " + feature.getFeatureId());
			if (feature.getOriginalEntityId() != 0L) {
				Feature originalFeature = featureLocalService.fetchFeature(feature.getOriginalEntityId());

				handleChildOnParentStatusChange(originalFeature, feature, WorkflowConstants.STATUS_DENIED);

				List<Segment> segments = segmentLocalService.findSegmentsByFeatureId(feature.getFeatureId());
				LOG.info("Setting status to INACTIVE for " + segments.size() + " segments linked to feature ID: " + feature.getFeatureId());
				if (!segments.isEmpty()) {
					for (Segment s : segments) {
						s.setStatus(WorkflowConstants.STATUS_INACTIVE);
						segmentLocalService.updateSegment(s);
					}
				}
			}
		}

	}
	private void handleAddOperation(Feature feature) {
		List<Segment> segments = segmentLocalService.findSegmentsByFeatureId(feature.getFeatureId());
		for(Segment s : segments){
			s.setStatus(WorkflowConstants.STATUS_APPROVED);
			segmentLocalService.updateSegment(s);
		}
		LOG.info("Feature creation approved for feature ID: " + feature.getFeatureId());
	}
	private void handleDeleteOperation(Feature feature) throws Exception {
		User user;
		try {
			user = userLocalService.getUser(feature.getUserId());
		} catch (PortalException e) {
			LOG.error("User not found for ID: " + feature.getUserId(), e);
			return;
		}
		deleteFeatureWithItsSegments(feature.getFeatureId(), user);
	}
	private void handleUpdateOperation(Feature feature, ServiceContext serviceContext)
			throws PortalException, SystemException {
		if (feature.getWorkflowAction().equals(Constants.UPDATE_SEGMENT)) {
			handleSegmentUpdate(serviceContext);
		} else {
			handleFeatureUpdate(feature);
		}
	}
	private void handleSegmentUpdate(ServiceContext serviceContext) throws PortalException, SystemException
	{
		long segmentId = GetterUtil.getLong(serviceContext.getAttribute("segmentId"));
		LOG.info("Approving update for segment ID: " + segmentId);
		Segment segment = segmentLocalService.getSegment(segmentId);
		long originalEntityId = segment.getOriginalEntityId();
		Segment originalSegment =  segmentLocalService.getSegment(originalEntityId);
		originalSegment.setStatus(WorkflowConstants.STATUS_INACTIVE);
		segmentLocalService.updateSegment(originalSegment);
		segment.setStatus(WorkflowConstants.STATUS_APPROVED);
		segmentLocalService.updateSegment(segment);
	}

	private void handleFeatureUpdate(Feature feature) throws PortalException, SystemException {
		long originalFeatureId = feature.getOriginalEntityId();
		Feature originalFeature = featureLocalService.getFeature(originalFeatureId);


		if (originalFeature.getEntityResourceId() != feature.getEntityResourceId()) {
			List<Feature> originalFeatures;
			if (Objects.equals(originalFeature.getPageType(), "0")) {
				originalFeatures = featurePersistence.findByEntityResourceId(originalFeature.getEntityResourceId());
			} else {
				originalFeatures = featurePersistence.findByChildResourceId(originalFeature.getChildResourceId());
			}

			for (Feature f : originalFeatures) {
				f.setStatus(WorkflowConstants.STATUS_INACTIVE);
				featureLocalService.updateFeature(f);
			}
		}

		handleChildOnParentStatusChange(originalFeature, feature, WorkflowConstants.STATUS_APPROVED);

		LOG.info("Approving update for feature ID: " + feature.getFeatureId() + " (Original ID: " + originalFeatureId + ")");
		List<Segment> segments = segmentLocalService.findSegmentsByFeatureId(feature.getFeatureId());
		if(!segments.isEmpty()){
			for(Segment s : segments){
				LOG.info("Updating segment ID: " + s.getSegmentId() + " for feature update approval");
				Segment originalSegment = segmentLocalService.getSegment(s.getOriginalEntityId());
				originalSegment.setStatus(WorkflowConstants.STATUS_INACTIVE);
				segmentLocalService.updateSegment(originalSegment);
				s.setStatus(WorkflowConstants.STATUS_APPROVED);
				segmentLocalService.updateSegment(s);
			}
		}
		LOG.info("Updating feature status to APPROVED for feature ID: " + feature.getFeatureId());
	}
	private void handleChildOnParentStatusChange(Feature originalFeature, Feature feature, int workFlowStatus) {
		if (originalFeature.getPageType().contains("0") && originalFeature.getFeatureStatus()
				&& !feature.getFeatureStatus())
		{
			LOG.info("====== Parent Feature Status Change Handler ======");
			LOG.info("Parent Feature ID: " + feature.getFeatureId() + " is being turned OFF");
			LOG.info("Turning OFF all child features with workflow status: " + workFlowStatus);

			List<Feature> childFeatures = getAllChildrenFeatures(feature.getEntityResourceId(),WorkflowConstants.STATUS_DRAFT);
			LOG.info("Found " + childFeatures.size() + " child feature(s) to turn OFF");

			for (Feature childFeature : childFeatures) {
				LOG.info("Updating child feature ID: " + childFeature.getFeatureId() +
						" (Name: " + childFeature.getFeatureName() + ") to workflow status: " + workFlowStatus);
				childFeature.setStatus(workFlowStatus);
				childFeature.setGroupId(feature.getGroupId());
				childFeature.setUserId(feature.getUserId());
				childFeature.setUserName(feature.getUserName());
		        childFeature.setStatusByUserId(feature.getStatusByUserId());
				childFeature.setStatusByUserName(feature.getStatusByUserName());
				childFeature.setStatusDate(feature.getStatusDate());
				childFeature.setUuid_(PortalUUIDUtil.generate());
				featurePersistence.update(childFeature);
			}

			LOG.info("====== Finished turning OFF " + childFeatures.size() + " child feature(s) ======");
		}
	}

	/**
	 * User Story 5 - Global Component Versioning.
	 *
	 * <p>
	 * An approved change to the Feature Toggling component (feature/segment
	 * add/update/delete) bumps the internal {@code featureToggleVersion} version
	 * for this company/channel. Runs in the same transaction as the approval so
	 * both succeed or roll back together.
	 * </p>
	 */
	private void bumpGlobalVersion(Feature feature) {
		GlobalVersionLocalServiceUtil.incrementApprovedVersion(
				feature.getCompanyId(),
				feature.getChannelId(),
				ComponentType.FEATURE_TOGGLE.name());
	}


}