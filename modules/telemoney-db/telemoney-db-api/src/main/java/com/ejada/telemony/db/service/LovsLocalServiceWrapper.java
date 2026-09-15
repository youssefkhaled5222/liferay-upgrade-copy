/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LovsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalService
 * @generated
 */
public class LovsLocalServiceWrapper
	implements LovsLocalService, ServiceWrapper<LovsLocalService> {

	public LovsLocalServiceWrapper() {
		this(null);
	}

	public LovsLocalServiceWrapper(LovsLocalService lovsLocalService) {
		_lovsLocalService = lovsLocalService;
	}

	@Override
	public void addLovDataWorkflow(
			Long lovId, String lovType, String recordTypeCode,
			java.util.Map<String, String> values, String recordShortDescription,
			Long channelId, Long originalLovDataId,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		_lovsLocalService.addLovDataWorkflow(
			lovId, lovType, recordTypeCode, values, recordShortDescription,
			channelId, originalLovDataId, user, serviceContext);
	}

	/**
	 * Adds the lovs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovs the lovs
	 * @return the lovs that was added
	 */
	@Override
	public com.ejada.telemony.db.model.Lovs addLovs(
		com.ejada.telemony.db.model.Lovs lovs) {

		return _lovsLocalService.addLovs(lovs);
	}

	/**
	 * Creates a new lovs with the primary key. Does not add the lovs to the database.
	 *
	 * @param id the primary key for the new lovs
	 * @return the new lovs
	 */
	@Override
	public com.ejada.telemony.db.model.Lovs createLovs(long id) {
		return _lovsLocalService.createLovs(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteLovByLovId(Long id, Long channelId) throws Exception {
		_lovsLocalService.deleteLovByLovId(id, channelId);
	}

	@Override
	public void deleteLovDataWorkflow(
			com.ejada.telemony.db.model.LovData originalLovData, Long chn,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		_lovsLocalService.deleteLovDataWorkflow(
			originalLovData, chn, serviceContext, user);
	}

	/**
	 * Deletes the lovs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs that was removed
	 * @throws PortalException if a lovs with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Lovs deleteLovs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.deleteLovs(id);
	}

	/**
	 * Deletes the lovs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovs the lovs
	 * @return the lovs that was removed
	 */
	@Override
	public com.ejada.telemony.db.model.Lovs deleteLovs(
		com.ejada.telemony.db.model.Lovs lovs) {

		return _lovsLocalService.deleteLovs(lovs);
	}

	@Override
	public void deleteLovWorkflow(
			Long id, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		_lovsLocalService.deleteLovWorkflow(id, user, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _lovsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _lovsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lovsLocalService.dynamicQuery();
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

		return _lovsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
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

		return _lovsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
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

		return _lovsLocalService.dynamicQuery(
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

		return _lovsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lovsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Lovs fetchLovs(long id) {
		return _lovsLocalService.fetchLovs(id);
	}

	@Override
	public com.ejada.telemony.db.model.LovsLocalization fetchLovsLocalization(
		long id, String languageId) {

		return _lovsLocalService.fetchLovsLocalization(id, languageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lovsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs> getByChannelId(
		Long channelId) {

		return _lovsLocalService.getByChannelId(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs>
		getByEntityResourceId(long entityResourceId) {

		return _lovsLocalService.getByEntityResourceId(entityResourceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lovsLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<String> getLangNamesByCode(
		String code, Long channelId) {

		return _lovsLocalService.getLangNamesByCode(code, channelId);
	}

	@Override
	public java.util.List<String> getLangTypeCodeByLOVCode(
		String code, Long channelId) {

		return _lovsLocalService.getLangTypeCodeByLOVCode(code, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs>
		getLatestApprovedByChannelId(long channelId) {

		return _lovsLocalService.getLatestApprovedByChannelId(channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs>
		getLatestApprovedByChannelIdAndCode(long channelId, String code) {

		return _lovsLocalService.getLatestApprovedByChannelIdAndCode(
			channelId, code);
	}

	@Override
	public java.util.List<String> getLatestApprovedLangNamesByCode(
		String code, Long channelId) {

		return _lovsLocalService.getLatestApprovedLangNamesByCode(
			code, channelId);
	}

	@Override
	public com.ejada.telemony.db.model.Lovs
		getLatestApprovedLovByEntityResourceId(long entityResourceId) {

		return _lovsLocalService.getLatestApprovedLovByEntityResourceId(
			entityResourceId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData>
		getLatestApprovedLovDataByCode(String code, Long channelId) {

		return _lovsLocalService.getLatestApprovedLovDataByCode(
			code, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovData> getLovDataByCode(
		String code, Long channelId) {

		return _lovsLocalService.getLovDataByCode(code, channelId);
	}

	@Override
	public int getLovDataCountByLovId(Long LovId) {
		return _lovsLocalService.getLovDataCountByLovId(LovId);
	}

	/**
	 * Returns the lovs with the primary key.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs
	 * @throws PortalException if a lovs with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Lovs getLovs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.getLovs(id);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getLovsAndRelatedDataByCode(
		String code, String language, Long channelId) {

		return _lovsLocalService.getLovsAndRelatedDataByCode(
			code, language, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs>
		getLovsByTypeCodeAndStatus(String code, long channelId, int status) {

		return _lovsLocalService.getLovsByTypeCodeAndStatus(
			code, channelId, status);
	}

	/**
	 * Returns a range of all the lovses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lovses
	 * @param end the upper bound of the range of lovses (not inclusive)
	 * @return the range of lovses
	 */
	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs> getLovses(
		int start, int end) {

		return _lovsLocalService.getLovses(start, end);
	}

	/**
	 * Returns the number of lovses.
	 *
	 * @return the number of lovses
	 */
	@Override
	public int getLovsesCount() {
		return _lovsLocalService.getLovsesCount();
	}

	@Override
	public com.ejada.telemony.db.model.LovsLocalization getLovsLocalization(
			long id, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.getLovsLocalization(id, languageId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovsLocalization>
		getLovsLocalizations(long id) {

		return _lovsLocalService.getLovsLocalizations(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lovsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void importLovsAndLovDataFromCSV(String filePath, Long channelId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException {

		_lovsLocalService.importLovsAndLovDataFromCSV(filePath, channelId);
	}

	@Override
	public com.ejada.telemony.db.model.Lovs lovListCreate(
			java.util.Map<String, String> names, String code, String eventCode,
			Long channelId, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _lovsLocalService.lovListCreate(
			names, code, eventCode, channelId, user, serviceContext);
	}

	@Override
	public void lovListDelete(Long id, Long channelId) throws Exception {
		_lovsLocalService.lovListDelete(id, channelId);
	}

	@Override
	public com.ejada.telemony.db.model.Lovs lovListUpdate(
			Long id, java.util.Map<String, String> names, String code,
			Long channelId, String eventCode)
		throws Exception {

		return _lovsLocalService.lovListUpdate(
			id, names, code, channelId, eventCode);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs> searchByCode(
			String code, Long channelId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException,
			   javax.portlet.PortletException {

		return _lovsLocalService.searchByCode(code, channelId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Lovs>
			searchLovLocalizationByName(String searchName, Long channelId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException {

		return _lovsLocalService.searchLovLocalizationByName(
			searchName, channelId);
	}

	@Override
	public void updateLovDataWorkflow(
			Long id, Long lovId, String lovType, String recordTypeCode,
			java.util.Map<String, String> values, String recordShortDescription,
			Long channelId, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		_lovsLocalService.updateLovDataWorkflow(
			id, lovId, lovType, recordTypeCode, values, recordShortDescription,
			channelId, user, serviceContext);
	}

	/**
	 * Updates the lovs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LovsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lovs the lovs
	 * @return the lovs that was updated
	 */
	@Override
	public com.ejada.telemony.db.model.Lovs updateLovs(
		com.ejada.telemony.db.model.Lovs lovs) {

		return _lovsLocalService.updateLovs(lovs);
	}

	@Override
	public com.ejada.telemony.db.model.LovsLocalization updateLovsLocalization(
			com.ejada.telemony.db.model.Lovs lovs, String languageId,
			String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.updateLovsLocalization(lovs, languageId, name);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.LovsLocalization>
			updateLovsLocalizations(
				com.ejada.telemony.db.model.Lovs lovs,
				java.util.Map<String, String> nameMap)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lovsLocalService.updateLovsLocalizations(lovs, nameMap);
	}

	@Override
	public void updateLovWorkflow(
			Long id, java.util.Map<String, String> nameValues, String code,
			Long channelId, String eventCode,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		_lovsLocalService.updateLovWorkflow(
			id, nameValues, code, channelId, eventCode, user, serviceContext);
	}

	@Override
	public com.ejada.telemony.db.model.Lovs updateStatus(
			long userId, long lovId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _lovsLocalService.updateStatus(
			userId, lovId, status, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _lovsLocalService.getBasePersistence();
	}

	@Override
	public LovsLocalService getWrappedService() {
		return _lovsLocalService;
	}

	@Override
	public void setWrappedService(LovsLocalService lovsLocalService) {
		_lovsLocalService = lovsLocalService;
	}

	private LovsLocalService _lovsLocalService;

}