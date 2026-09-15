/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchAppEnvironmentException;
import com.ejada.telemony.db.model.AppEnvironment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the app environment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppEnvironmentUtil
 * @generated
 */
@ProviderType
public interface AppEnvironmentPersistence
	extends BasePersistence<AppEnvironment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppEnvironmentUtil} to access the app environment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the app environments where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching app environments
	 */
	public java.util.List<AppEnvironment> findByChannelId(long channelId);

	/**
	 * Returns a range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByChannelId(
		long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app environments where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public AppEnvironment findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Returns the first app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public AppEnvironment fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns the last app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public AppEnvironment findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Returns the last app environment in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public AppEnvironment fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where channelId = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public AppEnvironment[] findByChannelId_PrevAndNext(
			long environmentId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Removes all the app environments where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of app environments where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching app environments
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the app environments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching app environments
	 */
	public java.util.List<AppEnvironment> findByWorkflowStatus(int status);

	/**
	 * Returns a range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app environments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByWorkflowStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public AppEnvironment findByWorkflowStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Returns the first app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public AppEnvironment fetchByWorkflowStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns the last app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public AppEnvironment findByWorkflowStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Returns the last app environment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public AppEnvironment fetchByWorkflowStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where status = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public AppEnvironment[] findByWorkflowStatus_PrevAndNext(
			long environmentId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Removes all the app environments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByWorkflowStatus(int status);

	/**
	 * Returns the number of app environments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching app environments
	 */
	public int countByWorkflowStatus(int status);

	/**
	 * Returns all the app environments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching app environments
	 */
	public java.util.List<AppEnvironment> findByEntityResourceId(
		long entityResourceId);

	/**
	 * Returns a range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end);

	/**
	 * Returns an ordered range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app environments where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app environments
	 */
	public java.util.List<AppEnvironment> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public AppEnvironment findByEntityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Returns the first app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public AppEnvironment fetchByEntityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns the last app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment
	 * @throws NoSuchAppEnvironmentException if a matching app environment could not be found
	 */
	public AppEnvironment findByEntityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Returns the last app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app environment, or <code>null</code> if a matching app environment could not be found
	 */
	public AppEnvironment fetchByEntityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns the app environments before and after the current app environment in the ordered set where entityResourceId = &#63;.
	 *
	 * @param environmentId the primary key of the current app environment
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public AppEnvironment[] findByEntityResourceId_PrevAndNext(
			long environmentId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
				orderByComparator)
		throws NoSuchAppEnvironmentException;

	/**
	 * Removes all the app environments where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByEntityResourceId(long entityResourceId);

	/**
	 * Returns the number of app environments where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching app environments
	 */
	public int countByEntityResourceId(long entityResourceId);

	/**
	 * Caches the app environment in the entity cache if it is enabled.
	 *
	 * @param appEnvironment the app environment
	 */
	public void cacheResult(AppEnvironment appEnvironment);

	/**
	 * Caches the app environments in the entity cache if it is enabled.
	 *
	 * @param appEnvironments the app environments
	 */
	public void cacheResult(java.util.List<AppEnvironment> appEnvironments);

	/**
	 * Creates a new app environment with the primary key. Does not add the app environment to the database.
	 *
	 * @param environmentId the primary key for the new app environment
	 * @return the new app environment
	 */
	public AppEnvironment create(long environmentId);

	/**
	 * Removes the app environment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment that was removed
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public AppEnvironment remove(long environmentId)
		throws NoSuchAppEnvironmentException;

	public AppEnvironment updateImpl(AppEnvironment appEnvironment);

	/**
	 * Returns the app environment with the primary key or throws a <code>NoSuchAppEnvironmentException</code> if it could not be found.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment
	 * @throws NoSuchAppEnvironmentException if a app environment with the primary key could not be found
	 */
	public AppEnvironment findByPrimaryKey(long environmentId)
		throws NoSuchAppEnvironmentException;

	/**
	 * Returns the app environment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param environmentId the primary key of the app environment
	 * @return the app environment, or <code>null</code> if a app environment with the primary key could not be found
	 */
	public AppEnvironment fetchByPrimaryKey(long environmentId);

	/**
	 * Returns all the app environments.
	 *
	 * @return the app environments
	 */
	public java.util.List<AppEnvironment> findAll();

	/**
	 * Returns a range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @return the range of app environments
	 */
	public java.util.List<AppEnvironment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app environments
	 */
	public java.util.List<AppEnvironment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app environments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppEnvironmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app environments
	 * @param end the upper bound of the range of app environments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app environments
	 */
	public java.util.List<AppEnvironment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppEnvironment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the app environments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of app environments.
	 *
	 * @return the number of app environments
	 */
	public int countAll();

}