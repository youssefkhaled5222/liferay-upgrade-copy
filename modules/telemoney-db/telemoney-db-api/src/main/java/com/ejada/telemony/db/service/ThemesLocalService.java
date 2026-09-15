/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ejada.telemony.db.service;

import com.ejada.telemony.db.model.ImportRequest;
import com.ejada.telemony.db.model.Persona;
import com.ejada.telemony.db.model.Themes;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.*;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Themes. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ThemesLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.ejada.telemony.db.model.Themes"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ThemesLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.telemony.db.service.impl.ThemesLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the themes local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ThemesLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addDefaultDarkTheme(Long channelId);

	public void addDefaultLightTheme(Long channelId);

	public void addTheme(
		long channelId, String enName, String arName, boolean darkTheme,
		String neutralColors, String primaryColors, String secondaryColors,
		String successColors, String errorColors, String warningColors,
		String supportColors, String gradientColors, String splashBg,
		String splashAnimation, String headerBg, String balanceBg,
		boolean deafultTheme, long themeId);

	/**
	 * Adds the themes to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themes the themes
	 * @return the themes that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Themes addThemes(Themes themes);

	public List<Persona> checkTheme(Long channelId, Long themeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new themes with the primary key. Does not add the themes to the database.
	 *
	 * @param themeId the primary key for the new themes
	 * @return the new themes
	 */
	@Transactional(enabled = false)
	public Themes createThemes(long themeId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteTheme(Long themeId, Long channelId) throws Exception;

	/**
	 * Deletes the themes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes that was removed
	 * @throws PortalException if a themes with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Themes deleteThemes(long themeId) throws PortalException;

	/**
	 * Deletes the themes from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themes the themes
	 * @return the themes that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Themes deleteThemes(Themes themes);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Themes fetchThemes(long themeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getAllDefaultThemes(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getAllNonDefaultThemes(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getbyChannelId(Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Themes getDefaultTheme(boolean mode, Long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getLatestApprovedByChannelId(long channelId);

	/**
	 * Returns latest APPROVED Themes entries for the channel along with a flag indicating whether
	 * that Theme (entityResourceId) currently has a pending draft awaiting approval.
	 *
	 * Map key: latest approved Theme for an entityResourceId
	 * Map value: true if there is any STATUS_DRAFT row for that entityResourceId
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<Themes, Boolean>
		getLatestApprovedByChannelIdWithPending(long channelId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Themes getLatestApprovedByEntityResourceId(long entityResourceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getLatestApprovedWithoutPendingByChannelId(
		long channelId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the themes with the primary key.
	 *
	 * @param themeId the primary key of the themes
	 * @return the themes
	 * @throws PortalException if a themes with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Themes getThemes(long themeId) throws PortalException;

	/**
	 * Returns a range of all the themeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.telemony.db.model.impl.ThemesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of themeses
	 * @param end the upper bound of the range of themeses (not inclusive)
	 * @return the range of themeses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Themes> getThemeses(int start, int end);

	/**
	 * Returns the number of themeses.
	 *
	 * @return the number of themeses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getThemesesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPendingDraft(long entityResourceId);

	public void importThemes(ImportRequest importRequest, JSONArray dataJson);

	public void themeCreate(
			long channelId, String enName, String arName, boolean darkTheme,
			String neutralColors, String primaryColors, String secondaryColors,
			String successColors, String errorColors, String warningColors,
			String supportColors, String gradientColors, String splashBg,
			String splashAnimation, String headerBg, String balanceBg,
			boolean defaultTheme, ServiceContext serviceContext, User user)
		throws Exception;

	public void themeDelete(Long id, ServiceContext serviceContext, User user)
		throws Exception;

	public void themeUpdate(
			Long id, long channelId, String enName, String arName,
			boolean darkTheme, String neutralColors, String primaryColors,
			String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors,
			String splashBg, String splashAnimation, String headerBg,
			String balanceBg, boolean defaultTheme,
			ServiceContext serviceContext, User user)
		throws Exception;

	public void themeUpdateWithoutWorkflow(
			Long id, long channelId, String enName, String arName,
			boolean darkTheme, String neutralColors, String primaryColors,
			String secondaryColors, String successColors, String errorColors,
			String warningColors, String supportColors, String gradientColors,
			String splashBg, String splashAnimation, String headerBg,
			String balanceBg, boolean defaultTheme,
			ServiceContext serviceContext, User user,
			ImportRequest importRequest)
		throws Exception;

	public Themes updateStatus(
			long userId, long themeId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	 * Updates the themes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ThemesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param themes the themes
	 * @return the themes that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Themes updateThemes(Themes themes);

}