/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppConfigItemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppConfigItemLocalService
 * @generated
 */
public class AppConfigItemLocalServiceWrapper
	implements AppConfigItemLocalService,
			   ServiceWrapper<AppConfigItemLocalService> {

	public AppConfigItemLocalServiceWrapper() {
		this(null);
	}

	public AppConfigItemLocalServiceWrapper(
		AppConfigItemLocalService appConfigItemLocalService) {

		_appConfigItemLocalService = appConfigItemLocalService;
	}

	/**
	 * Adds the app config item to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppConfigItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appConfigItem the app config item
	 * @return the app config item that was added
	 */
	@Override
	public com.ejada.telemony.db.model.AppConfigItem addAppConfigItem(
		com.ejada.telemony.db.model.AppConfigItem appConfigItem) {

		return _appConfigItemLocalService.addAppConfigItem(appConfigItem);
	}

	/**
	 * Creates a new app config item with the primary key. Does not add the app config item to the database.
	 *
	 * @param configItemId the primary key for the new app config item
	 * @return the new app config item
	 */
	@Override
	public com.ejada.telemony.db.model.AppConfigItem createAppConfigItem(
		long configItemId) {

		return _appConfigItemLocalService.createAppConfigItem(configItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appConfigItemLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the app config item from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppConfigItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appConfigItem the app config item
	 * @return the app config item that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.AppConfigItem deleteAppConfigItem(
		com.ejada.telemony.db.model.AppConfigItem appConfigItem) {

		return _appConfigItemLocalService.deleteAppConfigItem(appConfigItem);
	}

	/**
	 * Deletes the app config item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppConfigItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item that was removed
	 * @throws PortalException if a app config item with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.AppConfigItem deleteAppConfigItem(
			long configItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appConfigItemLocalService.deleteAppConfigItem(configItemId);
	}

	@Override
	public void deleteAppConfigItemsByEnvironmentId(long environmentId) {
		_appConfigItemLocalService.deleteAppConfigItemsByEnvironmentId(
			environmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appConfigItemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appConfigItemLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appConfigItemLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appConfigItemLocalService.dynamicQuery();
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

		return _appConfigItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppConfigItemModelImpl</code>.
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

		return _appConfigItemLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppConfigItemModelImpl</code>.
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

		return _appConfigItemLocalService.dynamicQuery(
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

		return _appConfigItemLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appConfigItemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.AppConfigItem fetchAppConfigItem(
		long configItemId) {

		return _appConfigItemLocalService.fetchAppConfigItem(configItemId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appConfigItemLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the app config item with the primary key.
	 *
	 * @param configItemId the primary key of the app config item
	 * @return the app config item
	 * @throws PortalException if a app config item with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.AppConfigItem getAppConfigItem(
			long configItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appConfigItemLocalService.getAppConfigItem(configItemId);
	}

	/**
	 * Returns a range of all the app config items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.AppConfigItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app config items
	 * @param end the upper bound of the range of app config items (not inclusive)
	 * @return the range of app config items
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.AppConfigItem>
		getAppConfigItems(int start, int end) {

		return _appConfigItemLocalService.getAppConfigItems(start, end);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.AppConfigItem>
		getAppConfigItemsByEnvironmentId(long environmentId) {

		return _appConfigItemLocalService.getAppConfigItemsByEnvironmentId(
			environmentId);
	}

	/**
	 * Returns the number of app config items.
	 *
	 * @return the number of app config items
	 */
	@Override
	public int getAppConfigItemsCount() {
		return _appConfigItemLocalService.getAppConfigItemsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appConfigItemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appConfigItemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appConfigItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the app config item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppConfigItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appConfigItem the app config item
	 * @return the app config item that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.AppConfigItem updateAppConfigItem(
		com.ejada.telemony.db.model.AppConfigItem appConfigItem) {

		return _appConfigItemLocalService.updateAppConfigItem(appConfigItem);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appConfigItemLocalService.getBasePersistence();
	}

	@Override
	public AppConfigItemLocalService getWrappedService() {
		return _appConfigItemLocalService;
	}

	@Override
	public void setWrappedService(
		AppConfigItemLocalService appConfigItemLocalService) {

		_appConfigItemLocalService = appConfigItemLocalService;
	}

	private AppConfigItemLocalService _appConfigItemLocalService;

}