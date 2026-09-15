/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BannerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BannerLocalService
 * @generated
 */
public class BannerLocalServiceWrapper
	implements BannerLocalService, ServiceWrapper<BannerLocalService> {

	public BannerLocalServiceWrapper() {
		this(null);
	}

	public BannerLocalServiceWrapper(BannerLocalService bannerLocalService) {
		_bannerLocalService = bannerLocalService;
	}

	/**
	 * Adds the banner to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param banner the banner
	 * @return the banner that was added
	 */
	@Override
	public com.ejada.telemony.db.model.Banner addBanner(
		com.ejada.telemony.db.model.Banner banner) {

		return _bannerLocalService.addBanner(banner);
	}

	@Override
	public void addNewBannerWithLocalization(
			long channelId, String bannerName, String bannerType,
			String container, java.util.Date dateFrom, java.util.Date dateTo,
			com.ejada.telemoney.db.dto.BlockDTO block, String persona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_bannerLocalService.addNewBannerWithLocalization(
			channelId, bannerName, bannerType, container, dateFrom, dateTo,
			block, persona, serviceContext, user);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Banner> checkBlockDate(
		java.util.List<com.ejada.telemony.db.model.Banner> banners,
		java.util.Date curDate, String version, String platform) {

		return _bannerLocalService.checkBlockDate(
			banners, curDate, version, platform);
	}

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param bannerId the primary key for the new banner
	 * @return the new banner
	 */
	@Override
	public com.ejada.telemony.db.model.Banner createBanner(long bannerId) {
		return _bannerLocalService.createBanner(bannerId);
	}

	@Override
	public com.ejada.telemoney.db.dto.BannerContentDTO createBannerContentDto(
		long channelId, String contentName, long bannerId, String contentStatus,
		java.util.Map<String, String> titleValues,
		java.util.Map<String, String> descriptionValues,
		java.util.Map<String, String> bannerImages,
		java.util.Map<String, String> imageOverlays,
		java.util.Map<String, String> links, java.util.Map<String, String> urls,
		Long contentId) {

		return _bannerLocalService.createBannerContentDto(
			channelId, contentName, bannerId, contentStatus, titleValues,
			descriptionValues, bannerImages, imageOverlays, links, urls,
			contentId);
	}

	@Override
	public com.ejada.telemoney.db.dto.BlockDTO createBlockDto(
		long channelId, String type, boolean androidBlock,
		String androidBlockVersion, java.util.Date androidBlockFrom,
		java.util.Date androidBlockTo, boolean iosBlock, String iosBlockVersion,
		java.util.Date iosBlockFrom, java.util.Date iosBlockTo,
		boolean webBlock, String webBlockVersion, java.util.Date webBlockFrom,
		java.util.Date webBlockTo) {

		return _bannerLocalService.createBlockDto(
			channelId, type, androidBlock, androidBlockVersion,
			androidBlockFrom, androidBlockTo, iosBlock, iosBlockVersion,
			iosBlockFrom, iosBlockTo, webBlock, webBlockVersion, webBlockFrom,
			webBlockTo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the banner from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param banner the banner
	 * @return the banner that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.Banner deleteBanner(
		com.ejada.telemony.db.model.Banner banner) {

		return _bannerLocalService.deleteBanner(banner);
	}

	/**
	 * Deletes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner that was removed
	 * @throws PortalException if a banner with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Banner deleteBanner(long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerLocalService.deleteBanner(bannerId);
	}

	@Override
	public void deleteBanners(long selectedBannerId) {
		_bannerLocalService.deleteBanners(selectedBannerId);
	}

	@Override
	public void deleteBannersWorkflow(
		long selectedBannerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		_bannerLocalService.deleteBannersWorkflow(
			selectedBannerId, serviceContext, user);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bannerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bannerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bannerLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bannerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bannerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bannerLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bannerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _bannerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Banner fetchBanner(long bannerId) {
		return _bannerLocalService.fetchBanner(bannerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bannerLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the banner with the primary key.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner
	 * @throws PortalException if a banner with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Banner getBanner(long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerLocalService.getBanner(bannerId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getBannerContentsAPI(
		java.util.List<com.ejada.telemony.db.model.Banner> banners,
		String langName) {

		return _bannerLocalService.getBannerContentsAPI(banners, langName);
	}

	/**
	 * Returns a range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of banners
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Banner> getBanners(
		int start, int end) {

		return _bannerLocalService.getBanners(start, end);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getBannersAPI(
			long channelId, String languageName, String platform,
			long personaId, int version)
		throws Exception {

		return _bannerLocalService.getBannersAPI(
			channelId, languageName, platform, personaId, version);
	}

	/**
	 * Returns the number of banners.
	 *
	 * @return the number of banners
	 */
	@Override
	public int getBannersCount() {
		return _bannerLocalService.getBannersCount();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Banner> getbyChannelId(
		Long channelId) {

		return _bannerLocalService.getbyChannelId(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Banner>
		getByEntityResourceId(long entityResourceId) {

		return _bannerLocalService.getByEntityResourceId(entityResourceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bannerLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Banner>
		getLatestApprovedByChannelId(long channelId) {

		return _bannerLocalService.getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bannerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void handleBannerContent(
			com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_bannerLocalService.handleBannerContent(
			bannerContentDTO, serviceContext, user);
	}

	@Override
	public void handleBannerContentWithoutWorkflow(
			com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO)
		throws com.liferay.portal.kernel.exception.PortalException {

		_bannerLocalService.handleBannerContentWithoutWorkflow(
			bannerContentDTO);
	}

	@Override
	public void handleDeleteBannerContent(
			com.ejada.telemony.db.model.BannerContent originalBannerContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_bannerLocalService.handleDeleteBannerContent(
			originalBannerContent, serviceContext, user);
	}

	@Override
	public void importBanners(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray jsonArray) {

		_bannerLocalService.importBanners(importRequest, jsonArray);
	}

	/**
	 * Updates the banner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param banner the banner
	 * @return the banner that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.Banner updateBanner(
		com.ejada.telemony.db.model.Banner banner) {

		return _bannerLocalService.updateBanner(banner);
	}

	@Override
	public void updateBannerWithLocalization(
			long channelId, String bannerName, String bannerType,
			String container, java.util.Date dateFrom, java.util.Date dateTo,
			com.ejada.telemoney.db.dto.BlockDTO block, Long bannerId,
			String persona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user,
			javax.portlet.ActionRequest actionRequest)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException {

		_bannerLocalService.updateBannerWithLocalization(
			channelId, bannerName, bannerType, container, dateFrom, dateTo,
			block, bannerId, persona, serviceContext, user, actionRequest);
	}

	@Override
	public com.ejada.telemony.db.model.Banner updateStatus(
			long userId, long bannerId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _bannerLocalService.updateStatus(
			userId, bannerId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bannerLocalService.getBasePersistence();
	}

	@Override
	public BannerLocalService getWrappedService() {
		return _bannerLocalService;
	}

	@Override
	public void setWrappedService(BannerLocalService bannerLocalService) {
		_bannerLocalService = bannerLocalService;
	}

	private BannerLocalService _bannerLocalService;

}