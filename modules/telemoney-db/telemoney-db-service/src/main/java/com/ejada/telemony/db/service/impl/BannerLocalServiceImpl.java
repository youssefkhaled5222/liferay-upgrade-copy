/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemoney.db.dto.BannerContentDTO;
import com.ejada.telemoney.db.dto.importDtos.BannerImportDTO;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.BannerContent;
import com.ejada.telemoney.db.dto.BlockDTO;
import com.ejada.telemony.db.mapper.BannerContentMapper;
import com.ejada.telemony.db.mapper.BannerMapper;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.service.BannerLocalServiceUtil;
import com.ejada.telemony.db.service.base.BannerLocalServiceBaseImpl;
import com.ejada.telemony.db.service.util.DateCheckUtil;
import com.ejada.telemony.db.model.ImportRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import javax.portlet.ActionRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The implementation of the banner local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.BannerLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerLocalServiceBaseImpl
 */
public class BannerLocalServiceImpl extends BannerLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use
     * <code>com.ejada.telemony.db.service.BannerLocalService</code> via injection
     * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
     * <code>com.ejada.telemony.db.service.BannerLocalServiceUtil</code>.
     */
    private static final Log LOG = LogFactoryUtil.getLog(BannerLocalServiceImpl.class);


    public void deleteBanners(long selectedBannerId) {
        try {
            LOG.info("Deleted banner ID: " + selectedBannerId);
            List<BannerContent> bannerContents = bannerContentLocalService.getByBannerId(selectedBannerId);
            for (BannerContent bannerContent : bannerContents) {
                bannerContentLocalService.deleteBannerContents(bannerContent.getContentId());
                LOG.info("Deleted banner content ID: " + bannerContent.getContentId());
            }
            Banner banner = bannerPersistence.fetchByPrimaryKey(selectedBannerId);
            if (banner.getBlockId() != 0) {
                try {
                    Blocks block = blocksLocalService.deleteBlocks(banner.getBlockId());
                    LOG.info("Deleted block ID: " + block.getBlockId());
                } catch (Exception e) {
                    LOG.info("Block not found for deletion: " + banner.getBlockId());
                }
            }
            bannerLocalService.deleteBanner(selectedBannerId);
        } catch (PortalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteBannersWorkflow(long selectedBannerId, ServiceContext serviceContext, User user) {
        try {
            Banner originalBanner = bannerPersistence.fetchByPrimaryKey(selectedBannerId);
            Banner trashBanner = this.bannerPersistence.create(counterLocalService.increment());
            copyProperties(originalBanner, trashBanner);
            trashBanner.setStatus(WorkflowConstants.STATUS_DRAFT);
            trashBanner.setOriginalEntityId(originalBanner.getBannerId());
            trashBanner.setEntityResourceId(originalBanner.getEntityResourceId());
            trashBanner.setVersion(getMaxVersion(originalBanner.getEntityResourceId()) + 1);
            trashBanner.setWorkflowAction(Constants.DELETE_BANNER);
            this.bannerPersistence.update(trashBanner);
            startWorkflow(trashBanner, serviceContext, user, originalBanner.getBannerId(), Constants.DELETE,Constants.BANNER);

        } catch (PortalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleDeleteBannerContent(BannerContent originalBannerContent ,ServiceContext serviceContext,User user) throws PortalException, JsonProcessingException {
        BannerContent draftBannerContent = bannerContentPersistence.create(CounterLocalServiceUtil.increment());
        copyProperties(originalBannerContent,draftBannerContent);
        draftBannerContent.setStatus(WorkflowConstants.STATUS_DRAFT);
        draftBannerContent.setOriginalEntityId(originalBannerContent.getContentId());
        draftBannerContent.setEntityResourceId(originalBannerContent.getEntityResourceId());
        bannerContentPersistence.update(draftBannerContent);

        for (Languages language : languagesLocalService.getbyChannelId(originalBannerContent.getChannelId())) {
            String langName = language.getLangName();
            BannerContentLocalization originalContentLocal = bannerContentLocalizationPersistence
                    .fetchByContentId_LanguageId(
                            originalBannerContent.getContentId(), langName);
            BannerContentLocalization trashContentLocal = bannerContentLocalizationPersistence
                    .create(CounterLocalServiceUtil.increment());
            copyLocalizationProperties(originalContentLocal,trashContentLocal);
            trashContentLocal.setContentId(draftBannerContent.getContentId());
            trashContentLocal.setLanguageId(langName);
            bannerContentLocalizationPersistence.update(trashContentLocal);
        }

        updateBannerContentWithLocalization(originalBannerContent.getBannerId(),draftBannerContent,serviceContext,user,Constants.DELETE);

    }

    public void addNewBannerWithLocalization(long channelId, String bannerName, String bannerType, String container,
                                             Date dateFrom, Date dateTo, BlockDTO block, String persona, ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {

        Banner banner = createBannerEntity(channelId, bannerName, bannerType, container, dateFrom, dateTo, persona,block,Constants.ADD_BANNER);
        banner.setEntityResourceId(banner.getBannerId());
        banner.setVersion(getMaxVersion(banner.getEntityResourceId())+1);
        this.bannerPersistence.update(banner);
        startWorkflow(banner, serviceContext, user, 0L, Constants.CREATE, Constants.BANNER);
    }

    public void updateBannerWithLocalization(long channelId, String bannerName, String bannerType, String container,
                                             Date dateFrom, Date dateTo, BlockDTO block, Long bannerId, String persona, ServiceContext serviceContext, User user, ActionRequest actionRequest) throws PortalException, JsonProcessingException {
        Banner existingBanner = bannerLocalService.getBanner(bannerId);
        boolean isBannerContentOrderChanged = hasBannerContentOrderChanges(existingBanner.getEntityResourceId(), actionRequest);

        boolean isBannerUpdated = isBannerUpdated(bannerId, channelId, bannerName, bannerType, container, dateFrom, dateTo, block, persona,existingBanner);


        if (isBannerUpdated || isBannerContentOrderChanged) {
            Banner draftBanner = createBannerEntity(channelId, bannerName, bannerType, container, dateFrom, dateTo, persona,block,Constants.UPDATE_BANNER);
            draftBanner.setEntityResourceId(existingBanner.getEntityResourceId());
            draftBanner.setVersion(getMaxVersion(existingBanner.getEntityResourceId()) + 1);
            this.bannerPersistence.update(draftBanner);
            if(isBannerContentOrderChanged)
            {
                applyBannerContentOrderChanges(existingBanner.getEntityResourceId(), actionRequest,draftBanner);

            }
            startWorkflow(draftBanner, serviceContext, user, bannerId, Constants.UPDATE, Constants.BANNER);
        } else {
            LOG.info("----------------No Changes in Banner-----------------");
        }
    }

    private Banner createBannerEntity(long channelId, String bannerName, String bannerType, String container,
                                      Date dateFrom, Date dateTo, String persona,BlockDTO block,String workflowAction) throws PortalException {
        Banner banner = this.bannerPersistence.create(counterLocalService.increment());
        banner.setChannelId(channelId);
        banner.setBannerName(bannerName);
        banner.setBannerType(bannerType);
        banner.setContainer(container);
        banner.setDateFrom(dateFrom);
        banner.setDateTo(dateTo);
        banner.setPersona(persona);
        banner.setWorkflowAction(workflowAction);
        Blocks createdBlock = createBlockEntity(block);
        banner.setBlockId(createdBlock.getBlockId());
        return  banner;

    }

    private void updateBannerContentWithLocalization(Long bannerId, BannerContent bannerContent, ServiceContext serviceContext, User user,String action) throws PortalException, JsonProcessingException {

        Banner banner = bannerPersistence.fetchByPrimaryKey(bannerId);

        //only just to start workflow with new banner instance
        Banner draftBanner = this.bannerPersistence.create(counterLocalService.increment());
        copyProperties(banner, draftBanner);
        draftBanner.setOriginalEntityId((banner.getBannerId()));
        draftBanner.setStatus(WorkflowConstants.STATUS_DRAFT);
        draftBanner.setEntityResourceId(banner.getEntityResourceId());
        draftBanner.setVersion(getMaxVersion(banner.getEntityResourceId()) + 1);
        if(action.equals(Constants.DELETE)){
            draftBanner.setWorkflowAction(Constants.DELETE_BANNER_CONTENT);
        } else if(action.equals(Constants.CREATE)){
            draftBanner.setWorkflowAction(Constants.ADD_BANNER_CONTENT);
        } else {
            draftBanner.setWorkflowAction(Constants.UPDATE_BANNER_CONTENT);
        }
        bannerContent.setBannerId(draftBanner.getBannerId());
        this.bannerContentPersistence.update(bannerContent);
        this.bannerPersistence.update(draftBanner);

        LOG.info("Banner Content ID for Workflow: " + bannerContent.getContentId() + ", Banner ID: " + draftBanner.getBannerId());


        serviceContext.setAttribute("bannerContentId", String.valueOf(bannerContent.getContentId()));
        startWorkflow(draftBanner, serviceContext, user, banner.getBannerId(), action, Constants.BANNER_CONTENT);
    }

    public List<Banner> checkBlockDate(List<Banner> banners, Date curDate, String version, String platform) {
        List<Banner> results = new ArrayList<>();
        for (Banner banner : banners) {
            long blockId = banner.getBlockId();
            Blocks block = blocksPersistence.fetchByPrimaryKey(blockId);
            if (block != null) {
                if (platform.equals("android") && block.getAndroidBlock()
                        && block.getAndroidBlockVersion().equals(version)) {
                    if (block.getAndroidBlockFrom().compareTo(curDate)
                            * block.getAndroidBlockTo().compareTo(curDate) > 0)
                        results.add(banner);
                } else if (platform.equals("ios") && block.getIosBlock()
                        && block.getIosBlockVersion().equals(version)) {
                    if (block.getIosBlockFrom().compareTo(curDate) * block.getIosBlockTo().compareTo(curDate) > 0)

                        results.add(banner);
                } else if (platform.equals("web") && block.getWebBlock()
                        && block.getWebBlockVersion().equals(version)) {
                    if (block.getWebBlockFrom().compareTo(curDate) * block.getWebBlockTo().compareTo(curDate) > 0)

                        results.add(banner);
                } else
                    results.add(banner);

            }
        }
        return results;
    }

    public JSONArray getBannerContentsAPI(List<Banner> banners, String langName) {
        JSONArray bannersArray = JSONFactoryUtil.createJSONArray();
        for (Banner banner : banners) {
            JSONObject bannerJson = JSONFactoryUtil.createJSONObject();
            bannerJson.put("bannerName", banner.getBannerName());
            bannerJson.put("container", banner.getContainer());
            bannerJson.put("bannerType", banner.getBannerType());
            List<BannerContent> bannerContents = bannerContentLocalService.getByEntityResourceIdAndStatusApproved(banner.getEntityResourceId());
            JSONArray bannerContentsArray = JSONFactoryUtil.createJSONArray();
            for (BannerContent bannerContent : bannerContents) {
                JSONObject bannerContentJson = JSONFactoryUtil.createJSONObject();
                bannerContentJson.put("contentName", bannerContent.getContentName());
                bannerContentJson.put("contentOrder", bannerContent.getContentOrder());
                bannerContentJson.put("contentStatus", bannerContent.getContentStatus());
                BannerContentLocalization bannerContentLocal = bannerContentLocalizationPersistence
                        .fetchByContentId_LanguageId(bannerContent.getContentId(), langName);
                if (bannerContentLocal != null) {
                    bannerContentJson.put("title", bannerContentLocal.getTitleValue());
                    bannerContentJson.put("description", bannerContentLocal.getDescriptionValue());
                    bannerContentJson.put("bannerImage", bannerContentLocal.getBannerImage());
                    bannerContentJson.put("imageOverlay", bannerContentLocal.getImageOverlay());
                    bannerContentJson.put("linkType", bannerContentLocal.getLinkType());
                    bannerContentJson.put("url", bannerContentLocal.getUrl());
                }
                bannerContentsArray.put(bannerContentJson);
            }
            bannerJson.put("contents", bannerContentsArray);
            bannersArray.put(bannerJson);
        }
        return bannersArray;
    }

    public JSONArray getBannersAPI(long channelId, String languageName, String platform, long personaId, int version)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0); // Set the hour to midnight
        calendar.set(Calendar.MINUTE, 0); // Set the minute to 0
        calendar.set(Calendar.SECOND, 0); // Set the second to 0
        calendar.set(Calendar.MILLISECOND, 0); // Set the millisecond to 0
        // Convert the Calendar instance to a Date
        Date curDate = calendar.getTime();

        // String checkDate = "GETDATE() BETWEEN dateFrom AND dateTo";
        List<Languages> lang = languagesLocalService.getByLangName(languageName, channelId);
        if (lang.size() < 1)
            throw new Exception(languageName + " is not found in languages table");

        String langName = lang.get(0).getLangName();
        Persona persona = personaPersistence.fetchByPrimaryKey(personaId);
        List<Persona> personas = personaLocalService.getApprovedByEntityResourceId(persona.getEntityResourceId());

        List<String> allPersonaIds = personas.stream()
                .map(p -> String.valueOf(p.getPersonaId()))
                .collect(Collectors.toList());

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Banner.class, getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        query.add(RestrictionsFactoryUtil.le("dateFrom", curDate));
        query.add(RestrictionsFactoryUtil.ge("dateTo", curDate));
        query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
        Criterion personaCriteria = null;
        for (String pid : allPersonaIds) {
            Criterion c = RestrictionsFactoryUtil.like("persona", "%\"" + pid + "\"%");
            personaCriteria = (personaCriteria == null) ? c : RestrictionsFactoryUtil.or(personaCriteria, c);
        }
        if (personaCriteria != null) {
            query.add(personaCriteria);
        }
        List<Banner> results = BannerLocalServiceUtil.dynamicQuery(query);

        Map<Long, Banner> latestByEntityResource = new HashMap<>();
        for (Banner banner : results) {
            long entityResId = banner.getEntityResourceId();
            Banner existing = latestByEntityResource.get(entityResId);
            if (existing == null || banner.getVersion() > existing.getVersion()) {
                latestByEntityResource.put(entityResId, banner);
            }
        }

        List<Banner> latestResults = new ArrayList<>(latestByEntityResource.values());
        List<Banner> finalResults = checkBlockDate(latestResults, curDate, String.valueOf(version), platform);



        return getBannerContentsAPI(finalResults, langName);
    }

    public List<Banner> getbyChannelId(Long channelId) {
        return bannerPersistence.findByChannelIdAndStatus(channelId, 0);
    }

    private void startWorkflow(Banner banner, ServiceContext serviceContext, User user, Long id, String type, String entityType) throws PortalException, JsonProcessingException {

         banner =enrichWorkflow(banner, serviceContext, user, id,null);


        serviceContext.setAttribute(Constants.ENTITY_TYPE, entityType);
        serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
        serviceContext.setAttribute(Constants.REQUEST_ID, banner.getBannerId());
        serviceContext.setAttribute(Constants.OPERATION_TYPE, type);


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
                Banner.class.getName(),
                banner.getBannerId(),
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames()
        );

        serviceContext.setAssetCategoryIds(null);
        serviceContext.setAssetTagNames(null);

        LOG.info("Starting workflow");
        WorkflowHandlerRegistryUtil.startWorkflowInstance(
                serviceContext.getCompanyId(),
                serviceContext.getUserId(),
                Banner.class.getName(),
                banner.getPrimaryKey(),
                banner,
                serviceContext
        );
        LOG.info("Workflow started successfully for Banner ID: " + banner.getBannerId());

    }

    private Banner enrichWorkflow(Banner banner, ServiceContext serviceContext, User user, Long id,ImportRequest importRequest)
    {
        if (serviceContext !=null){
        banner.setGroupId(serviceContext.getScopeGroupId());
        banner.setCompanyId(serviceContext.getCompanyId());
        banner.setUserId(serviceContext.getUserId());
        }
        else
        {
            banner.setGroupId(importRequest.getGroupId());
            banner.setCompanyId(importRequest.getCompanyId());
            banner.setUserId(importRequest.getUserId());
            banner.setImportRequestId(importRequest.getId());
        }
        banner.setStatus(WorkflowConstants.STATUS_DRAFT);
        banner.setUserName(user.getFullName());
        banner.setCreateDate(new Date());
        banner.setModifiedDate(new Date());
        banner.setUuid_(PortalUUIDUtil.generate());
        banner.setOriginalEntityId(id);

        return BannerLocalServiceUtil.updateBanner(banner);
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
    private boolean hasBannerContentOrderChanges(long entityResourceId, ActionRequest actionRequest) {
        List<BannerContent> bannerContents =
                bannerContentLocalService.getByEntityResourceIdAndStatusApproved(entityResourceId);

        for (BannerContent bannerContent : bannerContents) {
            int newOrder = ParamUtil.getInteger(
                    actionRequest,
                    bannerContent.getContentName() + "TargetOrder"
            );

            if (newOrder > 0 && newOrder != bannerContent.getContentOrder()) {
                LOG.info("Change detected for Banner Content ID: " + bannerContent.getContentId());
                return true;
            }
        }

        LOG.info("No banner content order changes detected for banner with resource Id: " + entityResourceId);
        return false;
    }

    private void applyBannerContentOrderChanges(long entityResourceId, ActionRequest actionRequest,Banner banner) {
        List<BannerContent> bannerContents =
                bannerContentLocalService.getByEntityResourceIdAndStatusApproved(entityResourceId);

        for (BannerContent bannerContent : bannerContents) {
            int newOrder = ParamUtil.getInteger(
                    actionRequest,
                    bannerContent.getContentName() + "TargetOrder"
            );

            if (newOrder > 0 && newOrder != bannerContent.getContentOrder()) {

                LOG.info("Creating edit entity for Banner Content ID: " + bannerContent.getContentId());

                BannerContent editedBannerContent =
                        bannerContentPersistence.create(CounterLocalServiceUtil.increment());

                copyProperties(bannerContent, editedBannerContent);
                editedBannerContent.setContentOrder(newOrder);

                editedBannerContent.setOriginalEntityId(bannerContent.getContentId());
                editedBannerContent.setStatus(WorkflowConstants.STATUS_DRAFT);
                editedBannerContent.setBannerId(banner.getBannerId());
                editedBannerContent.setEntityResourceId(bannerContent.getEntityResourceId());

                bannerContentLocalService.updateContentOrder(editedBannerContent);

                LOG.info("Updated content order to " + newOrder +
                        " for edited Banner Content ID: " + editedBannerContent.getContentId());


                for (Languages language : languagesLocalService.getbyChannelId(bannerContent.getChannelId())) {
                    String langName = language.getLangName();
                    BannerContentLocalization originalContentLocal = bannerContentLocalizationPersistence
                            .fetchByContentId_LanguageId(
                                    bannerContent.getContentId(), langName);
                    BannerContentLocalization editedContentLocal = bannerContentLocalizationPersistence
                            .create(CounterLocalServiceUtil.increment());
                    copyLocalizationProperties(originalContentLocal,editedContentLocal);
                    editedContentLocal.setContentId(editedBannerContent.getContentId());
                    editedContentLocal.setLanguageId(langName);
                    bannerContentLocalizationPersistence.update(editedContentLocal);
                }
            }
        }
    }



    public void handleBannerContent(BannerContentDTO bannerContentDTO, ServiceContext serviceContext, User user) throws PortalException, JsonProcessingException {
        //New Banner Content
        BannerContent content;
        String action;
        if (bannerContentDTO.getContentId() == 0) {
            // This is a new banner content being added
            content = bannerContentLocalService.addBannerContent(bannerContentDTO);
            action = Constants.CREATE;
        } else {
            BannerContent originalContent = bannerContentLocalService.getBannerContent(bannerContentDTO.getOriginalEntityId());
            if (isBannerContentUpdated(bannerContentDTO,originalContent)) {
                 LOG.info("----------------Changes found in Banner Content-----------------");
                 content =  bannerContentLocalService.addBannerContent(bannerContentDTO);
                 content.setContentOrder(originalContent.getContentOrder());
                 action = Constants.UPDATE;
            } else {
                LOG.info("----------------No Changes in Banner Content-----------------");
                return;
            }
        }
        updateBannerContentWithLocalization(content.getBannerId(),content, serviceContext, user, action);
    }


    public void handleBannerContentWithoutWorkflow(BannerContentDTO bannerContentDTO) throws PortalException {
        BannerContent content;
        if (bannerContentDTO.getContentId() == 0) {
            content = bannerContentLocalService.addBannerContent(bannerContentDTO);
            content.setStatus(WorkflowConstants.STATUS_APPROVED);
            bannerContentPersistence.update(content);
        }
    }



    public Banner updateStatus(long userId, long bannerId, int status,
                               ServiceContext serviceContext) throws PortalException, SystemException, JsonProcessingException {


        if (status != WorkflowConstants.STATUS_APPROVED && status != WorkflowConstants.STATUS_DENIED) {
            LOG.info("Banner ID " + bannerId + " is still pending approval");
            return null;
        }


        Banner banner = bannerPersistence.findByPrimaryKey(bannerId);
        banner.setModifiedDate(new Date());
        banner.setStatus(status);
        banner.setStatusByUserId(userId);
        if (userId > 0) {
            banner.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
        }
        banner.setStatusDate(new Date());

        String operationType = banner.getWorkflowAction();
        LOG.info("Updating status for Banner ID: " + bannerId + " to " + status + " with operation type: " + operationType);

        // Process based on workflow status
        if (status == WorkflowConstants.STATUS_APPROVED) {
            handleApprovedStatus(banner, serviceContext, operationType);
        } else {
            handleDeniedStatus(banner, serviceContext);
        }
        if(!operationType.equals(Constants.DELETE_BANNER)) {
            bannerPersistence.update(banner);
        }
        return banner;
    }

    /* ---------------------------------------- Helpers ---------------------------------------- */

    private void copyProperties(Banner source, Banner target) {
        BannerMapper.copyDraftToOriginal(source,target);
    }

    private void copyProperties(BannerContent source, BannerContent target) {
        BannerContentMapper.copyDraftToOriginal(source, target);
    }

    private void copyLocalizationProperties(BannerContentLocalization source, BannerContentLocalization target) {
        if (Objects.nonNull(source)) {
            BannerContentMapper.copyDraftLocalizationToOriginal(source, target);
        }
    }

    private boolean isBannerUpdated(long existingBannerId, long channelId, String bannerName, String bannerType, String container,
                                    Date dateFrom, Date dateTo, BlockDTO block, String persona,Banner existingBanner) throws PortalException {

        LOG.info("Checking for updates in Banner ID: " + existingBannerId);
        Blocks existingBlock = blocksLocalService.getBlocks(existingBanner.getBlockId());
        if (!Objects.equals(existingBanner.getChannelId(), channelId)) return true;
        if (!Objects.equals(existingBanner.getBannerName(), bannerName)) return true;
        if (!Objects.equals(existingBanner.getBannerType(), bannerType)) return true;
        if (!Objects.equals(existingBanner.getContainer(), container)) return true;
        if (!DateCheckUtil.isSameLocalDate(existingBanner.getDateFrom(), dateFrom)) return true;
        if (!DateCheckUtil.isSameLocalDate(existingBanner.getDateTo(), dateTo)) return true;
        if (isBlockUpdated(existingBlock, block)) return true;
        if (!Objects.equals(existingBanner.getPersona(), persona)) return true;

        return false;
    }

    private boolean isBannerContentUpdated(BannerContentDTO dto, BannerContent existing) throws PortalException {
        boolean flag = false;
        for (Languages language : languagesLocalService.getbyChannelId(dto.getChannelId())) {
            String langName = language.getLangName();
            BannerContentLocalization contentLocal = bannerContentLocalizationPersistence.fetchByContentId_LanguageId(dto.getContentId(), langName);
            if (checkLocalValuesChange(contentLocal.getTitleValue(), dto, langName, 1)) {
                flag = true;
            }
            if (checkLocalValuesChange(contentLocal.getDescriptionValue(), dto, langName, 2)) {
                flag = true;
            }
            if (checkLocalValuesChange(contentLocal.getBannerImage(), dto, langName, 3)) {
                flag = true;
            }
            if (!Objects.equals(contentLocal.getImageOverlay(), dto.getImageOverlays().get(langName))) {
                flag = true;
            }
            if (!Objects.equals(contentLocal.getLinkType(), dto.getLinks().get(langName))) {
                flag = true;
            }
            if (!Objects.equals(contentLocal.getUrl(), dto.getUrls().get(langName))) {
                flag = true;
            }
        }
        if (!Objects.equals(existing.getContentName(), dto.getContentName())) {
            flag = true;
        }
        if (!Objects.equals(existing.getBannerId(), dto.getBannerId())) {
            flag = true;
        }
        if (!Objects.equals(existing.getContentStatus(), dto.getContentStatus())) {
            flag = true;
        }
        if (!Objects.equals(existing.getChannelId(), dto.getChannelId())) {
            flag = true;
        }
        return flag;
    }


    private boolean checkLocalValuesChange(String value, BannerContentDTO dto, String langName, int Type) {
        boolean isChanged = false;
        switch (Type) {
            case 1:
                if (dto.getTitleValues().get(langName) != null && !dto.getTitleValues().get(langName).trim().isEmpty()) {
                    isChanged = true;
                } else {
                    dto.getTitleValues().put(langName, value);
                }

                break;
            case 2:
                if (dto.getDescriptionValues().get(langName) != null && !dto.getDescriptionValues().get(langName).trim().isEmpty()) {
                    isChanged = true;
                } else {
                    dto.getDescriptionValues().put(langName, value);

                }
                break;
            case 3:
                if (dto.getBannerImages().get(langName) != null && !dto.getBannerImages().get(langName).trim().isEmpty()) {
                    isChanged = true;
                } else {
                    dto.getBannerImages().put(langName, value);

                }
                break;
        }
        return isChanged;
    }
    private boolean isBlockUpdated(Blocks db, BlockDTO dto) {


        if (!Objects.equals(db.getChannelId(), dto.getChannelId())) return true;

        if (!Objects.equals(db.getType(), Objects.toString(dto.getType(), ""))) { return true; }

        // Android
        if (db.isAndroidBlock() != dto.isAndroidBlock()) return true;
        if (!Objects.equals(db.getAndroidBlockVersion(), Objects.toString(dto.getAndroidBlockVersion(), ""))) return true;
        if (!DateCheckUtil.isSameLocalDate(db.getAndroidBlockFrom(), dto.getAndroidBlockFrom())) return true;
        if (!DateCheckUtil.isSameLocalDate(db.getAndroidBlockTo(), dto.getAndroidBlockTo())) return true;

        // iOS
        if (db.isIosBlock() != dto.isIosBlock()) return true;
        if (!Objects.equals(db.getIosBlockVersion(), Objects.toString(dto.getIosBlockVersion(), ""))) return true;
        if (!DateCheckUtil.isSameLocalDate(db.getIosBlockFrom(), dto.getIosBlockFrom())) return true;
        if (!DateCheckUtil.isSameLocalDate(db.getIosBlockTo(), dto.getIosBlockTo())) return true;

        // Web
        if (db.isWebBlock() != dto.isWebBlock()) return true;
        if (!Objects.equals(db.getWebBlockVersion(), Objects.toString(dto.getWebBlockVersion(), "")))  return true;
        if (!DateCheckUtil.isSameLocalDate(db.getWebBlockFrom(), dto.getWebBlockFrom())) return true;
        if (!DateCheckUtil.isSameLocalDate(db.getWebBlockTo(), dto.getWebBlockTo())) return true;

        return false;
    }

    private void handleApprovedStatus(Banner banner,ServiceContext serviceContext,String operationType)
            throws PortalException, SystemException {

        switch (operationType) {
            case Constants.DELETE_BANNER_CONTENT:
            case Constants.DELETE_BANNER:
                handleDeleteOperation(banner, serviceContext);
                break;

            case Constants.ADD_BANNER_CONTENT:
            case Constants.UPDATE_BANNER_CONTENT:
            case Constants.UPDATE_BANNER:
                handleUpdateOperation(banner, serviceContext);
                break;
            case Constants.ADD_BANNER:
            case Constants.IMPORT + "_" + Constants.ADD_BANNER:
            case Constants.IMPORT + "_" + Constants.UPDATE_BANNER:
                LOG.info("Approving creation for banner ID: " + banner.getBannerId());
                break;
        }
    }

    /**
     * Handles delete operation for approved status
     */
    private void handleDeleteOperation(Banner banner,ServiceContext serviceContext)
            throws PortalException, SystemException {
        if (banner.getWorkflowAction().equals(Constants.DELETE_BANNER_CONTENT)) {
            handleBannerContentDeletion(serviceContext,banner);
        } else {
            handleBannerDeletion(banner);
        }
    }

    private void handleBannerContentDeletion(ServiceContext serviceContext,Banner banner) throws PortalException, SystemException {
        long bannerContentId = GetterUtil.getLong(serviceContext.getAttribute("bannerContentId"));
        LOG.info("Approving deletion of banner content ID: " + bannerContentId);
        BannerContent bannerContent = bannerContentLocalService.getBannerContent(bannerContentId);
        BannerContent originalBannerContent = bannerContentLocalService.getBannerContent(bannerContent.getOriginalEntityId());
        bannerContent.setStatus(WorkflowConstants.STATUS_INACTIVE);
        bannerContentLocalService.updateBannerContent(bannerContent);
        LOG.info("Set banner content ID: " + bannerContentId + " status to INACTIVE");
        originalBannerContent.setStatus(WorkflowConstants.STATUS_INACTIVE);
        bannerContentLocalService.updateBannerContent(originalBannerContent);
        LOG.info("Set original banner content ID: " + originalBannerContent.getContentId() + " status to INACTIVE");
    }
    private void handleBannerDeletion(Banner banner) throws SystemException {
        List<Banner> bannersToDelete = bannerPersistence.findByEntityResourceId(banner.getEntityResourceId());
        for (Banner bannerToDelete : bannersToDelete) {
            bannerLocalService.deleteBanners(bannerToDelete.getBannerId());
        }
    }


    private void handleUpdateOperation(Banner banner, ServiceContext serviceContext)
            throws PortalException, SystemException {
        if (banner.getWorkflowAction().equals(Constants.UPDATE_BANNER_CONTENT) ||
            banner.getWorkflowAction().equals(Constants.ADD_BANNER_CONTENT)) {
            handleBannerContentUpdate(serviceContext,banner);
        } else {
            handleBannerUpdate(banner);
        }
    }

    private void handleBannerContentUpdate(ServiceContext serviceContext,Banner banner) throws PortalException, SystemException {
        long bannerContentId = GetterUtil.getLong(serviceContext.getAttribute("bannerContentId"));
        LOG.info("Approving update for banner content ID: " + bannerContentId);
        BannerContent bannerContent = bannerContentLocalService.getBannerContent(bannerContentId);
        if (bannerContent.getOriginalEntityId() != 0L) {
            long originalEntityId = bannerContent.getOriginalEntityId();
            BannerContent originalBannerContent = bannerContentLocalService.getBannerContent(originalEntityId);
            originalBannerContent.setStatus(WorkflowConstants.STATUS_INACTIVE);
            bannerContentLocalService.updateBannerContent(originalBannerContent);
        }

        bannerContent.setStatus(WorkflowConstants.STATUS_APPROVED);
        bannerContentLocalService.updateBannerContent(bannerContent);
    }

    private void handleBannerUpdate(Banner banner) throws PortalException, SystemException {
        long originalBannerId = banner.getOriginalEntityId();
        LOG.info("Approving update for banner ID: " + banner.getBannerId() + " (Original ID: " + originalBannerId + ")");

        updatePendingBannerContents(banner.getBannerId());

        LOG.info("Banner update completed successfully for original banner ID: " + originalBannerId);
    }


    private void updatePendingBannerContents(long bannerId) throws PortalException, SystemException {
        List<BannerContent> bannerContents = bannerContentLocalService
                .getByBannerId(bannerId);

        LOG.info("Found " + bannerContents.size() + " pending banner contents to update for banner ID: " + bannerId);

        if (bannerContents.isEmpty()) {
            LOG.info("No pending banner contents found. Skipping content update.");
            return;
        }

        for (BannerContent bannerContent : bannerContents) {
            long contentId = bannerContent.getContentId();
            LOG.info("Processing pending banner content ID: " + contentId);
            BannerContent originalBannerContent = bannerContentPersistence.findByPrimaryKey(bannerContent.getOriginalEntityId());
            LOG.info("Set original banner content ID: " + originalBannerContent.getContentId() + " status to INACTIVE");
            originalBannerContent.setStatus(WorkflowConstants.STATUS_INACTIVE);
            bannerContentLocalService.updateContentOrder(originalBannerContent);
            LOG.info("Updating banner content ID: " + contentId + " status to APPROVED");
            bannerContent.setStatus(WorkflowConstants.STATUS_APPROVED);
            bannerContentLocalService.updateBannerContent(bannerContent);
        }
    }

    private void handleDeniedStatus(Banner banner, ServiceContext serviceContext)
            throws SystemException, PortalException {

        if(banner.getWorkflowAction().equals(Constants.UPDATE_BANNER_CONTENT)||
           banner.getWorkflowAction().equals(Constants.DELETE_BANNER_CONTENT)||
           banner.getWorkflowAction().equals(Constants.ADD_BANNER_CONTENT)) {
            long bannerContentId = GetterUtil.getLong(serviceContext.getAttribute("bannerContentId"));
            BannerContent bannerContent = bannerContentLocalService.getBannerContent(bannerContentId);
            bannerContent.setStatus(WorkflowConstants.STATUS_INACTIVE);
            bannerContentLocalService.updateBannerContent(bannerContent);
            LOG.info("Denied banner content ID: " + bannerContentId);
        }
        else {
            List<BannerContent> bannerContents = bannerContentLocalService.getByBannerId(banner.getBannerId());
            for (BannerContent bannerContent : bannerContents) {
                bannerContent.setStatus(WorkflowConstants.STATUS_INACTIVE);
                bannerContentLocalService.updateBannerContent(bannerContent);
                LOG.info("Denied banner content ID: " + bannerContent.getContentId());
            }
        }
    }

    private int getMaxVersion(long entityResourceId)
    {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Banner.class, getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
        query.setProjection(ProjectionFactoryUtil.max("version"));
        List<Integer> results = BannerLocalServiceUtil.dynamicQuery(query);
        if (results != null && !results.isEmpty() && results.get(0) != null) {
            return results.get(0);
        }
        return 0;
    }

    public List<Banner> getLatestApprovedByChannelId(long channelId) {

        DynamicQuery dq = dynamicQuery();

        dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
        dq.add(RestrictionsFactoryUtil.eq(
                "status", WorkflowConstants.STATUS_APPROVED));

        dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
        dq.addOrder(OrderFactoryUtil.desc("version"));

        List<Banner> allApproved =
                bannerPersistence.findWithDynamicQuery(dq);

        Map<Long, Banner> latestByResource = new LinkedHashMap<>();

        for (Banner banner : allApproved) {
            if (!latestByResource.containsKey(banner.getEntityResourceId())) {
                latestByResource.put(banner.getEntityResourceId(), banner);
            }
        }

        return new ArrayList<>(latestByResource.values());
    }

    public List<Banner> getByEntityResourceId(long entityResourceId) {
        return bannerPersistence.findByEntityResourceId(entityResourceId);
    }

    public void importBanners(ImportRequest importRequest, JSONArray jsonArray){
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject entryJson = jsonArray.getJSONObject(i);
                String action = entryJson.getString("action");
                long channelId = entryJson.getLong("channelId");
                long affectedEntityId = entryJson.getLong("affectedEntityId", 0L);

                BannerImportDTO bannerImportDTO = parseBanner(entryJson);
                BannerImportDTO.BannerData data = bannerImportDTO.getData();
                BannerImportDTO.BlockData blockData = data.getBlock();
                List<BannerImportDTO.BannerContentData> bannerContents = data.getBannerContents();
                String[] selectedPersonaIds = data.getSelectedPersonaIds();

                User user = UserLocalServiceUtil.getUser(importRequest.getUserId());
                if ("add".equals(action)) {
                    try {
                        importBannerAdd(importRequest, data, blockData,bannerContents,channelId, selectedPersonaIds,user);
                    } catch (Exception e) {
                        LOG.error("Failed to add banner from import at index " + i, e);
                    }
                }
                else if ("update".equals(action)) {
                    try {
                        importBannerUpdate(affectedEntityId,importRequest, data, bannerContents,blockData,channelId,selectedPersonaIds,user);
                    } catch (Exception e) {
                        LOG.error("Failed to update banner from import at index " + i + " for affected entity ID: " + affectedEntityId, e);
                    }
                }
                else {
                    LOG.warn("Unknown action for theme import: " + action);
                }

            }
        } catch (PortalException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void importBannerAdd(ImportRequest importRequest, BannerImportDTO.BannerData data, BannerImportDTO.BlockData blockData,
                                 List<BannerImportDTO.BannerContentData> bannerContents,long channelId, String[] selectedPersonaIds,User user) throws Exception {


        JSONArray selectedPersonasJSON = JSONFactoryUtil.createJSONArray(Arrays.asList(selectedPersonaIds));

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        BlockDTO block = createBlockDto(channelId, blockData.getType(), blockData.isAndroidBlock(), blockData.getAndroidBlockVersion(),
                parseDateSafe(blockData.getAndroidBlockFrom(),formatter),parseDateSafe(blockData.getAndroidBlockTo(),formatter),
                blockData.isIosBlock(), blockData.getIosBlockVersion(),
                parseDateSafe(blockData.getIosBlockFrom(),formatter),parseDateSafe(blockData.getIosBlockTo(),formatter),
                blockData.isWebBlock(), blockData.getWebBlockVersion(),
                parseDateSafe(blockData.getWebBlockFrom(),formatter), parseDateSafe(blockData.getWebBlockTo(),formatter));

        Banner banner = createBannerEntity(channelId,data.getBannerName(),data.getBannerType(),data.getContainer(),formatter.parse(data.getDateFrom()),formatter.parse(data.getDateTo()),selectedPersonasJSON.toString(),block,Constants.IMPORT + "_" + Constants.ADD_BANNER);
        banner.setEntityResourceId(banner.getBannerId());
        banner.setVersion(getMaxVersion(banner.getEntityResourceId())+1);

        enrichWorkflow(banner, null, user, 0L, importRequest);

        List<BannerContentDTO> bannerContentDTOList = mapBannerContentDataToDTOList(bannerContents, channelId, banner.getBannerId());
        for (BannerContentDTO contentDTO : bannerContentDTOList) {
            handleBannerContentWithoutWorkflow(contentDTO);
        }

        updateStatus(user.getUserId(), banner.getBannerId(), WorkflowConstants.STATUS_APPROVED, null);

    }

    private void importBannerUpdate(long affectedEntityId,ImportRequest importRequest, BannerImportDTO.BannerData data, List<BannerImportDTO.BannerContentData> bannerContents,
                                    BannerImportDTO.BlockData blockData, long channelId,String[] selectedPersonaIds,User user) throws Exception {


        Banner existingBanner = bannerPersistence.findByPrimaryKey(affectedEntityId);
        if (existingBanner == null) {
            LOG.error("No existing banner found with ID: " + affectedEntityId + " for update operation");
            return;
        }
        JSONArray selectedPersonasJSON = JSONFactoryUtil.createJSONArray(Arrays.asList(selectedPersonaIds));

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        BlockDTO block = createBlockDto(channelId, blockData.getType(), blockData.isAndroidBlock(), blockData.getAndroidBlockVersion(),
                parseDateSafe(blockData.getAndroidBlockFrom(),formatter),parseDateSafe(blockData.getAndroidBlockTo(),formatter),
                blockData.isIosBlock(), blockData.getIosBlockVersion(),
                parseDateSafe(blockData.getIosBlockFrom(),formatter),parseDateSafe(blockData.getIosBlockTo(),formatter),
                blockData.isWebBlock(), blockData.getWebBlockVersion(),
                parseDateSafe(blockData.getWebBlockFrom(),formatter), parseDateSafe(blockData.getWebBlockTo(),formatter));
        Banner updatedBanner = createBannerEntity(channelId,data.getBannerName(),data.getBannerType(),data.getContainer(),formatter.parse(data.getDateFrom()),formatter.parse(data.getDateTo()),selectedPersonasJSON.toString(),block,Constants.IMPORT + "_" + Constants.UPDATE_BANNER);
        updatedBanner.setEntityResourceId(existingBanner.getEntityResourceId());
        updatedBanner.setVersion(getMaxVersion(existingBanner.getEntityResourceId())+1);
        enrichWorkflow(updatedBanner, null, user, affectedEntityId, importRequest);
        List<BannerContent> existingContents = bannerContentLocalService.getByEntityResourceIdAndStatusApproved(existingBanner.getEntityResourceId());
        for (BannerContent content : existingContents) {
            content.setStatus(WorkflowConstants.STATUS_INACTIVE);
            bannerContentLocalService.updateBannerContent(content);
        }
        List<BannerContentDTO> bannerContentDTOList = mapBannerContentDataToDTOList(bannerContents, channelId, updatedBanner.getBannerId());
        for (BannerContentDTO contentDTO : bannerContentDTOList) {
            handleBannerContentWithoutWorkflow(contentDTO);
        }
        updateStatus(user.getUserId(), updatedBanner.getBannerId(), WorkflowConstants.STATUS_APPROVED, null);
    }
    private Date parseDateSafe(String value, SimpleDateFormat formatter) {
        try {
            return (value == null || value.isEmpty()) ? null : formatter.parse(value);
        } catch (Exception e) {
            return null;
        }
    }


    public BlockDTO createBlockDto(long channelId, String type, boolean androidBlock,
                                    String androidBlockVersion, Date androidBlockFrom, Date androidBlockTo,
                                    boolean iosBlock, String iosBlockVersion, Date iosBlockFrom,
                                    Date iosBlockTo, boolean webBlock, String webBlockVersion,
                                    Date webBlockFrom, Date webBlockTo){
        BlockDTO blocksDTO = new BlockDTO();
        blocksDTO.setChannelId(channelId);
        blocksDTO.setType(type);
        blocksDTO.setAndroidBlock(androidBlock);
        blocksDTO.setAndroidBlockVersion(androidBlockVersion);
        blocksDTO.setAndroidBlockFrom(androidBlockFrom);
        blocksDTO.setAndroidBlockTo(androidBlockTo);
        blocksDTO.setIosBlock(iosBlock);
        blocksDTO.setIosBlockVersion(iosBlockVersion);
        blocksDTO.setIosBlockFrom(iosBlockFrom);
        blocksDTO.setIosBlockTo(iosBlockTo);
        blocksDTO.setWebBlock(webBlock);
        blocksDTO.setWebBlockVersion(webBlockVersion);
        blocksDTO.setWebBlockFrom(webBlockFrom);
        blocksDTO.setWebBlockTo(webBlockTo);
        return blocksDTO;
    }

    public BannerContentDTO createBannerContentDto(
            long channelId,
            String contentName,
            long bannerId,
            String contentStatus,
            Map<String, String> titleValues,
            Map<String, String> descriptionValues,
            Map<String, String> bannerImages,
            Map<String, String> imageOverlays,
            Map<String, String> links,
            Map<String, String> urls,
            Long contentId) {

        BannerContentDTO dto = new BannerContentDTO();

        dto.setContentId(contentId);
        dto.setChannelId(channelId);
        dto.setContentName(contentName);
        dto.setBannerId(bannerId);
        dto.setContentStatus(contentStatus);
        dto.setTitleValues(titleValues);
        dto.setDescriptionValues(descriptionValues);
        dto.setBannerImages(bannerImages);
        dto.setImageOverlays(imageOverlays);
        dto.setLinks(links);
        dto.setUrls(urls);
        dto.setOriginalEntityId(contentId);

        return dto;
    }

    private BannerImportDTO parseBanner(JSONObject bannerJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(bannerJson.toString(), BannerImportDTO.class);
    }
    private List<BannerContentDTO> mapBannerContentDataToDTOList(
            List<BannerImportDTO.BannerContentData> bannerContents,
            long channelId,
            long bannerId) {

        List<BannerContentDTO> dtoList = new ArrayList<>();

        if (bannerContents == null || bannerContents.isEmpty()) {
            return dtoList;
        }

        for (BannerImportDTO.BannerContentData contentData : bannerContents) {
            Map<String, String> titleValues = new HashMap<>();
            Map<String, String> descriptionValues = new HashMap<>();
            Map<String, String> bannerImages = new HashMap<>();
            Map<String, String> imageOverlays = new HashMap<>();
            Map<String, String> links = new HashMap<>();
            Map<String, String> urls = new HashMap<>();

            if (contentData.getLocalizations() != null) {
                for (BannerImportDTO.LocalizationData localization : contentData.getLocalizations()) {
                    String langId = localization.getLanguageId();
                    titleValues.put(langId, localization.getTitleValue());
                    descriptionValues.put(langId, localization.getDescriptionValue());
                    bannerImages.put(langId, localization.getBannerImage());
                    imageOverlays.put(langId, localization.getImageOverlay());
                    links.put(langId, localization.getLinkType());
                    urls.put(langId, localization.getUrl());
                }
            }

            BannerContentDTO dto = createBannerContentDto(
                    channelId,
                    contentData.getContentName(),
                    bannerId,
                    contentData.getContentStatus(),
                    titleValues,
                    descriptionValues,
                    bannerImages,
                    imageOverlays,
                    links,
                    urls,
                    0L
            );

            dtoList.add(dto);
        }

        return dtoList;
    }

}