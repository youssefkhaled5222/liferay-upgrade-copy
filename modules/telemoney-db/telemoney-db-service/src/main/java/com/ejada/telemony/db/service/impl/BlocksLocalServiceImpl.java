/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.exception.NoSuchBlocksException;
import com.ejada.telemony.db.model.Blocks;
import com.ejada.telemony.db.service.BlocksLocalServiceUtil;
import com.ejada.telemony.db.service.ChannelsLocalService;
import com.ejada.telemony.db.service.base.BlocksLocalServiceBaseImpl;
import com.ejada.telemony.db.service.persistence.ChannelsUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the blocks local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.BlocksLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlocksLocalServiceBaseImpl
 */
public class BlocksLocalServiceImpl extends BlocksLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.BlocksLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.BlocksLocalServiceUtil</code>.
	 */
	public Blocks add(long channelId, String type, boolean androidBlock, String androidBlockVersion,
			Date androidBlockFrom, Date androidBlockTo, boolean iosBlock, String iosBlockVersion, Date iosBlockFrom,
			Date iosBlockTo, boolean webBlock, String webBlockVersion, Date webBlockFrom, Date webBlockTo)
			throws PortalException {

		/*
		 * try { if(ChannelsUtil.fetchByPrimaryKey(channelId) != null) {
		 */
		Blocks newBlock = BlocksLocalServiceUtil.createBlocks(counterLocalService.increment());
		newBlock.setChannelId(channelId);
		newBlock.setType(type);
		newBlock.setAndroidBlock(androidBlock);
		newBlock.setAndroidBlockVersion(androidBlockVersion);
		newBlock.setAndroidBlockFrom(androidBlockFrom);
		newBlock.setAndroidBlockTo(androidBlockTo);
		newBlock.setIosBlock(iosBlock);
		newBlock.setIosBlockVersion(iosBlockVersion);
		newBlock.setIosBlockFrom(iosBlockFrom);
		newBlock.setIosBlockTo(iosBlockTo);
		newBlock.setWebBlock(webBlock);
		newBlock.setWebBlockVersion(webBlockVersion);
		newBlock.setWebBlockFrom(webBlockFrom);
		newBlock.setWebBlockTo(webBlockTo);
		return BlocksLocalServiceUtil.addBlocks(newBlock);
		/*
		 * } } catch (Exception e) { throw new
		 * NotFoundException("The channel you're trying to create a block for is not found."
		 * ); } return null;
		 */
	}

	public Blocks update(Blocks block) throws PortalException {
		Blocks existingBlock = blocksPersistence.fetchByPrimaryKey(block.getBlockId());

		if (existingBlock == null) {
			throw new NoSuchBlocksException("No block found with ID " + block.getBlockId());
		}

		/*
		 * existingBlock.setChannelId(block.getChannelId());
		 * existingBlock.setType(block.getType());
		 * existingBlock.setAndroidBlock(block.getAndroidBlock());
		 * existingBlock.setAndroidBlockVersion(block.getAndroidBlockVersion());
		 * existingBlock.setAndroidBlockFrom(block.getAndroidBlockFrom());
		 * existingBlock.setAndroidBlockTo(block.getAndroidBlockTo());
		 * existingBlock.setIosBlock(block.getIosBlock());
		 * existingBlock.setIosBlockVersion(block.getAndroidBlockVersion());
		 * existingBlock.setIosBlockFrom(block.getIosBlockFrom());
		 * existingBlock.setIosBlockTo(block.getAndroidBlockTo());
		 */
		return blocksPersistence.update(block);
	}

	public List<Blocks> findAll() {
		return blocksPersistence.findAll();
	}

	public void updateBlock(long channelId, String type, boolean androidBlock, String androidBlockVersion,
			Date androidBlockFrom, Date androidBlockTo, boolean iosBlock, String iosBlockVersion, Date iosBlockFrom,
			Date iosBlockTo, boolean webBlock, String webBlockVersion, Date webBlockFrom, Date webBlockTo,
			long blockId) {
		Blocks block = blocksPersistence.fetchByPrimaryKey(blockId);
		block.setChannelId(channelId);
		block.setType(type);
		block.setAndroidBlock(androidBlock);
		block.setAndroidBlockVersion(androidBlockVersion);
		block.setAndroidBlockFrom(androidBlockFrom);
		block.setAndroidBlockTo(androidBlockTo);
		block.setIosBlock(iosBlock);
		block.setIosBlockVersion(iosBlockVersion);
		block.setIosBlockFrom(iosBlockFrom);
		block.setIosBlockTo(iosBlockTo);
		block.setWebBlock(webBlock);
		block.setWebBlockVersion(webBlockVersion);
		block.setWebBlockFrom(webBlockFrom);
		block.setWebBlockTo(webBlockTo);
	}

	@Reference
	private ChannelsLocalServiceImpl _channelsLocalServiceImpl;

	@Reference
	private ChannelsLocalService _channelsLocalService;

	@Override
	public Blocks update(long blockId, long channelId, String type, boolean androidBlock, String androidBlockVersion,
			Date androidBlockFrom, Date androidBlockTo, boolean iosBlock, String iosBlockVersion, Date iosBlockFrom,
			Date iosBlockTo) throws PortalException {
		return null;
	}

}