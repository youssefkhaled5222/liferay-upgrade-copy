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

import com.ejada.telemony.db.model.UserLogs;
import com.ejada.telemony.db.service.base.UserLogsLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the user logs local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.UserLogsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserLogsLocalServiceBaseImpl
 */
public class UserLogsLocalServiceImpl extends UserLogsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.UserLogsLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.UserLogsLocalServiceUtil</code>.
	 */

	public void addUserData(String userName, String userAction, Long channelId) {
		if (userName == null || userAction == null || channelId == null) {
			System.out.println("Invalid input: Null values detected.");
		}
		try {
			Date currentDate = new Date();
			UserLogs createUserlLogs = this.userLogsLocalService.createUserLogs(CounterLocalServiceUtil.increment());

			createUserlLogs.setUserName(userName);
			createUserlLogs.setUserActivity(userAction);
			createUserlLogs.setChannelId(channelId);
			createUserlLogs.setLogTime(currentDate);
			this.userLogsLocalService.updateUserLogs(createUserlLogs);
		} catch (Exception e) {
			System.out.println("Error adding user data: " + e.getMessage());
		}
	}

	public List<UserLogs> getbyChannelId(Long channelId) {
		if (channelId == null) {
			System.out.println("channelId is null.");
			return Collections.emptyList();
		}
		try {
			return userLogsPersistence.findByChannelId(channelId);
		} catch (Exception e) {
			System.out.println("Error retrieving data: " + e.getMessage());
			return Collections.emptyList();
		}
	}

}