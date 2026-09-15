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
import com.ejada.telemony.db.model.Languages;
import com.ejada.telemony.db.model.LovData;
import com.ejada.telemony.db.model.LovDataLocalization;
import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.model.impl.LovDataImpl;
import com.ejada.telemony.db.service.LovDataLocalServiceUtil;
import com.ejada.telemony.db.service.base.LovDataLocalServiceBaseImpl;
import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import com.ejada.telemony.db.mapper.LovDataMapper;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the lov data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.LovDataLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalServiceBaseImpl
 */
public class LovDataLocalServiceImpl extends LovDataLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.LovDataLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.LovDataLocalServiceUtil</code>.
	 */



	private static final Log LOG = LogFactoryUtil.getLog(LovDataLocalServiceImpl.class);



    public LovData lovDataCreate(Long lovId, String lovType, String recordTypeCode, Map<String, String> values,
			String recordShortDescription, Long channelId,Long originalLovDataId) throws Exception {
		try {
			Lovs lovs = lovsLocalService.getLovs(lovId);
			LovData createLovData = lovDataLocalService.createLovData(CounterLocalServiceUtil.increment());
			createLovData.setLovId(lovId);
			createLovData.setDefaultLanguageId(null);
			createLovData.setLovType(lovType);
			createLovData.setRecordTypeCode(recordTypeCode);
			createLovData.setRecordShortDescription(recordShortDescription);
			createLovData.setStatus(WorkflowConstants.STATUS_DRAFT);
			createLovData.setOriginalEntityId(originalLovDataId);
			createLovData.setEntityResourceId(lovs.getEntityResourceId());

			for (Languages language : languagesPersistence.findByChannelId(channelId)) {
				String langName = language.getLangName();
				LovDataLocalization lovDataLocal = lovDataLocalizationPersistence
						.create(counterLocalService.increment());
				lovDataLocal.setId(createLovData.getId());
				lovDataLocal.setLovIdLocalization(lovId.toString());
				lovDataLocal.setLanguageId(langName);
				if(values!=null){
				lovDataLocal.setRecordDescription(values.get(langName));}
				lovDataLocalizationPersistence.update(lovDataLocal);
			}
			LovDataLocalServiceUtil.updateLovData(createLovData);
			return createLovData;
		} catch (Exception e) {
			LOG.info("----------------Lov Data Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public void lovDataUpdate(Long id, Long lovId, String lovType, String recordTypeCode, Map<String, String> values,
			String recordShortDescription, Long channelId) throws Exception {
		LovData updateLovData;
		try {

			updateLovData = lovDataLocalService.getLovData(id);
			updateLovData.setDefaultLanguageId(null);
			updateLovData.setLovId(lovId);
			updateLovData.setLovType(lovType);
			updateLovData.setRecordTypeCode(recordTypeCode);
			updateLovData.setRecordShortDescription(recordShortDescription);
			LovDataLocalization lovDataLocal = null;
			for (Languages language : languagesPersistence.findByChannelId(channelId)) {
				String langName = language.getLangName();
				lovDataLocal = lovDataLocalizationPersistence.fetchById_LanguageId(id, langName);
				if (lovDataLocal != null) {
					lovDataLocal.setRecordDescription(values.get(langName));
					lovDataLocal.setLovIdLocalization(lovId.toString());
					lovDataLocal.setId(lovDataLocal.getId());
					lovDataLocal.setLanguageId(lovDataLocal.getLanguageId());
				} else {
					lovDataLocal = lovDataLocalizationPersistence.create(counterLocalService.increment());
					lovDataLocal.setId(updateLovData.getId());
					lovDataLocal.setLovIdLocalization(lovId.toString());
					lovDataLocal.setLanguageId(langName);
					lovDataLocal.setRecordDescription(values.get(langName));
				}
				lovDataLocalizationPersistence.update(lovDataLocal);
				// lovDataLocalizationPersistence.clearCache();
			}
			LovDataLocalServiceUtil.updateLovData(updateLovData);
			// lovDataPersistence.clearCache();

		} catch (Exception e) {
			LOG.info("----------------Lov Data Update Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public void lovDataDelete(Long id, Long channelId) throws Exception {
		LovData deleteLovData;
		LovDataLocalization dataDescLocalization = null;
		try {
			for (Languages language : languagesLocalService.getbyChannelId(channelId)) {
				String name = language.getLangName();
				dataDescLocalization = lovDataLocalizationPersistence.fetchById_LanguageId(id, name);
				if (dataDescLocalization != null){
				lovDataLocalizationPersistence.remove(dataDescLocalization);
				}
			}

			deleteLovData = lovDataLocalService.getLovData(id);
			lovDataLocalService.deleteLovData(deleteLovData);

		} catch (Exception e) {
			LOG.info("----------------Lov Data Delete Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public List<LovData> findLovDataByLovId(Long lovId) {

		List<LovData> data = new ArrayList<LovData>();

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LovData.class, getClassLoader());

			dynamicQuery.add(RestrictionsFactoryUtil.eq("lovId", lovId));

			data = LovDataLocalServiceUtil.dynamicQuery(dynamicQuery) != null
					&& (LovDataLocalServiceUtil.dynamicQuery(dynamicQuery)).size() != 0
							? LovDataLocalServiceUtil.dynamicQuery(dynamicQuery)
							: new ArrayList<LovData>();

		} catch (SystemException e) {
			// Handle exception
		}
		return data;
	}

	public List<LovData> findLovDataByLovIdAndStatus(Long lovId, int status) {

		List<LovData> data = new ArrayList<LovData>();

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LovData.class, getClassLoader());

			dynamicQuery.add(RestrictionsFactoryUtil.eq("lovId", lovId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("status", status));

			data = LovDataLocalServiceUtil.dynamicQuery(dynamicQuery) != null
					&& (LovDataLocalServiceUtil.dynamicQuery(dynamicQuery)).size() != 0
							? LovDataLocalServiceUtil.dynamicQuery(dynamicQuery)
							: new ArrayList<LovData>();

		} catch (SystemException e) {
			// Handle exception
		}
		return data;
	}

	public List<LovData> findLovDataByLovIdWithPersistence(Long lovId) {
		try {
			List<LovData> data = lovDataPersistence.findByLovdata(lovId) != null
					&& lovDataPersistence.findByLovdata(lovId).size() != 0 ? lovDataPersistence.findByLovdata(lovId)
							: new ArrayList<LovData>();
			return data;
		} catch (SystemException e) {
			LOG.error("Error while fetching LovData", e);
			return Collections.emptyList();
		}
	}

	public List<LovData> findLovDataByLovIdAndRecordShortDescriptione(Long lovId, String recordShortDescription) {
		try {
			List<LovData> data = lovDataPersistence.findBylovIdAndRecordShortDescription(lovId,
					recordShortDescription) != null
					&& lovDataPersistence.findBylovIdAndRecordShortDescription(lovId, recordShortDescription)
							.size() != 0
									? lovDataPersistence.findBylovIdAndRecordShortDescription(lovId,
											recordShortDescription)
									: new ArrayList<LovData>();
			return data;
		} catch (SystemException e) {
			LOG.error("Error while fetching LovData with short description", e);
			return Collections.emptyList();
		}
	}

	public void updateLovDataByLovId(Long lovId,Lovs draftLov) {
		// Check if the lovId is null or less than or equal to 0
		if (lovId == null || lovId <= 0) {
			throw new IllegalArgumentException("Invalid lovId: " + lovId);
		}

		// Retrieve LOVDATA objects based on the given lovId
		List<LovData> lovDataList = this.lovDataPersistence.findByLovdata(lovId);
		if (lovDataList == null) {
			lovDataList = new ArrayList<>();
		}

		try {
			Lovs lovList = lovsLocalService.getLovs(lovId);

			// Check if the LOVLIST object is not null before proceeding
			if (lovList != null) {
				String lovType = lovList.getName("English");

				for (LovData lovData : lovDataList) {
					LovData draftLovData = lovDataCreate(draftLov.getId(), lovType, lovData.getRecordTypeCode(), null,
							lovData.getRecordShortDescription(), draftLov.getChannelId(), lovData.getId());
					draftLovData.setLovType(lovType);
					lovDataLocalService.updateLovData(draftLovData);
					for (Languages language : languagesPersistence.findByChannelId(draftLov.getChannelId())) {
						LovDataLocalization lovDataLocalization = lovDataLocalizationPersistence.fetchById_LanguageId(lovData.getId(), language.getLangName());
						LovDataLocalization draftLovDataLocalization = lovDataLocalizationPersistence.fetchById_LanguageId(draftLovData.getId(), language.getLangName());
						if (lovDataLocalization != null) {
							LovDataMapper.copyOriginalLocalizationToDraft(lovDataLocalization, draftLovDataLocalization);
							lovDataLocalizationPersistence.update(draftLovDataLocalization);
						}
					}
				}
			} else {
				System.out.println("LOVLIST object is null for lovId: " + lovId);
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	public void deleteLovDataByLovId(Long lovId, Long channelId) {

		// Check if the lovId is null or less than or equal to 0
		if (lovId == null || lovId <= 0) {
			throw new IllegalArgumentException("Invalid lovId: " + lovId);
		}

		// Retrieve LOVDATA objects based on the given lovId
		List<LovData> lovDataList = this.lovDataPersistence.findByLovdata(lovId);
		if (lovDataList == null) {
			lovDataList = new ArrayList<>();
		}

		try {
			LovDataLocalization dataDescLocalization = null;
			Lovs lovList = lovsLocalService.getLovs(lovId);
			if (lovList != null) {
				for (LovData data : lovDataList) {
					for (Languages language : languagesLocalService.getbyChannelId(channelId)) {
						String name = language.getLangName();
						dataDescLocalization = lovDataLocalizationPersistence.fetchById_LanguageId(data.getId(), name);
						if (dataDescLocalization != null){
						lovDataLocalizationPersistence.remove(dataDescLocalization);
						}
					}
					lovDataLocalService.deleteLovData(data);
				}

				// Check if the LOVLIST object is not null before proceeding

			} else {
				System.out.println("LOVLIST object is null for lovId: " + lovId);
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}

	public List<LovData> search(String searchName, String searchBy,Long entityResourceId) throws IOException, PortletException {

		List<LovData> data = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LovData.class, getClassLoader());


			dynamicQuery.add(PropertyFactoryUtil.forName("recordTypeCode").like("%" + searchName + "%"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(
					"status", WorkflowConstants.STATUS_APPROVED));

			dynamicQuery.addOrder(OrderFactoryUtil.asc("entityResourceId"));

			data = LovDataLocalServiceUtil.dynamicQuery(dynamicQuery);

			Map<Long, LovData> latestByResource = new LinkedHashMap<>();
			for (LovData lovData : data) {
				if (!latestByResource.containsKey(lovData.getEntityResourceId())) {
					latestByResource.put(lovData.getEntityResourceId(), lovData);
				}
			}

			return new ArrayList<>(latestByResource.values());

		} catch (SystemException e) {
			// Handle exception
		}
		return data;
	}

	public List<LovData> searchLovDataLocalizationByDescription(String searchName, String lovId)
			throws IOException{
		List<LovData> lovData = new ArrayList<>();
		Session session = null;
		try {

			String sql ="SELECT DISTINCT ld.* " +
					"FROM LOVS l " +
					"JOIN LOVDATA ld ON ld.entityResourceId = l.entityResourceId " +
					"JOIN LOVDATALocalization ll ON ll.id_ = ld.id " +
					"WHERE l.id = ? " +
					"AND ld.status = ? " +
					"AND ll.languageId = ? " +
					"AND LOWER(ll.recordDescription) LIKE ?";

			session = lovDataPersistence.openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ld", LovDataImpl.class);

			query.setLong(0, Long.parseLong(lovId));
			query.setInteger(1, WorkflowConstants.STATUS_APPROVED);
			query.setString(2, "English");
			query.setString(3, "%" + searchName.toLowerCase() + "%");

			@SuppressWarnings("unchecked")
			List<LovData> results = query.list();
			lovData = results;

		} catch (Exception e) {
			LOG.info("Error in lovDataLocalSearchByName: " + e.getMessage(), e);
		} finally {
			if (session != null) {
				lovDataPersistence.closeSession(session);
			}
		}
		return lovData;
	}

	public List<LovData> getLovDataByTypeCodeAndLovCodeAndStatus(String lovCode, String typeCode,Long entityResourceId,int status) {
		return lovDataPersistence.findByDataTypeCodeAndLovCodeAndStatus(lovCode, typeCode,entityResourceId,status);
	}



	public List<LovData> getByEntityResourceIdAndStatusApproved(long lovId) {
		Lovs lov = null;
		try {
			lov = lovsLocalService.getLovs(lovId);
		} catch (Exception e) {
			LOG.info("----------------Lov Not Found-----------------");
		}
		if (lov != null) {
			DynamicQuery dq = dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("entityResourceId", lov.getEntityResourceId()));
			dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));

			return dynamicQuery(dq);
		} else {
			return new ArrayList<LovData>();
		}
	}



	public int countByResourceIdAndApproved(long resourceId) {
		DynamicQuery dynamicQuery = dynamicQuery();

		dynamicQuery.add(
				PropertyFactoryUtil.forName("entityResourceId").eq(resourceId)
		);

		dynamicQuery.add(
				PropertyFactoryUtil.forName("status")
						.eq(WorkflowConstants.STATUS_APPROVED)
		);

		return (int) dynamicQueryCount(dynamicQuery);
	}

	public List<LovData> findByEntityResourceId(long entityResourceId) {
		return lovDataPersistence.findByEntityResourceId(entityResourceId);
	}

}