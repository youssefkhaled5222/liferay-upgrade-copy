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
 * This class is a wrapper for {@link Segment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Segment
 * @generated
 */
public class SegmentWrapper
	extends BaseModelWrapper<Segment>
	implements ModelWrapper<Segment>, Segment {

	public SegmentWrapper(Segment segment) {
		super(segment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
		attributes.put("featureId", getFeatureId());
		attributes.put("name", getName());
		attributes.put("segmentStatus", getSegmentStatus());
		attributes.put("method", getMethod());
		attributes.put("popUpTitle", getPopUpTitle());
		attributes.put("popUpSubTitle", getPopUpSubTitle());
		attributes.put("status", getStatus());
		attributes.put("originalEntityId", getOriginalEntityId());
		attributes.put("entityResourceId", getEntityResourceId());
		attributes.put("childResourceId", getChildResourceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
		}

		Long featureId = (Long)attributes.get("featureId");

		if (featureId != null) {
			setFeatureId(featureId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean segmentStatus = (Boolean)attributes.get("segmentStatus");

		if (segmentStatus != null) {
			setSegmentStatus(segmentStatus);
		}

		String method = (String)attributes.get("method");

		if (method != null) {
			setMethod(method);
		}

		String popUpTitle = (String)attributes.get("popUpTitle");

		if (popUpTitle != null) {
			setPopUpTitle(popUpTitle);
		}

		String popUpSubTitle = (String)attributes.get("popUpSubTitle");

		if (popUpSubTitle != null) {
			setPopUpSubTitle(popUpSubTitle);
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

		Long childResourceId = (Long)attributes.get("childResourceId");

		if (childResourceId != null) {
			setChildResourceId(childResourceId);
		}
	}

	@Override
	public Segment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the child resource ID of this segment.
	 *
	 * @return the child resource ID of this segment
	 */
	@Override
	public long getChildResourceId() {
		return model.getChildResourceId();
	}

	/**
	 * Returns the entity resource ID of this segment.
	 *
	 * @return the entity resource ID of this segment
	 */
	@Override
	public long getEntityResourceId() {
		return model.getEntityResourceId();
	}

	/**
	 * Returns the feature ID of this segment.
	 *
	 * @return the feature ID of this segment
	 */
	@Override
	public long getFeatureId() {
		return model.getFeatureId();
	}

	/**
	 * Returns the method of this segment.
	 *
	 * @return the method of this segment
	 */
	@Override
	public String getMethod() {
		return model.getMethod();
	}

	/**
	 * Returns the name of this segment.
	 *
	 * @return the name of this segment
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the original entity ID of this segment.
	 *
	 * @return the original entity ID of this segment
	 */
	@Override
	public long getOriginalEntityId() {
		return model.getOriginalEntityId();
	}

	/**
	 * Returns the pop up sub title of this segment.
	 *
	 * @return the pop up sub title of this segment
	 */
	@Override
	public String getPopUpSubTitle() {
		return model.getPopUpSubTitle();
	}

	/**
	 * Returns the pop up title of this segment.
	 *
	 * @return the pop up title of this segment
	 */
	@Override
	public String getPopUpTitle() {
		return model.getPopUpTitle();
	}

	/**
	 * Returns the primary key of this segment.
	 *
	 * @return the primary key of this segment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the segment ID of this segment.
	 *
	 * @return the segment ID of this segment
	 */
	@Override
	public long getSegmentId() {
		return model.getSegmentId();
	}

	/**
	 * Returns the segment status of this segment.
	 *
	 * @return the segment status of this segment
	 */
	@Override
	public Boolean getSegmentStatus() {
		return model.getSegmentStatus();
	}

	/**
	 * Returns the status of this segment.
	 *
	 * @return the status of this segment
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the child resource ID of this segment.
	 *
	 * @param childResourceId the child resource ID of this segment
	 */
	@Override
	public void setChildResourceId(long childResourceId) {
		model.setChildResourceId(childResourceId);
	}

	/**
	 * Sets the entity resource ID of this segment.
	 *
	 * @param entityResourceId the entity resource ID of this segment
	 */
	@Override
	public void setEntityResourceId(long entityResourceId) {
		model.setEntityResourceId(entityResourceId);
	}

	/**
	 * Sets the feature ID of this segment.
	 *
	 * @param featureId the feature ID of this segment
	 */
	@Override
	public void setFeatureId(long featureId) {
		model.setFeatureId(featureId);
	}

	/**
	 * Sets the method of this segment.
	 *
	 * @param method the method of this segment
	 */
	@Override
	public void setMethod(String method) {
		model.setMethod(method);
	}

	/**
	 * Sets the name of this segment.
	 *
	 * @param name the name of this segment
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the original entity ID of this segment.
	 *
	 * @param originalEntityId the original entity ID of this segment
	 */
	@Override
	public void setOriginalEntityId(long originalEntityId) {
		model.setOriginalEntityId(originalEntityId);
	}

	/**
	 * Sets the pop up sub title of this segment.
	 *
	 * @param popUpSubTitle the pop up sub title of this segment
	 */
	@Override
	public void setPopUpSubTitle(String popUpSubTitle) {
		model.setPopUpSubTitle(popUpSubTitle);
	}

	/**
	 * Sets the pop up title of this segment.
	 *
	 * @param popUpTitle the pop up title of this segment
	 */
	@Override
	public void setPopUpTitle(String popUpTitle) {
		model.setPopUpTitle(popUpTitle);
	}

	/**
	 * Sets the primary key of this segment.
	 *
	 * @param primaryKey the primary key of this segment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the segment ID of this segment.
	 *
	 * @param segmentId the segment ID of this segment
	 */
	@Override
	public void setSegmentId(long segmentId) {
		model.setSegmentId(segmentId);
	}

	/**
	 * Sets the segment status of this segment.
	 *
	 * @param segmentStatus the segment status of this segment
	 */
	@Override
	public void setSegmentStatus(Boolean segmentStatus) {
		model.setSegmentStatus(segmentStatus);
	}

	/**
	 * Sets the status of this segment.
	 *
	 * @param status the status of this segment
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
	protected SegmentWrapper wrap(Segment segment) {
		return new SegmentWrapper(segment);
	}

}