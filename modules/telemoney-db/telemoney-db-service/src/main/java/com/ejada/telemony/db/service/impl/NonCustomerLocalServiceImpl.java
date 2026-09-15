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

import com.ejada.telemony.db.service.SMSLocalServiceUtil;
import com.ejada.telemony.db.service.base.NonCustomerLocalServiceBaseImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The implementation of the non customer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ejada.telemony.db.service.NonCustomerLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NonCustomerLocalServiceBaseImpl
 */
public class NonCustomerLocalServiceImpl
	extends NonCustomerLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ejada.telemony.db.service.NonCustomerLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ejada.telemony.db.service.NonCustomerLocalServiceUtil</code>.
	 */
	
	public String getAllNonCustomer(String nonCustomerUrl,String XCorrelationId,String userName,String password) {
		//String Url = "http://192.168.215.114:17427/api/v1/login-management/non-customers";
		return SMSLocalServiceUtil.getAdminPortalData(nonCustomerUrl,XCorrelationId,userName,password);
	}
	
	
}