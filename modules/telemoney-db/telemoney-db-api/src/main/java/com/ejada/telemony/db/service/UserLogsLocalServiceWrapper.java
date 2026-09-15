/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link UserLogsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserLogsLocalService
 * @generated
 */
public class UserLogsLocalServiceWrapper
	implements ServiceWrapper<UserLogsLocalService>, UserLogsLocalService {

	public UserLogsLocalServiceWrapper() {
		this(null);
	}

	public UserLogsLocalServiceWrapper(
		UserLogsLocalService userLogsLocalService) {

		_userLogsLocalService = userLogsLocalService;
	}

	@Override
	public void addUserData(
		String userName, String userAction, Long channelId) {

		_userLogsLocalService.addUserData(userName, userAction, channelId);
	}

	/**
	 * Adds the user logs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userLogs the user logs
	 * @return the user logs that was added
	 */
	@Override
	public com.ejada.telemony.db.model.UserLogs addUserLogs(
		com.ejada.telemony.db.model.UserLogs userLogs) {

		return _userLogsLocalService.addUserLogs(userLogs);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLogsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user logs with the primary key. Does not add the user logs to the database.
	 *
	 * @param logsId the primary key for the new user logs
	 * @return the new user logs
	 */
	@Override
	public com.ejada.telemony.db.model.UserLogs createUserLogs(long logsId) {
		return _userLogsLocalService.createUserLogs(logsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLogsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs that was removed
	 * @throws PortalException if a user logs with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.UserLogs deleteUserLogs(long logsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLogsLocalService.deleteUserLogs(logsId);
	}

	/**
	 * Deletes the user logs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userLogs the user logs
	 * @return the user logs that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.UserLogs deleteUserLogs(
		com.ejada.telemony.db.model.UserLogs userLogs) {

		return _userLogsLocalService.deleteUserLogs(userLogs);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userLogsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userLogsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userLogsLocalService.dynamicQuery();
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

		return _userLogsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.UserLogsModelImpl</code>.
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

		return _userLogsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.UserLogsModelImpl</code>.
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

		return _userLogsLocalService.dynamicQuery(
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

		return _userLogsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userLogsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.UserLogs fetchUserLogs(long logsId) {
		return _userLogsLocalService.fetchUserLogs(logsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userLogsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.UserLogs> getbyChannelId(
		Long channelId) {

		return _userLogsLocalService.getbyChannelId(channelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userLogsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userLogsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLogsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user logs with the primary key.
	 *
	 * @param logsId the primary key of the user logs
	 * @return the user logs
	 * @throws PortalException if a user logs with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.UserLogs getUserLogs(long logsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userLogsLocalService.getUserLogs(logsId);
	}

	/**
	 * Returns a range of all the user logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.UserLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user logses
	 * @param end the upper bound of the range of user logses (not inclusive)
	 * @return the range of user logses
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.UserLogs> getUserLogses(
		int start, int end) {

		return _userLogsLocalService.getUserLogses(start, end);
	}

	/**
	 * Returns the number of user logses.
	 *
	 * @return the number of user logses
	 */
	@Override
	public int getUserLogsesCount() {
		return _userLogsLocalService.getUserLogsesCount();
	}

	/**
	 * Updates the user logs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userLogs the user logs
	 * @return the user logs that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.UserLogs updateUserLogs(
		com.ejada.telemony.db.model.UserLogs userLogs) {

		return _userLogsLocalService.updateUserLogs(userLogs);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _userLogsLocalService.getBasePersistence();
	}

	@Override
	public UserLogsLocalService getWrappedService() {
		return _userLogsLocalService;
	}

	@Override
	public void setWrappedService(UserLogsLocalService userLogsLocalService) {
		_userLogsLocalService = userLogsLocalService;
	}

	private UserLogsLocalService _userLogsLocalService;

}