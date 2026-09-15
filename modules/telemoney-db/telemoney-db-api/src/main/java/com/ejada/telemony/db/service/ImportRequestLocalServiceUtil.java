/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.ImportRequest;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for ImportRequest. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.ImportRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ImportRequestLocalService
 * @generated
 */
public class ImportRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ImportRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ImportRequest addImportRequest(ImportRequest importRequest) {
		return getService().addImportRequest(importRequest);
	}

	public static java.nio.file.Path buildZip(
		com.ejada.telemoney.db.dto.importDtos.ImportResultDTO importResultDTO) {

		return getService().buildZip(importResultDTO);
	}

	/**
	 * Creates a new import request with the primary key. Does not add the import request to the database.
	 *
	 * @param id the primary key for the new import request
	 * @return the new import request
	 */
	public static ImportRequest createImportRequest(long id) {
		return getService().createImportRequest(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static ImportRequest deleteImportRequest(
		ImportRequest importRequest) {

		return getService().deleteImportRequest(importRequest);
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
	public static ImportRequest deleteImportRequest(long id)
		throws PortalException {

		return getService().deleteImportRequest(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ImportRequest fetchImportRequest(long id) {
		return getService().fetchImportRequest(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the import request with the primary key.
	 *
	 * @param id the primary key of the import request
	 * @return the import request
	 * @throws PortalException if a import request with the primary key could not be found
	 */
	public static ImportRequest getImportRequest(long id)
		throws PortalException {

		return getService().getImportRequest(id);
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
	public static List<ImportRequest> getImportRequests(int start, int end) {
		return getService().getImportRequests(start, end);
	}

	/**
	 * Returns the number of import requests.
	 *
	 * @return the number of import requests
	 */
	public static int getImportRequestsCount() {
		return getService().getImportRequestsCount();
	}

	/**
	 * Reads the zip file for the given ImportRequest, enriches the data by
	 * resolving channelId to channel name and entityResourceId to latest approved entity name.
	 *
	 * @param importRequestId the ID of the ImportRequest
	 * @return a map with keys: metadataJson, changeLogJson, enrichedDataJson
	 */
	public static Map<String, String> getImportRequestViewData(
			long importRequestId)
		throws PortalException {

		return getService().getImportRequestViewData(importRequestId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasPendingImportRequest(String type) {
		return getService().hasPendingImportRequest(type);
	}

	public static void startImportRequestWorkflow(
			com.ejada.telemoney.db.dto.importDtos.ImportResultDTO
				importResultDTO,
			String path, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		getService().startImportRequestWorkflow(
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
	public static ImportRequest updateImportRequest(
		ImportRequest importRequest) {

		return getService().updateImportRequest(importRequest);
	}

	public static ImportRequest updateStatus(
		long userId, long id, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateStatus(userId, id, status, serviceContext);
	}

	public static ImportRequestLocalService getService() {
		return _service;
	}

	public static void setService(ImportRequestLocalService service) {
		_service = service;
	}

	private static volatile ImportRequestLocalService _service;

}