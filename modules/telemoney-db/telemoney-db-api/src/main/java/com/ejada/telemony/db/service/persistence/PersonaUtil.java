/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.model.Persona;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the persona service. This utility wraps <code>com.ejada.telemony.db.service.persistence.impl.PersonaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonaPersistence
 * @generated
 */
public class PersonaUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Persona persona) {
		getPersistence().clearCache(persona);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Persona> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Persona> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Persona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Persona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Persona update(Persona persona) {
		return getPersistence().update(persona);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Persona update(
		Persona persona, ServiceContext serviceContext) {

		return getPersistence().update(persona, serviceContext);
	}

	/**
	 * Returns all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @return the matching personas
	 */
	public static List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status) {

		return getPersistence().findBylightThemeAndStatus(
			channelId, lightThemeId, status);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	public static List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end) {

		return getPersistence().findBylightThemeAndStatus(
			channelId, lightThemeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findBylightThemeAndStatus(
			channelId, lightThemeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBylightThemeAndStatus(
			channelId, lightThemeId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findBylightThemeAndStatus_First(
			long channelId, Long lightThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBylightThemeAndStatus_First(
			channelId, lightThemeId, status, orderByComparator);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchBylightThemeAndStatus_First(
		long channelId, Long lightThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchBylightThemeAndStatus_First(
			channelId, lightThemeId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findBylightThemeAndStatus_Last(
			long channelId, Long lightThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBylightThemeAndStatus_Last(
			channelId, lightThemeId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchBylightThemeAndStatus_Last(
		long channelId, Long lightThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchBylightThemeAndStatus_Last(
			channelId, lightThemeId, status, orderByComparator);
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona[] findBylightThemeAndStatus_PrevAndNext(
			long personaId, long channelId, Long lightThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBylightThemeAndStatus_PrevAndNext(
			personaId, channelId, lightThemeId, status, orderByComparator);
	}

	/**
	 * Removes all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 */
	public static void removeBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status) {

		getPersistence().removeBylightThemeAndStatus(
			channelId, lightThemeId, status);
	}

	/**
	 * Returns the number of personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public static int countBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status) {

		return getPersistence().countBylightThemeAndStatus(
			channelId, lightThemeId, status);
	}

	/**
	 * Returns all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @return the matching personas
	 */
	public static List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status) {

		return getPersistence().findBydarkThemeAndStatus(
			channelId, darkThemeId, status);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	public static List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end) {

		return getPersistence().findBydarkThemeAndStatus(
			channelId, darkThemeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findBydarkThemeAndStatus(
			channelId, darkThemeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBydarkThemeAndStatus(
			channelId, darkThemeId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findBydarkThemeAndStatus_First(
			long channelId, Long darkThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBydarkThemeAndStatus_First(
			channelId, darkThemeId, status, orderByComparator);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchBydarkThemeAndStatus_First(
		long channelId, Long darkThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchBydarkThemeAndStatus_First(
			channelId, darkThemeId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findBydarkThemeAndStatus_Last(
			long channelId, Long darkThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBydarkThemeAndStatus_Last(
			channelId, darkThemeId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchBydarkThemeAndStatus_Last(
		long channelId, Long darkThemeId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchBydarkThemeAndStatus_Last(
			channelId, darkThemeId, status, orderByComparator);
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona[] findBydarkThemeAndStatus_PrevAndNext(
			long personaId, long channelId, Long darkThemeId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBydarkThemeAndStatus_PrevAndNext(
			personaId, channelId, darkThemeId, status, orderByComparator);
	}

	/**
	 * Removes all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 */
	public static void removeBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status) {

		getPersistence().removeBydarkThemeAndStatus(
			channelId, darkThemeId, status);
	}

	/**
	 * Returns the number of personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public static int countBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status) {

		return getPersistence().countBydarkThemeAndStatus(
			channelId, darkThemeId, status);
	}

	/**
	 * Returns all the personas where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching personas
	 */
	public static List<Persona> findByChannelIdAndStatus(
		long channelId, int status) {

		return getPersistence().findByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	public static List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByChannelIdAndStatus(
			channelId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findByChannelIdAndStatus_First(
			long channelId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByChannelIdAndStatus_First(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchByChannelIdAndStatus_First(
		long channelId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchByChannelIdAndStatus_First(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findByChannelIdAndStatus_Last(
			long channelId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchByChannelIdAndStatus_Last(
			channelId, status, orderByComparator);
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona[] findByChannelIdAndStatus_PrevAndNext(
			long personaId, long channelId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByChannelIdAndStatus_PrevAndNext(
			personaId, channelId, status, orderByComparator);
	}

	/**
	 * Removes all the personas where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	public static void removeByChannelIdAndStatus(long channelId, int status) {
		getPersistence().removeByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns the number of personas where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public static int countByChannelIdAndStatus(long channelId, int status) {
		return getPersistence().countByChannelIdAndStatus(channelId, status);
	}

	/**
	 * Returns all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @return the matching personas
	 */
	public static List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status) {

		return getPersistence().findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status);
	}

	/**
	 * Returns a range of all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	public static List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start,
		int end) {

		return getPersistence().findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, start, end);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBydefaultPersonaAndStatus(
			channelId, defaultPersona, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findBydefaultPersonaAndStatus_First(
			long channelId, boolean defaultPersona, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBydefaultPersonaAndStatus_First(
			channelId, defaultPersona, status, orderByComparator);
	}

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchBydefaultPersonaAndStatus_First(
		long channelId, boolean defaultPersona, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchBydefaultPersonaAndStatus_First(
			channelId, defaultPersona, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findBydefaultPersonaAndStatus_Last(
			long channelId, boolean defaultPersona, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBydefaultPersonaAndStatus_Last(
			channelId, defaultPersona, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchBydefaultPersonaAndStatus_Last(
		long channelId, boolean defaultPersona, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchBydefaultPersonaAndStatus_Last(
			channelId, defaultPersona, status, orderByComparator);
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona[] findBydefaultPersonaAndStatus_PrevAndNext(
			long personaId, long channelId, boolean defaultPersona, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findBydefaultPersonaAndStatus_PrevAndNext(
			personaId, channelId, defaultPersona, status, orderByComparator);
	}

	/**
	 * Removes all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 */
	public static void removeBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status) {

		getPersistence().removeBydefaultPersonaAndStatus(
			channelId, defaultPersona, status);
	}

	/**
	 * Returns the number of personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @return the number of matching personas
	 */
	public static int countBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status) {

		return getPersistence().countBydefaultPersonaAndStatus(
			channelId, defaultPersona, status);
	}

	/**
	 * Returns all the personas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching personas
	 */
	public static List<Persona> findByentityResourceId(long entityResourceId) {
		return getPersistence().findByentityResourceId(entityResourceId);
	}

	/**
	 * Returns a range of all the personas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	public static List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByentityResourceId(
			entityResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findByentityResourceId_First(
			long entityResourceId, OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchByentityResourceId_First(
		long entityResourceId, OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchByentityResourceId_First(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findByentityResourceId_Last(
			long entityResourceId, OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchByentityResourceId_Last(
		long entityResourceId, OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchByentityResourceId_Last(
			entityResourceId, orderByComparator);
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona[] findByentityResourceId_PrevAndNext(
			long personaId, long entityResourceId,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByentityResourceId_PrevAndNext(
			personaId, entityResourceId, orderByComparator);
	}

	/**
	 * Removes all the personas where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public static void removeByentityResourceId(long entityResourceId) {
		getPersistence().removeByentityResourceId(entityResourceId);
	}

	/**
	 * Returns the number of personas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching personas
	 */
	public static int countByentityResourceId(long entityResourceId) {
		return getPersistence().countByentityResourceId(entityResourceId);
	}

	/**
	 * Returns all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the matching personas
	 */
	public static List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status) {

		return getPersistence().findByentityResourceIdAndStatus(
			entityResourceId, status);
	}

	/**
	 * Returns a range of all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of matching personas
	 */
	public static List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end) {

		return getPersistence().findByentityResourceIdAndStatus(
			entityResourceId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findByentityResourceIdAndStatus(
			entityResourceId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personas
	 */
	public static List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end,
		OrderByComparator<Persona> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByentityResourceIdAndStatus(
			entityResourceId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findByentityResourceIdAndStatus_First(
			long entityResourceId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByentityResourceIdAndStatus_First(
			entityResourceId, status, orderByComparator);
	}

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchByentityResourceIdAndStatus_First(
		long entityResourceId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchByentityResourceIdAndStatus_First(
			entityResourceId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public static Persona findByentityResourceIdAndStatus_Last(
			long entityResourceId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByentityResourceIdAndStatus_Last(
			entityResourceId, status, orderByComparator);
	}

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public static Persona fetchByentityResourceIdAndStatus_Last(
		long entityResourceId, int status,
		OrderByComparator<Persona> orderByComparator) {

		return getPersistence().fetchByentityResourceIdAndStatus_Last(
			entityResourceId, status, orderByComparator);
	}

	/**
	 * Returns the personas before and after the current persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona[] findByentityResourceIdAndStatus_PrevAndNext(
			long personaId, long entityResourceId, int status,
			OrderByComparator<Persona> orderByComparator)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByentityResourceIdAndStatus_PrevAndNext(
			personaId, entityResourceId, status, orderByComparator);
	}

	/**
	 * Removes all the personas where entityResourceId = &#63; and status = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 */
	public static void removeByentityResourceIdAndStatus(
		long entityResourceId, int status) {

		getPersistence().removeByentityResourceIdAndStatus(
			entityResourceId, status);
	}

	/**
	 * Returns the number of personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public static int countByentityResourceIdAndStatus(
		long entityResourceId, int status) {

		return getPersistence().countByentityResourceIdAndStatus(
			entityResourceId, status);
	}

	/**
	 * Caches the persona in the entity cache if it is enabled.
	 *
	 * @param persona the persona
	 */
	public static void cacheResult(Persona persona) {
		getPersistence().cacheResult(persona);
	}

	/**
	 * Caches the personas in the entity cache if it is enabled.
	 *
	 * @param personas the personas
	 */
	public static void cacheResult(List<Persona> personas) {
		getPersistence().cacheResult(personas);
	}

	/**
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param personaId the primary key for the new persona
	 * @return the new persona
	 */
	public static Persona create(long personaId) {
		return getPersistence().create(personaId);
	}

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona that was removed
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona remove(long personaId)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().remove(personaId);
	}

	public static Persona updateImpl(Persona persona) {
		return getPersistence().updateImpl(persona);
	}

	/**
	 * Returns the persona with the primary key or throws a <code>NoSuchPersonaException</code> if it could not be found.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public static Persona findByPrimaryKey(long personaId)
		throws com.ejada.telemony.db.exception.NoSuchPersonaException {

		return getPersistence().findByPrimaryKey(personaId);
	}

	/**
	 * Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona, or <code>null</code> if a persona with the primary key could not be found
	 */
	public static Persona fetchByPrimaryKey(long personaId) {
		return getPersistence().fetchByPrimaryKey(personaId);
	}

	/**
	 * Returns all the personas.
	 *
	 * @return the personas
	 */
	public static List<Persona> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of personas
	 */
	public static List<Persona> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personas
	 */
	public static List<Persona> findAll(
		int start, int end, OrderByComparator<Persona> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personas
	 */
	public static List<Persona> findAll(
		int start, int end, OrderByComparator<Persona> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the personas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersonaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PersonaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PersonaPersistence _persistence;

}