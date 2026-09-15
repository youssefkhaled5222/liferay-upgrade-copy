/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchGlobalVersionException;
import com.ejada.telemony.db.model.GlobalVersion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the global version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GlobalVersionUtil
 * @generated
 */
@ProviderType
public interface GlobalVersionPersistence
	extends BasePersistence<GlobalVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GlobalVersionUtil} to access the global version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; or throws a <code>NoSuchGlobalVersionException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the matching global version
	 * @throws NoSuchGlobalVersionException if a matching global version could not be found
	 */
	public GlobalVersion findByC_C_C(
			long companyId, long channelId, String componentName)
		throws NoSuchGlobalVersionException;

	/**
	 * Returns the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the matching global version, or <code>null</code> if a matching global version could not be found
	 */
	public GlobalVersion fetchByC_C_C(
		long companyId, long channelId, String componentName);

	/**
	 * Returns the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching global version, or <code>null</code> if a matching global version could not be found
	 */
	public GlobalVersion fetchByC_C_C(
		long companyId, long channelId, String componentName,
		boolean useFinderCache);

	/**
	 * Removes the global version where companyId = &#63; and channelId = &#63; and componentName = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the global version that was removed
	 */
	public GlobalVersion removeByC_C_C(
			long companyId, long channelId, String componentName)
		throws NoSuchGlobalVersionException;

	/**
	 * Returns the number of global versions where companyId = &#63; and channelId = &#63; and componentName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param channelId the channel ID
	 * @param componentName the component name
	 * @return the number of matching global versions
	 */
	public int countByC_C_C(
		long companyId, long channelId, String componentName);

	/**
	 * Returns all the global versions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching global versions
	 */
	public java.util.List<GlobalVersion> findByCompanyId(long companyId);

	/**
	 * Returns a range of all the global versions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @return the range of matching global versions
	 */
	public java.util.List<GlobalVersion> findByCompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the global versions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global versions
	 */
	public java.util.List<GlobalVersion> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the global versions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching global versions
	 */
	public java.util.List<GlobalVersion> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global version
	 * @throws NoSuchGlobalVersionException if a matching global version could not be found
	 */
	public GlobalVersion findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
				orderByComparator)
		throws NoSuchGlobalVersionException;

	/**
	 * Returns the first global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global version, or <code>null</code> if a matching global version could not be found
	 */
	public GlobalVersion fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
			orderByComparator);

	/**
	 * Returns the last global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global version
	 * @throws NoSuchGlobalVersionException if a matching global version could not be found
	 */
	public GlobalVersion findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
				orderByComparator)
		throws NoSuchGlobalVersionException;

	/**
	 * Returns the last global version in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global version, or <code>null</code> if a matching global version could not be found
	 */
	public GlobalVersion fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
			orderByComparator);

	/**
	 * Returns the global versions before and after the current global version in the ordered set where companyId = &#63;.
	 *
	 * @param versionId the primary key of the current global version
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global version
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	public GlobalVersion[] findByCompanyId_PrevAndNext(
			long versionId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
				orderByComparator)
		throws NoSuchGlobalVersionException;

	/**
	 * Removes all the global versions where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of global versions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching global versions
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Caches the global version in the entity cache if it is enabled.
	 *
	 * @param globalVersion the global version
	 */
	public void cacheResult(GlobalVersion globalVersion);

	/**
	 * Caches the global versions in the entity cache if it is enabled.
	 *
	 * @param globalVersions the global versions
	 */
	public void cacheResult(java.util.List<GlobalVersion> globalVersions);

	/**
	 * Creates a new global version with the primary key. Does not add the global version to the database.
	 *
	 * @param versionId the primary key for the new global version
	 * @return the new global version
	 */
	public GlobalVersion create(long versionId);

	/**
	 * Removes the global version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version that was removed
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	public GlobalVersion remove(long versionId)
		throws NoSuchGlobalVersionException;

	public GlobalVersion updateImpl(GlobalVersion globalVersion);

	/**
	 * Returns the global version with the primary key or throws a <code>NoSuchGlobalVersionException</code> if it could not be found.
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version
	 * @throws NoSuchGlobalVersionException if a global version with the primary key could not be found
	 */
	public GlobalVersion findByPrimaryKey(long versionId)
		throws NoSuchGlobalVersionException;

	/**
	 * Returns the global version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param versionId the primary key of the global version
	 * @return the global version, or <code>null</code> if a global version with the primary key could not be found
	 */
	public GlobalVersion fetchByPrimaryKey(long versionId);

	/**
	 * Returns all the global versions.
	 *
	 * @return the global versions
	 */
	public java.util.List<GlobalVersion> findAll();

	/**
	 * Returns a range of all the global versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @return the range of global versions
	 */
	public java.util.List<GlobalVersion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the global versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of global versions
	 */
	public java.util.List<GlobalVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the global versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GlobalVersionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of global versions
	 * @param end the upper bound of the range of global versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of global versions
	 */
	public java.util.List<GlobalVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GlobalVersion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the global versions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of global versions.
	 *
	 * @return the number of global versions
	 */
	public int countAll();

}