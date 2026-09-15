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
 * This class is a wrapper for {@link BannerContentLocalization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BannerContentLocalization
 * @generated
 */
public class BannerContentLocalizationWrapper
	extends BaseModelWrapper<BannerContentLocalization>
	implements BannerContentLocalization,
			   ModelWrapper<BannerContentLocalization> {

	public BannerContentLocalizationWrapper(
		BannerContentLocalization bannerContentLocalization) {

		super(bannerContentLocalization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put(
			"bannerContentLocalizationId", getBannerContentLocalizationId());
		attributes.put("contentId", getContentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("bannerImage", getBannerImage());
		attributes.put("imageOverlay", getImageOverlay());
		attributes.put("linkType", getLinkType());
		attributes.put("url", getUrl());
		attributes.put("titleValue", getTitleValue());
		attributes.put("descriptionValue", getDescriptionValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long bannerContentLocalizationId = (Long)attributes.get(
			"bannerContentLocalizationId");

		if (bannerContentLocalizationId != null) {
			setBannerContentLocalizationId(bannerContentLocalizationId);
		}

		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String bannerImage = (String)attributes.get("bannerImage");

		if (bannerImage != null) {
			setBannerImage(bannerImage);
		}

		String imageOverlay = (String)attributes.get("imageOverlay");

		if (imageOverlay != null) {
			setImageOverlay(imageOverlay);
		}

		String linkType = (String)attributes.get("linkType");

		if (linkType != null) {
			setLinkType(linkType);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String titleValue = (String)attributes.get("titleValue");

		if (titleValue != null) {
			setTitleValue(titleValue);
		}

		String descriptionValue = (String)attributes.get("descriptionValue");

		if (descriptionValue != null) {
			setDescriptionValue(descriptionValue);
		}
	}

	@Override
	public BannerContentLocalization cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the banner content localization ID of this banner content localization.
	 *
	 * @return the banner content localization ID of this banner content localization
	 */
	@Override
	public long getBannerContentLocalizationId() {
		return model.getBannerContentLocalizationId();
	}

	/**
	 * Returns the banner image of this banner content localization.
	 *
	 * @return the banner image of this banner content localization
	 */
	@Override
	public String getBannerImage() {
		return model.getBannerImage();
	}

	/**
	 * Returns the content ID of this banner content localization.
	 *
	 * @return the content ID of this banner content localization
	 */
	@Override
	public long getContentId() {
		return model.getContentId();
	}

	/**
	 * Returns the description value of this banner content localization.
	 *
	 * @return the description value of this banner content localization
	 */
	@Override
	public String getDescriptionValue() {
		return model.getDescriptionValue();
	}

	/**
	 * Returns the image overlay of this banner content localization.
	 *
	 * @return the image overlay of this banner content localization
	 */
	@Override
	public String getImageOverlay() {
		return model.getImageOverlay();
	}

	/**
	 * Returns the language ID of this banner content localization.
	 *
	 * @return the language ID of this banner content localization
	 */
	@Override
	public String getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the link type of this banner content localization.
	 *
	 * @return the link type of this banner content localization
	 */
	@Override
	public String getLinkType() {
		return model.getLinkType();
	}

	/**
	 * Returns the mvcc version of this banner content localization.
	 *
	 * @return the mvcc version of this banner content localization
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this banner content localization.
	 *
	 * @return the primary key of this banner content localization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title value of this banner content localization.
	 *
	 * @return the title value of this banner content localization
	 */
	@Override
	public String getTitleValue() {
		return model.getTitleValue();
	}

	/**
	 * Returns the url of this banner content localization.
	 *
	 * @return the url of this banner content localization
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Sets the banner content localization ID of this banner content localization.
	 *
	 * @param bannerContentLocalizationId the banner content localization ID of this banner content localization
	 */
	@Override
	public void setBannerContentLocalizationId(
		long bannerContentLocalizationId) {

		model.setBannerContentLocalizationId(bannerContentLocalizationId);
	}

	/**
	 * Sets the banner image of this banner content localization.
	 *
	 * @param bannerImage the banner image of this banner content localization
	 */
	@Override
	public void setBannerImage(String bannerImage) {
		model.setBannerImage(bannerImage);
	}

	/**
	 * Sets the content ID of this banner content localization.
	 *
	 * @param contentId the content ID of this banner content localization
	 */
	@Override
	public void setContentId(long contentId) {
		model.setContentId(contentId);
	}

	/**
	 * Sets the description value of this banner content localization.
	 *
	 * @param descriptionValue the description value of this banner content localization
	 */
	@Override
	public void setDescriptionValue(String descriptionValue) {
		model.setDescriptionValue(descriptionValue);
	}

	/**
	 * Sets the image overlay of this banner content localization.
	 *
	 * @param imageOverlay the image overlay of this banner content localization
	 */
	@Override
	public void setImageOverlay(String imageOverlay) {
		model.setImageOverlay(imageOverlay);
	}

	/**
	 * Sets the language ID of this banner content localization.
	 *
	 * @param languageId the language ID of this banner content localization
	 */
	@Override
	public void setLanguageId(String languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the link type of this banner content localization.
	 *
	 * @param linkType the link type of this banner content localization
	 */
	@Override
	public void setLinkType(String linkType) {
		model.setLinkType(linkType);
	}

	/**
	 * Sets the mvcc version of this banner content localization.
	 *
	 * @param mvccVersion the mvcc version of this banner content localization
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this banner content localization.
	 *
	 * @param primaryKey the primary key of this banner content localization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title value of this banner content localization.
	 *
	 * @param titleValue the title value of this banner content localization
	 */
	@Override
	public void setTitleValue(String titleValue) {
		model.setTitleValue(titleValue);
	}

	/**
	 * Sets the url of this banner content localization.
	 *
	 * @param url the url of this banner content localization
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BannerContentLocalizationWrapper wrap(
		BannerContentLocalization bannerContentLocalization) {

		return new BannerContentLocalizationWrapper(bannerContentLocalization);
	}

}