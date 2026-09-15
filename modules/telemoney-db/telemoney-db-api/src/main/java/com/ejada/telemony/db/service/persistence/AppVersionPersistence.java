/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchAppVersionException;
import com.ejada.telemony.db.model.AppVersion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the app version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppVersionUtil
 * @generated
 */
@ProviderType
public interface AppVersionPersistence extends BasePersistence<AppVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppVersionUtil} to access the app version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the app versions where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching app versions
	 */
	public java.util.List<AppVersion> findByChannelId(long channelId);

	/**
	 * Returns a range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public java.util.List<AppVersion> findByChannelId(
		long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app versions where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the first app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the last app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the last app version in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the app versions before and after the current app version in the ordered set where channelId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public AppVersion[] findByChannelId_PrevAndNext(
			long versionId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Removes all the app versions where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of app versions where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching app versions
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @return the matching app versions
	 */
	public java.util.List<AppVersion> findByPlatform(
		String platform, long channelId);

	/**
	 * Returns a range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public java.util.List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app versions where platform = &#63; and channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByPlatform(
		String platform, long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByPlatform_First(
			String platform, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the first app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByPlatform_First(
		String platform, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the last app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByPlatform_Last(
			String platform, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the last app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByPlatform_Last(
		String platform, long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the app versions before and after the current app version in the ordered set where platform = &#63; and channelId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public AppVersion[] findByPlatform_PrevAndNext(
			long versionId, String platform, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Removes all the app versions where platform = &#63; and channelId = &#63; from the database.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 */
	public void removeByPlatform(String platform, long channelId);

	/**
	 * Returns the number of app versions where platform = &#63; and channelId = &#63;.
	 *
	 * @param platform the platform
	 * @param channelId the channel ID
	 * @return the number of matching app versions
	 */
	public int countByPlatform(String platform, long channelId);

	/**
	 * Returns all the app versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching app versions
	 */
	public java.util.List<AppVersion> findByWorkflowStatus(int status);

	/**
	 * Returns a range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public java.util.List<AppVersion> findByWorkflowStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByWorkflowStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app versions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByWorkflowStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByWorkflowStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the first app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByWorkflowStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the last app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByWorkflowStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the last app version in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByWorkflowStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the app versions before and after the current app version in the ordered set where status = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public AppVersion[] findByWorkflowStatus_PrevAndNext(
			long versionId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Removes all the app versions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByWorkflowStatus(int status);

	/**
	 * Returns the number of app versions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching app versions
	 */
	public int countByWorkflowStatus(int status);

	/**
	 * Returns all the app versions where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching app versions
	 */
	public java.util.List<AppVersion> findByEntityResourceId(
		long entityResourceId);

	/**
	 * Returns a range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of matching app versions
	 */
	public java.util.List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end);

	/**
	 * Returns an ordered range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app versions where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching app versions
	 */
	public java.util.List<AppVersion> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByEntityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the first app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByEntityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the last app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version
	 * @throws NoSuchAppVersionException if a matching app version could not be found
	 */
	public AppVersion findByEntityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Returns the last app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app version, or <code>null</code> if a matching app version could not be found
	 */
	public AppVersion fetchByEntityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns the app versions before and after the current app version in the ordered set where entityResourceId = &#63;.
	 *
	 * @param versionId the primary key of the current app version
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public AppVersion[] findByEntityResourceId_PrevAndNext(
			long versionId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
				orderByComparator)
		throws NoSuchAppVersionException;

	/**
	 * Removes all the app versions where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByEntityResourceId(long entityResourceId);

	/**
	 * Returns the number of app versions where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching app versions
	 */
	public int countByEntityResourceId(long entityResourceId);

	/**
	 * Caches the app version in the entity cache if it is enabled.
	 *
	 * @param appVersion the app version
	 */
	public void cacheResult(AppVersion appVersion);

	/**
	 * Caches the app versions in the entity cache if it is enabled.
	 *
	 * @param appVersions the app versions
	 */
	public void cacheResult(java.util.List<AppVersion> appVersions);

	/**
	 * Creates a new app version with the primary key. Does not add the app version to the database.
	 *
	 * @param versionId the primary key for the new app version
	 * @return the new app version
	 */
	public AppVersion create(long versionId);

	/**
	 * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version that was removed
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public AppVersion remove(long versionId) throws NoSuchAppVersionException;

	public AppVersion updateImpl(AppVersion appVersion);

	/**
	 * Returns the app version with the primary key or throws a <code>NoSuchAppVersionException</code> if it could not be found.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version
	 * @throws NoSuchAppVersionException if a app version with the primary key could not be found
	 */
	public AppVersion findByPrimaryKey(long versionId)
		throws NoSuchAppVersionException;

	/**
	 * Returns the app version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param versionId the primary key of the app version
	 * @return the app version, or <code>null</code> if a app version with the primary key could not be found
	 */
	public AppVersion fetchByPrimaryKey(long versionId);

	/**
	 * Returns all the app versions.
	 *
	 * @return the app versions
	 */
	public java.util.List<AppVersion> findAll();

	/**
	 * Returns a range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @return the range of app versions
	 */
	public java.util.List<AppVersion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app versions
	 */
	public java.util.List<AppVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the app versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app versions
	 * @param end the upper bound of the range of app versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of app versions
	 */
	public java.util.List<AppVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the app versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of app versions.
	 *
	 * @return the number of app versions
	 */
	public int countAll();

}