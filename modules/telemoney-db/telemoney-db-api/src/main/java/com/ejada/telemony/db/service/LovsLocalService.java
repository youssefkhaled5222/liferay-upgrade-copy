/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.*;
import com.ejada.telemony.db.model.LovData;
import com.ejada.telemony.db.model.Lovs;
import com.ejada.telemony.db.model.LovsLocalization;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
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
import java.util.Map;

import javax.portlet.PortletException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Lovs. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.Lovs"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LovsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.LovsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the lovs local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link LovsLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addLovDataWorkflow(
			Long lovId, String lovType, String recordTypeCode,
			Map<String, String> values, String recordShortDescription,
			Long channelId, Long originalLovDataId, User user,
			ServiceContext serviceContext)
		throws Exception;

	/**
	 * Adds the lovs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovs the lovs
	 * @return the lovs that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Lovs addLovs(Lovs lovs);

	/**
	 * Creates a new lovs with the primary key. Does not add the lovs to the database.
	 *
	 * @param id the primary key for the new lovs
	 * @return the new lovs
	 */
	@Transactional(enabled = false)
	public Lovs createLovs(long id);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteLovByLovId(Long id, Long channelId) throws Exception;

	public void deleteLovDataWorkflow(
			LovData originalLovData, Long chn, ServiceContext serviceContext,
			User user)
		throws Exception;

	/**
	 * Deletes the lovs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs that was removed
	 * @throws PortalException if a lovs with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Lovs deleteLovs(long id) throws PortalException;

	/**
	 * Deletes the lovs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovs the lovs
	 * @return the lovs that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Lovs deleteLovs(Lovs lovs);

	public void deleteLovWorkflow(
			Long id, User user, ServiceContext serviceContext)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
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
	public Lovs fetchLovs(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LovsLocalization fetchLovsLocalization(long id, String languageId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> getByChannelId(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> getByEntityResourceId(long entityResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getLangNamesByCode(String code, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getLangTypeCodeByLOVCode(String code, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> getLatestApprovedByChannelId(long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> getLatestApprovedByChannelIdAndCode(
		long channelId, String code);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getLatestApprovedLangNamesByCode(
		String code, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lovs getLatestApprovedLovByEntityResourceId(long entityResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LovData> getLatestApprovedLovDataByCode(
		String code, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LovData> getLovDataByCode(String code, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLovDataCountByLovId(Long LovId);

	/**
	 * Returns the lovs with the primary key.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs
	 * @throws PortalException if a lovs with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lovs getLovs(long id) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getLovsAndRelatedDataByCode(
		String code, String language, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> getLovsByTypeCodeAndStatus(
		String code, long channelId, int status);

	/**
	 * Returns a range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of lovses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> getLovses(int start, int end);

	/**
	 * Returns the number of lovses.
	 *
	 * @return the number of lovses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLovsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LovsLocalization getLovsLocalization(long id, String languageId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LovsLocalization> getLovsLocalizations(long id);

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

	public void importLovsAndLovDataFromCSV(String filePath, Long channelId)
		throws IOException;

	public Lovs lovListCreate(
			Map<String, String> names, String code, String eventCode,
			Long channelId, User user, ServiceContext serviceContext)
		throws Exception;

	public void lovListDelete(Long id, Long channelId) throws Exception;

	public Lovs lovListUpdate(
			Long id, Map<String, String> names, String code, Long channelId,
			String eventCode)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> searchByCode(String code, Long channelId)
		throws IOException, PortletException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lovs> searchLovLocalizationByName(
			String searchName, Long channelId)
		throws IOException;

	public void updateLovDataWorkflow(
			Long id, Long lovId, String lovType, String recordTypeCode,
			Map<String, String> values, String recordShortDescription,
			Long channelId, User user, ServiceContext serviceContext)
		throws Exception;

	/**
	 * Updates the lovs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovs the lovs
	 * @return the lovs that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Lovs updateLovs(Lovs lovs);

	public LovsLocalization updateLovsLocalization(
			Lovs lovs, String languageId, String name)
		throws PortalException;

	public List<LovsLocalization> updateLovsLocalizations(
			Lovs lovs, Map<String, String> nameMap)
		throws PortalException;

	public void updateLovWorkflow(
			Long id, Map<String, String> nameValues, String code,
			Long channelId, String eventCode, User user,
			ServiceContext serviceContext)
		throws Exception;

	public Lovs updateStatus(
			long userId, long lovId, int status, ServiceContext serviceContext)
		throws Exception;

}