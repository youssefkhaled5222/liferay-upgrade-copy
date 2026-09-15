/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchBannerContentException;
import com.ejada.telemony.db.model.BannerContent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the banner content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentUtil
 * @generated
 */
@ProviderType
public interface BannerContentPersistence
	extends BasePersistence<BannerContent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BannerContentUtil} to access the banner content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the banner contents where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @return the matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerId(long bannerId);

	/**
	 * Returns a range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerId(
		long bannerId, int start, int end);

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerId(
		long bannerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerId(
		long bannerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByBannerId_First(
			long bannerId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByBannerId_First(
		long bannerId,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByBannerId_Last(
			long bannerId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByBannerId_Last(
		long bannerId,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where bannerId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param bannerId the banner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public BannerContent[] findByBannerId_PrevAndNext(
			long contentId, long bannerId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Removes all the banner contents where bannerId = &#63; from the database.
	 *
	 * @param bannerId the banner ID
	 */
	public void removeByBannerId(long bannerId);

	/**
	 * Returns the number of banner contents where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @return the number of matching banner contents
	 */
	public int countByBannerId(long bannerId);

	/**
	 * Returns all the banner contents where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching banner contents
	 */
	public java.util.List<BannerContent> findByEntityResourceId(
		long entityResourceId);

	/**
	 * Returns a range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public java.util.List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end);

	/**
	 * Returns an ordered range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banner contents where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByEntityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the first banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByEntityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the last banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByEntityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the last banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByEntityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where entityResourceId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public BannerContent[] findByEntityResourceId_PrevAndNext(
			long contentId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Removes all the banner contents where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByEntityResourceId(long entityResourceId);

	/**
	 * Returns the number of banner contents where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching banner contents
	 */
	public int countByEntityResourceId(long entityResourceId);

	/**
	 * Returns all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @return the matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status);

	/**
	 * Returns a range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByBannerIdAndStatus(
		long bannerId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByBannerIdAndStatus_First(
			long bannerId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the first banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByBannerIdAndStatus_First(
		long bannerId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByBannerIdAndStatus_Last(
			long bannerId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the last banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByBannerIdAndStatus_Last(
		long bannerId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where bannerId = &#63; and status = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param bannerId the banner ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public BannerContent[] findByBannerIdAndStatus_PrevAndNext(
			long contentId, long bannerId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Removes all the banner contents where bannerId = &#63; and status = &#63; from the database.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 */
	public void removeByBannerIdAndStatus(long bannerId, int status);

	/**
	 * Returns the number of banner contents where bannerId = &#63; and status = &#63;.
	 *
	 * @param bannerId the banner ID
	 * @param status the status
	 * @return the number of matching banner contents
	 */
	public int countByBannerIdAndStatus(long bannerId, int status);

	/**
	 * Returns all the banner contents where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching banner contents
	 */
	public java.util.List<BannerContent> findByChannelId(long channelId);

	/**
	 * Returns a range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of matching banner contents
	 */
	public java.util.List<BannerContent> findByChannelId(
		long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banner contents where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banner contents
	 */
	public java.util.List<BannerContent> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the first banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the last banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content
	 * @throws NoSuchBannerContentException if a matching banner content could not be found
	 */
	public BannerContent findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Returns the last banner content in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner content, or <code>null</code> if a matching banner content could not be found
	 */
	public BannerContent fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns the banner contents before and after the current banner content in the ordered set where channelId = &#63;.
	 *
	 * @param contentId the primary key of the current banner content
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public BannerContent[] findByChannelId_PrevAndNext(
			long contentId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
				orderByComparator)
		throws NoSuchBannerContentException;

	/**
	 * Removes all the banner contents where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of banner contents where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching banner contents
	 */
	public int countByChannelId(long channelId);

	/**
	 * Caches the banner content in the entity cache if it is enabled.
	 *
	 * @param bannerContent the banner content
	 */
	public void cacheResult(BannerContent bannerContent);

	/**
	 * Caches the banner contents in the entity cache if it is enabled.
	 *
	 * @param bannerContents the banner contents
	 */
	public void cacheResult(java.util.List<BannerContent> bannerContents);

	/**
	 * Creates a new banner content with the primary key. Does not add the banner content to the database.
	 *
	 * @param contentId the primary key for the new banner content
	 * @return the new banner content
	 */
	public BannerContent create(long contentId);

	/**
	 * Removes the banner content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content that was removed
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public BannerContent remove(long contentId)
		throws NoSuchBannerContentException;

	public BannerContent updateImpl(BannerContent bannerContent);

	/**
	 * Returns the banner content with the primary key or throws a <code>NoSuchBannerContentException</code> if it could not be found.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content
	 * @throws NoSuchBannerContentException if a banner content with the primary key could not be found
	 */
	public BannerContent findByPrimaryKey(long contentId)
		throws NoSuchBannerContentException;

	/**
	 * Returns the banner content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentId the primary key of the banner content
	 * @return the banner content, or <code>null</code> if a banner content with the primary key could not be found
	 */
	public BannerContent fetchByPrimaryKey(long contentId);

	/**
	 * Returns all the banner contents.
	 *
	 * @return the banner contents
	 */
	public java.util.List<BannerContent> findAll();

	/**
	 * Returns a range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @return the range of banner contents
	 */
	public java.util.List<BannerContent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banner contents
	 */
	public java.util.List<BannerContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banner contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BannerContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banner contents
	 * @param end the upper bound of the range of banner contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banner contents
	 */
	public java.util.List<BannerContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BannerContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the banner contents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of banner contents.
	 *
	 * @return the number of banner contents
	 */
	public int countAll();

}