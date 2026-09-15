/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Blocks}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Blocks
 * @generated
 */
public class BlocksWrapper
	extends BaseModelWrapper<Blocks> implements Blocks, ModelWrapper<Blocks> {

	public BlocksWrapper(Blocks blocks) {
		super(blocks);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("blockId", getBlockId());
		attributes.put("channelId", getChannelId());
		attributes.put("type", getType());
		attributes.put("androidBlock", isAndroidBlock());
		attributes.put("androidBlockVersion", getAndroidBlockVersion());
		attributes.put("androidBlockFrom", getAndroidBlockFrom());
		attributes.put("androidBlockTo", getAndroidBlockTo());
		attributes.put("iosBlock", isIosBlock());
		attributes.put("iosBlockVersion", getIosBlockVersion());
		attributes.put("iosBlockFrom", getIosBlockFrom());
		attributes.put("iosBlockTo", getIosBlockTo());
		attributes.put("webBlock", isWebBlock());
		attributes.put("webBlockVersion", getWebBlockVersion());
		attributes.put("webBlockFrom", getWebBlockFrom());
		attributes.put("webBlockTo", getWebBlockTo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long blockId = (Long)attributes.get("blockId");

		if (blockId != null) {
			setBlockId(blockId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean androidBlock = (Boolean)attributes.get("androidBlock");

		if (androidBlock != null) {
			setAndroidBlock(androidBlock);
		}

		String androidBlockVersion = (String)attributes.get(
			"androidBlockVersion");

		if (androidBlockVersion != null) {
			setAndroidBlockVersion(androidBlockVersion);
		}

		Date androidBlockFrom = (Date)attributes.get("androidBlockFrom");

		if (androidBlockFrom != null) {
			setAndroidBlockFrom(androidBlockFrom);
		}

		Date androidBlockTo = (Date)attributes.get("androidBlockTo");

		if (androidBlockTo != null) {
			setAndroidBlockTo(androidBlockTo);
		}

		Boolean iosBlock = (Boolean)attributes.get("iosBlock");

		if (iosBlock != null) {
			setIosBlock(iosBlock);
		}

		String iosBlockVersion = (String)attributes.get("iosBlockVersion");

		if (iosBlockVersion != null) {
			setIosBlockVersion(iosBlockVersion);
		}

		Date iosBlockFrom = (Date)attributes.get("iosBlockFrom");

		if (iosBlockFrom != null) {
			setIosBlockFrom(iosBlockFrom);
		}

		Date iosBlockTo = (Date)attributes.get("iosBlockTo");

		if (iosBlockTo != null) {
			setIosBlockTo(iosBlockTo);
		}

		Boolean webBlock = (Boolean)attributes.get("webBlock");

		if (webBlock != null) {
			setWebBlock(webBlock);
		}

		String webBlockVersion = (String)attributes.get("webBlockVersion");

		if (webBlockVersion != null) {
			setWebBlockVersion(webBlockVersion);
		}

		Date webBlockFrom = (Date)attributes.get("webBlockFrom");

		if (webBlockFrom != null) {
			setWebBlockFrom(webBlockFrom);
		}

		Date webBlockTo = (Date)attributes.get("webBlockTo");

		if (webBlockTo != null) {
			setWebBlockTo(webBlockTo);
		}
	}

	@Override
	public Blocks cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the android block of this blocks.
	 *
	 * @return the android block of this blocks
	 */
	@Override
	public boolean getAndroidBlock() {
		return model.getAndroidBlock();
	}

	/**
	 * Returns the android block from of this blocks.
	 *
	 * @return the android block from of this blocks
	 */
	@Override
	public Date getAndroidBlockFrom() {
		return model.getAndroidBlockFrom();
	}

	/**
	 * Returns the android block to of this blocks.
	 *
	 * @return the android block to of this blocks
	 */
	@Override
	public Date getAndroidBlockTo() {
		return model.getAndroidBlockTo();
	}

	/**
	 * Returns the android block version of this blocks.
	 *
	 * @return the android block version of this blocks
	 */
	@Override
	public String getAndroidBlockVersion() {
		return model.getAndroidBlockVersion();
	}

	/**
	 * Returns the block ID of this blocks.
	 *
	 * @return the block ID of this blocks
	 */
	@Override
	public long getBlockId() {
		return model.getBlockId();
	}

	/**
	 * Returns the channel ID of this blocks.
	 *
	 * @return the channel ID of this blocks
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the ios block of this blocks.
	 *
	 * @return the ios block of this blocks
	 */
	@Override
	public boolean getIosBlock() {
		return model.getIosBlock();
	}

	/**
	 * Returns the ios block from of this blocks.
	 *
	 * @return the ios block from of this blocks
	 */
	@Override
	public Date getIosBlockFrom() {
		return model.getIosBlockFrom();
	}

	/**
	 * Returns the ios block to of this blocks.
	 *
	 * @return the ios block to of this blocks
	 */
	@Override
	public Date getIosBlockTo() {
		return model.getIosBlockTo();
	}

	/**
	 * Returns the ios block version of this blocks.
	 *
	 * @return the ios block version of this blocks
	 */
	@Override
	public String getIosBlockVersion() {
		return model.getIosBlockVersion();
	}

	/**
	 * Returns the primary key of this blocks.
	 *
	 * @return the primary key of this blocks
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this blocks.
	 *
	 * @return the type of this blocks
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the web block of this blocks.
	 *
	 * @return the web block of this blocks
	 */
	@Override
	public boolean getWebBlock() {
		return model.getWebBlock();
	}

	/**
	 * Returns the web block from of this blocks.
	 *
	 * @return the web block from of this blocks
	 */
	@Override
	public Date getWebBlockFrom() {
		return model.getWebBlockFrom();
	}

	/**
	 * Returns the web block to of this blocks.
	 *
	 * @return the web block to of this blocks
	 */
	@Override
	public Date getWebBlockTo() {
		return model.getWebBlockTo();
	}

	/**
	 * Returns the web block version of this blocks.
	 *
	 * @return the web block version of this blocks
	 */
	@Override
	public String getWebBlockVersion() {
		return model.getWebBlockVersion();
	}

	/**
	 * Returns <code>true</code> if this blocks is android block.
	 *
	 * @return <code>true</code> if this blocks is android block; <code>false</code> otherwise
	 */
	@Override
	public boolean isAndroidBlock() {
		return model.isAndroidBlock();
	}

	/**
	 * Returns <code>true</code> if this blocks is ios block.
	 *
	 * @return <code>true</code> if this blocks is ios block; <code>false</code> otherwise
	 */
	@Override
	public boolean isIosBlock() {
		return model.isIosBlock();
	}

	/**
	 * Returns <code>true</code> if this blocks is web block.
	 *
	 * @return <code>true</code> if this blocks is web block; <code>false</code> otherwise
	 */
	@Override
	public boolean isWebBlock() {
		return model.isWebBlock();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this blocks is android block.
	 *
	 * @param androidBlock the android block of this blocks
	 */
	@Override
	public void setAndroidBlock(boolean androidBlock) {
		model.setAndroidBlock(androidBlock);
	}

	/**
	 * Sets the android block from of this blocks.
	 *
	 * @param androidBlockFrom the android block from of this blocks
	 */
	@Override
	public void setAndroidBlockFrom(Date androidBlockFrom) {
		model.setAndroidBlockFrom(androidBlockFrom);
	}

	/**
	 * Sets the android block to of this blocks.
	 *
	 * @param androidBlockTo the android block to of this blocks
	 */
	@Override
	public void setAndroidBlockTo(Date androidBlockTo) {
		model.setAndroidBlockTo(androidBlockTo);
	}

	/**
	 * Sets the android block version of this blocks.
	 *
	 * @param androidBlockVersion the android block version of this blocks
	 */
	@Override
	public void setAndroidBlockVersion(String androidBlockVersion) {
		model.setAndroidBlockVersion(androidBlockVersion);
	}

	/**
	 * Sets the block ID of this blocks.
	 *
	 * @param blockId the block ID of this blocks
	 */
	@Override
	public void setBlockId(long blockId) {
		model.setBlockId(blockId);
	}

	/**
	 * Sets the channel ID of this blocks.
	 *
	 * @param channelId the channel ID of this blocks
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets whether this blocks is ios block.
	 *
	 * @param iosBlock the ios block of this blocks
	 */
	@Override
	public void setIosBlock(boolean iosBlock) {
		model.setIosBlock(iosBlock);
	}

	/**
	 * Sets the ios block from of this blocks.
	 *
	 * @param iosBlockFrom the ios block from of this blocks
	 */
	@Override
	public void setIosBlockFrom(Date iosBlockFrom) {
		model.setIosBlockFrom(iosBlockFrom);
	}

	/**
	 * Sets the ios block to of this blocks.
	 *
	 * @param iosBlockTo the ios block to of this blocks
	 */
	@Override
	public void setIosBlockTo(Date iosBlockTo) {
		model.setIosBlockTo(iosBlockTo);
	}

	/**
	 * Sets the ios block version of this blocks.
	 *
	 * @param iosBlockVersion the ios block version of this blocks
	 */
	@Override
	public void setIosBlockVersion(String iosBlockVersion) {
		model.setIosBlockVersion(iosBlockVersion);
	}

	/**
	 * Sets the primary key of this blocks.
	 *
	 * @param primaryKey the primary key of this blocks
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this blocks.
	 *
	 * @param type the type of this blocks
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets whether this blocks is web block.
	 *
	 * @param webBlock the web block of this blocks
	 */
	@Override
	public void setWebBlock(boolean webBlock) {
		model.setWebBlock(webBlock);
	}

	/**
	 * Sets the web block from of this blocks.
	 *
	 * @param webBlockFrom the web block from of this blocks
	 */
	@Override
	public void setWebBlockFrom(Date webBlockFrom) {
		model.setWebBlockFrom(webBlockFrom);
	}

	/**
	 * Sets the web block to of this blocks.
	 *
	 * @param webBlockTo the web block to of this blocks
	 */
	@Override
	public void setWebBlockTo(Date webBlockTo) {
		model.setWebBlockTo(webBlockTo);
	}

	/**
	 * Sets the web block version of this blocks.
	 *
	 * @param webBlockVersion the web block version of this blocks
	 */
	@Override
	public void setWebBlockVersion(String webBlockVersion) {
		model.setWebBlockVersion(webBlockVersion);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BlocksWrapper wrap(Blocks blocks) {
		return new BlocksWrapper(blocks);
	}

}