/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemoney.db.dto.BannerContentDTO;
import com.ejada.telemoney.db.dto.BlockDTO;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.model.Banner;
import com.ejada.telemony.db.model.BannerContent;
import com.ejada.telemony.db.model.ImportRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.*;
import java.util.List;

import javax.portlet.ActionRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Banner. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BannerLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.Banner"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BannerLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.BannerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the banner local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BannerLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public Banner addBanner(Banner banner);

	public void addNewBannerWithLocalization(
			long channelId, String bannerName, String bannerType,
			String container, java.util.Date dateFrom, java.util.Date dateTo,
			BlockDTO block, String persona, ServiceContext serviceContext,
			User user)
		throws JsonProcessingException, PortalException;

	public List<Banner> checkBlockDate(
		List<Banner> banners, java.util.Date curDate, String version,
		String platform);

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param bannerId the primary key for the new banner
	 * @return the new banner
	 */
	@Transactional(enabled = false)
	public Banner createBanner(long bannerId);

	public BannerContentDTO createBannerContentDto(
		long channelId, String contentName, long bannerId, String contentStatus,
		java.util.Map<String, String> titleValues,
		java.util.Map<String, String> descriptionValues,
		java.util.Map<String, String> bannerImages,
		java.util.Map<String, String> imageOverlays,
		java.util.Map<String, String> links, java.util.Map<String, String> urls,
		Long contentId);

	public BlockDTO createBlockDto(
		long channelId, String type, boolean androidBlock,
		String androidBlockVersion, java.util.Date androidBlockFrom,
		java.util.Date androidBlockTo, boolean iosBlock, String iosBlockVersion,
		java.util.Date iosBlockFrom, java.util.Date iosBlockTo,
		boolean webBlock, String webBlockVersion, java.util.Date webBlockFrom,
		java.util.Date webBlockTo);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Banner deleteBanner(Banner banner);

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
	@Indexable(type = IndexableType.DELETE)
	public Banner deleteBanner(long bannerId) throws PortalException;

	public void deleteBanners(long selectedBannerId);

	public void deleteBannersWorkflow(
		long selectedBannerId, ServiceContext serviceContext, User user);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Banner fetchBanner(long bannerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the banner with the primary key.
	 *
	 * @param bannerId the primary key of the banner
	 * @return the banner
	 * @throws PortalException if a banner with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Banner getBanner(long bannerId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getBannerContentsAPI(
		List<Banner> banners, String langName);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Banner> getBanners(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getBannersAPI(
			long channelId, String languageName, String platform,
			long personaId, int version)
		throws Exception;

	/**
	 * Returns the number of banners.
	 *
	 * @return the number of banners
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBannersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Banner> getbyChannelId(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Banner> getByEntityResourceId(long entityResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Banner> getLatestApprovedByChannelId(long channelId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void handleBannerContent(
			BannerContentDTO bannerContentDTO, ServiceContext serviceContext,
			User user)
		throws JsonProcessingException, PortalException;

	public void handleBannerContentWithoutWorkflow(
			BannerContentDTO bannerContentDTO)
		throws PortalException;

	public void handleDeleteBannerContent(
			BannerContent originalBannerContent, ServiceContext serviceContext,
			User user)
		throws JsonProcessingException, PortalException;

	public void importBanners(ImportRequest importRequest, JSONArray jsonArray);

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
	@Indexable(type = IndexableType.REINDEX)
	public Banner updateBanner(Banner banner);

	public void updateBannerWithLocalization(
			long channelId, String bannerName, String bannerType,
			String container, java.util.Date dateFrom, java.util.Date dateTo,
			BlockDTO block, Long bannerId, String persona,
			ServiceContext serviceContext, User user,
			ActionRequest actionRequest)
		throws JsonProcessingException, PortalException;

	public Banner updateStatus(
			long userId, long bannerId, int status,
			ServiceContext serviceContext)
		throws JsonProcessingException, PortalException, SystemException;

}