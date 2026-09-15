/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BannerContent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerContent
 * @generated
 */
public class BannerContentWrapper
	extends BaseModelWrapper<BannerContent>
	implements BannerContent, ModelWrapper<BannerContent> {

	public BannerContentWrapper(BannerContent bannerContent) {
		super(bannerContent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("defaultLanguageId", getDefaultLanguageId());
		attributes.put("contentId", getContentId());
		attributes.put("contentName", getContentName());
		attributes.put("contentOrder", getContentOrder());
		attributes.put("bannerId", getBannerId());
		attributes.put("contentStatus", getContentStatus());
		attributes.put("channelId", getChannelId());
		attributes.put("status", getStatus());
		attributes.put("originalEntityId", getOriginalEntityId());
		attributes.put("entityResourceId", getEntityResourceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String defaultLanguageId = (String)attributes.get("defaultLanguageId");

		if (defaultLanguageId != null) {
			setDefaultLanguageId(defaultLanguageId);
		}

		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		String contentName = (String)attributes.get("contentName");

		if (contentName != null) {
			setContentName(contentName);
		}

		Integer contentOrder = (Integer)attributes.get("contentOrder");

		if (contentOrder != null) {
			setContentOrder(contentOrder);
		}

		Long bannerId = (Long)attributes.get("bannerId");

		if (bannerId != null) {
			setBannerId(bannerId);
		}

		String contentStatus = (String)attributes.get("contentStatus");

		if (contentStatus != null) {
			setContentStatus(contentStatus);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long originalEntityId = (Long)attributes.get("originalEntityId");

		if (originalEntityId != null) {
			setOriginalEntityId(originalEntityId);
		}

		Long entityResourceId = (Long)attributes.get("entityResourceId");

		if (entityResourceId != null) {
			setEntityResourceId(entityResourceId);
		}
	}

	@Override
	public BannerContent cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the banner ID of this banner content.
	 *
	 * @return the banner ID of this banner content
	 */
	@Override
	public long getBannerId() {
		return model.getBannerId();
	}

	/**
	 * Returns the channel ID of this banner content.
	 *
	 * @return the channel ID of this banner content
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the content ID of this banner content.
	 *
	 * @return the content ID of this banner content
	 */
	@Override
	public long getContentId() {
		return model.getContentId();
	}

	/**
	 * Returns the content name of this banner content.
	 *
	 * @return the content name of this banner content
	 */
	@Override
	public String getContentName() {
		return model.getContentName();
	}

	/**
	 * Returns the content order of this banner content.
	 *
	 * @return the content order of this banner content
	 */
	@Override
	public int getContentOrder() {
		return model.getContentOrder();
	}

	/**
	 * Returns the content status of this banner content.
	 *
	 * @return the content status of this banner content
	 */
	@Override
	public String getContentStatus() {
		return model.getContentStatus();
	}

	/**
	 * Returns the default language ID of this banner content.
	 *
	 * @return the default language ID of this banner content
	 */
	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	@Override
	public String getDescriptionValue() {
		return model.getDescriptionValue();
	}

	@Override
	public String getDescriptionValue(String languageId) {
		return model.getDescriptionValue(languageId);
	}

	@Override
	public String getDescriptionValue(String languageId, boolean useDefault) {
		return model.getDescriptionValue(languageId, useDefault);
	}

	@Override
	public String getDescriptionValueMapAsXML() {
		return model.getDescriptionValueMapAsXML();
	}

	/**
	 * Returns the entity resource ID of this banner content.
	 *
	 * @return the entity resource ID of this banner content
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	@Override
	public Map<String, String> getLanguageIdToDescriptionValueMap() {
		return model.getLanguageIdToDescriptionValueMap();
	}

	@Override
	public Map<String, String> getLanguageIdToTitleValueMap() {
		return model.getLanguageIdToTitleValueMap();
	}

	/**
	 * Returns the original entity ID of this banner content.
	 *
	 * @return the original entity ID of this banner content
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the primary key of this banner content.
	 *
	 * @return the primary key of this banner content
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this banner content.
	 *
	 * @return the status of this banner content
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	@Override
	public String getTitleValue() {
		return model.getTitleValue();
	}

	@Override
	public String getTitleValue(String languageId) {
		return model.getTitleValue(languageId);
	}

	@Override
	public String getTitleValue(String languageId, boolean useDefault) {
		return model.getTitleValue(languageId, useDefault);
	}

	@Override
	public String getTitleValueMapAsXML() {
		return model.getTitleValueMapAsXML();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the banner ID of this banner content.
	 *
	 * @param bannerId the banner ID of this banner content
	 */
	@Override
	public void setBannerId(long bannerId) {
		model.setBannerId(bannerId);
	}

	/**
	 * Sets the channel ID of this banner content.
	 *
	 * @param channelId the channel ID of this banner content
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the content ID of this banner content.
	 *
	 * @param contentId the content ID of this banner content
	 */
	@Override
	public void setContentId(long contentId) {
		model.setContentId(contentId);
	}

	/**
	 * Sets the content name of this banner content.
	 *
	 * @param contentName the content name of this banner content
	 */
	@Override
	public void setContentName(String contentName) {
		model.setContentName(contentName);
	}

	/**
	 * Sets the content order of this banner content.
	 *
	 * @param contentOrder the content order of this banner content
	 */
	@Override
	public void setContentOrder(int contentOrder) {
		model.setContentOrder(contentOrder);
	}

	/**
	 * Sets the content status of this banner content.
	 *
	 * @param contentStatus the content status of this banner content
	 */
	@Override
	public void setContentStatus(String contentStatus) {
		model.setContentStatus(contentStatus);
	}

	/**
	 * Sets the default language ID of this banner content.
	 *
	 * @param defaultLanguageId the default language ID of this banner content
	 */
	@Override
	public void setDefaultLanguageId(String defaultLanguageId) {
		model.setDefaultLanguageId(defaultLanguageId);
	}

	/**
	 * Sets the entity resource ID of this banner content.
	 *
	 * @param entityResourceId the entity resource ID of this banner content
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the original entity ID of this banner content.
	 *
	 * @param originalEntityId the original entity ID of this banner content
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the primary key of this banner content.
	 *
	 * @param primaryKey the primary key of this banner content
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this banner content.
	 *
	 * @param status the status of this banner content
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BannerContentWrapper wrap(BannerContent bannerContent) {
		return new BannerContentWrapper(bannerContent);
	}

}