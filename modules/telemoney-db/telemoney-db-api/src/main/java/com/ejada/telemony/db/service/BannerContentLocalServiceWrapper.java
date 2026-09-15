/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BannerContentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalService
 * @generated
 */
public class BannerContentLocalServiceWrapper
	implements BannerContentLocalService,
			   ServiceWrapper<BannerContentLocalService> {

	public BannerContentLocalServiceWrapper() {
		this(null);
	}

	public BannerContentLocalServiceWrapper(
		BannerContentLocalService bannerContentLocalService) {

		_bannerContentLocalService = bannerContentLocalService;
	}

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
	@Override
	public com.ejada.telemony.db.model.BannerContent addBannerContent(
		com.ejada.telemony.db.model.BannerContent bannerContent) {

		return _bannerContentLocalService.addBannerContent(bannerContent);
	}

	@Override
	public com.ejada.telemony.db.model.BannerContent addBannerContent(
			com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.addBannerContent(bannerContentDTO);
	}

	/**
	 * Creates a new banner content with the primary key. Does not add the banner content to the database.
	 *
	 * @param contentId the primary key for the new banner content
	 * @return the new banner content
	 */
	@Override
	public com.ejada.telemony.db.model.BannerContent createBannerContent(
		long contentId) {

		return _bannerContentLocalService.createBannerContent(contentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.telemony.db.model.BannerContent deleteBannerContent(
		com.ejada.telemony.db.model.BannerContent bannerContent) {

		return _bannerContentLocalService.deleteBannerContent(bannerContent);
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
	@Override
	public com.ejada.telemony.db.model.BannerContent deleteBannerContent(
			long contentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.deleteBannerContent(contentId);
	}

	@Override
	public void deleteBannerContentLocal(long bannerContentId) {
		_bannerContentLocalService.deleteBannerContentLocal(bannerContentId);
	}

	@Override
	public void deleteBannerContents(long bannerContentId) {
		_bannerContentLocalService.deleteBannerContents(bannerContentId);
	}

	@Override
	public void deleteBannerContentsWithoutLocalization(long bannerContentId) {
		_bannerContentLocalService.deleteBannerContentsWithoutLocalization(
			bannerContentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bannerContentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bannerContentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bannerContentLocalService.dynamicQuery();
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

		return _bannerContentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bannerContentLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bannerContentLocalService.dynamicQuery(
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

		return _bannerContentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bannerContentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.BannerContent fetchBannerContent(
		long contentId) {

		return _bannerContentLocalService.fetchBannerContent(contentId);
	}

	@Override
	public com.ejada.telemony.db.model.BannerContentLocalization
		fetchBannerContentLocalization(long contentId, String languageId) {

		return _bannerContentLocalService.fetchBannerContentLocalization(
			contentId, languageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bannerContentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContent>
		getAllBannerContents() {

		return _bannerContentLocalService.getAllBannerContents();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContent>
		getApprovedByEntityResourceId(long entityResourceId) {

		return _bannerContentLocalService.getApprovedByEntityResourceId(
			entityResourceId);
	}

	/**
	 * Returns the banner content with the primary key.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content
	 * @throws PortalException if a banner content with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.BannerContent getBannerContent(
			long contentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.getBannerContent(contentId);
	}

	@Override
	public com.ejada.telemony.db.model.BannerContentLocalization
			getBannerContentLocalization(long contentId, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.getBannerContentLocalization(
			contentId, languageId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContentLocalization>
		getBannerContentLocalizations(long contentId) {

		return _bannerContentLocalService.getBannerContentLocalizations(
			contentId);
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
	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContent>
		getBannerContents(int start, int end) {

		return _bannerContentLocalService.getBannerContents(start, end);
	}

	/**
	 * Returns the number of banner contents.
	 *
	 * @return the number of banner contents
	 */
	@Override
	public int getBannerContentsCount() {
		return _bannerContentLocalService.getBannerContentsCount();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContent>
		getByBannerId(long bannerId) {

		return _bannerContentLocalService.getByBannerId(bannerId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContent>
		getByEntityResourceId(long entityResourceId) {

		return _bannerContentLocalService.getByEntityResourceId(
			entityResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContent>
		getByEntityResourceIdAndStatusApproved(long entityResourceId) {

		return _bannerContentLocalService.
			getByEntityResourceIdAndStatusApproved(entityResourceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bannerContentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bannerContentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.telemony.db.model.BannerContent updateBannerContent(
		com.ejada.telemony.db.model.BannerContent bannerContent) {

		return _bannerContentLocalService.updateBannerContent(bannerContent);
	}

	@Override
	public void updateBannerContent(
		com.ejada.telemoney.db.dto.BannerContentDTO bannerContentDTO) {

		_bannerContentLocalService.updateBannerContent(bannerContentDTO);
	}

	@Override
	public com.ejada.telemony.db.model.BannerContentLocalization
			updateBannerContentLocalization(
				com.ejada.telemony.db.model.BannerContent bannerContent,
				String languageId, String titleValue, String descriptionValue)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.updateBannerContentLocalization(
			bannerContent, languageId, titleValue, descriptionValue);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.BannerContentLocalization>
			updateBannerContentLocalizations(
				com.ejada.telemony.db.model.BannerContent bannerContent,
				java.util.Map<String, String> titleValueMap,
				java.util.Map<String, String> descriptionValueMap)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bannerContentLocalService.updateBannerContentLocalizations(
			bannerContent, titleValueMap, descriptionValueMap);
	}

	@Override
	public void updateContentOrder(
		com.ejada.telemony.db.model.BannerContent bannerContent) {

		_bannerContentLocalService.updateContentOrder(bannerContent);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bannerContentLocalService.getBasePersistence();
	}

	@Override
	public BannerContentLocalService getWrappedService() {
		return _bannerContentLocalService;
	}

	@Override
	public void setWrappedService(
		BannerContentLocalService bannerContentLocalService) {

		_bannerContentLocalService = bannerContentLocalService;
	}

	private BannerContentLocalService _bannerContentLocalService;

}