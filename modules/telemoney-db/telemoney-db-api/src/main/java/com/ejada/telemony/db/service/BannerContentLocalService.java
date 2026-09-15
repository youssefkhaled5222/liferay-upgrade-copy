/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemoney.db.dto.BannerContentDTO;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.model.BannerContent;
import com.ejada.telemony.db.model.BannerContentLocalization;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for BannerContent. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.BannerContent"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BannerContentLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.BannerContentLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the banner content local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BannerContentLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public BannerContent addBannerContent(BannerContent bannerContent);

	public BannerContent addBannerContent(BannerContentDTO bannerContentDTO)
		throws PortalException;

	/**
	 * Creates a new banner content with the primary key. Does not add the banner content to the database.
	 *
	 * @param contentId the primary key for the new banner content
	 * @return the new banner content
	 */
	@Transactional(enabled = false)
	public BannerContent createBannerContent(long contentId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public BannerContent deleteBannerContent(BannerContent bannerContent);

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
	@Indexable(type = IndexableType.DELETE)
	public BannerContent deleteBannerContent(long contentId)
		throws PortalException;

	public void deleteBannerContentLocal(long bannerContentId);

	public void deleteBannerContents(long bannerContentId);

	public void deleteBannerContentsWithoutLocalization(long bannerContentId);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerContentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BannerContentModelImpl</code>.
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
	public BannerContent fetchBannerContent(long contentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BannerContentLocalization fetchBannerContentLocalization(
		long contentId, String languageId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BannerContent> getAllBannerContents();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BannerContent> getApprovedByEntityResourceId(
		long entityResourceId);

	/**
	 * Returns the banner content with the primary key.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content
	 * @throws PortalException if a banner content with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BannerContent getBannerContent(long contentId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BannerContentLocalization getBannerContentLocalization(
			long contentId, String languageId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BannerContentLocalization> getBannerContentLocalizations(
		long contentId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BannerContent> getBannerContents(int start, int end);

	/**
	 * Returns the number of banner contents.
	 *
	 * @return the number of banner contents
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBannerContentsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BannerContent> getByBannerId(long bannerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BannerContent> getByEntityResourceId(long entityResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BannerContent> getByEntityResourceIdAndStatusApproved(
		long entityResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	@Indexable(type = IndexableType.REINDEX)
	public BannerContent updateBannerContent(BannerContent bannerContent);

	public void updateBannerContent(BannerContentDTO bannerContentDTO);

	public BannerContentLocalization updateBannerContentLocalization(
			BannerContent bannerContent, String languageId, String titleValue,
			String descriptionValue)
		throws PortalException;

	public List<BannerContentLocalization> updateBannerContentLocalizations(
			BannerContent bannerContent, Map<String, String> titleValueMap,
			Map<String, String> descriptionValueMap)
		throws PortalException;

	public void updateContentOrder(BannerContent bannerContent);

}