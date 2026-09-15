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

import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.mapper.LovDataMapper;
import com.ejada.telemony.db.mapper.LovMapper;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.GlobalVersionLocalServiceUtil;
import com.ejada.telemony.db.service.LovsLocalServiceUtil;
import com.ejada.telemony.db.service.base.LovsLocalServiceBaseImpl;
import com.ejada.telemony.db.service.persistence.LovsLocalizationUtil;
import com.ejada.telemony.db.service.persistence.LovsUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ejada.telemony.db.model.LovData;
import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import javax.portlet.PortletException;

/**
 * The implementation of the lovs local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.LovsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalServiceBaseImpl
 */

public class LovsLocalServiceImpl extends LovsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.LovsLocalService</code> via injection or
	 * a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.LovsLocalServiceUtil</code>.
	 */

	private static final Log LOG = LogFactoryUtil.getLog(LovsLocalServiceImpl.class);

	public Lovs lovListCreate(Map<String, String> names, String code, String eventCode, Long channelId,User user,ServiceContext serviceContext)
			throws Exception {
		Lovs createdLovList;
		try {
			createdLovList = this.lovsLocalService.createLovs(CounterLocalServiceUtil.increment());
			createdLovList.setChannelId(channelId);
			createdLovList.setCode(code);
			createdLovList.setDefaultLanguageId("English");
			createdLovList.setEventCode(eventCode);
			createdLovList.setEntityResourceId(createdLovList.getId());
			createdLovList.setVersion(getMaxVersion(createdLovList.getEntityResourceId()) + 1);
			createdLovList.setStatus(WorkflowConstants.STATUS_DRAFT);
			createdLovList.setWorkflowAction(Constants.ADD_LOV);

			for (Languages language : languagesLocalService.getbyChannelId(channelId)) {
				String langName = language.getLangName();
				LovsLocalization lovsLocal = lovsLocalizationPersistence.create(counterLocalService.increment());
				lovsLocal.setId(createdLovList.getId());
				lovsLocal.setLanguageId(langName);
				lovsLocal.setName(names.get(langName));
				lovsLocalizationPersistence.update(lovsLocal);
			}
			lovsLocalService.updateLovs(createdLovList);
			startWorkflow(createdLovList, serviceContext, user, 0L, Constants.CREATE,Constants.LOV);

		} catch (Exception e) {
			LOG.info("----------------Lovs Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
		return createdLovList;
	}

	public Lovs lovListUpdate(Long id, Map<String, String> names, String code, Long channelId, String eventCode)
			throws Exception {
		Lovs draftLovList;
		Lovs existingLovList = lovsLocalService.getLovs(id);
		try {

			draftLovList = this.lovsLocalService.createLovs(CounterLocalServiceUtil.increment());
			draftLovList.setCode(code);
			draftLovList.setDefaultLanguageId("English");
			draftLovList.setChannelId(channelId);
			draftLovList.setEventCode(eventCode);
			draftLovList.setVersion(getMaxVersion(existingLovList.getEntityResourceId()) + 1);
			draftLovList.setEntityResourceId(existingLovList.getEntityResourceId());
			draftLovList.setStatus(WorkflowConstants.STATUS_DRAFT);
			draftLovList.setWorkflowAction(Constants.UPDATE_LOV);
			draftLovList.setOriginalEntityId(id);
			LovsLocalization draftLovsLocal;

			for (Languages language : languagesLocalService.getbyChannelId(channelId)) {
				String langName = language.getLangName();
					draftLovsLocal = lovsLocalizationPersistence.create(counterLocalService.increment());
					draftLovsLocal.setLanguageId(langName);
					draftLovsLocal.setName(names.get(langName));
					draftLovsLocal.setId(draftLovList.getId());
					lovsLocalizationPersistence.update(draftLovsLocal);
			}
			this.lovsLocalService.updateLovs(draftLovList);
			return draftLovList;

		} catch (Exception e) {
			LOG.info("----------------Lovs Update Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}

	}

	public void updateLovWorkflow(Long id, Map<String, String> nameValues, String code, Long channelId, String eventCode,User user,ServiceContext serviceContext) throws Exception
	{

		if(isLovUnchanged(lovsLocalService.getLovs(id),code,eventCode,channelId,nameValues)) {
			LOG.info("No changes detected for LOV ID: " + id + ". Skipping workflow.");
			return;
		}
		Lovs draftLovList = lovListUpdate(id, nameValues, code, channelId, eventCode);
		lovDataLocalService.updateLovDataByLovId(id,draftLovList);
		startWorkflow(draftLovList, serviceContext, user, id, Constants.UPDATE,Constants.LOV);
	}

	public void lovListDelete(Long id, Long channelId) throws Exception {
		Lovs deleteLovList;
		LovsLocalization localization;
		try {
			for (Languages language : languagesLocalService.getbyChannelId(channelId)) {
				String name = language.getLangName();
				localization = lovsLocalizationPersistence.fetchById_LanguageId(id, name);

				if(localization!=null){
				LOG.info("Deleting LOV Localization: ID=" + localization.getId() + ", Language=" + name);
				lovsLocalizationPersistence.remove(localization);
			}
				// lovsLocalizationPersistence.clearCache();
			}
			deleteLovList = lovsLocalService.getLovs(id);
			lovsLocalService.deleteLovs(deleteLovList);
			// lovsPersistence.clearCache();

		} catch (Exception e) {
			LOG.info("---------------- Lovs  Delete Failed -----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public void deleteLovByLovId(Long id , Long channelId) throws Exception {
		lovDataLocalService.deleteLovDataByLovId(id, channelId);
		lovListDelete(id,channelId);
	}

	public void deleteLovWorkflow(Long id, User user, ServiceContext serviceContext) throws Exception {
		Lovs trashLov = this.lovsLocalService.createLovs(CounterLocalServiceUtil.increment());
		Lovs originalLov = lovsLocalService.getLovs(id);
		LovMapper.copyOriginalDataToDraft(originalLov, trashLov);
		for (Languages language : languagesPersistence.findByChannelId(trashLov.getChannelId())) {
			LovsLocalization originalLovLocalization = lovsLocalizationPersistence.fetchById_LanguageId(id, language.getLangName());
			if (originalLovLocalization != null) {
				LovsLocalization trashLovLocalization = lovsLocalizationPersistence.create(CounterLocalServiceUtil.increment());
				trashLovLocalization.setId(trashLov.getId());
				trashLovLocalization.setLanguageId(language.getLangName());
				LovMapper.copyOriginalLocalizationToDraft(originalLovLocalization, trashLovLocalization);
				lovsLocalizationPersistence.update(trashLovLocalization);
			}

		}
		trashLov.setStatus(WorkflowConstants.STATUS_DRAFT);
		trashLov.setWorkflowAction(Constants.DELETE_LOV);
		trashLov.setEntityResourceId(originalLov.getEntityResourceId());
		trashLov.setOriginalEntityId(originalLov.getId());
		trashLov.setVersion(getMaxVersion(originalLov.getEntityResourceId()) + 1);
		startWorkflow(trashLov, serviceContext, user, originalLov.getId(), Constants.DELETE, Constants.LOV);
	}

	public void addLovDataWorkflow(Long lovId, String lovType, String recordTypeCode, Map<String, String> values,
								   String recordShortDescription, Long channelId, Long originalLovDataId,
								   User user, ServiceContext serviceContext) throws Exception {

		Lovs originalLov = lovsLocalService.getLovs(lovId);
		Lovs draftLov = createDraftLov(originalLov, Constants.ADD_LOV_DATA);

		LovData draftLovData = lovDataLocalService.lovDataCreate(
				draftLov.getId(), lovType, recordTypeCode, values, recordShortDescription, channelId, originalLovDataId);

		serviceContext.setAttribute("lovDataId", String.valueOf(draftLovData.getId()));
		startWorkflow(draftLov, serviceContext, user, lovId, Constants.UPDATE, Constants.LOV_DATA);
	}

	public void updateLovDataWorkflow(Long id, Long lovId, String lovType, String recordTypeCode, Map<String, String> values,
									  String recordShortDescription, Long channelId, User user, ServiceContext serviceContext) throws Exception {

		LovData originalLovData = lovDataLocalService.getLovData(id);
		if(isLovDataUnchanged(originalLovData, lovType, recordTypeCode, recordShortDescription, channelId, values)) {
			LOG.info("No changes detected for LovData ID: " + id + ". Skipping workflow.");
			return;
		}
		Lovs originalLov = lovsLocalService.getLovs(lovId);
		Lovs draftLov = createDraftLov(originalLov, Constants.UPDATE_LOV_DATA);

		LovData draftLovData = lovDataLocalService.lovDataCreate(
				draftLov.getId(), lovType, recordTypeCode, values, recordShortDescription, channelId, id);
		serviceContext.setAttribute("lovDataId", String.valueOf(draftLovData.getId()));
		startWorkflow(draftLov, serviceContext, user, lovId, Constants.UPDATE, Constants.LOV_DATA);
	}

	public void deleteLovDataWorkflow(LovData originalLovData, Long chn, ServiceContext serviceContext, User user) throws Exception {



		Lovs originalLov = lovsLocalService.getLovs(originalLovData.getLovId());
		Lovs draftLov = createDraftLov(originalLov, Constants.DELETE_LOV_DATA);
		LovData draftLovData = lovDataLocalService.lovDataCreate(
				draftLov.getId(), null, null, null, null, draftLov.getChannelId(), originalLovData.getId());
		LovDataMapper.copyOriginalDataToDraft(originalLovData, draftLovData);
		draftLovData.setLovId(draftLov.getId());
		lovDataLocalService.updateLovData(draftLovData);
		for (Languages language : languagesPersistence.findByChannelId(chn)) {
			LovDataLocalization lovDataLocalization = lovDataLocalizationPersistence.fetchById_LanguageId(originalLovData.getId(), language.getLangName());
			LovDataLocalization draftLovDataLocalization = lovDataLocalizationPersistence.fetchById_LanguageId(draftLovData.getId(), language.getLangName());
			if (lovDataLocalization != null) {
				LovDataMapper.copyOriginalLocalizationToDraft(lovDataLocalization, draftLovDataLocalization);
				lovDataLocalizationPersistence.update(draftLovDataLocalization);
			}
		}
		serviceContext.setAttribute("lovDataId", String.valueOf(draftLovData.getId()));
		startWorkflow(draftLov, serviceContext, user, originalLov.getId(), Constants.DELETE, Constants.LOV_DATA);
	}

	private Lovs createDraftLov(Lovs originalLov, String workflowAction) throws Exception {
		Lovs draftLov = lovsLocalService.createLovs(CounterLocalServiceUtil.increment());
		LovMapper.copyOriginalDataToDraft(originalLov, draftLov);
		for (Languages language : languagesPersistence.findByChannelId(draftLov.getChannelId())) {
			LovsLocalization originalLocalization = lovsLocalizationPersistence.fetchById_LanguageId(
					originalLov.getId(), language.getLangName()
			);
			if (originalLocalization != null) {
				LovsLocalization draftLocalization = lovsLocalizationPersistence.create(CounterLocalServiceUtil.increment());
				draftLocalization.setId(draftLov.getId());
				draftLocalization.setLanguageId(language.getLangName());
				LovMapper.copyOriginalLocalizationToDraft(originalLocalization, draftLocalization);
				lovsLocalizationPersistence.update(draftLocalization);
			}

		}
		draftLov.setStatus(WorkflowConstants.STATUS_DRAFT);
		draftLov.setWorkflowAction(workflowAction);
		draftLov.setEntityResourceId(originalLov.getEntityResourceId());
		draftLov.setOriginalEntityId(originalLov.getId());
		draftLov.setVersion(getMaxVersion(originalLov.getEntityResourceId()) + 1);
		lovsLocalService.updateLovs(draftLov);
		return draftLov;
	}

	private boolean isLovDataUnchanged(LovData originalLovData, String lovType, String recordTypeCode,
									   String recordShortDescription, Long channelId, Map<String, String> values) {
		if (!Objects.equals(originalLovData.getLovType(), lovType)
				|| !Objects.equals(originalLovData.getRecordTypeCode(), recordTypeCode)
				|| !Objects.equals(originalLovData.getRecordShortDescription(), recordShortDescription)) {
			return false;
		}

		for (Languages language : languagesPersistence.findByChannelId(channelId)) {
			String langName = language.getLangName();
			LovDataLocalization originalLocalization = lovDataLocalizationPersistence
					.fetchById_LanguageId(originalLovData.getId(), langName);

			String originalDescription = (originalLocalization != null)
					? originalLocalization.getRecordDescription() : null;

			if (!Objects.equals(originalDescription, values.get(langName))) {
				return false;
			}
		}

		return true;
	}

	private boolean isLovUnchanged(Lovs originalLov, String code, String eventCode,
									Long channelId, Map<String, String> nameValues) {
		if (!Objects.equals(originalLov.getCode(), code)
				|| !Objects.equals(originalLov.getEventCode(), eventCode)) {
			return false;
		}

		for (Languages language : languagesLocalService.getbyChannelId(channelId)) {
			String langName = language.getLangName();
			LovsLocalization originalLocalization = lovsLocalizationPersistence
					.fetchById_LanguageId(originalLov.getId(), langName);

			String originalName = (originalLocalization != null)
					? originalLocalization.getName() : null;

			if (!Objects.equals(originalName, nameValues.get(langName))) {
				return false;
			}
		}

		return true;
	}


	public int getLovDataCountByLovId(Long LovId) {
		Lovs lov = null;
		try {
			lov = getLovs(LovId);
		} catch (PortalException e) {
            LOG.info("Lov not found for ID: " + LovId);
        }
		if (lov != null) {
        return  lovDataLocalService.countByResourceIdAndApproved(lov.getEntityResourceId());
		}
		return 0;
	}

	public List<Lovs> searchByCode(String code, Long channelId) throws IOException, PortletException {

		List<Lovs> types = null;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Lovs.class, getClassLoader());

			dynamicQuery.add(PropertyFactoryUtil.forName("code").like("%" + code + "%"));

			dynamicQuery.add(RestrictionsFactoryUtil.eq("channelId", channelId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(
					"status", WorkflowConstants.STATUS_APPROVED));

			dynamicQuery.addOrder(OrderFactoryUtil.asc("entityResourceId"));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("version"));

			types = LovsLocalServiceUtil.dynamicQuery(dynamicQuery);

			Map<Long, Lovs> latestByResource = new LinkedHashMap<>();
			for (Lovs lov : types) {
				if (!latestByResource.containsKey(lov.getEntityResourceId())) {
					latestByResource.put(lov.getEntityResourceId(), lov);
				}
			}

			return new ArrayList<>(latestByResource.values());

		} catch (SystemException e) {
			// Handle exception
		}
		return types;
	}

	public List<Lovs> searchLovLocalizationByName(String searchName,Long channelId)
			throws IOException {

		List<LovsLocalization> localizations = null;
		List<Lovs> lovs = new ArrayList<>();

		try {
			StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append("%");
			queryBuilder.append(searchName);
			queryBuilder.append("%");
			String likeSearchName = queryBuilder.toString();

			localizations = LovsLocalizationUtil.findBynameAndLanguageId("English", likeSearchName);
			LOG.info("Found " + localizations.size() + " localizations matching the name: " + searchName);
			for (LovsLocalization localization : localizations) {
				long lovID = localization.getId();
				Lovs lov = null;
				try {
					 lov = getLovs(lovID);
					 LOG.info("Processing LOV ID: " + lovID);
				} catch (PortalException e) {
					LOG.info("Lov not found for ID: " + lovID);
				}
				if (lov != null
						&& lov.getStatus() == WorkflowConstants.STATUS_APPROVED
						&& lov.getVersion() == getMaxApprovedVersion(lov.getEntityResourceId())) {
					LOG.info("Adding LOV ID: " + lovID + " to results");
					lovs.addAll(LovsUtil.findByidAndChannel(localization.getId(), channelId));
				}
			}
		} catch (SystemException e) {
			// Handle exception
		}
		return lovs;
	}



	public JSONArray getLovsAndRelatedDataByCode(String code, String language, Long channelId) {
		JSONObject type1 = JSONFactoryUtil.createJSONObject();
		JSONArray all = JSONFactoryUtil.createJSONArray();
		String[] codeAndShortDescription = code.split("-");
		List<Lovs> approvedLovs = lovsLocalService.getLatestApprovedByChannelIdAndCode(channelId, codeAndShortDescription[0]);
		if (!approvedLovs.isEmpty()) {
			Lovs type = approvedLovs.get(0);
			Long id = type.getId();

			type1.put("name", type.getName(language));

			type1.put("serviceListCode", type.getCode());

			JSONArray dataArray = JSONFactoryUtil.createJSONArray();



			long startTime1 = System.currentTimeMillis();
			List<LovData> relatedData = lovDataLocalService.getByEntityResourceIdAndStatusApproved(type.getEntityResourceId());
			long endTime1 = System.currentTimeMillis();
			long executionTime1 = endTime1 - startTime1;
			LOG.info("Execution time for relatedData: " + executionTime1 + " milliseconds");


			Map<Long, LovDataLocalization> lovDataLocalizationMap = new HashMap<>();

			long startTime = System.currentTimeMillis();
			List<LovDataLocalization> lovDataLocalization = new ArrayList<>();
			for(LovData data:relatedData) {
			 lovDataLocalization.add(lovDataLocalService.getLovDataLocalizations(data.getId()).get(0));
			}
			long endTime = System.currentTimeMillis();
			long executionTime = endTime - startTime;
			LOG.info("Execution time for lovDataLocalization: " + executionTime + " milliseconds");

			for (LovDataLocalization localization : lovDataLocalization) {
				lovDataLocalizationMap.put(localization.getId(), localization);
			}
			for (LovData data : relatedData) {
				JSONObject dataObject = JSONFactoryUtil.createJSONObject();

				LovDataLocalization localization = lovDataLocalizationMap.get(data.getId());
				if (localization != null) {
					dataObject.put("listItemName", localization.getRecordDescription());
				}
				dataObject.put("listItemCode", data.getRecordTypeCode());

				dataObject.put("listItemAttribute", data.getRecordShortDescription());

				dataArray.put(dataObject);

			}

			type1.put("serviceListRecords", dataArray); // Add related data to the type1 object

			all.put(type1);

		} else {
			type1.put("serviceListRecords", "There is no code: " + codeAndShortDescription[0]); // Add related data to
			// the type1 object

			all.put(type1);
		}

		return all;
	}

	public List<String> getLangNamesByCode(String code, Long channelId) {
		Lovs lovs = lovsPersistence.findBytypeCode(channelId, code).get(0);
		ArrayList<String> langNames = new ArrayList<String>();

		Long id = lovs.getId();
		List<LovData> relatedData = lovDataLocalService.findLovDataByLovId(id);
		for (LovData data : relatedData) {
			langNames.add(data.getRecordDescription("English"));
		}
		return langNames;
	}

	public List<String> getLangTypeCodeByLOVCode(String code, Long channelId) {



		Lovs lovs = getLatestApprovedByChannelIdAndCode(channelId,code).	get(0);
		getLatestApprovedByChannelId(channelId);
		ArrayList<String> langNames = new ArrayList<String>();

		Long id = lovs.getId();
		List<LovData> relatedData = lovDataLocalService.findLovDataByLovIdAndStatus(id, 0);
		for (LovData data : relatedData) {
			langNames.add(data.getRecordTypeCode());
		}
		return langNames;
	}

	public List<LovData> getLovDataByCode(String code, Long channelId) {
		Lovs lovs = lovsPersistence.findBytypeCode(channelId, code) != null
				&& (lovsPersistence.findBytypeCode(channelId, code)).size() != 0
				? lovsPersistence.findBytypeCode(channelId, code).get(0)
				: null;
		if (lovs != null) {
			Long id = lovs.getId();
			List<LovData> relatedData = lovDataLocalService.findLovDataByLovId(id);
			return relatedData;
		} else {
			return new ArrayList<LovData>();
		}
	}

	public List<LovData> getLatestApprovedLovDataByCode(String code, Long channelId) {
		List<Lovs> approved = getLatestApprovedByChannelIdAndCode(channelId, code);
		if (approved == null || approved.isEmpty()) {
			return new ArrayList<LovData>();
		}
		Lovs latestLov = approved.get(0);
		return lovDataLocalService.getByEntityResourceIdAndStatusApproved(latestLov.getId());
	}

	public List<String> getLatestApprovedLangNamesByCode(String code, Long channelId) {
		List<LovData> approvedData = getLatestApprovedLovDataByCode(code, channelId);
		ArrayList<String> langNames = new ArrayList<String>();
		for (LovData data : approvedData) {
			langNames.add(data.getRecordDescription("English"));
		}
		return langNames;
	}

	public List<Lovs> getByChannelId(Long channelId) {

		List<Lovs> relatedData = lovsPersistence.findByChannelId(channelId);

		return relatedData;
	}

	public List<Lovs> getLovsByTypeCodeAndStatus(String code, long channelId, int status) {
		return lovsPersistence.findBytypeCodeAndStatus(channelId, code,status);
	}


	public void importLovsAndLovDataFromCSV(String filePath, Long channelId) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			// Read Lovs name
			String lovNameLine = br.readLine();
			String lovName = extractLovName(lovNameLine);

			// Read Lovs code
			String lovCodeLine = br.readLine();
			String lovCode = extractLovCode(lovCodeLine);

			// Create Lovs entity
			Lovs lov = createLovsFromCSV(lovName, lovCode, channelId);

			// Read LovData parameters
			String lovDataParametersLine = br.readLine();
			String[] lovDataParams = lovDataParametersLine.split(",");
			String lovDataCode = lovDataParams[1].trim();
			String recordTypeCode = lovDataCode;

			// Read all lines into a list
			List<String> lines = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			// Process the lines
			Map<String, String> valuesMap = new HashMap<>();
			for (int i = 0; i < lines.size() / 2; i++) {
				String[] parts = lines.get(i).split(",");
				String language = parts[2].trim().replace("$", ",");
				String text = parts[0].trim().replace("$", ",");
				String code = parts[1].trim().replace("$", ",");
				String recordShortDescription = parts.length > 3 ? parts[3].trim().replace("$", ",") : "";

				for (int j = i + 1; j < lines.size(); j++) {
					String[] parts1 = lines.get(j).split(",");
					String language1 = parts1[2].trim().replace("$", ",");
					String text1 = parts1[0].trim().replace("$", ",");
					String code1 = parts1[1].trim().replace("$", ",");

					if (code1.equals(code)) {
						if (language1.equals("ar_SA")) {
							valuesMap.put("Arabic", text1);
						} else if (language1.equals("en_US")) {
							valuesMap.put("English", text1);
						}
					}
				}

				if (language.equals("ar_SA")) {
					valuesMap.put("Arabic", text);
				} else if (language.equals("en_US")) {
					valuesMap.put("English", text);
				}

				try {
					lovDataLocalService.lovDataCreate(lov.getId(), lovName, code, valuesMap, recordShortDescription,
							channelId,0L);
				} catch (Exception e) {
					e.printStackTrace();
				}

				valuesMap.clear();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (java.io.IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private String extractLovName(String line) {
		// Assuming that the name is the first value before the first comma
		return line.split(",")[0];
	}

	private String extractLovCode(String line) {
		// Assuming that the code is the value after the last space and before the last
		// comma
		String[] parts = line.split(" ");
		return parts[parts.length - 1].replaceAll(",", "");
	}

	private Lovs createLovsFromCSV(String lovName, String lovCode, Long channelId) {
		Lovs lov = null;
		try {
			Map<String, String> names = new HashMap<>();
			names.put("English", lovName); // Assuming English is the default language
			names.put("Arabic", lovName); // Add other languages as needed

			// Set the default values for eventCode and channelId
			String eventCode = "EC";

			// Call your existing method to create Lovs
			//TODO: pass user and service context
			lov = lovListCreate(names, lovCode, eventCode, channelId,null,null);

		} catch (Exception e) {
			LOG.error("Error creating Lovs from CSV", e);
		}
		return lov;
	}

	private int getMaxVersion(long entityResourceId)
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Lovs.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		query.setProjection(ProjectionFactoryUtil.max("version"));
		List<Integer> results = LovsLocalServiceUtil.dynamicQuery(query);
		if (results != null && !results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return 0;
	}

	private int getMaxApprovedVersion(long entityResourceId)
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Lovs.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		query.add(RestrictionsFactoryUtil.eq(
				"status", WorkflowConstants.STATUS_APPROVED));
		query.setProjection(ProjectionFactoryUtil.max("version"));
		List<Integer> results = LovsLocalServiceUtil.dynamicQuery(query);
		if (results != null && !results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return 0;
	}



	public Lovs updateStatus(long userId, long lovId, int status,
							   ServiceContext serviceContext) throws Exception {


		if (status != WorkflowConstants.STATUS_APPROVED && status != WorkflowConstants.STATUS_DENIED) {
			LOG.info("Lov ID " + lovId + " is still pending approval");
			return null;
		}


		Lovs lov = lovsPersistence.findByPrimaryKey(lovId);
		lov.setStatus(status);
		lov.setStatusByUserId(userId);
		if (serviceContext != null && userId > 0) {
			lov.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
		}
		lov.setStatusDate(new Date());
		String operationType = lov.getWorkflowAction();
		LOG.info("Updating status for LOV ID: " + lovId + " to " + status + " with operation type: " + operationType);
		lovsPersistence.update(lov);

		// Process based on workflow status
		if (status == WorkflowConstants.STATUS_APPROVED) {
			handleApprovedStatus(lov, serviceContext, operationType);
			bumpGlobalVersion(lov);
		} else {
			handleDeniedStatus(lov, serviceContext);
		}

		return lov;
	}
	private void handleApprovedStatus(Lovs lov,ServiceContext serviceContext,String operationType)
            throws Exception {

		switch (operationType) {
			case Constants.DELETE_LOV_DATA:
			case Constants.DELETE_LOV:
				handleDeleteOperation(lov, serviceContext);
				break;

			case Constants.ADD_LOV_DATA:
			case Constants.UPDATE_LOV_DATA:
			case Constants.UPDATE_LOV:
				handleUpdateOperation(lov, serviceContext);
				break;
			case Constants.ADD_LOV:
				LOG.info("Approving creation for LOV ID: " + lov.getId());
				break;
		}
	}

	private void handleDeleteOperation(Lovs lov,ServiceContext serviceContext)
            throws Exception {
		if (lov.getWorkflowAction().equals(Constants.DELETE_LOV_DATA)) {
			handleLovDataDeletion(serviceContext,lov);
		} else {
			handleLovDeletion(lov);
		}
	}

	private void handleLovDataDeletion(ServiceContext serviceContext, Lovs lov) throws PortalException, SystemException {
		long lovDataId = GetterUtil.getLong(serviceContext.getAttribute("lovDataId"));
		LOG.info("Approving deletion of LOV data ID: " + lovDataId);
		LovData lovData = lovDataLocalService.getLovData(lovDataId);
		LovData originalLovData = lovDataLocalService.getLovData(lovData.getOriginalEntityId());
		lovData.setStatus(WorkflowConstants.STATUS_INACTIVE);
		lovDataLocalService.updateLovData(lovData);
		LOG.info("Set LOV data ID: " + lovDataId + " status to INACTIVE");
		originalLovData.setStatus(WorkflowConstants.STATUS_INACTIVE);
		lovDataLocalService.updateLovData(originalLovData);
		LOG.info("Set original LOV data ID: " + originalLovData.getId() + " status to INACTIVE");
	}

	private void handleLovDeletion(Lovs lov) throws Exception {
		List<Lovs> lovsToDelete = lovsPersistence.findByEntityResourceId(lov.getEntityResourceId());
		for (Lovs lovToDelete : lovsToDelete) {
			deleteLovByLovId(lovToDelete.getId(), lovToDelete.getChannelId());
		}
	}

	private void handleUpdateOperation(Lovs lov, ServiceContext serviceContext)
			throws PortalException, SystemException {
		if (lov.getWorkflowAction().equals(Constants.UPDATE_LOV_DATA) ||
				lov.getWorkflowAction().equals(Constants.ADD_LOV_DATA)) {
			handleLovDataUpdate(serviceContext,lov);
		} else {
			handleLovUpdate(lov);
		}
	}

	private void handleLovDataUpdate(ServiceContext serviceContext, Lovs lov) throws PortalException, SystemException {
		long lovDataId = GetterUtil.getLong(serviceContext.getAttribute("lovDataId"));
		LOG.info("Approving update for lov data ID: " + lovDataId);
		LovData lovData = lovDataLocalService.getLovData(lovDataId);
		if (lovData.getOriginalEntityId() != 0L) {
			long originalEntityId = lovData.getOriginalEntityId();
			LovData originalLovData = lovDataLocalService.getLovData(originalEntityId);
			originalLovData.setStatus(WorkflowConstants.STATUS_INACTIVE);
			lovDataLocalService.updateLovData(originalLovData);
		}
		lovData.setStatus(WorkflowConstants.STATUS_APPROVED);
		lovDataLocalService.updateLovData(lovData);
	}

	private void handleLovUpdate(Lovs lov) throws PortalException, SystemException {
		long originalLovId = lov.getOriginalEntityId();
		LOG.info("Approving update for lov ID: " + lov.getId() + " (Original ID: " + originalLovId + ")");
		updatePendingLovData(lov);
		LOG.info("Lov update completed successfully for original Lov ID: " + originalLovId);
	}
	private void updatePendingLovData(Lovs lov) throws PortalException {
		List<LovData> pendingLovData = lovDataLocalService.findLovDataByLovId(lov.getId());

		for (LovData lovData : pendingLovData) {
				long originalEntityId = lovData.getOriginalEntityId();
				LovData originalLovData = lovDataLocalService.getLovData(originalEntityId);
				originalLovData.setStatus(WorkflowConstants.STATUS_INACTIVE);
				lovDataLocalService.updateLovData(originalLovData);
				lovData.setStatus(WorkflowConstants.STATUS_APPROVED);
				lovDataLocalService.updateLovData(lovData);
		}

	}


	private void handleDeniedStatus(Lovs lov, ServiceContext serviceContext)
			throws SystemException, PortalException {

		if(lov.getWorkflowAction().equals(Constants.UPDATE_LOV_DATA)||
				lov.getWorkflowAction().equals(Constants.DELETE_LOV_DATA)||
				lov.getWorkflowAction().equals(Constants.ADD_LOV_DATA)) {
			long lovDataId = GetterUtil.getLong(serviceContext.getAttribute("lovDataId"));
			LovData lovData = lovDataLocalService.getLovData(lovDataId);
			lovData.setStatus(WorkflowConstants.STATUS_INACTIVE);
			lovDataLocalService.updateLovData(lovData);
			LOG.info("Denied lov data ID: " + lovDataId);
		}
		else {
			List<LovData> lovdata = lovDataLocalService.findLovDataByLovId(lov.getId());
			for (LovData data : lovdata) {
				data.setStatus(WorkflowConstants.STATUS_INACTIVE);
				lovDataLocalService.updateLovData(data);
				LOG.info("Denied lov data ID: " + data.getId());
			}
		}
	}


	private void startWorkflow(Lovs lov, ServiceContext serviceContext, User user, Long id, String type,String entityType) throws PortalException, JsonProcessingException {

		serviceContext.setAttribute(Constants.ENTITY_TYPE, entityType);
		serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
		serviceContext.setAttribute(Constants.REQUEST_ID, lov.getId());
		serviceContext.setAttribute(Constants.OPERATION_TYPE, type);


		lov.setGroupId(serviceContext.getScopeGroupId());
		lov.setCompanyId(serviceContext.getCompanyId());
		lov.setUserId(serviceContext.getUserId());
		lov.setUserName(user.getFullName());
		lov.setCreateDate(new Date());
		lov.setModifiedDate(new Date());
		lov.setUuid_(PortalUUIDUtil.generate());
		lov.setOriginalEntityId(id);

		if (serviceContext.getScopeGroupId() <= 0) {
			serviceContext.setScopeGroupId(
					GroupLocalServiceUtil.getCompanyGroup(
							serviceContext.getCompanyId()
					).getGroupId()
			);
		}

		lovsPersistence.update(lov);

		AssetEntryLocalServiceUtil.updateEntry(
				serviceContext.getUserId(),
				serviceContext.getScopeGroupId(),
				Lovs.class.getName(),
				lov.getId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames()
		);
		serviceContext.setAssetCategoryIds(null);
		serviceContext.setAssetTagNames(null);

		LOG.info("Starting workflow");
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(),
				serviceContext.getUserId(),
				Lovs.class.getName(),
				lov.getPrimaryKey(),
				lov,
				serviceContext
		);
		LOG.info("Workflow started successfully for LOV ID: " + lov.getId());
	}


	public List<Lovs> getLatestApprovedByChannelId(long channelId) {

		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq(
				"status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Lovs> allApproved =
				lovsPersistence.findWithDynamicQuery(dq);

		Map<Long, Lovs> latestByResource = new LinkedHashMap<>();

		for (Lovs lov : allApproved) {
			if (!latestByResource.containsKey(lov.getEntityResourceId())) {
				latestByResource.put(lov.getEntityResourceId(), lov);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}

	public List<Lovs> getLatestApprovedByChannelIdAndCode(long channelId, String code) {

		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("code", code));
		dq.add(RestrictionsFactoryUtil.eq(
				"status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Lovs> allApproved =
				lovsPersistence.findWithDynamicQuery(dq);

		Map<Long, Lovs> latestByResource = new LinkedHashMap<>();

		for (Lovs lov : allApproved) {
			if (!latestByResource.containsKey(lov.getEntityResourceId())) {
				latestByResource.put(lov.getEntityResourceId(), lov);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}

	public List<Lovs> getByEntityResourceId(long entityResourceId) {
		return lovsPersistence.findByEntityResourceId(entityResourceId);
	}

	public Lovs getLatestApprovedLovByEntityResourceId(long entityResourceId) {
		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		dq.add(RestrictionsFactoryUtil.eq(
				"status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Lovs> allApproved =
				lovsPersistence.findWithDynamicQuery(dq);

		if (!allApproved.isEmpty()) {
			return allApproved.get(0);
		} else {
			return null;
		}
	}

	/**
	 * User Story 5 - Global Component Versioning.
	 *
	 * <p>
	 * An approved change to the LOV component (LOV or LOV data add/update/delete)
	 * bumps the internal {@code lovVersion} version for this company/channel. Runs
	 * in the same transaction as the approval so both succeed or roll back
	 * together.
	 * </p>
	 */
	private void bumpGlobalVersion(Lovs lov) {
		GlobalVersionLocalServiceUtil.incrementApprovedVersion(
				lov.getCompanyId(),
				lov.getChannelId(),
				ComponentType.LOV.name());
	}



}