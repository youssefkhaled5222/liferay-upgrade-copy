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

import com.ejada.telemoney.db.dto.importDtos.ThemeDTO;
import com.ejada.telemony.db.constants.ComponentType;
import com.ejada.telemony.db.constants.Constants;
import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.mapper.ThemesMapper;
import com.ejada.telemony.db.model.Themes;
import com.ejada.telemony.db.service.GlobalVersionLocalServiceUtil;
import com.ejada.telemony.db.service.ThemesLocalServiceUtil;
import com.ejada.telemony.db.service.base.ThemesLocalServiceBaseImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
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

import java.util.*;
import java.util.stream.Collectors;


/**
 * The implementation of the themes local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.ThemesLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThemesLocalServiceBaseImpl
 */
public class ThemesLocalServiceImpl extends ThemesLocalServiceBaseImpl {

	private static final Log LOG = LogFactoryUtil.getLog(ThemesLocalServiceImpl.class);

	public void themeCreate(long channelId, String enName, String arName, boolean darkTheme, String neutralColors,
			String primaryColors, String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors, String splashBg, String splashAnimation,
			String headerBg, String balanceBg, boolean defaultTheme, ServiceContext serviceContext, User user) throws Exception {

		try {
			Themes createTheme =prepareTheme(channelId,  enName, arName,  darkTheme, neutralColors,
					 primaryColors,  secondaryColors, successColors,  errorColors,
					 warningColors,  supportColors,  gradientColors,  splashBg,  splashAnimation,
					headerBg, balanceBg,  defaultTheme,  serviceContext,  user);

			startWorkflow(createTheme, serviceContext, user, 0L, Constants.CREATE);

		} catch (Exception e) {
			LOG.error("Theme Create Failed", e);
			throw new Exception(e);
		}
	}

	private void themeCreateWithoutWorkflow(long channelId, String enName, String arName, boolean darkTheme, String neutralColors,
							String primaryColors, String secondaryColors, String successColors, String errorColors,
							String warningColors, String supportColors, String gradientColors, String splashBg, String splashAnimation,
							String headerBg, String balanceBg, boolean defaultTheme, User user,ImportRequest importRequest) throws Exception {

		try {

			Themes createTheme = prepareTheme(channelId, enName, arName, darkTheme, neutralColors,
					primaryColors, secondaryColors, successColors, errorColors,
					warningColors, supportColors, gradientColors, splashBg, splashAnimation,
					headerBg, balanceBg, defaultTheme, null, user);

			if (createTheme !=null) {
				enrichWorkflow(createTheme, null, user, 0L, Constants.IMPORT + "_" + Constants.ADD,importRequest);
				updateStatus(user.getUserId(), createTheme.getThemeId(), WorkflowConstants.STATUS_APPROVED, null);
			}


		} catch (Exception e) {
			LOG.error("Theme Create Failed", e);
			throw new Exception(e);
		}
	}


	public void themeUpdate(Long id, long channelId, String enName, String arName, boolean darkTheme, String neutralColors,
							String primaryColors, String secondaryColors, String successColors, String errorColors,
							String warningColors, String supportColors, String gradientColors, String splashBg, String splashAnimation,
							String headerBg, String balanceBg, boolean defaultTheme, ServiceContext serviceContext, User user) throws Exception {

		try {

			boolean isThemeUpdated = isThemeUpdated(
					id, channelId, enName, arName, darkTheme,
					neutralColors, primaryColors, secondaryColors,
					successColors, errorColors, warningColors,
					supportColors, gradientColors,
					splashBg, splashAnimation, headerBg, balanceBg,
					defaultTheme
			);

			if (!isThemeUpdated) {
				LOG.info("No Changes in Theme");
				return;
			}

			Themes draftTheme = prepareThemeBeforeUpdate(
					id, channelId, enName, arName, darkTheme,
					neutralColors, primaryColors, secondaryColors,
					successColors, errorColors, warningColors,
					supportColors, gradientColors,
					splashBg, splashAnimation, headerBg, balanceBg,
					defaultTheme
			);
			startWorkflow(draftTheme, serviceContext, user, id, Constants.UPDATE);

		} catch (Exception e) {
			LOG.error("Theme Update Failed", e);
			throw new Exception(e);
		}
	}


	public void themeUpdateWithoutWorkflow(Long id, long channelId, String enName, String arName, boolean darkTheme, String neutralColors,
										   String primaryColors, String secondaryColors, String successColors, String errorColors,
										   String warningColors, String supportColors, String gradientColors, String splashBg, String splashAnimation,
										   String headerBg, String balanceBg, boolean defaultTheme, ServiceContext serviceContext, User user, ImportRequest importRequest) throws Exception {


		Themes draftTheme = prepareThemeBeforeUpdate(
				id, channelId, enName, arName, darkTheme,
				neutralColors, primaryColors, secondaryColors,
				successColors, errorColors, warningColors,
				supportColors, gradientColors,
				splashBg, splashAnimation, headerBg, balanceBg,
				defaultTheme
		);
		if (draftTheme == null) {
			LOG.info("No Changes in Theme");
			return;
		}
		enrichWorkflow(draftTheme, serviceContext, user, id, Constants.IMPORT + "_" + Constants.UPDATE, importRequest);
		updateStatus(user.getUserId(), draftTheme.getThemeId(), WorkflowConstants.STATUS_APPROVED, serviceContext);
	}
	private Themes prepareThemeBeforeUpdate(
			Long id,
			long channelId,
			String enName,
			String arName,
			boolean darkTheme,
			String neutralColors,
			String primaryColors,
			String secondaryColors,
			String successColors,
			String errorColors,
			String warningColors,
			String supportColors,
			String gradientColors,
			String splashBg,
			String splashAnimation,
			String headerBg,
			String balanceBg,
			boolean defaultTheme
	) throws Exception {

		Themes originalTheme = themesLocalService.getThemes(id);

		if (hasPendingDraft(originalTheme.getEntityResourceId())) {
			throw new Exception("This Theme is currently locked because there is a pending change awaiting approval.");
		}



		Themes draftTheme = createThemeEntity(
				channelId, enName, arName, darkTheme,
				neutralColors, primaryColors, secondaryColors,
				successColors, errorColors, warningColors,
				supportColors, gradientColors,
				splashBg, splashAnimation, headerBg, balanceBg,
				defaultTheme
		);

		draftTheme.setEntityResourceId(originalTheme.getEntityResourceId());
		draftTheme.setVersion(getMaxVersion(originalTheme.getEntityResourceId()) + 1);

		return draftTheme;
	}

	public void themeDelete(Long id, ServiceContext serviceContext, User user) throws Exception {
		try {
			Themes originalTheme = themesLocalService.getThemes(id);

			// Block edits if there is any pending draft for the same entityResourceId
			if (hasPendingDraft(originalTheme.getEntityResourceId())) {
				throw new Exception("This Theme is currently locked because there is a pending change awaiting approval.");
			}

			// Check if any latest-approved persona references this theme
			if (isThemeUsedByPersona(originalTheme.getEntityResourceId(), originalTheme.getChannelId())) {
				throw new Exception("Theme is Used");
			}

			Themes draftTheme = themesLocalService.createThemes(CounterLocalServiceUtil.increment());
			ThemesMapper.copyDraftToOriginal(originalTheme, draftTheme);

			// Set entityResourceId from original and increment version
			draftTheme.setEntityResourceId(originalTheme.getEntityResourceId());
			draftTheme.setVersion(getMaxVersion(originalTheme.getEntityResourceId()) + 1);

			startWorkflow(draftTheme, serviceContext, user, id, Constants.DELETE);
		} catch (Exception e) {
			LOG.error("Theme Delete Failed", e);
			throw new Exception(e);
		}
	}

	public Themes updateStatus(long userId, long themeId, int status, ServiceContext serviceContext) throws PortalException, SystemException {
		Themes theme = themesPersistence.findByPrimaryKey(themeId);

		// Set status metadata
		theme.setStatusByUserId(userId);
		if (userId > 0) {
			theme.setStatusByUserName(UserLocalServiceUtil.getUser(userId).getFullName());
		}
		theme.setStatusDate(new Date());
		theme.setModifiedDate(new Date());
		theme = themesPersistence.update(theme);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			// Read workflow action from the entity
			String workflowAction = theme.getWorkflowAction();

			// DELETE action
			if (Constants.DELETE.equalsIgnoreCase(workflowAction)) {
				long entityResourceId = theme.getEntityResourceId();
				deleteAllByEntityResourceId(entityResourceId);
				incrementGlobalVersion(theme);
				LOG.info("All Theme versions deleted for entityResourceId: " + entityResourceId);
				return theme;
			}

			// UPDATE action
			if (workflowAction.toLowerCase().contains(Constants.UPDATE.toLowerCase())) {
				theme.setStatus(status);
				themesPersistence.update(theme);
				incrementGlobalVersion(theme);
				LOG.info("Theme updated and approved: " + theme.getThemeEnName());
				return theme;
			}

			// ADD action
			if (workflowAction.toLowerCase().contains(Constants.ADD.toLowerCase())) {
				theme.setStatus(status);
				themesPersistence.update(theme);
				incrementGlobalVersion(theme);
				LOG.info("Theme created and approved: " + theme.getThemeEnName());
				return theme;
			}

			return theme;
		}

		if (status == WorkflowConstants.STATUS_DENIED || status == WorkflowConstants.STATUS_EXPIRED) {
			theme.setStatus(status);
			themesPersistence.update(theme);
			LOG.info("Theme rejected/expired: " + theme.getThemeEnName());
		}

		return theme;
	}

	// Keep old addTheme for backwards compatibility (non-workflow)
	public void addTheme(long channelId, String enName, String arName, boolean darkTheme, String neutralColors,
			String primaryColors, String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors, String splashBg, String splashAnimation,
			String headerBg, String balanceBg, boolean deafultTheme, long themeId) {
		long newThemeId = themeId != 0 ? themeId : CounterLocalServiceUtil.increment();
		Themes theme;
		try {
			theme = ThemesLocalServiceUtil.getThemes(newThemeId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			theme = ThemesLocalServiceUtil.createThemes(newThemeId);
		}
		theme.setChannelId(channelId);
		theme.setThemeEnName(enName);
		theme.setThemeArName(arName);
		theme.setDefaultTheme(deafultTheme);
		theme.setDarkTheme(darkTheme);

		theme.setNeutralColors(neutralColors);
		theme.setPrimaryColors(primaryColors);
		theme.setSecondaryColors(secondaryColors);
		theme.setSuccessColors(successColors);
		theme.setErrorColors(errorColors);
		theme.setWarningColors(warningColors);
		theme.setSupportColors(supportColors);
		theme.setGradientColors(gradientColors);
		if (splashBg != null)
			theme.setSplashBg(splashBg);
		if (splashAnimation != null)
			theme.setSplashAnimation(splashAnimation);
		if (headerBg != null)
			theme.setHeaderBg(headerBg);
		if (balanceBg != null)
			theme.setBalanceBg(balanceBg);
		ThemesLocalServiceUtil.updateThemes(theme);
		incrementGlobalVersion(theme);
	}

	public void deleteTheme(Long themeId, Long channelId) throws Exception {
		List<Persona> dark;
		List<Persona> light;
		try {
			dark = personaLocalService.getDarkThemeDelete(channelId, themeId);
			light = personaLocalService.getLightThemeDelete(channelId, themeId);
			if (dark.isEmpty() && light.isEmpty()) {
				ThemesLocalServiceUtil.deleteThemes(themeId);
			} else {
				throw new Exception("Theme is Used");
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Persona> checkTheme(Long channelId, Long themeId) {

		List<Persona> dark;
		List<Persona> light;
		try {
			dark = personaLocalService.getDarkThemeDelete(channelId, themeId);
			light = personaLocalService.getLightThemeDelete(channelId, themeId);
			List<Persona> result = new ArrayList<Persona>();
			result.addAll(light);
			result.addAll(dark);


            LOG.info("personas that is attached to this theme: " + result.stream().map(Persona::getName).collect(java.util.stream.Collectors.joining(", ")));

			if (dark.isEmpty() && light.isEmpty()) {
				return null;
			} else {
				return result;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Themes> getAllNonDefaultThemes(Long channelId) {
		return this.themesPersistence.findByDefaultTheme(channelId, false);
	}

	public List<Themes> getAllDefaultThemes(Long channelId) {
		return this.themesPersistence.findByDefaultTheme(channelId, true);
	}

	public Themes getDefaultTheme(boolean mode, Long channelId) {
		List<Themes> result = themesPersistence.findByDefaultModeTheme(true, mode, channelId);
		if (result.size() > 0) {
			return result.get(0);
		} else {
			LOG.info("+++++++++++++++++++++++++++++ No Default Theme Found ++++++++++++++++++++++++++");
			return null;
		}
	}

	public List<Themes> getbyChannelId(Long channelId) {
		return themesPersistence.findByChannelId(channelId);
	}

	public void addDefaultLightTheme(Long channelId) {
		JSONObject neutral = JSONFactoryUtil.createJSONObject();
		neutral.put("black", "#1A1F2D");
		neutral.put("gray1", "#3B3F50");
		neutral.put("gray2", "#6E7184");
		neutral.put("gray3", "#B6B9CE");
		neutral.put("gray4", "#E8EBFF");
		neutral.put("gray5", "#F4F6FF");
		neutral.put("gray6", "#6e7184");
		neutral.put("white", "#FFFFFF");
		neutral.put("disabledGray", "#F7F8FF");
		neutral.put("cards", "#282A33");
		neutral.put("Background", "#F8F8F8");


		JSONObject primary =JSONFactoryUtil.createJSONObject();
		primary.put("bg", "#FFE9EF");
		primary.put("light", "#F1919B");
		primary.put("dark", "#CC0029");
		primary.put("default", "#F43653");
		primary.put("disabled", "#E3B9BF");
		primary.put("icon", "#F43653");

		JSONObject secondary = JSONFactoryUtil.createJSONObject();
		secondary.put("bg", "#E5E8F2");
		secondary.put("light", "#4C63A3");
		secondary.put("dark", "#00153D");
		secondary.put("default", "#00205F");
		secondary.put("disabled", "#959DAF");
		secondary.put("extra", "#4B63A3");

		JSONObject success = JSONFactoryUtil.createJSONObject();
		success.put("bg", "#F1F8E8");
		success.put("light", "#ACD77C");
		success.put("dark", "#2A6B12");
		success.put("default", "#88C540");
		success.put("success", "#78B538");

		JSONObject error = JSONFactoryUtil.createJSONObject();
		error.put("bg", "#FFECEF");
		error.put("light", "#FFCFD4");
		error.put("dark", "#E22025");
		error.put("default", "#FF7474");

		JSONObject warning = JSONFactoryUtil.createJSONObject();
		warning.put("bg", "#FFFDE6");
		warning.put("light", "#FFF06F");
		warning.put("dark", "#F87902");
		warning.put("default", "#FFC01E");

		JSONObject support = JSONFactoryUtil.createJSONObject();
		support.put("defaultYellow", "#FCDB7B");
		support.put("bgYellow", "#FFFBF2");
		support.put("lightBlue", "#618BEE");
		support.put("cardDefault", "#009DEA");
		support.put("cardDarkBlue", "#003E70");
		support.put("cardExtra", "#4C63A3");
		support.put("extra", "#4B63A3");
		support.put("logo", "#FFFFFF");

		JSONObject primaryGd = JSONFactoryUtil.createJSONObject();
		JSONObject gradient =  JSONFactoryUtil.createJSONObject();

		primaryGd.put("primary1", "#001F5F");
		primaryGd.put("primary2", "#001F5F");
		primaryGd.put("dashboardColorOne","0B378E");
		primaryGd.put("dashboardColorTwo","00205F");
		primaryGd.put("dashboardColorThree","F43653");



		gradient.put("primary", primaryGd);
		addTheme(channelId, "Light Theme", "Light Theme", false, neutral.toString(), primary.toString(),
				secondary.toString(), success.toString(), error.toString(), warning.toString(), support.toString(),
				gradient.toString(), "", "", "", "", true, 0);


	}

	public void addDefaultDarkTheme(Long channelId) {
		JSONObject neutral = JSONFactoryUtil.createJSONObject();
		neutral.put("black", "#191D29");
		neutral.put("gray1", "#363842");
		neutral.put("gray2", "#525462");
		neutral.put("gray3", "#888A9E");
		neutral.put("gray4", "#98979F");
		neutral.put("gray5", "#D2D1D3");
		neutral.put("gray6", "#6e7184");
		neutral.put("white", "#F2F2F2");
		neutral.put("disabledGray", "#F4F6FF");
		neutral.put("cards", "#282A33");
		neutral.put("Background", "#F8F8F8");

		JSONObject primary = JSONFactoryUtil.createJSONObject();
		primary.put("bg", "#5C4349");
		primary.put("light", "#FFC8D3");
		primary.put("dark", "#E86474");
		primary.put("default", "#F1919B");
		primary.put("disabled", "#E3B9BF");
		primary.put("icon", "#E86474");

		JSONObject secondary = JSONFactoryUtil.createJSONObject();
		secondary.put("bg", "#3E4968");
		secondary.put("light", "#BEC6DE");
		secondary.put("dark", "#294A95");
		secondary.put("default", "#A1B3E9");
		secondary.put("disabled", "#959DAF");
		secondary.put("extra", "#849bdd");

		JSONObject success = JSONFactoryUtil.createJSONObject();
		success.put("bg", "#455542");
		success.put("light", "#DBEEC6");
		success.put("dark", "#ACD77C");
		success.put("default", "#ACD77C");
		success.put("success", "#78B538");

		JSONObject error = JSONFactoryUtil.createJSONObject();
		error.put("bg", "#5E373F");
		error.put("light", "#FFCFD4");
		error.put("dark", "#FF8686");
		error.put("default", "#FF8686");

		JSONObject warning = JSONFactoryUtil.createJSONObject();
		warning.put("bg", "#5E5C3E");
		warning.put("light", "#FFF9C2");
		warning.put("dark", "#FFA525");
		warning.put("default", "#FFF06F");

		JSONObject support = JSONFactoryUtil.createJSONObject();
		support.put("defaultYellow", "#FCDB7B");
		support.put("bgYellow", "#5D5642");
		support.put("lightBlue", "#618BEE");
		support.put("cardDefault", "#009DEA");
		support.put("cardDarkBlue", "#003E70");
		support.put("cardExtra", "#618BEE");
		support.put("extra", "#4B63A3");
		support.put("logo", "#FFFFFF");
		
		JSONObject primaryGd = JSONFactoryUtil.createJSONObject();
		JSONObject gradient = JSONFactoryUtil.createJSONObject();

		primaryGd.put("primary1", "#001F5F");
		primaryGd.put("primary2", "#001F5F");
		primaryGd.put("dashboardColorOne","0B378E");
		primaryGd.put("dashboardColorTwo","00205F");
		primaryGd.put("dashboardColorThree","F43653");

		gradient.put("primary", primaryGd);
		addTheme(channelId, "Dark Theme", "Dark Theme", true, neutral.toString(), primary.toString(),
				secondary.toString(), success.toString(), error.toString(), warning.toString(), support.toString(),
				gradient.toString(), "", "", "", "", true, 0);
	}

	public List<Themes> getLatestApprovedByChannelId(long channelId) {
		DynamicQuery dq = dynamicQuery();

		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));

		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));
		List<Themes> allApproved = themesPersistence.findWithDynamicQuery(dq);

		// Keep only latest version per resourceId
		Map<Long, Themes> latestByResource = new LinkedHashMap<>();

		for (Themes theme : allApproved) {
			if (!latestByResource.containsKey(theme.getEntityResourceId())) {
				latestByResource.put(theme.getEntityResourceId(), theme);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}
	public List<Themes> getLatestApprovedWithoutPendingByChannelId(long channelId) {
		DynamicQuery dq = dynamicQuery();
		dq.add(RestrictionsFactoryUtil.eq("channelId", channelId));
		dq.addOrder(OrderFactoryUtil.asc("entityResourceId"));
		dq.addOrder(OrderFactoryUtil.desc("version"));
		List<Themes> allThemes = themesPersistence.findWithDynamicQuery(dq);
		Set<Long> hasPending = allThemes.stream()
				.filter(t -> t.getStatus() == WorkflowConstants.STATUS_DRAFT)
				.map(Themes::getEntityResourceId)
				.collect(Collectors.toSet());

		Map<Long, Themes> latestByResource = new LinkedHashMap<>();
		for (Themes theme : allThemes) {
			if (hasPending.contains(theme.getEntityResourceId())) continue;
			if (theme.getStatus() != WorkflowConstants.STATUS_APPROVED) continue;
			if (!latestByResource.containsKey(theme.getEntityResourceId())) {
				latestByResource.put(theme.getEntityResourceId(), theme);
			}
		}

		return new ArrayList<>(latestByResource.values());
	}

	/**
	 * Returns latest APPROVED Themes entries for the channel along with a flag indicating whether
	 * that Theme (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved Theme for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	public Map<Themes, Boolean> getLatestApprovedByChannelIdWithPending(long channelId) {
		List<Themes> latestApproved = getLatestApprovedByChannelId(channelId);

		Map<Themes, Boolean> result = new LinkedHashMap<>();

		for (Themes theme : latestApproved) {
			boolean pending = hasPendingDraft(theme.getEntityResourceId());
			result.put(theme, pending);
		}

		return result;
	}

	private boolean isThemeUsedByPersona(long themeEntityResourceId, long channelId) {
		// Collect all themeIds for this theme's entityResourceId
		DynamicQuery themeQuery = DynamicQueryFactoryUtil.forClass(Themes.class, getClassLoader());
		themeQuery.add(RestrictionsFactoryUtil.eq("entityResourceId", themeEntityResourceId));
		themeQuery.setProjection(ProjectionFactoryUtil.property("themeId"));
		List<Long> allThemeIds = themesLocalService.dynamicQuery(themeQuery);

		if (allThemeIds.isEmpty()) {
			return false;
		}

		// Get latest approved persona per entityResourceId for this channel
		List<Persona> latestPersonas = personaLocalService.getLatestApprovedByChannelId(channelId);

		for (Persona p : latestPersonas) {
			if (allThemeIds.contains(p.getDarkThemeId()) || allThemeIds.contains(p.getLightThemeId())) {
				return true;
			}
		}

		return false;
	}

	public boolean hasPendingDraft(long entityResourceId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Themes.class, getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
			query.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DRAFT));

			List<Themes> versions = themesLocalService.dynamicQuery(query);

			return !versions.isEmpty();
		} catch (Exception e) {
			LOG.error("Unable to evaluate pending drafts for entityResourceId " + entityResourceId, e);
			// Fail closed: better to block edits than allow concurrent conflicting drafts.
			return true;
		}
	}

	private void deleteAllByEntityResourceId(long entityResourceId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Themes.class, getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));

			List<Themes> themes = themesLocalService.dynamicQuery(query);

			for (Themes t : themes) {
				themesPersistence.remove(t);
			}
		} catch (Exception e) {
			LOG.error("Unable to delete themes for entityResourceId " + entityResourceId, e);
			throw new RuntimeException("Failed to delete themes for entityResourceId " + entityResourceId, e);
		}
	}

	private Themes createThemeEntity(long channelId, String enName, String arName, boolean darkTheme, String neutralColors,
			String primaryColors, String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors, String splashBg, String splashAnimation,
			String headerBg, String balanceBg, boolean defaultTheme) {

		Themes theme = themesLocalService.createThemes(CounterLocalServiceUtil.increment());
		theme.setChannelId(channelId);
		theme.setThemeEnName(enName);
		theme.setThemeArName(arName);
		theme.setDarkTheme(darkTheme);
		theme.setDefaultTheme(defaultTheme);
		theme.setNeutralColors(neutralColors);
		theme.setPrimaryColors(primaryColors);
		theme.setSecondaryColors(secondaryColors);
		theme.setSuccessColors(successColors);
		theme.setErrorColors(errorColors);
		theme.setWarningColors(warningColors);
		theme.setSupportColors(supportColors);
		theme.setGradientColors(gradientColors);
		if (splashBg != null) theme.setSplashBg(splashBg);
		if (splashAnimation != null) theme.setSplashAnimation(splashAnimation);
		if (headerBg != null) theme.setHeaderBg(headerBg);
		if (balanceBg != null) theme.setBalanceBg(balanceBg);
		return theme;
	}

	private void startWorkflow(Themes theme, ServiceContext serviceContext, User user, Long id, String type) throws PortalException {

		theme = enrichWorkflow(theme, serviceContext, user, id, type,null);

		serviceContext.setAttribute(Constants.ENTITY_TYPE, Constants.THEMES);
		serviceContext.setAttribute(Constants.USER_NAME, user.getFullName());
		serviceContext.setAttribute(Constants.REQUEST_ID, theme.getThemeId());

		if (serviceContext.getScopeGroupId() <= 0) {
			serviceContext.setScopeGroupId(
					GroupLocalServiceUtil.getCompanyGroup(serviceContext.getCompanyId()).getGroupId()
			);
		}

		AssetEntryLocalServiceUtil.updateEntry(
				serviceContext.getUserId(),
				serviceContext.getScopeGroupId(),
				Themes.class.getName(),
				theme.getThemeId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames()
		);

		serviceContext.setAssetCategoryIds(null);
		serviceContext.setAssetTagNames(null);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				serviceContext.getCompanyId(),
				serviceContext.getUserId(),
				Themes.class.getName(),
				theme.getPrimaryKey(),
				theme,
				serviceContext
		);
	}

	private boolean isThemeUpdated(Long existingThemeId, long channelId, String enName, String arName, boolean darkTheme,
			String neutralColors, String primaryColors, String secondaryColors, String successColors,
			String errorColors, String warningColors, String supportColors, String gradientColors,
			String splashBg, String splashAnimation, String headerBg, String balanceBg, boolean defaultTheme) throws PortalException {

		Themes existing = themesLocalService.getThemes(existingThemeId);

		if (!Objects.equals(existing.getThemeEnName(), enName)) return true;
		if (!Objects.equals(existing.getThemeArName(), arName)) return true;
		if (existing.getDarkTheme() != darkTheme) return true;
		if (existing.getDefaultTheme() != defaultTheme) return true;
		if (!Objects.equals(existing.getNeutralColors(), neutralColors)) return true;
		if (!Objects.equals(existing.getPrimaryColors(), primaryColors)) return true;
		if (!Objects.equals(existing.getSecondaryColors(), secondaryColors)) return true;
		if (!Objects.equals(existing.getSuccessColors(), successColors)) return true;
		if (!Objects.equals(existing.getErrorColors(), errorColors)) return true;
		if (!Objects.equals(existing.getWarningColors(), warningColors)) return true;
		if (!Objects.equals(existing.getSupportColors(), supportColors)) return true;
		if (!Objects.equals(existing.getGradientColors(), gradientColors)) return true;
		if (!Objects.equals(existing.getSplashBg(), splashBg)) return true;
		if (!Objects.equals(existing.getSplashAnimation(), splashAnimation)) return true;
		if (!Objects.equals(existing.getHeaderBg(), headerBg)) return true;
		if (!Objects.equals(existing.getBalanceBg(), balanceBg)) return true;

		return false;
	}


	public Themes getLatestApprovedByEntityResourceId(long entityResourceId) {
		DynamicQuery dq = dynamicQuery();
		dq.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		dq.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		dq.addOrder(OrderFactoryUtil.desc("version"));
		List<Themes> results = themesPersistence.findWithDynamicQuery(dq, 0, 1);
		return results.isEmpty() ? null : results.get(0);
	}

	private int getMaxVersion(long entityResourceId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Themes.class, getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("entityResourceId", entityResourceId));
		query.setProjection(ProjectionFactoryUtil.max("version"));
		List<Integer> results = themesLocalService.dynamicQuery(query);
		if (results != null && !results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return 0;
	}

	public void importThemes(ImportRequest importRequest, JSONArray dataJson) {

		try {
			for (int i = 0; i < dataJson.length(); i++) {
				JSONObject themeJson = dataJson.getJSONObject(i);
				String action = themeJson.getString("action");
				Long channelId = themeJson.getLong("channelId");
				Long affectedEntityId = themeJson.getLong("affectedEntityId", 0L);
				ThemeDTO themeDTO = parseTheme(themeJson);
				ThemeDTO.themeData data = themeDTO.getData();
				User user = UserLocalServiceUtil.getUser(importRequest.getUserId());
				if ("add".equals(action)) {
					try {
						importThemeAdd(importRequest, data, channelId,user);
					} catch (Exception e) {
						LOG.error("Failed to add theme from import at index " + i, e);
					}
				} else if ("update".equals(action)) {
					try {
						importThemeUpdate(affectedEntityId,importRequest, data,channelId,user);
					} catch (Exception e) {
						LOG.error("Failed to update theme from import at index " + i, e);
					}
				} else {
					LOG.warn("Unknown action for theme import: " + action);
				}
			}
		} catch (Exception e) {
			LOG.error("Failed to import themes", e);
		}

	}

	private void importThemeAdd(ImportRequest importRequest, ThemeDTO.themeData data ,Long channelId,User user) throws Exception {
		themeCreateWithoutWorkflow(
				channelId, data.getThemeEnName(), data.getThemeArName(),
				data.isDarkTheme(), data.getNeutralColors(), data.getPrimaryColors(),
				data.getSecondaryColors(), data.getSuccessColors(), data.getErrorColors(),
				data.getWarningColors(), data.getSupportColors(), data.getGradientColors(),
				data.getSplashBg(), data.getSplashAnimation(), data.getHeaderBg(), data.getBalanceBg(),
				data.isDefaultTheme(), user, importRequest
		);
	}

	private void importThemeUpdate(Long affectedEntityId,ImportRequest importRequest, ThemeDTO.themeData data ,Long channelId,User user) throws Exception
	{
		themeUpdateWithoutWorkflow(affectedEntityId, channelId, data.getThemeEnName(), data.getThemeArName(),
				data.isDarkTheme(), data.getNeutralColors(), data.getPrimaryColors(),
				data.getSecondaryColors(), data.getSuccessColors(), data.getErrorColors(),
				data.getWarningColors(), data.getSupportColors(), data.getGradientColors(),
				data.getSplashBg(), data.getSplashAnimation(), data.getHeaderBg(), data.getBalanceBg(),
				data.isDefaultTheme(), null, user, importRequest);
	}

	private ThemeDTO parseTheme(JSONObject themeJson) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(themeJson.toString(), ThemeDTO.class);
	}


	private Themes prepareTheme(long channelId, String enName, String arName, boolean darkTheme, String neutralColors,
								String primaryColors, String secondaryColors, String successColors, String errorColors,
								String warningColors, String supportColors, String gradientColors, String splashBg, String splashAnimation,
								String headerBg, String balanceBg, boolean defaultTheme, ServiceContext serviceContext, User user) {


		Themes createTheme = createThemeEntity(channelId, enName, arName, darkTheme, neutralColors, primaryColors,
				secondaryColors, successColors, errorColors, warningColors, supportColors, gradientColors,
				splashBg, splashAnimation, headerBg, balanceBg, defaultTheme);


		createTheme = themesLocalService.updateThemes(createTheme);

		// Set entityResourceId to the theme's own ID for a new entity
		createTheme.setEntityResourceId(createTheme.getThemeId());
		createTheme.setVersion(getMaxVersion(createTheme.getEntityResourceId()) + 1);

		return createTheme;
	}

	private Themes enrichWorkflow(Themes theme, ServiceContext serviceContext, User user, Long id, String type,ImportRequest importRequest)
	{

		if(serviceContext !=null) {
			theme.setGroupId(serviceContext.getScopeGroupId());
			theme.setCompanyId(serviceContext.getCompanyId());
			theme.setUserId(serviceContext.getUserId());
		}
		else {
			theme.setGroupId(importRequest.getGroupId());
			theme.setCompanyId(importRequest.getCompanyId());
			theme.setUserId(importRequest.getUserId());
			theme.setImportRequestId(importRequest.getId());
		}
		theme.setUserName(user.getFullName());

		if (theme.getCreateDate() == null) {
			theme.setCreateDate(new Date());
		}
		theme.setModifiedDate(new Date());

		if (theme.getUuid_() == null || theme.getUuid_().isEmpty()) {
			theme.setUuid_(PortalUUIDUtil.generate());
		}

		theme.setOriginalEntityId(id);
		theme.setStatus(WorkflowConstants.STATUS_DRAFT);
		theme.setStatusDate(new Date());

		if (Constants.ADD.equals(type) || Constants.CREATE.equals(type)) {
			theme.setWorkflowAction(Constants.ADD);
		} else if (Constants.UPDATE.equals(type)) {
			theme.setWorkflowAction(Constants.UPDATE);
		} else if (Constants.DELETE.equals(type)) {
			theme.setWorkflowAction(Constants.DELETE);
		} else {
			theme.setWorkflowAction(type);
		}

		return ThemesLocalServiceUtil.updateThemes(theme);
	}

	/**
	 * User Story 5 - Global Component Versioning.
	 *
	 * <p>
	 * An approved change to the Themes component bumps the internal
	 * {@code themeVersion} version for this company/channel. Runs in the same
	 * transaction as the approval so both succeed or roll back together.
	 * </p>
	 */
	private void incrementGlobalVersion(Themes theme) {
		GlobalVersionLocalServiceUtil.incrementApprovedVersion(
				theme.getCompanyId(),
				theme.getChannelId(),
				ComponentType.THEME.name());
	}

}