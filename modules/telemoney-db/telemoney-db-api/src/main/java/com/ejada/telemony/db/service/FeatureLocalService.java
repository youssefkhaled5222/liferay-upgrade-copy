/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemoney.db.dto.BlockDTO;
import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.model.Feature;

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
import com.liferay.portal.kernel.json.JSONObject;
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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Feature. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FeatureLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.Feature"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FeatureLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.FeatureLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the feature local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FeatureLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the feature to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param feature the feature
	 * @return the feature that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Feature addFeature(Feature feature);

	public void addFeature(
			String featureName, String pageType, long parentPage,
			String routeId, Boolean status, long blockId, long channelId,
			List<String> whitelistLovData, List<String> segmentsLovData,
			User user, ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

	public Boolean checkIfParentHaveChildren(long entityResourceId);

	/**
	 * Creates a new feature with the primary key. Does not add the feature to the database.
	 *
	 * @param featureId the primary key for the new feature
	 * @return the new feature
	 */
	@Transactional(enabled = false)
	public Feature createFeature(long featureId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void delete(long featureId) throws Exception;

	/**
	 * Deletes the feature from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param feature the feature
	 * @return the feature that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Feature deleteFeature(Feature feature);

	/**
	 * Deletes the feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature that was removed
	 * @throws PortalException if a feature with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Feature deleteFeature(long featureId) throws PortalException;

	public void deleteFeatureWithItsSegments(long featureId, User user)
		throws Exception;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
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
	public Feature fetchFeature(long featureId);

	public List<Feature> findByOriginalEntityIdAndStatus(
		long originalEntityId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Feature> getAllChildrenFeatures(
		long entityResourceId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getAllFeaturesForSegment(
		long channelId, String segmentName, String deviceType,
		String deviceVersion);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Feature> getAllParentPages(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getBlueAppFeatures(
		long channelId, List<String> whitelistFilter,
		List<String> segmentsFilter);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Feature> getByChildResourceId(long childResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Feature> getByEntityResourceId(long entityResourceId);

	/**
	 * Returns the feature with the primary key.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature
	 * @throws PortalException if a feature with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Feature getFeature(long featureId) throws PortalException;

	/**
	 * Returns a range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of features
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Feature> getFeatures(int start, int end);

	/**
	 * Returns the number of features.
	 *
	 * @return the number of features
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFeaturesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Feature> getLatestApprovedByChannelId(long channelId);

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

	public void handleDeleteFeature(
			Feature originalFeature, ServiceContext serviceContext, User user)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isLinkedToLocalization(Long featureId, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isLinkedToResources(Long featureId, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isLovDataLinkedToApprovedFeature(
		long lovEntityResourceId, String lovDataCode);

	public void turnOffChildrenFeatures(
		long entityResourceId, long draftFeatureId);

	/**
	 * Updates the feature in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param feature the feature
	 * @return the feature that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Feature updateFeature(Feature feature);

	public void updateFeature(
			String featureName, String pageType, long parentPage,
			String routeId, Boolean status, Long channelId, BlockDTO blockDTO,
			List<String> whitelistLovData, List<String> segmentsLovData,
			Feature originalFeature, User user, ServiceContext serviceContext)
		throws JsonProcessingException, PortalException;

	public void updateSegment(
			long segmentId, String name, Boolean status, String method,
			String popUpTitle, String popUpSubTitle,
			ServiceContext serviceContext, User user)
		throws JsonProcessingException, PortalException;

	public Feature updateStatus(
			long userId, long featureId, int status,
			ServiceContext serviceContext)
		throws Exception;

}