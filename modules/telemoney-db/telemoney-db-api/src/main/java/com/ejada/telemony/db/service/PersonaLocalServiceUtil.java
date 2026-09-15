/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Persona;

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
 * Provides the local service utility for Persona. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.PersonaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersonaLocalService
 * @generated
 */
public class PersonaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.PersonaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addDefualtPersona(Long channelId) throws Exception {
		getService().addDefualtPersona(channelId);
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
	public static Persona addPersona(Persona persona) {
		return getService().addPersona(persona);
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
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param personaId the primary key for the new persona
	 * @return the new persona
	 */
	public static Persona createPersona(long personaId) {
		return getService().createPersona(personaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Persona deletePersona(long personaId) throws PortalException {
		return getService().deletePersona(personaId);
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
	public static Persona deletePersona(Persona persona) {
		return getService().deletePersona(persona);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.PersonaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.PersonaModelImpl</code>.
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

	public static Persona fetchPersona(long personaId) {
		return getService().fetchPersona(personaId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Persona> getAllPersonas() {
		return getService().getAllPersonas();
	}

	public static List<Persona> getApprovedByEntityResourceId(
		long entityResourceId) {

		return getService().getApprovedByEntityResourceId(entityResourceId);
	}

	public static List<Persona> getbyChannelId(Long channelId) {
		return getService().getbyChannelId(channelId);
	}

	public static List<Persona> getDarkThemeDelete(Long channelId, Long themeId)
		throws Exception {

		return getService().getDarkThemeDelete(channelId, themeId);
	}

	public static List<com.ejada.telemony.db.model.Themes> getDarkThemes(
		Long channelId) {

		return getService().getDarkThemes(channelId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDefaultPersona(
		Long channelId) {

		return getService().getDefaultPersona(channelId);
	}

	public static Persona getDefaultPersonas(Long channelId) {
		return getService().getDefaultPersonas(channelId);
	}

	public static List<Persona> getDesiredData(
		String nationality, int age, int income, String customerSegment,
		String gender, String sector, long channelId) {

		return getService().getDesiredData(
			nationality, age, income, customerSegment, gender, sector,
			channelId);
	}

	public static List<Persona> getDesiredDataLatestApproved(
		String nationality, int age, int income, String customerSegment,
		String gender, String sector, long channelId) {

		return getService().getDesiredDataLatestApproved(
			nationality, age, income, customerSegment, gender, sector,
			channelId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<Persona> getLatestApprovedByChannelId(long channelId) {
		return getService().getLatestApprovedByChannelId(channelId);
	}

	public static Map<Persona, Boolean> getLatestApprovedByChannelIdWithPending(
		long channelId) {

		return getService().getLatestApprovedByChannelIdWithPending(channelId);
	}

	public static List<Persona> getLightThemeDelete(
			Long channelId, Long themeId)
		throws Exception {

		return getService().getLightThemeDelete(channelId, themeId);
	}

	public static List<com.ejada.telemony.db.model.Themes> getLightThemes(
		Long channelId) {

		return getService().getLightThemes(channelId);
	}

	public static List<String> getLinkedBannerNames(Long personaId) {
		return getService().getLinkedBannerNames(personaId);
	}

	public static List<Persona> getNonDefaultPersonas(Long channelId) {
		return getService().getNonDefaultPersonas(channelId);
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
	 * Returns the persona with the primary key.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona
	 * @throws PortalException if a persona with the primary key could not be found
	 */
	public static Persona getPersona(long personaId) throws PortalException {
		return getService().getPersona(personaId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPersonaForApi(
			String nationality, int age, int income, String customerSegment,
			String gender, String sector, Long channelId)
		throws PortalException {

		return getService().getPersonaForApi(
			nationality, age, income, customerSegment, gender, sector,
			channelId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getPersonaForApiLatestApproved(
				String nationality, int age, int income, String customerSegment,
				String gender, String sector, Long channelId)
		throws PortalException {

		return getService().getPersonaForApiLatestApproved(
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
	public static List<Persona> getPersonas(int start, int end) {
		return getService().getPersonas(start, end);
	}

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 */
	public static int getPersonasCount() {
		return getService().getPersonasCount();
	}

	public static void personaCreate(
			Long darkThemeId, Long lightThemeId, int startAge, int endAge,
			String name, String nationality, String customerSegment,
			String status, String description, String gender, int priority,
			java.util.Date dateTo, java.util.Date dateFrom, String sector,
			int minIncome, int maxIncome, Long channelId,
			boolean defaultPersona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().personaCreate(
			darkThemeId, lightThemeId, startAge, endAge, name, nationality,
			customerSegment, status, description, gender, priority, dateTo,
			dateFrom, sector, minIncome, maxIncome, channelId, defaultPersona,
			serviceContext, user);
	}

	public static void personaDelete(
			Long id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().personaDelete(id, serviceContext, user);
	}

	public static void personaUpdate(
			Long id, Long channelId, Long darkThemeId, Long lightThemeId,
			int startAge, int endAge, String name, String nationality,
			String customerSegment, String status, String description,
			String gender, int priority, java.util.Date dateTo,
			java.util.Date dateFrom, String sector, int minIncome,
			int maxIncome, Boolean defaultPersona,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().personaUpdate(
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
	public static Persona updatePersona(Persona persona) {
		return getService().updatePersona(persona);
	}

	public static Persona updateStatus(
			long userId, long personaId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, personaId, status, serviceContext);
	}

	public static PersonaLocalService getService() {
		return _service;
	}

	public static void setService(PersonaLocalService service) {
		_service = service;
	}

	private static volatile PersonaLocalService _service;

}