/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.Blocks;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Blocks. This utility wraps
 * <code>com.ejada.telemony.db.service.impl.BlocksLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BlocksLocalService
 * @generated
 */
public class BlocksLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.BlocksLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Blocks add(
			long channelId, String type, boolean androidBlock,
			String androidBlockVersion, java.util.Date androidBlockFrom,
			java.util.Date androidBlockTo, boolean iosBlock,
			String iosBlockVersion, java.util.Date iosBlockFrom,
			java.util.Date iosBlockTo, boolean webBlock, String webBlockVersion,
			java.util.Date webBlockFrom, java.util.Date webBlockTo)
		throws PortalException {

		return getService().add(
			channelId, type, androidBlock, androidBlockVersion,
			androidBlockFrom, androidBlockTo, iosBlock, iosBlockVersion,
			iosBlockFrom, iosBlockTo, webBlock, webBlockVersion, webBlockFrom,
			webBlockTo);
	}

	/**
	 * Adds the blocks to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocks the blocks
	 * @return the blocks that was added
	 */
	public static Blocks addBlocks(Blocks blocks) {
		return getService().addBlocks(blocks);
	}

	/**
	 * Creates a new blocks with the primary key. Does not add the blocks to the database.
	 *
	 * @param blockId the primary key for the new blocks
	 * @return the new blocks
	 */
	public static Blocks createBlocks(long blockId) {
		return getService().createBlocks(blockId);
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
	 * Deletes the blocks from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocks the blocks
	 * @return the blocks that was removed
	 */
	public static Blocks deleteBlocks(Blocks blocks) {
		return getService().deleteBlocks(blocks);
	}

	/**
	 * Deletes the blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks that was removed
	 * @throws PortalException if a blocks with the primary key could not be found
	 */
	public static Blocks deleteBlocks(long blockId) throws PortalException {
		return getService().deleteBlocks(blockId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BlocksModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BlocksModelImpl</code>.
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

	public static Blocks fetchBlocks(long blockId) {
		return getService().fetchBlocks(blockId);
	}

	public static List<Blocks> findAll() {
		return getService().findAll();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the blocks with the primary key.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks
	 * @throws PortalException if a blocks with the primary key could not be found
	 */
	public static Blocks getBlocks(long blockId) throws PortalException {
		return getService().getBlocks(blockId);
	}

	/**
	 * Returns a range of all the blockses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.BlocksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blockses
	 * @param end the upper bound of the range of blockses (not inclusive)
	 * @return the range of blockses
	 */
	public static List<Blocks> getBlockses(int start, int end) {
		return getService().getBlockses(start, end);
	}

	/**
	 * Returns the number of blockses.
	 *
	 * @return the number of blockses
	 */
	public static int getBlocksesCount() {
		return getService().getBlocksesCount();
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

	public static Blocks update(Blocks block) throws PortalException {
		return getService().update(block);
	}

	public static Blocks update(
			long blockId, long channelId, String type, boolean androidBlock,
			String androidBlockVersion, java.util.Date androidBlockFrom,
			java.util.Date androidBlockTo, boolean iosBlock,
			String iosBlockVersion, java.util.Date iosBlockFrom,
			java.util.Date iosBlockTo)
		throws PortalException {

		return getService().update(
			blockId, channelId, type, androidBlock, androidBlockVersion,
			androidBlockFrom, androidBlockTo, iosBlock, iosBlockVersion,
			iosBlockFrom, iosBlockTo);
	}

	public static void updateBlock(
		long channelId, String type, boolean androidBlock,
		String androidBlockVersion, java.util.Date androidBlockFrom,
		java.util.Date androidBlockTo, boolean iosBlock, String iosBlockVersion,
		java.util.Date iosBlockFrom, java.util.Date iosBlockTo,
		boolean webBlock, String webBlockVersion, java.util.Date webBlockFrom,
		java.util.Date webBlockTo, long blockId) {

		getService().updateBlock(
			channelId, type, androidBlock, androidBlockVersion,
			androidBlockFrom, androidBlockTo, iosBlock, iosBlockVersion,
			iosBlockFrom, iosBlockTo, webBlock, webBlockVersion, webBlockFrom,
			webBlockTo, blockId);
	}

	/**
	 * Updates the blocks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocks the blocks
	 * @return the blocks that was updated
	 */
	public static Blocks updateBlocks(Blocks blocks) {
		return getService().updateBlocks(blocks);
	}

	public static BlocksLocalService getService() {
		return _service;
	}

	public static void setService(BlocksLocalService service) {
		_service = service;
	}

	private static volatile BlocksLocalService _service;

}