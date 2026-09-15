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

import com.ejada.telemony.db.model.Feature;
import com.ejada.telemony.db.model.Segment;
import com.ejada.telemony.db.service.SegmentLocalServiceUtil;
import com.ejada.telemony.db.service.base.SegmentLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Collections;
import java.util.List;

/**
 * The implementation of the segment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ejada.telemony.db.service.SegmentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegmentLocalServiceBaseImpl
 */
public class SegmentLocalServiceImpl extends SegmentLocalServiceBaseImpl {

	private static final Log LOG = LogFactoryUtil.getLog(FeatureLocalServiceImpl.class);

	public Segment addSegment(
			long featureId,
			String name, 
			Boolean status,
			String method,
			String popUpTitle,
			String popUpSubTitle
		) {
		Segment newSegment = SegmentLocalServiceUtil.createSegment(counterLocalService.increment());
		newSegment.setFeatureId(featureId);
		newSegment.setName(name);
		newSegment.setSegmentStatus(status);
		newSegment.setMethod(method);
		newSegment.setPopUpTitle(popUpTitle);
		newSegment.setPopUpSubTitle(popUpSubTitle);
		SegmentLocalServiceUtil.updateSegment(newSegment);
		return newSegment;
	}
	
	public void updateSegment(
			long segmentId,
			String name, 
			Boolean status,
			String method,
			String popUpTitle,
			String popUpSubTitle
		) {
		Segment foundSegment = SegmentLocalServiceUtil.fetchSegment(segmentId);
		if(foundSegment != null) {
			foundSegment.setName(name);
			foundSegment.setSegmentStatus(status);
			foundSegment.setMethod(method);
			foundSegment.setPopUpTitle(popUpTitle);
			foundSegment.setPopUpSubTitle(popUpSubTitle);
			SegmentLocalServiceUtil.updateSegment(foundSegment);
		}
	}
	
	public List<Segment> getAllSegments(){
		return this.segmentPersistence.findAll();
	}
	
	public void turnOffAllSegmentsStatusForFeature(long featureId){
		//TODO: replace this with a finder function in the XML file
		List<Segment> segments = this.segmentPersistence.findAll();
		for (Segment segment : segments)
			if(segment.getFeatureId() == featureId)
				updateSegment(segment.getSegmentId(),segment.getName(), false, segment.getMethod(), segment.getPopUpTitle(), segment.getPopUpSubTitle());
	}



	public List<Segment> findFeatureSegments(long featureId) {

		Feature feature = featurePersistence.fetchByPrimaryKey(featureId);

		if (feature == null) {
			return Collections.emptyList();
		}

		return findSegmentsByResourceIds(feature.getEntityResourceId(), feature.getChildResourceId());
	}
	public List<Segment> findSegmentsByFeatureId(long featureId)
	{
		return  segmentPersistence.findByfeatureSegments(featureId);
	}

	public List<Segment> findSegmentsByResourceIds(long entityResourceId, long childResourceId) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				Segment.class, getClass().getClassLoader());

		dynamicQuery.add(
				PropertyFactoryUtil.forName("entityResourceId")
						.eq(entityResourceId)
		);

		dynamicQuery.add(
				PropertyFactoryUtil.forName("status")
						.eq(WorkflowConstants.STATUS_APPROVED)
		);

		dynamicQuery.add(
				PropertyFactoryUtil.forName("childResourceId")
						.eq(childResourceId)
		);

		// Order by segmentId to maintain consistent order
		dynamicQuery.addOrder(OrderFactoryUtil.asc("entityResourceId"));

		return segmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Find segments by originalEntityId and status
	 * Used to detect pending segment versions (for segment update workflow)
	 */
	public List<Segment> findByOriginalEntityIdAndStatus(long originalEntityId, int status) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				Segment.class, getClass().getClassLoader());

		dynamicQuery.add(
				PropertyFactoryUtil.forName("originalEntityId")
						.eq(originalEntityId)
		);

		dynamicQuery.add(
				PropertyFactoryUtil.forName("status")
						.eq(status)
		);

		return segmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Find all segments by resource IDs regardless of status
	 * Used to check if any segment has pending/draft status
	 */
	public List<Segment> findAllSegmentsByResourceIds(long entityResourceId, long childResourceId) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				Segment.class, getClass().getClassLoader());

		dynamicQuery.add(
				PropertyFactoryUtil.forName("entityResourceId")
						.eq(entityResourceId)
		);

		dynamicQuery.add(
				PropertyFactoryUtil.forName("childResourceId")
						.eq(childResourceId)
		);

		// Order by segmentId to maintain consistent order
		dynamicQuery.addOrder(com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.asc("segmentId"));

		return segmentLocalService.dynamicQuery(dynamicQuery);
	}


	public void deleteAllSegmentsForFeature(List<Segment> segments) throws Exception {
		try {
			
			for (Segment segment : segments) {
				segmentPersistence.remove(segment.getSegmentId());
			}
		} catch (Exception e) {
			LOG.info("----------------Error occured when deleting segments-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
		
	}
}