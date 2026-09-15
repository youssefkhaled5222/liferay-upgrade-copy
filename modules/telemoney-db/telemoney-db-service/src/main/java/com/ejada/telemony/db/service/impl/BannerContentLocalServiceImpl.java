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
import com.ejada.telemoney.db.dto.BannerContentDTO;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.BannerContentLocalServiceUtil;
import com.ejada.telemony.db.service.base.BannerContentLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;

/**
 * The implementation of the banner content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.BannerContentLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalServiceBaseImpl
 */
public class BannerContentLocalServiceImpl extends BannerContentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.BannerContentLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.BannerContentLocalServiceUtil</code>.
	 */

	public BannerContent addBannerContent(BannerContentDTO bannerContentDTO) throws PortalException {

		Banner banner = bannerLocalService.getBanner(bannerContentDTO.getBannerId());
		BannerContent bannerContent = bannerContentPersistence.create(CounterLocalServiceUtil.increment());
		bannerContent.setEntityResourceId(banner.getEntityResourceId());
		bannerContent.setContentOrder(getApprovedByEntityResourceId(banner.getEntityResourceId()).size() + 1);
		bannerContent.setContentName(bannerContentDTO.getContentName());
		bannerContent.setBannerId(bannerContentDTO.getBannerId());
		bannerContent.setContentStatus(bannerContentDTO.getContentStatus());
		bannerContent.setChannelId(bannerContentDTO.getChannelId());
		bannerContent.setDefaultLanguageId(TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
		bannerContent.setStatus(WorkflowConstants.STATUS_DRAFT);
		bannerContent.setOriginalEntityId(bannerContentDTO.getOriginalEntityId());
		bannerContentPersistence.update(bannerContent);
		for (Languages language : languagesLocalService.getbyChannelId(bannerContentDTO.getChannelId())) {
			String langName = language.getLangName();
			BannerContentLocalization contentLocal = bannerContentLocalizationPersistence
					.create(CounterLocalServiceUtil.increment());
			contentLocal.setContentId(bannerContent.getContentId());
			contentLocal.setLanguageId(langName);
			contentLocal.setTitleValue(bannerContentDTO.getTitleValues().get(langName));
			contentLocal.setDescriptionValue(bannerContentDTO.getDescriptionValues().get(langName));
			contentLocal.setBannerImage(bannerContentDTO.getBannerImages().get(langName));
			contentLocal.setImageOverlay(bannerContentDTO.getImageOverlays().get(langName));
			contentLocal.setLinkType(bannerContentDTO.getLinks().get(langName));
			contentLocal.setUrl(bannerContentDTO.getUrls().get(langName));

			this.bannerContentLocalizationPersistence.update(contentLocal);

		}
		return bannerContent;
	}

	public void updateBannerContent(BannerContentDTO bannerContentDTO) {
		BannerContent bannerContent = bannerContentPersistence.fetchByPrimaryKey(bannerContentDTO.getContentId());
		bannerContent.setContentName(bannerContentDTO.getContentName());
		bannerContent.setContentStatus(bannerContentDTO.getContentStatus());
		bannerContent.setChannelId(bannerContentDTO.getChannelId());
		bannerContent.setDefaultLanguageId(TelemoneyConstants.LANGUAGE_ENGLISH_NAME);
		bannerContentPersistence.update(bannerContent);
		for (Languages language : languagesLocalService.getbyChannelId(bannerContentDTO.getChannelId())) {
			String langName = language.getLangName();
			BannerContentLocalization contentLocal = bannerContentLocalizationPersistence
					.fetchByContentId_LanguageId(bannerContentDTO.getContentId(), langName);
			if (contentLocal != null) {
				contentLocal.setTitleValue(bannerContentDTO.getTitleValues().get(langName));
				contentLocal.setDescriptionValue(bannerContentDTO.getDescriptionValues().get(langName));
				if (bannerContentDTO.getBannerImages().get(langName) != null)
					contentLocal.setBannerImage(bannerContentDTO.getBannerImages().get(langName));
				contentLocal.setImageOverlay(bannerContentDTO.getImageOverlays().get(langName));
				contentLocal.setLinkType(bannerContentDTO.getLinks().get(langName));
				contentLocal.setUrl(bannerContentDTO.getUrls().get(langName));

				this.bannerContentLocalizationPersistence.update(contentLocal);
			}
		}
	}

	public void deleteBannerContents(long bannerContentId) {

		try {
			bannerContentLocalizationPersistence.removeByContentId(bannerContentId);
			bannerContentPersistence.remove(bannerContentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBannerContentsWithoutLocalization(long bannerContentId) {
		try {
			bannerContentPersistence.remove(bannerContentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBannerContentLocal(long bannerContentId) {
		List<BannerContentLocalization> bannerContentLocals = bannerContentLocalizationPersistence
				.findByContentId(bannerContentId);
		for (BannerContentLocalization banncerContentLocal : bannerContentLocals) {
			bannerContentLocalizationPersistence.remove(banncerContentLocal);
		}
	}

	public List<BannerContent> getAllBannerContents() {
		return bannerContentPersistence.findAll();
	}

	/*
	 * public void editOrder(int contentOrder) throws NoSuchBannerContentException {
	 * DynamicQuery query = DynamicQueryFactoryUtil.forClass(BannerContent.class,
	 * getClassLoader()); query.add(RestrictionsFactoryUtil.ge("contentOrder",
	 * contentOrder)); List<BannerContent> result =
	 * BannerContentLocalServiceUtil.dynamicQuery(query);
	 * System.out.println("Edit Order: " + result); for (BannerContent bannerContent
	 * : result) { updateBannerContent(bannerContent.getBannerId(), null,
	 * bannerContent.getContentOrder() + 1); } }
	 * 
	 * public int getMaxOrder() { DynamicQuery query =
	 * DynamicQueryFactoryUtil.forClass(BannerContent.class, getClassLoader());
	 * query.setProjection(PropertyFactoryUtil.forName("contentOrder").max());
	 * List<Integer> result = BannerContentLocalServiceUtil.dynamicQuery(query);
	 * System.out.println("getMaxOrder: " + result); if (!result.isEmpty()) return
	 * result.get(0); return 0;
	 * 
	 * }
	 */

	public List<BannerContent> getByBannerId(long bannerId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(BannerContent.class, getClassLoader());
		query.add(PropertyFactoryUtil.forName("bannerId").eq(bannerId));
		query.addOrder(PropertyFactoryUtil.forName("contentOrder").asc());
		List<BannerContent> result = BannerContentLocalServiceUtil.dynamicQuery(query);
		return result;
	}
	public List<BannerContent> getApprovedByEntityResourceId(long entityResourceId) {

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				BannerContent.class, getClassLoader());

		query.add(PropertyFactoryUtil.forName("entityResourceId").eq(entityResourceId));

		query.add(PropertyFactoryUtil.forName("status")
				.eq(WorkflowConstants.STATUS_APPROVED));

		return BannerContentLocalServiceUtil.dynamicQuery(query);
	}





	public void updateContentOrder(BannerContent bannerContent) {
		bannerContentPersistence.update(bannerContent);
	}

	public List<BannerContent> getByEntityResourceIdAndStatusApproved(long entityResourceId) {

		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		dq.add(RestrictionsFactoryUtil.eq(
				"status", WorkflowConstants.STATUS_APPROVED));
		dq.addOrder(PropertyFactoryUtil.forName("contentOrder").asc());


		return dynamicQuery(dq);
	}

	public List<BannerContent> getByEntityResourceId(long entityResourceId) {
		return bannerContentPersistence.findByEntityResourceId(entityResourceId);
	}



}