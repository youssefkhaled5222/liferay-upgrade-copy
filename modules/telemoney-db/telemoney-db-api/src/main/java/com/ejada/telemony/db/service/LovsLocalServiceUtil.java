/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Lovs;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Lovs. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.LovsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LovsLocalService
 * @generated
 */
public class LovsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.LovsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addLovDataWorkflow(
			Long lovId, String lovType, String recordTypeCode,
			Map<String, String> values, String recordShortDescription,
			Long channelId, Long originalLovDataId,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		getService().addLovDataWorkflow(
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
	public static Lovs addLovs(Lovs lovs) {
		return getService().addLovs(lovs);
	}

	/**
	 * Creates a new lovs with the primary key. Does not add the lovs to the database.
	 *
	 * @param id the primary key for the new lovs
	 * @return the new lovs
	 */
	public static Lovs createLovs(long id) {
		return getService().createLovs(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteLovByLovId(Long id, Long channelId)
		throws Exception {

		getService().deleteLovByLovId(id, channelId);
	}

	public static void deleteLovDataWorkflow(
			com.ejada.telemony.db.model.LovData originalLovData, Long chn,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user)
		throws Exception {

		getService().deleteLovDataWorkflow(
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
	public static Lovs deleteLovs(long id) throws PortalException {
		return getService().deleteLovs(id);
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
	public static Lovs deleteLovs(Lovs lovs) {
		return getService().deleteLovs(lovs);
	}

	public static void deleteLovWorkflow(
			Long id, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		getService().deleteLovWorkflow(id, user, serviceContext);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.LovsModelImpl</code>.
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

	public static Lovs fetchLovs(long id) {
		return getService().fetchLovs(id);
	}

	public static com.ejada.telemony.db.model.LovsLocalization
		fetchLovsLocalization(long id, String languageId) {

		return getService().fetchLovsLocalization(id, languageId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Lovs> getByChannelId(Long channelId) {
		return getService().getByChannelId(channelId);
	}

	public static List<Lovs> getByEntityResourceId(long entityResourceId) {
		return getService().getByEntityResourceId(entityResourceId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<String> getLangNamesByCode(String code, Long channelId) {
		return getService().getLangNamesByCode(code, channelId);
	}

	public static List<String> getLangTypeCodeByLOVCode(
		String code, Long channelId) {

		return getService().getLangTypeCodeByLOVCode(code, channelId);
	}

	public static List<Lovs> getLatestApprovedByChannelId(long channelId) {
		return getService().getLatestApprovedByChannelId(channelId);
	}

	public static List<Lovs> getLatestApprovedByChannelIdAndCode(
		long channelId, String code) {

		return getService().getLatestApprovedByChannelIdAndCode(
			channelId, code);
	}

	public static List<String> getLatestApprovedLangNamesByCode(
		String code, Long channelId) {

		return getService().getLatestApprovedLangNamesByCode(code, channelId);
	}

	public static Lovs getLatestApprovedLovByEntityResourceId(
		long entityResourceId) {

		return getService().getLatestApprovedLovByEntityResourceId(
			entityResourceId);
	}

	public static List<com.ejada.telemony.db.model.LovData>
		getLatestApprovedLovDataByCode(String code, Long channelId) {

		return getService().getLatestApprovedLovDataByCode(code, channelId);
	}

	public static List<com.ejada.telemony.db.model.LovData> getLovDataByCode(
		String code, Long channelId) {

		return getService().getLovDataByCode(code, channelId);
	}

	public static int getLovDataCountByLovId(Long LovId) {
		return getService().getLovDataCountByLovId(LovId);
	}

	/**
	 * Returns the lovs with the primary key.
	 *
	 * @param id the primary key of the lovs
	 * @return the lovs
	 * @throws PortalException if a lovs with the primary key could not be found
	 */
	public static Lovs getLovs(long id) throws PortalException {
		return getService().getLovs(id);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getLovsAndRelatedDataByCode(
			String code, String language, Long channelId) {

		return getService().getLovsAndRelatedDataByCode(
			code, language, channelId);
	}

	public static List<Lovs> getLovsByTypeCodeAndStatus(
		String code, long channelId, int status) {

		return getService().getLovsByTypeCodeAndStatus(code, channelId, status);
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
	public static List<Lovs> getLovses(int start, int end) {
		return getService().getLovses(start, end);
	}

	/**
	 * Returns the number of lovses.
	 *
	 * @return the number of lovses
	 */
	public static int getLovsesCount() {
		return getService().getLovsesCount();
	}

	public static com.ejada.telemony.db.model.LovsLocalization
			getLovsLocalization(long id, String languageId)
		throws PortalException {

		return getService().getLovsLocalization(id, languageId);
	}

	public static List<com.ejada.telemony.db.model.LovsLocalization>
		getLovsLocalizations(long id) {

		return getService().getLovsLocalizations(id);
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

	public static void importLovsAndLovDataFromCSV(
			String filePath, Long channelId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException {

		getService().importLovsAndLovDataFromCSV(filePath, channelId);
	}

	public static Lovs lovListCreate(
			Map<String, String> names, String code, String eventCode,
			Long channelId, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return getService().lovListCreate(
			names, code, eventCode, channelId, user, serviceContext);
	}

	public static void lovListDelete(Long id, Long channelId) throws Exception {
		getService().lovListDelete(id, channelId);
	}

	public static Lovs lovListUpdate(
			Long id, Map<String, String> names, String code, Long channelId,
			String eventCode)
		throws Exception {

		return getService().lovListUpdate(
			id, names, code, channelId, eventCode);
	}

	public static List<Lovs> searchByCode(String code, Long channelId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException,
			   javax.portlet.PortletException {

		return getService().searchByCode(code, channelId);
	}

	public static List<Lovs> searchLovLocalizationByName(
			String searchName, Long channelId)
		throws com.liferay.adaptive.media.exception.AMRuntimeException.
			IOException {

		return getService().searchLovLocalizationByName(searchName, channelId);
	}

	public static void updateLovDataWorkflow(
			Long id, Long lovId, String lovType, String recordTypeCode,
			Map<String, String> values, String recordShortDescription,
			Long channelId, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		getService().updateLovDataWorkflow(
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
	public static Lovs updateLovs(Lovs lovs) {
		return getService().updateLovs(lovs);
	}

	public static com.ejada.telemony.db.model.LovsLocalization
			updateLovsLocalization(Lovs lovs, String languageId, String name)
		throws PortalException {

		return getService().updateLovsLocalization(lovs, languageId, name);
	}

	public static List<com.ejada.telemony.db.model.LovsLocalization>
			updateLovsLocalizations(Lovs lovs, Map<String, String> nameMap)
		throws PortalException {

		return getService().updateLovsLocalizations(lovs, nameMap);
	}

	public static void updateLovWorkflow(
			Long id, Map<String, String> nameValues, String code,
			Long channelId, String eventCode,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		getService().updateLovWorkflow(
			id, nameValues, code, channelId, eventCode, user, serviceContext);
	}

	public static Lovs updateStatus(
			long userId, long lovId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return getService().updateStatus(userId, lovId, status, serviceContext);
	}

	public static LovsLocalService getService() {
		return _service;
	}

	public static void setService(LovsLocalService service) {
		_service = service;
	}

	private static volatile LovsLocalService _service;

}