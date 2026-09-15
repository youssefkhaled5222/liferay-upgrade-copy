/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.model.Themes;

import com.liferay.petra.sql.dsl.query.DSLQuery;
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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Persona. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersonaLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.Persona"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersonaLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.PersonaLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the persona local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PersonaLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addDefualtPersona(Long channelId) throws Exception;

	/**
	 * Adds the persona to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persona the persona
	 * @return the persona that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Persona addPersona(Persona persona);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param personaId the primary key for the new persona
	 * @return the new persona
	 */
	@Transactional(enabled = false)
	public Persona createPersona(long personaId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona that was removed
	 * @throws PortalException if a persona with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Persona deletePersona(long personaId) throws PortalException;

	/**
	 * Deletes the persona from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persona the persona
	 * @return the persona that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Persona deletePersona(Persona persona);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.PersonaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.PersonaModelImpl</code>.
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
	public Persona fetchPersona(long personaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getAllPersonas();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getApprovedByEntityResourceId(long entityResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getbyChannelId(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getDarkThemeDelete(Long channelId, Long themeId)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getDarkThemes(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getDefaultPersona(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Persona getDefaultPersonas(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getDesiredData(
		String nationality, int age, int income, String customerSegment,
		String gender, String sector, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getDesiredDataLatestApproved(
		String nationality, int age, int income, String customerSegment,
		String gender, String sector, long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getLatestApprovedByChannelId(long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<Persona, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getLightThemeDelete(Long channelId, Long themeId)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getLightThemes(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getLinkedBannerNames(Long personaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getNonDefaultPersonas(Long channelId);

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
	 * Returns the persona with the primary key.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona
	 * @throws PortalException if a persona with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Persona getPersona(long personaId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPersonaForApi(
			String nationality, int age, int income, String customerSegment,
			String gender, String sector, Long channelId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPersonaForApiLatestApproved(
			String nationality, int age, int income, String customerSegment,
			String gender, String sector, Long channelId)
		throws PortalException;

	/**
	 * Returns a range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of personas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Persona> getPersonas(int start, int end);

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersonasCount();

	public void personaCreate(
			Long darkThemeId, Long lightThemeId, int startAge, int endAge,
			String name, String nationality, String customerSegment,
			String status, String description, String gender, int priority,
			java.util.Date dateTo, java.util.Date dateFrom, String sector,
			int minIncome, int maxIncome, Long channelId,
			boolean defaultPersona, ServiceContext serviceContext, User user)
		throws Exception;

	public void personaDelete(Long id, ServiceContext serviceContext, User user)
		throws Exception;

	public void personaUpdate(
			Long id, Long channelId, Long darkThemeId, Long lightThemeId,
			int startAge, int endAge, String name, String nationality,
			String customerSegment, String status, String description,
			String gender, int priority, java.util.Date dateTo,
			java.util.Date dateFrom, String sector, int minIncome,
			int maxIncome, Boolean defaultPersona,
			ServiceContext serviceContext, User user)
		throws Exception;

	/**
	 * Updates the persona in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persona the persona
	 * @return the persona that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Persona updatePersona(Persona persona);

	public Persona updateStatus(
			long userId, long personaId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}