/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Banner;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Banner. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.BannerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BannerLocalService
 * @generated
 */
public class BannerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.BannerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Banner addBanner(Banner banner) {
		return getService().addBanner(banner);
	}

	public static void addNewBannerWithLocalization(
			long channelId, String bannerName, String bannerType,
			String container, java.util.Date dateFrom, java.util.Date dateTo,
			com.ejada.telemoney.db.dto.BlockDTO block, String persona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().addNewBannerWithLocalization(
			channelId, bannerName, bannerType, container, dateFrom, dateTo,
			block, persona, serviceContext, user);
	}

	public static List<Banner> checkBlockDate(
		List<Banner> banners, java.util.Date curDate, String version,
		String platform) {

		return getService().checkBlockDate(banners, curDate, version, platform);
	}

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param bannerId the primary key for the new banner
	 * @return the new banner
	 */
	public static Banner createBanner(long bannerId) {
		return getService().createBanner(bannerId);
	}

	public static com.ejada.telemoney.db.dto.BannerContentDTO
		createBannerContentDto(
			long channelId, String contentName, long bannerId,
			String contentStatus, Map<String, String> titleValues,
			Map<String, String> descriptionValues,
			Map<String, String> bannerImages, Map<String, String> imageOverlays,
			Map<String, String> links, Map<String, String> urls,
			Long contentId) {

		return getService().createBannerContentDto(
			channelId, contentName, bannerId, contentStatus, titleValues,
			descriptionValues, bannerImages, imageOverlays, links, urls,
			contentId);
	}

	public static com.ejada.telemoney.db.dto.BlockDTO createBlockDto(
		long channelId, String type, boolean androidBlock,
		String androidBlockVersion, java.util.Date androidBlockFrom,
		java.util.Date androidBlockTo, boolean iosBlock, String iosBlockVersion,
		java.util.Date iosBlockFrom, java.util.Date iosBlockTo,
		boolean webBlock, String webBlockVersion, java.util.Date webBlockFrom,
		java.util.Date webBlockTo) {

		return getService().createBlockDto(
			channelId, type, androidBlock, androidBlockVersion,
			androidBlockFrom, androidBlockTo, iosBlock, iosBlockVersion,
			iosBlockFrom, iosBlockTo, webBlock, webBlockVersion, webBlockFrom,
			webBlockTo);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Banner deleteBanner(Banner banner) {
		return getService().deleteBanner(banner);
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
	public static Banner deleteBanner(long bannerId) throws PortalException {
		return getService().deleteBanner(bannerId);
	}

	public static void deleteBanners(long selectedBannerId) {
		getService().deleteBanners(selectedBannerId);
	}

	public static void deleteBannersWorkflow(
		long selectedBannerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user) {

		getService().deleteBannersWorkflow(
			selectedBannerId, serviceContext, user);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Banner fetchBanner(long bannerId) {
		return getService().fetchBanner(bannerId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the banner with the primary key.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner
	 * @throws PortalException if a banner with the primary key could not be found
	 */
	public static Banner getBanner(long bannerId) throws PortalException {
		return getService().getBanner(bannerId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getBannerContentsAPI(
		List<Banner> banners, String langName) {

		return getService().getBannerContentsAPI(banners, langName);
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
	public static List<Banner> getBanners(int start, int end) {
		return getService().getBanners(start, end);
	}

	public static com.liferay.portal.kernel.json.JSONArray getBannersAPI(
			long channelId, String languageName, String platform,
			long personaId, int version)
		throws Exception {

		return getService().getBannersAPI(
			channelId, languageName, platform, personaId, version);
	}

	/**
	 * Returns the number of banners.
	 *
	 * @return the number of banners
	 */
	public static int getBannersCount() {
		return getService().getBannersCount();
	}

	public static List<Banner> getbyChannelId(Long channelId) {
		return getService().getbyChannelId(channelId);
	}

	public static List<Banner> getByEntityResourceId(long entityResourceId) {
		return getService().getByEntityResourceId(entityResourceId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Banner> getLatestApprovedByChannelId(long channelId) {
		return getService().getLatestApprovedByChannelId(channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void handleBannerContent(
			com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleBannerContent(
			bannerContentDTO, serviceContext, user);
	}

	public static void handleBannerContentWithoutWorkflow(
			com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO)
		throws PortalException {

		getService().handleBannerContentWithoutWorkflow(bannerContentDTO);
	}

	public static void handleDeleteBannerContent(
			com.ejada.telemony.db.model.BannerContent originalBannerContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().handleDeleteBannerContent(
			originalBannerContent, serviceContext, user);
	}

	public static void importBanners(
		com.ejada.telemony.db.model.ImportRequest importRequest,
		com.liferay.portal.kernel.json.JSONArray jsonArray) {

		getService().importBanners(importRequest, jsonArray);
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
	public static Banner updateBanner(Banner banner) {
		return getService().updateBanner(banner);
	}

	public static void updateBannerWithLocalization(
			long channelId, String bannerName, String bannerType,
			String container, java.util.Date dateFrom, java.util.Date dateTo,
			com.ejada.telemoney.db.dto.BlockDTO block, Long bannerId,
			String persona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user,
			javax.portlet.ActionRequest actionRequest)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException {

		getService().updateBannerWithLocalization(
			channelId, bannerName, bannerType, container, dateFrom, dateTo,
			block, bannerId, persona, serviceContext, user, actionRequest);
	}

	public static Banner updateStatus(
			long userId, long bannerId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.fasterxml.jackson.core.JsonProcessingException,
			   PortalException, SystemException {

		return getService().updateStatus(
			userId, bannerId, status, serviceContext);
	}

	public static BannerLocalService getService() {
		return _service;
	}

	public static void setService(BannerLocalService service) {
		_service = service;
	}

	private static volatile BannerLocalService _service;

}