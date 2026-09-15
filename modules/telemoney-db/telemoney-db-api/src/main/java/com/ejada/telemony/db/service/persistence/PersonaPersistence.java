/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchPersonaException;
import com.ejada.telemony.db.model.Persona;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonaUtil
 * @generated
 */
@ProviderType
public interface PersonaPersistence extends BasePersistence<Persona> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonaUtil} to access the persona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @return the matching personas
	 */
	public java.util.List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status);

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
	public java.util.List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end);

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
	public java.util.List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public java.util.List<Persona> findBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator,
		boolean useFinderCache);

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
	public Persona findBylightThemeAndStatus_First(
			long channelId, Long lightThemeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchBylightThemeAndStatus_First(
		long channelId, Long lightThemeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona findBylightThemeAndStatus_Last(
			long channelId, Long lightThemeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchBylightThemeAndStatus_Last(
		long channelId, Long lightThemeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona[] findBylightThemeAndStatus_PrevAndNext(
			long personaId, long channelId, Long lightThemeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Removes all the personas where channelId = &#63; and lightThemeId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 */
	public void removeBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status);

	/**
	 * Returns the number of personas where channelId = &#63; and lightThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param lightThemeId the light theme ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public int countBylightThemeAndStatus(
		long channelId, Long lightThemeId, int status);

	/**
	 * Returns all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @return the matching personas
	 */
	public java.util.List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status);

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
	public java.util.List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end);

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
	public java.util.List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public java.util.List<Persona> findBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator,
		boolean useFinderCache);

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
	public Persona findBydarkThemeAndStatus_First(
			long channelId, Long darkThemeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchBydarkThemeAndStatus_First(
		long channelId, Long darkThemeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona findBydarkThemeAndStatus_Last(
			long channelId, Long darkThemeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchBydarkThemeAndStatus_Last(
		long channelId, Long darkThemeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona[] findBydarkThemeAndStatus_PrevAndNext(
			long personaId, long channelId, Long darkThemeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Removes all the personas where channelId = &#63; and darkThemeId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 */
	public void removeBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status);

	/**
	 * Returns the number of personas where channelId = &#63; and darkThemeId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param darkThemeId the dark theme ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public int countBydarkThemeAndStatus(
		long channelId, Long darkThemeId, int status);

	/**
	 * Returns all the personas where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the matching personas
	 */
	public java.util.List<Persona> findByChannelIdAndStatus(
		long channelId, int status);

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
	public java.util.List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end);

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
	public java.util.List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public java.util.List<Persona> findByChannelIdAndStatus(
		long channelId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public Persona findByChannelIdAndStatus_First(
			long channelId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchByChannelIdAndStatus_First(
		long channelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public Persona findByChannelIdAndStatus_Last(
			long channelId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchByChannelIdAndStatus_Last(
		long channelId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona[] findByChannelIdAndStatus_PrevAndNext(
			long personaId, long channelId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Removes all the personas where channelId = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 */
	public void removeByChannelIdAndStatus(long channelId, int status);

	/**
	 * Returns the number of personas where channelId = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public int countByChannelIdAndStatus(long channelId, int status);

	/**
	 * Returns all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @return the matching personas
	 */
	public java.util.List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status);

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
	public java.util.List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start, int end);

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
	public java.util.List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public java.util.List<Persona> findBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator,
		boolean useFinderCache);

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
	public Persona findBydefaultPersonaAndStatus_First(
			long channelId, boolean defaultPersona, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the first persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchBydefaultPersonaAndStatus_First(
		long channelId, boolean defaultPersona, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona findBydefaultPersonaAndStatus_Last(
			long channelId, boolean defaultPersona, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the last persona in the ordered set where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchBydefaultPersonaAndStatus_Last(
		long channelId, boolean defaultPersona, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona[] findBydefaultPersonaAndStatus_PrevAndNext(
			long personaId, long channelId, boolean defaultPersona, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Removes all the personas where channelId = &#63; and defaultPersona = &#63; and status = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 */
	public void removeBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status);

	/**
	 * Returns the number of personas where channelId = &#63; and defaultPersona = &#63; and status = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param defaultPersona the default persona
	 * @param status the status
	 * @return the number of matching personas
	 */
	public int countBydefaultPersonaAndStatus(
		long channelId, boolean defaultPersona, int status);

	/**
	 * Returns all the personas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching personas
	 */
	public java.util.List<Persona> findByentityResourceId(
		long entityResourceId);

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
	public java.util.List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end);

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
	public java.util.List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public java.util.List<Persona> findByentityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public Persona findByentityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchByentityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public Persona findByentityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchByentityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

	/**
	 * Returns the personas before and after the current persona in the ordered set where entityResourceId = &#63;.
	 *
	 * @param personaId the primary key of the current persona
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public Persona[] findByentityResourceId_PrevAndNext(
			long personaId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Removes all the personas where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByentityResourceId(long entityResourceId);

	/**
	 * Returns the number of personas where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching personas
	 */
	public int countByentityResourceId(long entityResourceId);

	/**
	 * Returns all the personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the matching personas
	 */
	public java.util.List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status);

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
	public java.util.List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end);

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
	public java.util.List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public java.util.List<Persona> findByentityResourceIdAndStatus(
		long entityResourceId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public Persona findByentityResourceIdAndStatus_First(
			long entityResourceId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the first persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchByentityResourceIdAndStatus_First(
		long entityResourceId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona
	 * @throws NoSuchPersonaException if a matching persona could not be found
	 */
	public Persona findByentityResourceIdAndStatus_Last(
			long entityResourceId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Returns the last persona in the ordered set where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona, or <code>null</code> if a matching persona could not be found
	 */
	public Persona fetchByentityResourceIdAndStatus_Last(
		long entityResourceId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public Persona[] findByentityResourceIdAndStatus_PrevAndNext(
			long personaId, long entityResourceId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Persona>
				orderByComparator)
		throws NoSuchPersonaException;

	/**
	 * Removes all the personas where entityResourceId = &#63; and status = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 */
	public void removeByentityResourceIdAndStatus(
		long entityResourceId, int status);

	/**
	 * Returns the number of personas where entityResourceId = &#63; and status = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param status the status
	 * @return the number of matching personas
	 */
	public int countByentityResourceIdAndStatus(
		long entityResourceId, int status);

	/**
	 * Caches the persona in the entity cache if it is enabled.
	 *
	 * @param persona the persona
	 */
	public void cacheResult(Persona persona);

	/**
	 * Caches the personas in the entity cache if it is enabled.
	 *
	 * @param personas the personas
	 */
	public void cacheResult(java.util.List<Persona> personas);

	/**
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param personaId the primary key for the new persona
	 * @return the new persona
	 */
	public Persona create(long personaId);

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona that was removed
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public Persona remove(long personaId) throws NoSuchPersonaException;

	public Persona updateImpl(Persona persona);

	/**
	 * Returns the persona with the primary key or throws a <code>NoSuchPersonaException</code> if it could not be found.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona
	 * @throws NoSuchPersonaException if a persona with the primary key could not be found
	 */
	public Persona findByPrimaryKey(long personaId)
		throws NoSuchPersonaException;

	/**
	 * Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personaId the primary key of the persona
	 * @return the persona, or <code>null</code> if a persona with the primary key could not be found
	 */
	public Persona fetchByPrimaryKey(long personaId);

	/**
	 * Returns all the personas.
	 *
	 * @return the personas
	 */
	public java.util.List<Persona> findAll();

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
	public java.util.List<Persona> findAll(int start, int end);

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
	public java.util.List<Persona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator);

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
	public java.util.List<Persona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Persona>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the personas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 */
	public int countAll();

}