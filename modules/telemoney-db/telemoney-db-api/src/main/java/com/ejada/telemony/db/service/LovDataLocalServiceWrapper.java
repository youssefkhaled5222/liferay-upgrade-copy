/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LovDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LovDataLocalService
 * @generated
 */
public class LovDataLocalServiceWrapper
	implements LovDataLocalService, ServiceWrapper<LovDataLocalService> {

	public LovDataLocalServiceWrapper() {
		this(null);
	}

	public LovDataLocalServiceWrapper(LovDataLocalService lovDataLocalService) {
		_lovDataLocalService = lovDataLocalService;
	}

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
	@Override
	public com.ejada.telemony.db.model.LovData addLovData(
		com.ejada.telemony.db.model.LovData lovData) {

		return _lovDataLocalService.addLovData(lovData);
	}

	@Override
	public int countByResourceIdAndApproved(long resourceId) {
		return _lovDataLocalService.countByResourceIdAndApproved(resourceId);
	}

	/**
	 * Creates a new lov data with the primary key. Does not add the lov data to the database.
	 *
	 * @param id the primary key for the new lov data
	 * @return the new lov data
	 */
	@Override
	public com.ejada.telemony.db.model.LovData createLovData(long id) {
		return _lovDataLocalService.createLovData(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.telemony.db.model.LovData deleteLovData(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.deleteLovData(id);
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
	@Override
	public com.ejada.telemony.db.model.LovData deleteLovData(
		com.ejada.telemony.db.model.LovData lovData) {

		return _lovDataLocalService.deleteLovData(lovData);
	}

	@Override
	public void deleteLovDataByLovId(Long lovId, Long channelId) {
		_lovDataLocalService.deleteLovDataByLovId(lovId, channelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _lovDataLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _lovDataLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lovDataLocalService.dynamicQuery();
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

		return _lovDataLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _lovDataLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _lovDataLocalService.dynamicQuery(
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

		return _lovDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lovDataLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.LovData fetchLovData(long id) {
		return _lovDataLocalService.fetchLovData(id);
	}

	@Override
	public com.ejada.telemony.db.model.LovDataLocalization
		fetchLovDataLocalization(long id, String languageId) {

		return _lovDataLocalService.fetchLovDataLocalization(id, languageId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		findByEntityResourceId(long entityResourceId) {

		return _lovDataLocalService.findByEntityResourceId(entityResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		findLovDataByLovId(Long lovId) {

		return _lovDataLocalService.findLovDataByLovId(lovId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		findLovDataByLovIdAndRecordShortDescriptione(
			Long lovId, String recordShortDescription) {

		return _lovDataLocalService.
			findLovDataByLovIdAndRecordShortDescriptione(
				lovId, recordShortDescription);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		findLovDataByLovIdAndStatus(Long lovId, int status) {

		return _lovDataLocalService.findLovDataByLovIdAndStatus(lovId, status);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		findLovDataByLovIdWithPersistence(Long lovId) {

		return _lovDataLocalService.findLovDataByLovIdWithPersistence(lovId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lovDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		getByEntityResourceIdAndStatusApproved(long lovId) {

		return _lovDataLocalService.getByEntityResourceIdAndStatusApproved(
			lovId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lovDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lov data with the primary key.
	 *
	 * @param id the primary key of the lov data
	 * @return the lov data
	 * @throws PortalException if a lov data with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.LovData getLovData(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.getLovData(id);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		getLovDataByTypeCodeAndLovCodeAndStatus(
			String lovCode, String typeCode, Long entityResourceId,
			int status) {

		return _lovDataLocalService.getLovDataByTypeCodeAndLovCodeAndStatus(
			lovCode, typeCode, entityResourceId, status);
	}

	@Override
	public com.ejada.telemony.db.model.LovDataLocalization
			getLovDataLocalization(long id, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.getLovDataLocalization(id, languageId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovDataLocalization>
		getLovDataLocalizations(long id) {

		return _lovDataLocalService.getLovDataLocalizations(id);
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
	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData> getLovDatas(
		int start, int end) {

		return _lovDataLocalService.getLovDatas(start, end);
	}

	/**
	 * Returns the number of lov datas.
	 *
	 * @return the number of lov datas
	 */
	@Override
	public int getLovDatasCount() {
		return _lovDataLocalService.getLovDatasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lovDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.ejada.telemony.db.model.LovData lovDataCreate(
			Long lovId, String lovType, String recordTypeCode,
			java.util.Map<String, String> values, String recordShortDescription,
			Long channelId, Long originalLovDataId)
		throws Exception {

		return _lovDataLocalService.lovDataCreate(
			lovId, lovType, recordTypeCode, values, recordShortDescription,
			channelId, originalLovDataId);
	}

	@Override
	public void lovDataDelete(Long id, Long channelId) throws Exception {
		_lovDataLocalService.lovDataDelete(id, channelId);
	}

	@Override
	public void lovDataUpdate(
			Long id, Long lovId, String lovType, String recordTypeCode,
			java.util.Map<String, String> values, String recordShortDescription,
			Long channelId)
		throws Exception {

		_lovDataLocalService.lovDataUpdate(
			id, lovId, lovType, recordTypeCode, values, recordShortDescription,
			channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData> search(
			String searchName, String searchBy, Long entityResourceId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException,
			   javax.portlet.PortletException {

		return _lovDataLocalService.search(
			searchName, searchBy, entityResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
			searchLovDataLocalizationByDescription(
				String searchName, String lovId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException {

		return _lovDataLocalService.searchLovDataLocalizationByDescription(
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
	@Override
	public com.ejada.telemony.db.model.LovData updateLovData(
		com.ejada.telemony.db.model.LovData lovData) {

		return _lovDataLocalService.updateLovData(lovData);
	}

	@Override
	public void updateLovDataByLovId(
		Long lovId, com.ejada.telemony.db.model.Lovs draftLov) {

		_lovDataLocalService.updateLovDataByLovId(lovId, draftLov);
	}

	@Override
	public com.ejada.telemony.db.model.LovDataLocalization
			updateLovDataLocalization(
				com.ejada.telemony.db.model.LovData lovData, String languageId,
				String recordDescription, String lovIdLocalization)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.updateLovDataLocalization(
			lovData, languageId, recordDescription, lovIdLocalization);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovDataLocalization>
			updateLovDataLocalizations(
				com.ejada.telemony.db.model.LovData lovData,
				java.util.Map<String, String> recordDescriptionMap,
				java.util.Map<String, String> lovIdLocalizationMap)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovDataLocalService.updateLovDataLocalizations(
			lovData, recordDescriptionMap, lovIdLocalizationMap);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _lovDataLocalService.getBasePersistence();
	}

	@Override
	public LovDataLocalService getWrappedService() {
		return _lovDataLocalService;
	}

	@Override
	public void setWrappedService(LovDataLocalService lovDataLocalService) {
		_lovDataLocalService = lovDataLocalService;
	}

	private LovDataLocalService _lovDataLocalService;

}