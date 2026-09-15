/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ChannelsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChannelsLocalService
 * @generated
 */
public class ChannelsLocalServiceWrapper
	implements ChannelsLocalService, ServiceWrapper<ChannelsLocalService> {

	public ChannelsLocalServiceWrapper() {
		this(null);
	}

	public ChannelsLocalServiceWrapper(
		ChannelsLocalService channelsLocalService) {

		_channelsLocalService = channelsLocalService;
	}

	@Override
	public com.ejada.telemony.db.model.Channels add(
			String name, String desc, String type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		return _channelsLocalService.add(
			name, desc, type, serviceContext, user);
	}

	/**
	 * Adds the channels to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChannelsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param channels the channels
	 * @return the channels that was added
	 */
	@Override
	public com.ejada.telemony.db.model.Channels addChannels(
		com.ejada.telemony.db.model.Channels channels) {

		return _channelsLocalService.addChannels(channels);
	}

	@Override
	public boolean checkChannelName(String channelName) {
		return _channelsLocalService.checkChannelName(channelName);
	}

	/**
	 * Creates a new channels with the primary key. Does not add the channels to the database.
	 *
	 * @param channelId the primary key for the new channels
	 * @return the new channels
	 */
	@Override
	public com.ejada.telemony.db.model.Channels createChannels(long channelId) {
		return _channelsLocalService.createChannels(channelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the channels from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChannelsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param channels the channels
	 * @return the channels that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.Channels deleteChannels(
		com.ejada.telemony.db.model.Channels channels) {

		return _channelsLocalService.deleteChannels(channels);
	}

	/**
	 * Deletes the channels with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChannelsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels that was removed
	 * @throws PortalException if a channels with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Channels deleteChannels(long channelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelsLocalService.deleteChannels(channelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _channelsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _channelsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _channelsLocalService.dynamicQuery();
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

		return _channelsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ChannelsModelImpl</code>.
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

		return _channelsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ChannelsModelImpl</code>.
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

		return _channelsLocalService.dynamicQuery(
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

		return _channelsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _channelsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Channels fetchChannels(long channelId) {
		return _channelsLocalService.fetchChannels(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Channels> findAll() {
		return _channelsLocalService.findAll();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Channels> findByStatus(
		int status) {

		return _channelsLocalService.findByStatus(status);
	}

	@Override
	public com.ejada.telemony.db.model.Channels findOne(long channelId) {
		return _channelsLocalService.findOne(channelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _channelsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.ejada.telemony.db.model.Channels getByName(String channelName) {
		return _channelsLocalService.getByName(channelName);
	}

	/**
	 * Returns the channels with the primary key.
	 *
	 * @param channelId the primary key of the channels
	 * @return the channels
	 * @throws PortalException if a channels with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Channels getChannels(long channelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelsLocalService.getChannels(channelId);
	}

	/**
	 * Returns a range of all the channelses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ChannelsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channelses
	 * @param end the upper bound of the range of channelses (not inclusive)
	 * @return the range of channelses
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Channels> getChannelses(
		int start, int end) {

		return _channelsLocalService.getChannelses(start, end);
	}

	/**
	 * Returns the number of channelses.
	 *
	 * @return the number of channelses
	 */
	@Override
	public int getChannelsesCount() {
		return _channelsLocalService.getChannelsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _channelsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _channelsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean ifExist(long channelId) {
		return _channelsLocalService.ifExist(channelId);
	}

	/**
	 * Updates the channels in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChannelsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param channels the channels
	 * @return the channels that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.Channels updateChannels(
		com.ejada.telemony.db.model.Channels channels) {

		return _channelsLocalService.updateChannels(channels);
	}

	@Override
	public com.ejada.telemony.db.model.Channels updateStatus(
			long userId, long channelId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _channelsLocalService.updateStatus(
			userId, channelId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _channelsLocalService.getBasePersistence();
	}

	@Override
	public ChannelsLocalService getWrappedService() {
		return _channelsLocalService;
	}

	@Override
	public void setWrappedService(ChannelsLocalService channelsLocalService) {
		_channelsLocalService = channelsLocalService;
	}

	private ChannelsLocalService _channelsLocalService;

}