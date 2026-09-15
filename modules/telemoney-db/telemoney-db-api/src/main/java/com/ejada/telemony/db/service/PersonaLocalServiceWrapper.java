/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PersonaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersonaLocalService
 * @generated
 */
public class PersonaLocalServiceWrapper
	implements PersonaLocalService, ServiceWrapper<PersonaLocalService> {

	public PersonaLocalServiceWrapper() {
		this(null);
	}

	public PersonaLocalServiceWrapper(PersonaLocalService personaLocalService) {
		_personaLocalService = personaLocalService;
	}

	@Override
	public void addDefualtPersona(Long channelId) throws Exception {
		_personaLocalService.addDefualtPersona(channelId);
	}

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
	@Override
	public com.ejada.telemony.db.model.Persona addPersona(
		com.ejada.telemony.db.model.Persona persona) {

		return _personaLocalService.addPersona(persona);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param personaId the primary key for the new persona
	 * @return the new persona
	 */
	@Override
	public com.ejada.telemony.db.model.Persona createPersona(long personaId) {
		return _personaLocalService.createPersona(personaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personaLocalService.deletePersistedModel(persistedModel);
	}

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
	@Override
	public com.ejada.telemony.db.model.Persona deletePersona(long personaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personaLocalService.deletePersona(personaId);
	}

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
	@Override
	public com.ejada.telemony.db.model.Persona deletePersona(
		com.ejada.telemony.db.model.Persona persona) {

		return _personaLocalService.deletePersona(persona);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _personaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _personaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _personaLocalService.dynamicQuery();
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

		return _personaLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _personaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _personaLocalService.dynamicQuery(
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

		return _personaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _personaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Persona fetchPersona(long personaId) {
		return _personaLocalService.fetchPersona(personaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _personaLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona>
		getAllPersonas() {

		return _personaLocalService.getAllPersonas();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona>
		getApprovedByEntityResourceId(long entityResourceId) {

		return _personaLocalService.getApprovedByEntityResourceId(
			entityResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona> getbyChannelId(
		Long channelId) {

		return _personaLocalService.getbyChannelId(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona>
			getDarkThemeDelete(Long channelId, Long themeId)
		throws Exception {

		return _personaLocalService.getDarkThemeDelete(channelId, themeId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes> getDarkThemes(
		Long channelId) {

		return _personaLocalService.getDarkThemes(channelId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDefaultPersona(
		Long channelId) {

		return _personaLocalService.getDefaultPersona(channelId);
	}

	@Override
	public com.ejada.telemony.db.model.Persona getDefaultPersonas(
		Long channelId) {

		return _personaLocalService.getDefaultPersonas(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona> getDesiredData(
		String nationality, int age, int income, String customerSegment,
		String gender, String sector, long channelId) {

		return _personaLocalService.getDesiredData(
			nationality, age, income, customerSegment, gender, sector,
			channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona>
		getDesiredDataLatestApproved(
			String nationality, int age, int income, String customerSegment,
			String gender, String sector, long channelId) {

		return _personaLocalService.getDesiredDataLatestApproved(
			nationality, age, income, customerSegment, gender, sector,
			channelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _personaLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona>
		getLatestApprovedByChannelId(long channelId) {

		return _personaLocalService.getLatestApprovedByChannelId(channelId);
	}

	@Override
	public java.util.Map<com.ejada.telemony.db.model.Persona, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId) {

		return _personaLocalService.getLatestApprovedByChannelIdWithPending(
			channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona>
			getLightThemeDelete(Long channelId, Long themeId)
		throws Exception {

		return _personaLocalService.getLightThemeDelete(channelId, themeId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Themes> getLightThemes(
		Long channelId) {

		return _personaLocalService.getLightThemes(channelId);
	}

	@Override
	public java.util.List<String> getLinkedBannerNames(Long personaId) {
		return _personaLocalService.getLinkedBannerNames(personaId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona>
		getNonDefaultPersonas(Long channelId) {

		return _personaLocalService.getNonDefaultPersonas(channelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _personaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persona with the primary key.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona
	 * @throws PortalException if a persona with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Persona getPersona(long personaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personaLocalService.getPersona(personaId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPersonaForApi(
			String nationality, int age, int income, String customerSegment,
			String gender, String sector, Long channelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personaLocalService.getPersonaForApi(
			nationality, age, income, customerSegment, gender, sector,
			channelId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
			getPersonaForApiLatestApproved(
				String nationality, int age, int income, String customerSegment,
				String gender, String sector, Long channelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personaLocalService.getPersonaForApiLatestApproved(
			nationality, age, income, customerSegment, gender, sector,
			channelId);
	}

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
	@Override
	public java.util.List<com.ejada.telemony.db.model.Persona> getPersonas(
		int start, int end) {

		return _personaLocalService.getPersonas(start, end);
	}

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 */
	@Override
	public int getPersonasCount() {
		return _personaLocalService.getPersonasCount();
	}

	@Override
	public void personaCreate(
			Long darkThemeId, Long lightThemeId, int startAge, int endAge,
			String name, String nationality, String customerSegment,
			String status, String description, String gender, int priority,
			java.util.Date dateTo, java.util.Date dateFrom, String sector,
			int minIncome, int maxIncome, Long channelId,
			boolean defaultPersona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_personaLocalService.personaCreate(
			darkThemeId, lightThemeId, startAge, endAge, name, nationality,
			customerSegment, status, description, gender, priority, dateTo,
			dateFrom, sector, minIncome, maxIncome, channelId, defaultPersona,
			serviceContext, user);
	}

	@Override
	public void personaDelete(
			Long id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_personaLocalService.personaDelete(id, serviceContext, user);
	}

	@Override
	public void personaUpdate(
			Long id, Long channelId, Long darkThemeId, Long lightThemeId,
			int startAge, int endAge, String name, String nationality,
			String customerSegment, String status, String description,
			String gender, int priority, java.util.Date dateTo,
			java.util.Date dateFrom, String sector, int minIncome,
			int maxIncome, Boolean defaultPersona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_personaLocalService.personaUpdate(
			id, channelId, darkThemeId, lightThemeId, startAge, endAge, name,
			nationality, customerSegment, status, description, gender, priority,
			dateTo, dateFrom, sector, minIncome, maxIncome, defaultPersona,
			serviceContext, user);
	}

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
	@Override
	public com.ejada.telemony.db.model.Persona updatePersona(
		com.ejada.telemony.db.model.Persona persona) {

		return _personaLocalService.updatePersona(persona);
	}

	@Override
	public com.ejada.telemony.db.model.Persona updateStatus(
			long userId, long personaId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _personaLocalService.updateStatus(
			userId, personaId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _personaLocalService.getBasePersistence();
	}

	@Override
	public PersonaLocalService getWrappedService() {
		return _personaLocalService;
	}

	@Override
	public void setWrappedService(PersonaLocalService personaLocalService) {
		_personaLocalService = personaLocalService;
	}

	private PersonaLocalService _personaLocalService;

}