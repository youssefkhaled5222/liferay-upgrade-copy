/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ImportRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImportRequestLocalService
 * @generated
 */
public class ImportRequestLocalServiceWrapper
	implements ImportRequestLocalService,
			   ServiceWrapper<ImportRequestLocalService> {

	public ImportRequestLocalServiceWrapper() {
		this(null);
	}

	public ImportRequestLocalServiceWrapper(
		ImportRequestLocalService importRequestLocalService) {

		_importRequestLocalService = importRequestLocalService;
	}

	/**
	 * Adds the import request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importRequest the import request
	 * @return the import request that was added
	 */
	@Override
	public com.ejada.telemony.db.model.ImportRequest addImportRequest(
		com.ejada.telemony.db.model.ImportRequest importRequest) {

		return _importRequestLocalService.addImportRequest(importRequest);
	}

	@Override
	public java.nio.file.Path buildZip(
		com.ejada.telemoney.db.dto.importDtos.ImportResultDTO importResultDTO) {

		return _importRequestLocalService.buildZip(importResultDTO);
	}

	/**
	 * Creates a new import request with the primary key. Does not add the import request to the database.
	 *
	 * @param id the primary key for the new import request
	 * @return the new import request
	 */
	@Override
	public com.ejada.telemony.db.model.ImportRequest createImportRequest(
		long id) {

		return _importRequestLocalService.createImportRequest(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importRequestLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the import request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importRequest the import request
	 * @return the import request that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.ImportRequest deleteImportRequest(
		com.ejada.telemony.db.model.ImportRequest importRequest) {

		return _importRequestLocalService.deleteImportRequest(importRequest);
	}

	/**
	 * Deletes the import request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the import request
	 * @return the import request that was removed
	 * @throws PortalException if a import request with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.ImportRequest deleteImportRequest(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importRequestLocalService.deleteImportRequest(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importRequestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _importRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _importRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importRequestLocalService.dynamicQuery();
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

		return _importRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ImportRequestModelImpl</code>.
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

		return _importRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ImportRequestModelImpl</code>.
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

		return _importRequestLocalService.dynamicQuery(
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

		return _importRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _importRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.ImportRequest fetchImportRequest(
		long id) {

		return _importRequestLocalService.fetchImportRequest(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _importRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the import request with the primary key.
	 *
	 * @param id the primary key of the import request
	 * @return the import request
	 * @throws PortalException if a import request with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.ImportRequest getImportRequest(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importRequestLocalService.getImportRequest(id);
	}

	/**
	 * Returns a range of all the import requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ImportRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import requests
	 * @param end the upper bound of the range of import requests (not inclusive)
	 * @return the range of import requests
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.ImportRequest>
		getImportRequests(int start, int end) {

		return _importRequestLocalService.getImportRequests(start, end);
	}

	/**
	 * Returns the number of import requests.
	 *
	 * @return the number of import requests
	 */
	@Override
	public int getImportRequestsCount() {
		return _importRequestLocalService.getImportRequestsCount();
	}

	/**
	 * Reads the zip file for the given ImportRequest, enriches the data by
	 * resolving channelId to channel name and entityResourceId to latest approved entity name.
	 *
	 * @param importRequestId the ID of the ImportRequest
	 * @return a map with keys: metadataJson, changeLogJson, enrichedDataJson
	 */
	@Override
	public java.util.Map<String, String> getImportRequestViewData(
			long importRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importRequestLocalService.getImportRequestViewData(
			importRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _importRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _importRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasPendingImportRequest(String type) {
		return _importRequestLocalService.hasPendingImportRequest(type);
	}

	@Override
	public void startImportRequestWorkflow(
			com.ejada.telemoney.db.dto.importDtos.ImportResultDTO
				importResultDTO,
			String path, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_importRequestLocalService.startImportRequestWorkflow(
			importResultDTO, path, user, serviceContext);
	}

	/**
	 * Updates the import request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importRequest the import request
	 * @return the import request that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.ImportRequest updateImportRequest(
		com.ejada.telemony.db.model.ImportRequest importRequest) {

		return _importRequestLocalService.updateImportRequest(importRequest);
	}

	@Override
	public com.ejada.telemony.db.model.ImportRequest updateStatus(
		long userId, long id, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _importRequestLocalService.updateStatus(
			userId, id, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _importRequestLocalService.getBasePersistence();
	}

	@Override
	public ImportRequestLocalService getWrappedService() {
		return _importRequestLocalService;
	}

	@Override
	public void setWrappedService(
		ImportRequestLocalService importRequestLocalService) {

		_importRequestLocalService = importRequestLocalService;
	}

	private ImportRequestLocalService _importRequestLocalService;

}