/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.LovData;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for LovData. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.LovDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalService
 * @generated
 */
public class LovDataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.LovDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lov data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovData the lov data
	 * @return the lov data that was added
	 */
	public static LovData addLovData(LovData lovData) {
		return getService().addLovData(lovData);
	}

	public static int countByResourceIdAndApproved(long resourceId) {
		return getService().countByResourceIdAndApproved(resourceId);
	}

	/**
	 * Creates a new lov data with the primary key. Does not add the lov data to the database.
	 *
	 * @param id the primary key for the new lov data
	 * @return the new lov data
	 */
	public static LovData createLovData(long id) {
		return getService().createLovData(id);
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
	 * Deletes the lov data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data that was removed
	 * @throws PortalException if a lov data with the primary key could not be found
	 */
	public static LovData deleteLovData(long id) throws PortalException {
		return getService().deleteLovData(id);
	}

	/**
	 * Deletes the lov data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovData the lov data
	 * @return the lov data that was removed
	 */
	public static LovData deleteLovData(LovData lovData) {
		return getService().deleteLovData(lovData);
	}

	public static void deleteLovDataByLovId(Long lovId, Long channelId) {
		getService().deleteLovDataByLovId(lovId, channelId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovDataModelImpl</code>.
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

	public static LovData fetchLovData(long id) {
		return getService().fetchLovData(id);
	}

	public static com.ejada.telemony.db.model.LovDataLocalization
		fetchLovDataLocalization(long id, String languageId) {

		return getService().fetchLovDataLocalization(id, languageId);
	}

	public static List<LovData> findByEntityResourceId(long entityResourceId) {
		return getService().findByEntityResourceId(entityResourceId);
	}

	public static List<LovData> findLovDataByLovId(Long lovId) {
		return getService().findLovDataByLovId(lovId);
	}

	public static List<LovData> findLovDataByLovIdAndRecordShortDescriptione(
		Long lovId, String recordShortDescription) {

		return getService().findLovDataByLovIdAndRecordShortDescriptione(
			lovId, recordShortDescription);
	}

	public static List<LovData> findLovDataByLovIdAndStatus(
		Long lovId, int status) {

		return getService().findLovDataByLovIdAndStatus(lovId, status);
	}

	public static List<LovData> findLovDataByLovIdWithPersistence(Long lovId) {
		return getService().findLovDataByLovIdWithPersistence(lovId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<LovData> getByEntityResourceIdAndStatusApproved(
		long lovId) {

		return getService().getByEntityResourceIdAndStatusApproved(lovId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lov data with the primary key.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data
	 * @throws PortalException if a lov data with the primary key could not be found
	 */
	public static LovData getLovData(long id) throws PortalException {
		return getService().getLovData(id);
	}

	public static List<LovData> getLovDataByTypeCodeAndLovCodeAndStatus(
		String lovCode, String typeCode, Long entityResourceId, int status) {

		return getService().getLovDataByTypeCodeAndLovCodeAndStatus(
			lovCode, typeCode, entityResourceId, status);
	}

	public static com.ejada.telemony.db.model.LovDataLocalization
			getLovDataLocalization(long id, String languageId)
		throws PortalException {

		return getService().getLovDataLocalization(id, languageId);
	}

	public static List<com.ejada.telemony.db.model.LovDataLocalization>
		getLovDataLocalizations(long id) {

		return getService().getLovDataLocalizations(id);
	}

	/**
	 * Returns a range of all the lov datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lov datas
	 * @param end the upper bound of the range of lov datas (not inclusive)
	 * @return the range of lov datas
	 */
	public static List<LovData> getLovDatas(int start, int end) {
		return getService().getLovDatas(start, end);
	}

	/**
	 * Returns the number of lov datas.
	 *
	 * @return the number of lov datas
	 */
	public static int getLovDatasCount() {
		return getService().getLovDatasCount();
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

	public static LovData lovDataCreate(
			Long lovId, String lovType, String recordTypeCode,
			Map<String, String> values, String recordShortDescription,
			Long channelId, Long originalLovDataId)
		throws Exception {

		return getService().lovDataCreate(
			lovId, lovType, recordTypeCode, values, recordShortDescription,
			channelId, originalLovDataId);
	}

	public static void lovDataDelete(Long id, Long channelId) throws Exception {
		getService().lovDataDelete(id, channelId);
	}

	public static void lovDataUpdate(
			Long id, Long lovId, String lovType, String recordTypeCode,
			Map<String, String> values, String recordShortDescription,
			Long channelId)
		throws Exception {

		getService().lovDataUpdate(
			id, lovId, lovType, recordTypeCode, values, recordShortDescription,
			channelId);
	}

	public static List<LovData> search(
			String searchName, String searchBy, Long entityResourceId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException,
			   javax.portlet.PortletException {

		return getService().search(searchName, searchBy, entityResourceId);
	}

	public static List<LovData> searchLovDataLocalizationByDescription(
			String searchName, String lovId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException {

		return getService().searchLovDataLocalizationByDescription(
			searchName, lovId);
	}

	/**
	 * Updates the lov data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovData the lov data
	 * @return the lov data that was updated
	 */
	public static LovData updateLovData(LovData lovData) {
		return getService().updateLovData(lovData);
	}

	public static void updateLovDataByLovId(
		Long lovId, com.ejada.telemony.db.model.Lovs draftLov) {

		getService().updateLovDataByLovId(lovId, draftLov);
	}

	public static com.ejada.telemony.db.model.LovDataLocalization
			updateLovDataLocalization(
				LovData lovData, String languageId, String recordDescription,
				String lovIdLocalization)
		throws PortalException {

		return getService().updateLovDataLocalization(
			lovData, languageId, recordDescription, lovIdLocalization);
	}

	public static List<com.ejada.telemony.db.model.LovDataLocalization>
			updateLovDataLocalizations(
				LovData lovData, Map<String, String> recordDescriptionMap,
				Map<String, String> lovIdLocalizationMap)
		throws PortalException {

		return getService().updateLovDataLocalizations(
			lovData, recordDescriptionMap, lovIdLocalizationMap);
	}

	public static LovDataLocalService getService() {
		return _service;
	}

	public static void setService(LovDataLocalService service) {
		_service = service;
	}

	private static volatile LovDataLocalService _service;

}