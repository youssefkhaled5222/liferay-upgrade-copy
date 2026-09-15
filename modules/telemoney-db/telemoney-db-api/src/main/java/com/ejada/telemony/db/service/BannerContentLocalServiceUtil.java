/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.BannerContent;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for BannerContent. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.BannerContentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalService
 * @generated
 */
public class BannerContentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.BannerContentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the banner content to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bannerContent the banner content
	 * @return the banner content that was added
	 */
	public static BannerContent addBannerContent(BannerContent bannerContent) {
		return getService().addBannerContent(bannerContent);
	}

	public static BannerContent addBannerContent(
			com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO)
		throws PortalException {

		return getService().addBannerContent(bannerContentDTO);
	}

	/**
	 * Creates a new banner content with the primary key. Does not add the banner content to the database.
	 *
	 * @param contentId the primary key for the new banner content
	 * @return the new banner content
	 */
	public static BannerContent createBannerContent(long contentId) {
		return getService().createBannerContent(contentId);
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
	 * Deletes the banner content from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bannerContent the banner content
	 * @return the banner content that was removed
	 */
	public static BannerContent deleteBannerContent(
		BannerContent bannerContent) {

		return getService().deleteBannerContent(bannerContent);
	}

	/**
	 * Deletes the banner content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content that was removed
	 * @throws PortalException if a banner content with the primary key could not be found
	 */
	public static BannerContent deleteBannerContent(long contentId)
		throws PortalException {

		return getService().deleteBannerContent(contentId);
	}

	public static void deleteBannerContentLocal(long bannerContentId) {
		getService().deleteBannerContentLocal(bannerContentId);
	}

	public static void deleteBannerContents(long bannerContentId) {
		getService().deleteBannerContents(bannerContentId);
	}

	public static void deleteBannerContentsWithoutLocalization(
		long bannerContentId) {

		getService().deleteBannerContentsWithoutLocalization(bannerContentId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerContentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerContentModelImpl</code>.
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

	public static BannerContent fetchBannerContent(long contentId) {
		return getService().fetchBannerContent(contentId);
	}

	public static com.ejada.telemony.db.model.BannerContentLocalization
		fetchBannerContentLocalization(long contentId, String languageId) {

		return getService().fetchBannerContentLocalization(
			contentId, languageId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<BannerContent> getAllBannerContents() {
		return getService().getAllBannerContents();
	}

	public static List<BannerContent> getApprovedByEntityResourceId(
		long entityResourceId) {

		return getService().getApprovedByEntityResourceId(entityResourceId);
	}

	/**
	 * Returns the banner content with the primary key.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content
	 * @throws PortalException if a banner content with the primary key could not be found
	 */
	public static BannerContent getBannerContent(long contentId)
		throws PortalException {

		return getService().getBannerContent(contentId);
	}

	public static com.ejada.telemony.db.model.BannerContentLocalization
			getBannerContentLocalization(long contentId, String languageId)
		throws PortalException {

		return getService().getBannerContentLocalization(contentId, languageId);
	}

	public static List<com.ejada.telemony.db.model.BannerContentLocalization>
		getBannerContentLocalizations(long contentId) {

		return getService().getBannerContentLocalizations(contentId);
	}

	/**
	 * Returns a range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of banner contents
	 */
	public static List<BannerContent> getBannerContents(int start, int end) {
		return getService().getBannerContents(start, end);
	}

	/**
	 * Returns the number of banner contents.
	 *
	 * @return the number of banner contents
	 */
	public static int getBannerContentsCount() {
		return getService().getBannerContentsCount();
	}

	public static List<BannerContent> getByBannerId(long bannerId) {
		return getService().getByBannerId(bannerId);
	}

	public static List<BannerContent> getByEntityResourceId(
		long entityResourceId) {

		return getService().getByEntityResourceId(entityResourceId);
	}

	public static List<BannerContent> getByEntityResourceIdAndStatusApproved(
		long entityResourceId) {

		return getService().getByEntityResourceIdAndStatusApproved(
			entityResourceId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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

	/**
	 * Updates the banner content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BannerContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bannerContent the banner content
	 * @return the banner content that was updated
	 */
	public static BannerContent updateBannerContent(
		BannerContent bannerContent) {

		return getService().updateBannerContent(bannerContent);
	}

	public static void updateBannerContent(
		com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO) {

		getService().updateBannerContent(bannerContentDTO);
	}

	public static com.ejada.telemony.db.model.BannerContentLocalization
			updateBannerContentLocalization(
				BannerContent bannerContent, String languageId,
				String titleValue, String descriptionValue)
		throws PortalException {

		return getService().updateBannerContentLocalization(
			bannerContent, languageId, titleValue, descriptionValue);
	}

	public static List<com.ejada.telemony.db.model.BannerContentLocalization>
			updateBannerContentLocalizations(
				BannerContent bannerContent, Map<String, String> titleValueMap,
				Map<String, String> descriptionValueMap)
		throws PortalException {

		return getService().updateBannerContentLocalizations(
			bannerContent, titleValueMap, descriptionValueMap);
	}

	public static void updateContentOrder(BannerContent bannerContent) {
		getService().updateContentOrder(bannerContent);
	}

	public static BannerContentLocalService getService() {
		return _service;
	}

	public static void setService(BannerContentLocalService service) {
		_service = service;
	}

	private static volatile BannerContentLocalService _service;

}