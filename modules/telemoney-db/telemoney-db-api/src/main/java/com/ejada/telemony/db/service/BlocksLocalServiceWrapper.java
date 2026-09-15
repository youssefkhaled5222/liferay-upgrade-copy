/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BlocksLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BlocksLocalService
 * @generated
 */
public class BlocksLocalServiceWrapper
	implements BlocksLocalService, ServiceWrapper<BlocksLocalService> {

	public BlocksLocalServiceWrapper() {
		this(null);
	}

	public BlocksLocalServiceWrapper(BlocksLocalService blocksLocalService) {
		_blocksLocalService = blocksLocalService;
	}

	@Override
	public com.ejada.telemony.db.model.Blocks add(
			long channelId, String type, boolean androidBlock,
			String androidBlockVersion, java.util.Date androidBlockFrom,
			java.util.Date androidBlockTo, boolean iosBlock,
			String iosBlockVersion, java.util.Date iosBlockFrom,
			java.util.Date iosBlockTo, boolean webBlock, String webBlockVersion,
			java.util.Date webBlockFrom, java.util.Date webBlockTo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.add(
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
	@Override
	public com.ejada.telemony.db.model.Blocks addBlocks(
		com.ejada.telemony.db.model.Blocks blocks) {

		return _blocksLocalService.addBlocks(blocks);
	}

	/**
	 * Creates a new blocks with the primary key. Does not add the blocks to the database.
	 *
	 * @param blockId the primary key for the new blocks
	 * @return the new blocks
	 */
	@Override
	public com.ejada.telemony.db.model.Blocks createBlocks(long blockId) {
		return _blocksLocalService.createBlocks(blockId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.telemony.db.model.Blocks deleteBlocks(
		com.ejada.telemony.db.model.Blocks blocks) {

		return _blocksLocalService.deleteBlocks(blocks);
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
	@Override
	public com.ejada.telemony.db.model.Blocks deleteBlocks(long blockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.deleteBlocks(blockId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _blocksLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _blocksLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _blocksLocalService.dynamicQuery();
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

		return _blocksLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _blocksLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _blocksLocalService.dynamicQuery(
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

		return _blocksLocalService.dynamicQueryCount(dynamicQuery);
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

		return _blocksLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.telemony.db.model.Blocks fetchBlocks(long blockId) {
		return _blocksLocalService.fetchBlocks(blockId);
	}

	@Override
	public java.util.List<com.ejada.telemony.db.model.Blocks> findAll() {
		return _blocksLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _blocksLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the blocks with the primary key.
	 *
	 * @param blockId the primary key of the blocks
	 * @return the blocks
	 * @throws PortalException if a blocks with the primary key could not be found
	 */
	@Override
	public com.ejada.telemony.db.model.Blocks getBlocks(long blockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.getBlocks(blockId);
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
	@Override
	public java.util.List<com.ejada.telemony.db.model.Blocks> getBlockses(
		int start, int end) {

		return _blocksLocalService.getBlockses(start, end);
	}

	/**
	 * Returns the number of blockses.
	 *
	 * @return the number of blockses
	 */
	@Override
	public int getBlocksesCount() {
		return _blocksLocalService.getBlocksesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _blocksLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _blocksLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.ejada.telemony.db.model.Blocks update(
			com.ejada.telemony.db.model.Blocks block)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.update(block);
	}

	@Override
	public com.ejada.telemony.db.model.Blocks update(
			long blockId, long channelId, String type, boolean androidBlock,
			String androidBlockVersion, java.util.Date androidBlockFrom,
			java.util.Date androidBlockTo, boolean iosBlock,
			String iosBlockVersion, java.util.Date iosBlockFrom,
			java.util.Date iosBlockTo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksLocalService.update(
			blockId, channelId, type, androidBlock, androidBlockVersion,
			androidBlockFrom, androidBlockTo, iosBlock, iosBlockVersion,
			iosBlockFrom, iosBlockTo);
	}

	@Override
	public void updateBlock(
		long channelId, String type, boolean androidBlock,
		String androidBlockVersion, java.util.Date androidBlockFrom,
		java.util.Date androidBlockTo, boolean iosBlock, String iosBlockVersion,
		java.util.Date iosBlockFrom, java.util.Date iosBlockTo,
		boolean webBlock, String webBlockVersion, java.util.Date webBlockFrom,
		java.util.Date webBlockTo, long blockId) {

		_blocksLocalService.updateBlock(
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
	@Override
	public com.ejada.telemony.db.model.Blocks updateBlocks(
		com.ejada.telemony.db.model.Blocks blocks) {

		return _blocksLocalService.updateBlocks(blocks);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _blocksLocalService.getBasePersistence();
	}

	@Override
	public BlocksLocalService getWrappedService() {
		return _blocksLocalService;
	}

	@Override
	public void setWrappedService(BlocksLocalService blocksLocalService) {
		_blocksLocalService = blocksLocalService;
	}

	private BlocksLocalService _blocksLocalService;

}