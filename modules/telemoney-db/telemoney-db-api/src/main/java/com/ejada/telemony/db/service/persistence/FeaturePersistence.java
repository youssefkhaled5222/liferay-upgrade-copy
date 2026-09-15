/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service.persistence;

import com.ejada.telemony.db.exception.NoSuchFeatureException;
import com.ejada.telemony.db.model.Feature;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the feature service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeatureUtil
 * @generated
 */
@ProviderType
public interface FeaturePersistence extends BasePersistence<Feature> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeatureUtil} to access the feature persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the features where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching features
	 */
	public java.util.List<Feature> findByChannelId(long channelId);

	/**
	 * Returns a range of all the features where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	public java.util.List<Feature> findByChannelId(
		long channelId, int start, int end);

	/**
	 * Returns an ordered range of all the features where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns an ordered range of all the features where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByChannelId(
		long channelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByChannelId_First(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the first feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByChannelId_First(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the last feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByChannelId_Last(
			long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the last feature in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByChannelId_Last(
		long channelId,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the features before and after the current feature in the ordered set where channelId = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	public Feature[] findByChannelId_PrevAndNext(
			long featureId, long channelId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Removes all the features where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	public void removeByChannelId(long channelId);

	/**
	 * Returns the number of features where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching features
	 */
	public int countByChannelId(long channelId);

	/**
	 * Returns all the features where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @return the matching features
	 */
	public java.util.List<Feature> findByFeatureId(long parentPage);

	/**
	 * Returns a range of all the features where parentPage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param parentPage the parent page
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	public java.util.List<Feature> findByFeatureId(
		long parentPage, int start, int end);

	/**
	 * Returns an ordered range of all the features where parentPage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param parentPage the parent page
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByFeatureId(
		long parentPage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns an ordered range of all the features where parentPage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param parentPage the parent page
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByFeatureId(
		long parentPage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByFeatureId_First(
			long parentPage,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the first feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByFeatureId_First(
		long parentPage,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the last feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByFeatureId_Last(
			long parentPage,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the last feature in the ordered set where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByFeatureId_Last(
		long parentPage,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the features before and after the current feature in the ordered set where parentPage = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param parentPage the parent page
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	public Feature[] findByFeatureId_PrevAndNext(
			long featureId, long parentPage,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Removes all the features where parentPage = &#63; from the database.
	 *
	 * @param parentPage the parent page
	 */
	public void removeByFeatureId(long parentPage);

	/**
	 * Returns the number of features where parentPage = &#63;.
	 *
	 * @param parentPage the parent page
	 * @return the number of matching features
	 */
	public int countByFeatureId(long parentPage);

	/**
	 * Returns all the features where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the matching features
	 */
	public java.util.List<Feature> findByEntityResourceId(
		long entityResourceId);

	/**
	 * Returns a range of all the features where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	public java.util.List<Feature> findByEntityResourceId(
		long entityResourceId, int start, int end);

	/**
	 * Returns an ordered range of all the features where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns an ordered range of all the features where entityResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param entityResourceId the entity resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByEntityResourceId(
		long entityResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByEntityResourceId_First(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the first feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByEntityResourceId_First(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the last feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByEntityResourceId_Last(
			long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the last feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByEntityResourceId_Last(
		long entityResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the features before and after the current feature in the ordered set where entityResourceId = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param entityResourceId the entity resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	public Feature[] findByEntityResourceId_PrevAndNext(
			long featureId, long entityResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Removes all the features where entityResourceId = &#63; from the database.
	 *
	 * @param entityResourceId the entity resource ID
	 */
	public void removeByEntityResourceId(long entityResourceId);

	/**
	 * Returns the number of features where entityResourceId = &#63;.
	 *
	 * @param entityResourceId the entity resource ID
	 * @return the number of matching features
	 */
	public int countByEntityResourceId(long entityResourceId);

	/**
	 * Returns all the features where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the matching features
	 */
	public java.util.List<Feature> findByChildResourceId(long childResourceId);

	/**
	 * Returns a range of all the features where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of matching features
	 */
	public java.util.List<Feature> findByChildResourceId(
		long childResourceId, int start, int end);

	/**
	 * Returns an ordered range of all the features where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByChildResourceId(
		long childResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns an ordered range of all the features where childResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param childResourceId the child resource ID
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching features
	 */
	public java.util.List<Feature> findByChildResourceId(
		long childResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByChildResourceId_First(
			long childResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the first feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByChildResourceId_First(
		long childResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the last feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature
	 * @throws NoSuchFeatureException if a matching feature could not be found
	 */
	public Feature findByChildResourceId_Last(
			long childResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Returns the last feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feature, or <code>null</code> if a matching feature could not be found
	 */
	public Feature fetchByChildResourceId_Last(
		long childResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns the features before and after the current feature in the ordered set where childResourceId = &#63;.
	 *
	 * @param featureId the primary key of the current feature
	 * @param childResourceId the child resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	public Feature[] findByChildResourceId_PrevAndNext(
			long featureId, long childResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<Feature>
				orderByComparator)
		throws NoSuchFeatureException;

	/**
	 * Removes all the features where childResourceId = &#63; from the database.
	 *
	 * @param childResourceId the child resource ID
	 */
	public void removeByChildResourceId(long childResourceId);

	/**
	 * Returns the number of features where childResourceId = &#63;.
	 *
	 * @param childResourceId the child resource ID
	 * @return the number of matching features
	 */
	public int countByChildResourceId(long childResourceId);

	/**
	 * Caches the feature in the entity cache if it is enabled.
	 *
	 * @param feature the feature
	 */
	public void cacheResult(Feature feature);

	/**
	 * Caches the features in the entity cache if it is enabled.
	 *
	 * @param features the features
	 */
	public void cacheResult(java.util.List<Feature> features);

	/**
	 * Creates a new feature with the primary key. Does not add the feature to the database.
	 *
	 * @param featureId the primary key for the new feature
	 * @return the new feature
	 */
	public Feature create(long featureId);

	/**
	 * Removes the feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature that was removed
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	public Feature remove(long featureId) throws NoSuchFeatureException;

	public Feature updateImpl(Feature feature);

	/**
	 * Returns the feature with the primary key or throws a <code>NoSuchFeatureException</code> if it could not be found.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature
	 * @throws NoSuchFeatureException if a feature with the primary key could not be found
	 */
	public Feature findByPrimaryKey(long featureId)
		throws NoSuchFeatureException;

	/**
	 * Returns the feature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param featureId the primary key of the feature
	 * @return the feature, or <code>null</code> if a feature with the primary key could not be found
	 */
	public Feature fetchByPrimaryKey(long featureId);

	/**
	 * Returns all the features.
	 *
	 * @return the features
	 */
	public java.util.List<Feature> findAll();

	/**
	 * Returns a range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @return the range of features
	 */
	public java.util.List<Feature> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of features
	 */
	public java.util.List<Feature> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator);

	/**
	 * Returns an ordered range of all the features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of features
	 * @param end the upper bound of the range of features (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of features
	 */
	public java.util.List<Feature> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Feature>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the features from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of features.
	 *
	 * @return the number of features
	 */
	public int countAll();

}