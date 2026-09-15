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

import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.Banner;
import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.model.Themes;
import com.ejada.telemony.db.service.PersonaLocalServiceUtil;
import com.ejada.telemony.db.service.base.PersonaLocalServiceBaseImpl;
import com.ejada.telemony.db.service.util.DateCheckUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.ejada.telemony.db.mapper.PersonaMapper;



import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The implementation of the persona local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.PersonaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonaLocalServiceBaseImpl
 */
public class PersonaLocalServiceImpl extends PersonaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ejada.telemony.db.service.PersonaLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.telemony.db.service.PersonaLocalServiceUtil</code>.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(PersonaLocalServiceImpl.class);




	public void personaCreate(Long darkThemeId, Long lightThemeId, int startAge, int endAge, String name,
							  String nationality, String customerSegment, String status, String description, String gender, int priority,
							  Date dateTo, Date dateFrom, String sector, int minIncome, int maxIncome,Long channelId, boolean defaultPersona,  ServiceContext serviceContext, User user) throws Exception {

		try {
			Persona createPersona = createPersona(darkThemeId, lightThemeId, startAge, endAge, name, nationality, customerSegment,
					status, description, gender, priority, dateTo, dateFrom, sector, minIncome, maxIncome,channelId, defaultPersona,serviceContext,user);
			if(serviceContext == null || user == null)
			{
				personaLocalService.updatePersona(createPersona);
				return;
			}
			createPersona = personaLocalService.updatePersona(createPersona);

			// Set entityResourceId to the persona's own ID for a new entity
			createPersona.setEntityResourceId(createPersona.getPersonaId());
			createPersona.setVersion(getMaxVersion(createPersona.getEntityResourceId()) + 1);

			startWorkflow(createPersona,serviceContext,user,0L, Constants.CREATE);

		} catch (Exception e) {
			LOG.info("----------------Persona Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}

	}
	public void personaUpdate(Long id, Long channelId, Long darkThemeId, Long lightThemeId, int startAge, int endAge,
			String name, String nationality, String customerSegment, String status, String description, String gender,
			int priority, Date dateTo, Date dateFrom, String sector, int minIncome, int maxIncome,
			Boolean defaultPersona,ServiceContext serviceContext,User user) throws Exception {
		try {
			Persona originalPersona = personaLocalService.getPersona(id);

			// Block edits if there is any pending draft for the same entityResourceId
			if (hasPendingDraft(originalPersona.getEntityResourceId())) {
				throw new Exception("This Persona is currently locked because there is a pending change awaiting approval.");
			}

			boolean isPersonaUpdated = isPersonaUpdated(id, darkThemeId, lightThemeId, startAge, endAge,
					name, nationality, customerSegment, status, description, gender,
					priority, dateTo, dateFrom, sector, minIncome, maxIncome,
					defaultPersona);
			if (isPersonaUpdated) {
			Persona draftPersona = createPersona(darkThemeId, lightThemeId, startAge, endAge, name, nationality, customerSegment,
					status, description, gender, priority, dateTo, dateFrom, sector, minIncome, maxIncome, channelId, defaultPersona,serviceContext,user);

				// Set entityResourceId from original and increment version
				draftPersona.setEntityResourceId(originalPersona.getEntityResourceId());
				draftPersona.setVersion(getMaxVersion(originalPersona.getEntityResourceId()) + 1);

				startWorkflow(draftPersona, serviceContext, user, id, Constants.UPDATE);
			}
			else {
				LOG.info("----------------No Changes in Persona-----------------");
			}
		} catch (Exception e) {
			LOG.info("----------------Persona Update Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public void personaDelete(Long id,ServiceContext serviceContext,User user) throws Exception {
		try {
			Persona originalPersona = personaLocalService.getPersona(id);

			// Block edits if there is any pending draft for the same entityResourceId
			if (hasPendingDraft(originalPersona.getEntityResourceId())) {
				throw new Exception("This Persona is currently locked because there is a pending change awaiting approval.");
			}

			Persona draftPersona = this.personaLocalService.createPersona(CounterLocalServiceUtil.increment());
			copyProperties(originalPersona,draftPersona);

			// Set entityResourceId from original and increment version
			draftPersona.setEntityResourceId(originalPersona.getEntityResourceId());
			draftPersona.setVersion(getMaxVersion(originalPersona.getEntityResourceId()) + 1);

			startWorkflow(draftPersona,serviceContext,user,id,Constants.DELETE);
		} catch (Exception e) {
			LOG.info("----------------Persona Delete Failed-----------------");
			LOG.error(e);
			throw new Exception(e);
		}
	}

	public List<String> getLinkedBannerNames(Long personaId) {
		Persona persona = personaPersistence.fetchByPrimaryKey(personaId);
		if (persona == null) {
			return Collections.emptyList();
		}

		String personaIdStr = String.valueOf(personaId);

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Banner.class, getClassLoader());
		dq.add(RestrictionsFactoryUtil.eq("channelId", persona.getChannelId()));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));
		List<Banner> allApproved = bannerPersistence.findWithDynamicQuery(dq);
		Map<Long, Banner> latestByResource = new LinkedHashMap<>();
		for (Banner banner : allApproved) {
			latestByResource.putIfAbsent(banner.getEntityResourceId(), banner);
		}
		List<String> result = new ArrayList<>();
		for (Banner banner : latestByResource.values()) {
			String personaField = banner.getPersona();
			if (personaField != null && personaField.contains("\"" + personaIdStr + "\"")) {
				result.add(banner.getBannerName());
			}
		}
		return result;
	}




	public void addDefualtPersona(Long channelId) throws Exception {
		int startAge = 15;
		int endAge = 22;
		String name = "Default Persona";
		String nationality = "Egyptian";
		String customerSegment = "CATAL";
		String status = "Active";
		String description = "Defualt persona for this channel" + " " + channelId;
		String gender = "MALE";
		int priority = 15;
		Date dateTo = new Date(2033, 11, 8);
		Date dateFrom = new Date(2023, 11, 8);
		String sector = "Gov";
		int minIncome = 5000;
		int maxIncome = 9999;
		personaCreate(null, null, startAge, endAge, name, nationality, customerSegment, status, description, gender,
				priority, dateTo, dateFrom, sector, minIncome, maxIncome, channelId,true,null,null);

	}

	public List<Persona> getAllPersonas() {
		return personaPersistence.findAll();
	}

	public List<Themes> getDarkThemes(Long channelId) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Themes.class, getClassLoader());
		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("darkTheme", true));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));


		List<Themes> allApproved = themesPersistence.findWithDynamicQuery(dq);

		HashMap<Long, Themes> latestByResource = new LinkedHashMap<>();

		for (Themes theme : allApproved) {
			if (!latestByResource.containsKey(theme.getEntityResourceId())) {
				latestByResource.put(theme.getEntityResourceId(), theme);
			}
		}


		return new ArrayList<>(latestByResource.values());
	}

	public List<Themes> getLightThemes(Long channelId) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Themes.class, getClassLoader());
		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("darkTheme", false));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Themes> allApproved = themesPersistence.findWithDynamicQuery(dq);
		HashMap<Long, Themes> latestByResource = new LinkedHashMap<>();
		for (Themes theme : allApproved) {
			if (!latestByResource.containsKey(theme.getEntityResourceId())) {
				latestByResource.put(theme.getEntityResourceId(), theme);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}

	public List<Persona> getDarkThemeDelete(Long channelId, Long themeId) throws Exception {

		Set<Long> allThemeIds = getAllThemeIdsForSameEntity(themeId);

		DynamicQuery dq = dynamicQuery();
		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.in("status", new Integer[]{0, 2}));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Persona> all = personaPersistence.findWithDynamicQuery(dq);

		Map<Long, Persona> latestApprovedByResource = new LinkedHashMap<>();
		Map<Long, Persona> pendingByResource = new LinkedHashMap<>();

		for (Persona p : all) {
			if (p.getStatus() == 0) {
				latestApprovedByResource.putIfAbsent(p.getEntityResourceId(), p);
			} else if (p.getStatus() == 2) {
				pendingByResource.put(p.getEntityResourceId(), p);
			}
		}

		// Match at resource group level — not individual row level
		Set<Long> matchingResourceIds = new HashSet<>();
		latestApprovedByResource.forEach((resourceId, p) -> {
			if (p.getDarkThemeId() != null && allThemeIds.contains(p.getDarkThemeId())) matchingResourceIds.add(resourceId);
		});
		pendingByResource.forEach((resourceId, p) -> {
			if (p.getDarkThemeId() != null && allThemeIds.contains(p.getDarkThemeId())) matchingResourceIds.add(resourceId);
		});

		List<Persona> result = new ArrayList<>();

		for (Long resourceId : matchingResourceIds) {
			Persona approved = latestApprovedByResource.get(resourceId);
			if (approved != null) result.add(approved);

			Persona pending = pendingByResource.get(resourceId);
			if (pending != null) result.add(pending);
		}

		return result;
	}


	public List<Persona> getLightThemeDelete(Long channelId, Long themeId) throws Exception {

		// Resolve the entityResourceId for the given themeId and collect ALL themeIds
		// that belong to the same logical theme (across versions)
		Set<Long> allThemeIds = getAllThemeIdsForSameEntity(themeId);

		DynamicQuery dq = dynamicQuery();
		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.in("status", new Integer[]{0, 2}));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Persona> all = personaPersistence.findWithDynamicQuery(dq);

		Map<Long, Persona> latestApprovedByResource = new LinkedHashMap<>();
		Map<Long, Persona> pendingByResource = new LinkedHashMap<>();

		for (Persona p : all) {
			if (p.getStatus() == 0) {
				latestApprovedByResource.putIfAbsent(p.getEntityResourceId(), p);
			} else if (p.getStatus() == 2) {
				pendingByResource.put(p.getEntityResourceId(), p);
			}
		}

		// Collect entityResourceIds where ANY version references the themeId
		Set<Long> matchingResourceIds = new HashSet<>();
		latestApprovedByResource.forEach((resourceId, p) -> {
			if (p.getLightThemeId() != null && allThemeIds.contains(p.getLightThemeId())) matchingResourceIds.add(resourceId);
		});
		pendingByResource.forEach((resourceId, p) -> {
			if (p.getLightThemeId() != null && allThemeIds.contains(p.getLightThemeId())) matchingResourceIds.add(resourceId);
		});

		List<Persona> result = new ArrayList<>();

		// approved first, then its pending sibling — only for matching resources
		for (Long resourceId : matchingResourceIds) {
			Persona approved = latestApprovedByResource.get(resourceId);
			if (approved != null) result.add(approved);

			Persona pending = pendingByResource.get(resourceId);
			if (pending != null) result.add(pending);
		}

		return result;
	}


	public JSONArray getDefaultPersona(Long channelId) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Persona.class, getClassLoader());
		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("defaultPersona", true));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Persona> allApproved = personaPersistence.findWithDynamicQuery(dq);

		// Keep only the latest version per entityResourceId
		Persona persona = null;
		Map<Long, Persona> latestByResource = new LinkedHashMap<>();
		for (Persona p : allApproved) {
			latestByResource.putIfAbsent(p.getEntityResourceId(), p);
		}
		if (!latestByResource.isEmpty()) {
			persona = latestByResource.values().iterator().next();
		}

		JSONArray personassArray = null;
		try {
			personassArray = personaResponseBody(persona);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return personassArray;
	}

	public JSONArray getPersonaForApi(String nationality, int age, int income, String customerSegment, String gender,
			String sector, Long channelId) throws PortalException {

		Persona defaultPersona = personaPersistence.findBydefaultPersonaAndStatus(channelId, true,0).get(0);
		Persona per = this.getDesiredData(nationality, age, income, customerSegment, gender, sector, channelId)
				.size() != 0
						? this.getDesiredData(nationality, age, income, customerSegment, gender, sector, channelId)
								.get(0)
						: defaultPersona;
		JSONArray personassArray = personaResponseBody(per);

		return personassArray;
	}

	private JSONArray personaResponseBody(Persona per) throws PortalException, JSONException {
		JSONArray personassArray = JSONFactoryUtil.createJSONArray();

		JSONObject themesContentsArray = JSONFactoryUtil.createJSONObject();
		JSONObject lightthemeObject = JSONFactoryUtil.createJSONObject();
		JSONObject darkthemeObject = JSONFactoryUtil.createJSONObject();
		JSONObject systemMessages = JSONFactoryUtil.createJSONObject();
		JSONObject splashScreen = JSONFactoryUtil.createJSONObject();
		JSONObject darkSystemMessages = JSONFactoryUtil.createJSONObject();
		JSONObject darkSplashScreen = JSONFactoryUtil.createJSONObject();
		long lightThemeEntityResourceId = themesLocalService.getThemes(per.getLightThemeId()).getEntityResourceId();
		Themes lighTheme = themesLocalService.getLatestApprovedByEntityResourceId(lightThemeEntityResourceId);
		lightthemeObject.put("lightThemeId", per.getLightThemeId());
		lightthemeObject.put("neutralColors", JSONFactoryUtil.createJSONObject(lighTheme.getNeutralColors()));
		lightthemeObject.put("primaryColors", JSONFactoryUtil.createJSONObject(lighTheme.getPrimaryColors()));
		lightthemeObject.put("secondaryColors", JSONFactoryUtil.createJSONObject(lighTheme.getSecondaryColors()));
		systemMessages.put("success", JSONFactoryUtil.createJSONObject(lighTheme.getSuccessColors()));
		systemMessages.put("error", JSONFactoryUtil.createJSONObject(lighTheme.getErrorColors()));
		systemMessages.put("warning", JSONFactoryUtil.createJSONObject(lighTheme.getWarningColors()));
		lightthemeObject.put("systemMessages", systemMessages);
		lightthemeObject.put("support", JSONFactoryUtil.createJSONObject(lighTheme.getSupportColors()));
		lightthemeObject.put("gradientColors", JSONFactoryUtil.createJSONObject(lighTheme.getGradientColors()));
		splashScreen.put("splashBg", lighTheme.getSplashBg());
		splashScreen.put("splashAnimation", lighTheme.getSplashAnimation());
		splashScreen.put("headerBg", lighTheme.getHeaderBg());
		splashScreen.put("balanceBg", lighTheme.getBalanceBg());
		lightthemeObject.put("splashScreen", splashScreen);

		long darkThemeEntityResourceId = themesLocalService.getThemes(per.getDarkThemeId()).getEntityResourceId();
		Themes darkTheme = themesLocalService.getLatestApprovedByEntityResourceId(darkThemeEntityResourceId);
		darkthemeObject.put("darkThemeId", per.getDarkThemeId());
		darkthemeObject.put("primaryColors", JSONFactoryUtil.createJSONObject(darkTheme.getPrimaryColors()));
		darkthemeObject.put("secondaryColors", JSONFactoryUtil.createJSONObject(darkTheme.getSecondaryColors()));
		darkthemeObject.put("gradientColors", JSONFactoryUtil.createJSONObject(darkTheme.getGradientColors()));
		darkthemeObject.put("neutralColors", JSONFactoryUtil.createJSONObject(darkTheme.getNeutralColors()));
		darkthemeObject.put("support", JSONFactoryUtil.createJSONObject(darkTheme.getSupportColors()));
		darkSystemMessages.put("success", JSONFactoryUtil.createJSONObject(darkTheme.getSuccessColors()));
		darkSystemMessages.put("error", JSONFactoryUtil.createJSONObject(darkTheme.getErrorColors()));
		darkSystemMessages.put("warning", JSONFactoryUtil.createJSONObject(darkTheme.getWarningColors()));
		darkthemeObject.put("systemMessages", darkSystemMessages);
		darkSplashScreen.put("splashBg", darkTheme.getSplashBg());
		darkSplashScreen.put("splashAnimation", darkTheme.getSplashAnimation());
		darkSplashScreen.put("headerBg", darkTheme.getHeaderBg());
		darkSplashScreen.put("balanceBg", darkTheme.getBalanceBg());
		darkthemeObject.put("splashScreen", darkSplashScreen);
		themesContentsArray.put("lightTheme", lightthemeObject);
		themesContentsArray.put("darkTheme", darkthemeObject);
		themesContentsArray.put("personaId", per.getPersonaId());

		personassArray.put(themesContentsArray);
		return personassArray;
	}

	public List<Persona> getDesiredData(String nationality, int age, int income, String customerSegment, String gender,
			String sector, long channelId) {

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Persona.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));

		if (!nationality.isEmpty()) {
			query.add(RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.like("nationality", "%" + nationality + "%"),
					RestrictionsFactoryUtil.like("nationality", "%" + "All" + "%")
			));
		}



		if (age > 0) {

			query.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.ge("endAge", age),
					RestrictionsFactoryUtil.le("startAge", age)));
		}


		if (income > 0) {

			query.add(RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.ge("maxIncome", income),
							RestrictionsFactoryUtil.le("minIncome", income)),
					RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("maxIncome", 0),
							RestrictionsFactoryUtil.eq("minIncome", 0))));
		}

		if (!customerSegment.isEmpty()) {
			query.add(RestrictionsFactoryUtil.like("customerSegment", "%\"" + customerSegment + "\"%"));
		}

		/*
		 * if (!gender.isEmpty()) { query.add(RestrictionsFactoryUtil.eq("gender",
		 * gender)); }
		 */

		if (!gender.isEmpty()) {
			query.add(RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.eq("gender", gender),
					RestrictionsFactoryUtil.eq("gender", "BOTH")));
		}


		if (!sector.isEmpty()) {
			// Assuming that "sector" is a property in your Persona entity.
			query.add(RestrictionsFactoryUtil.like("sector", "%\"" + sector + "\"%"));
		}

		query.add(RestrictionsFactoryUtil.like("status", "Active"));

		query.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.and(
				RestrictionsFactoryUtil.gt("dateTo", new Date()), RestrictionsFactoryUtil.le("dateFrom", new Date())

		), RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.isNull("dateTo"),
				RestrictionsFactoryUtil.isNull("dateFrom"))));

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.property("personaId"));

		query.setProjection(projectionList);

		List<Long> results = personaLocalService.dynamicQuery(query);

		List<Persona> personas = new ArrayList<Persona>();

		int highestPriority = Integer.MIN_VALUE;

		for (long result : results) {
			Persona per = null;
			try {
				per = personaLocalService.getPersona(result);
				int priority = per.getPriority();

				if (priority > highestPriority) {
					// Found a persona with a higher priority, so clear the list and add this
					// persona
					personas.clear();
					personas.add(per);
					highestPriority = priority;
				} else if (priority == highestPriority) {
					// Found another persona with the same highest priority, so add it to the list
					personas.add(per);
				}
			} catch (PortalException e) {
				e.printStackTrace();
			}

		}

		return personas;
	}

	public List<Persona> getbyChannelId(Long channelId) {
		return personaPersistence.findByChannelIdAndStatus(channelId,0);
	}

	public JSONArray getPersonaForApiLatestApproved(String nationality, int age, int income, String customerSegment, String gender,
			String sector, Long channelId) throws PortalException {

		Persona defaultPersona = getDefaultPersonas(channelId);
		List<Persona> matched = getDesiredDataLatestApproved(nationality, age, income, customerSegment, gender, sector, channelId);
		Persona per = !matched.isEmpty() ? matched.get(0) : defaultPersona;
		return personaResponseBody(per);
	}

	public List<Persona> getDesiredDataLatestApproved(String nationality, int age, int income, String customerSegment, String gender,
			String sector, long channelId) {

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Persona.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));

		if (!nationality.isEmpty()) {
			query.add(RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.like("nationality", "%" + nationality + "%"),
					RestrictionsFactoryUtil.like("nationality", "%" + "All" + "%")
			));
		}

		if (age > 0) {
			query.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.ge("endAge", age),
					RestrictionsFactoryUtil.le("startAge", age)));
		}

		if (income > 0) {
			query.add(RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.ge("maxIncome", income),
							RestrictionsFactoryUtil.le("minIncome", income)),
					RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("maxIncome", 0),
							RestrictionsFactoryUtil.eq("minIncome", 0))));
		}

		if (!customerSegment.isEmpty()) {
			query.add(RestrictionsFactoryUtil.like("customerSegment", "%\"" + customerSegment + "\"%"));
		}

		if (!gender.isEmpty()) {
			query.add(RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.eq("gender", gender),
					RestrictionsFactoryUtil.eq("gender", "BOTH")));
		}

		if (!sector.isEmpty()) {
			query.add(RestrictionsFactoryUtil.like("sector", "%\"" + sector + "\"%"));
		}

		query.add(RestrictionsFactoryUtil.like("personaStatus", "Active"));

		query.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.and(
				RestrictionsFactoryUtil.gt("dateTo", new Date()), RestrictionsFactoryUtil.le("dateFrom", new Date())
		), RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.isNull("dateTo"),
				RestrictionsFactoryUtil.isNull("dateFrom"))));

		query.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		query.addOrder(OrderFactoryUtil.desc("version"));

		List<Persona> allMatched = personaPersistence.findWithDynamicQuery(query);

		// Keep only the latest version per entityResourceId
		Map<Long, Persona> latestByResource = new LinkedHashMap<>();
		for (Persona p : allMatched) {
			latestByResource.putIfAbsent(p.getEntityResourceId(), p);
		}

		List<Persona> personas = new ArrayList<>(latestByResource.values());

		// Return the one with highest priority
		if (personas.isEmpty()) {
			return personas;
		}

		int highestPriority = Integer.MIN_VALUE;
		List<Persona> result = new ArrayList<>();

		for (Persona per : personas) {
			int priority = per.getPriority();
			if (priority > highestPriority) {
				result.clear();
				result.add(per);
				highestPriority = priority;
			} else if (priority == highestPriority) {
				result.add(per);
			}
		}

		return result;
	}

	public Persona getDefaultPersonas(Long channelId) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Persona.class, getClassLoader());
		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("defaultPersona", true));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));

		List<Persona> allApproved = personaPersistence.findWithDynamicQuery(dq);

		Map<Long, Persona> latestByResource = new LinkedHashMap<>();
		for (Persona p : allApproved) {
			latestByResource.putIfAbsent(p.getEntityResourceId(), p);
		}

		if (!latestByResource.isEmpty()) {
			return latestByResource.values().iterator().next();
		}
		return null;
	}

	public List<Persona> getNonDefaultPersonas(Long channelId) {
		return personaPersistence.findBydefaultPersonaAndStatus(channelId, false,0);
	}
	public Persona updateStatus(long userId, long personaId, int status,
								ServiceContext serviceContext) throws PortalException, SystemException
	{
		Persona persona = personaPersistence.findByPrimaryKey(personaId);

		// Set status metadata
		persona.setStatusByUserId(userId);
		if (serviceContext != null && userId > 0) {
			persona.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
		}
		persona.setStatusDate(new Date());
		persona.setModifiedDate(new Date());
		persona = personaPersistence.update(persona);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			// Read workflow action from the entity instead of serviceContext
			String workflowAction = persona.getWorkflowAction();

			// DELETE action
			if (Constants.DELETE.equalsIgnoreCase(workflowAction)) {
				// For approved deletion: remove ALL versions for this entityResourceId
				// (draft + any historical/approved versions)
				long entityResourceId = persona.getEntityResourceId();
				deleteAllByEntityResourceId(entityResourceId);
				LOG.info("All Persona versions deleted for entityResourceId: " + entityResourceId);
				return persona;
			}

			// UPDATE action
			if (Constants.UPDATE.equalsIgnoreCase(workflowAction)) {
				persona.setStatus(status);
				personaPersistence.update(persona);
				LOG.info("Persona updated and approved: " + persona.getName());
				return persona;
			}

			// ADD action
			if (Constants.ADD.equalsIgnoreCase(workflowAction)) {
				persona.setStatus(status);
				personaPersistence.update(persona);
				LOG.info("Persona created and approved: " + persona.getName());
				return persona;
			}

			// Fallback: keep same row as approved
			return persona;
		}

		if (status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_EXPIRED) {
			persona.setStatus(status);
			personaPersistence.update(persona);
			LOG.info("Persona rejected/expired: " + persona.getName());
		}

		return persona;
	}
	private Persona createPersona(Long darkThemeId, Long lightThemeId, int startAge, int endAge, String name,
								  String nationality, String customerSegment, String status, String description, String gender, int priority,
								  Date dateTo, Date dateFrom, String sector, int minIncome, int maxIncome, Long channelId, boolean defaultPersona ,ServiceContext serviceContext, User user) throws Exception {
		Persona createPersona = this.personaLocalService.createPersona(CounterLocalServiceUtil.increment());
		createPersona.setChannelId(channelId);
		createPersona.setDarkThemeId(darkThemeId);
		createPersona.setLightThemeId(lightThemeId);
		createPersona.setStartAge(startAge);
		createPersona.setEndAge(endAge);
		createPersona.setName(name);
		createPersona.setNationality(nationality);
		createPersona.setCustomerSegment(customerSegment);
		createPersona.setPersonaStatus(status);
		createPersona.setGender(gender);
		createPersona.setDescription(description);
		createPersona.setPriority(priority);
		createPersona.setDateTo(dateTo);
		createPersona.setDateFrom(dateFrom);
		createPersona.setSector(sector);
		createPersona.setMinIncome(minIncome);
		createPersona.setMaxIncome(maxIncome);
		createPersona.setDefaultPersona(defaultPersona);
		return createPersona;

	}
	private void startWorkflow(Persona persona, ServiceContext serviceContext, User user, Long id,String type) throws PortalException {
		persona.setGroupId(serviceContext.getScopeGroupId());
		persona.setCompanyId(serviceContext.getCompanyId());
		persona.setUserId(serviceContext.getUserId());
		persona.setUserName(user.getFullName());

		// Only set createDate if not already set
		if (persona.getCreateDate() == null) {
			persona.setCreateDate(new Date());
		}
		persona.setModifiedDate(new Date());

		// Only set UUID if not already set
		if (persona.getUuid_() == null || persona.getUuid_().isEmpty()) {
			persona.setUuid_(PortalUUIDUtil.generate());
		}

		persona.setOriginalEntityId(id);
		persona.setStatus(WorkflowConstants.STATUS_DRAFT);
		persona.setStatusDate(new Date());

		// Persist workflow action on the entity (DB column: workflowAction)
		// Allowed values are ADD / UPDATE / DELETE.
		if (Constants.ADD.equals(type) || Constants.CREATE.equals(type)) {
			persona.setWorkflowAction(Constants.ADD);
		} else if (Constants.UPDATE.equals(type)) {
			persona.setWorkflowAction(Constants.UPDATE);
		} else if (Constants.DELETE.equals(type)) {
			persona.setWorkflowAction(Constants.DELETE);
		} else {
			// fallback to ADD to keep behavior consistent for unexpected values
			persona.setWorkflowAction(Constants.ADD);
		}

		persona = PersonaLocalServiceUtil.updatePersona(persona);

		serviceContext.setAttribute(Constants.ENTITY_TYPE, Constants.PERSONA);
		serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
		serviceContext.setAttribute(Constants.REQUEST_ID, persona.getPersonaId());
		// NOTE: no longer storing operation type in service context

		if (serviceContext.getScopeGroupId() <= 0) {
			serviceContext.setScopeGroupId(
					GroupLocalServiceUtil.getCompanyGroup(
							serviceContext.getCompanyId()
					).getGroupId()
			);
		}
		AssetEntryLocalServiceUtil.updateEntry(
				serviceContext.getUserId(),
				serviceContext.getScopeGroupId(),
				Persona.class.getName(),
				persona.getPersonaId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames()
		);

		serviceContext.setAssetCategoryIds(null);
		serviceContext.setAssetTagNames(null);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(),
				serviceContext.getUserId(),
				Persona.class.getName(),
				persona.getPrimaryKey(),
				persona,
				serviceContext
		);
	}

	private boolean isPersonaUpdated(Long existingPersonaId, Long darkThemeId, Long lightThemeId, int startAge, int endAge,
									 String name, String nationality, String customerSegment, String status, String description, String gender,
									 int priority, Date dateTo, Date dateFrom, String sector, int minIncome, int maxIncome,
									 Boolean defaultPersona) throws PortalException {
		Persona existingPersona = personaLocalService.getPersona(existingPersonaId);

		if (!Objects.equals(existingPersona.getName(), name)) return true;
		if (!Objects.equals(existingPersona.getNationality(), nationality)) return true;
		if (!Objects.equals(existingPersona.getCustomerSegment(), customerSegment)) return true;
		if (!Objects.equals(existingPersona.getPersonaStatus(), status)) return true;
		if (!Objects.equals(existingPersona.getDescription(), description)) return true;
		if (!Objects.equals(existingPersona.getGender(), gender)) return true;
		if (existingPersona.getStartAge() != startAge) return true;
		if (existingPersona.getEndAge() != endAge) return true;
		if (!DateCheckUtil.isSameLocalDate(existingPersona.getDateFrom(), dateFrom)) return true;
		if (!DateCheckUtil.isSameLocalDate(existingPersona.getDateTo(), dateTo)) return true;
		if (existingPersona.getMinIncome() != minIncome) return true;
		if (existingPersona.getMaxIncome() != maxIncome) return true;
		if (!Objects.equals(existingPersona.getSector(), sector)) return true;
		if (!Objects.equals(existingPersona.getDarkThemeId(), darkThemeId)) return true;
		if (!Objects.equals(existingPersona.getLightThemeId(), lightThemeId)) return true;
		if (!Objects.equals(existingPersona.getDefaultPersona(), defaultPersona)) return true;
		if (!Objects.equals(existingPersona.getPriority(), priority)) return true;


		return false;
	}


	private void copyProperties(Persona source,Persona target)
	{
		PersonaMapper.copyDraftToOriginal(source,target);
	}

	private int getMaxVersion(long entityResourceId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Persona.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		query.setProjection(ProjectionFactoryUtil.max("version"));
		List<Integer> results = personaLocalService.dynamicQuery(query);
		if (results != null && !results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return 0;
	}

	public List<Persona> getLatestApprovedByChannelId(long channelId) {
		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));
		List<Persona> allApproved = personaPersistence.findWithDynamicQuery(dq);

		// Keep only latest version per resourceId
		Map<Long, Persona> latestByResource = new LinkedHashMap<>();

		for (Persona persona : allApproved) {
			if (!latestByResource.containsKey(persona.getEntityResourceId())) {
				latestByResource.put(persona.getEntityResourceId(), persona);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}

	public List<Persona> getApprovedByEntityResourceId(long entityResourceId)
	{
		return personaPersistence.findByentityResourceIdAndStatus(entityResourceId, WorkflowConstants.STATUS_APPROVED);
	}

	public Map<Persona, Boolean> getLatestApprovedByChannelIdWithPending(long channelId) {
		List<Persona> latestApproved = getLatestApprovedByChannelId(channelId);

		Map<Persona, Boolean> result = new LinkedHashMap<>();

		for (Persona persona : latestApproved) {
			boolean pending = hasPendingDraft(persona.getEntityResourceId());
			result.put(persona, pending);
		}

		return result;
	}

	private boolean hasPendingDraft(long entityResourceId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Persona.class, getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
			query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));

			List<Persona> versions = personaLocalService.dynamicQuery(query);

			return !versions.isEmpty();
		} catch (Exception e) {
			LOG.error("Unable to evaluate pending drafts for entityResourceId " + entityResourceId, e);
			// Fail closed: better to block edits than allow concurrent conflicting drafts.
			return true;
		}
	}

	private void deleteAllByEntityResourceId(long entityResourceId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Persona.class, getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));

			List<Persona> personas = personaLocalService.dynamicQuery(query);

			for (Persona p : personas) {
				personaPersistence.remove(p);
			}
		} catch (Exception e) {
			LOG.error("Unable to delete personas for entityResourceId " + entityResourceId, e);
			throw new RuntimeException("Failed to delete personas for entityResourceId " + entityResourceId, e);
		}
	}

	private Set<Long> getAllThemeIdsForSameEntity(Long themeId) {
		try {
			Themes theme = themesLocalService.getThemes(themeId);
			long entityResourceId = theme.getEntityResourceId();

			DynamicQuery themeQuery = DynamicQueryFactoryUtil.forClass(Themes.class, getClassLoader());
			themeQuery.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
			themeQuery.setProjection(ProjectionFactoryUtil.property("themeId"));

			List<Long> ids = themesLocalService.dynamicQuery(themeQuery);
			return new HashSet<>(ids);
		} catch (Exception e) {
			LOG.error("Unable to resolve all themeIds for themeId " + themeId, e);
			Set<Long> fallback = new HashSet<>();
			if (themeId != null) {
				fallback.add(themeId);
			}
			return fallback;
		}
	}
}