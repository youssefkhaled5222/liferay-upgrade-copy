package com.ejada.telemony.db.service.impl;

import com.ejada.telemony.db.model.GlobalVersion;
import com.ejada.telemony.db.service.base.GlobalVersionLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

/**
 * User Story 5 - Global Component Versioning.
 *
 * <p>
 * Maintains one internal version per company, channel and component. The
 * version starts at 1 and is incremented by 1 only after an approved component
 * change (draft / pending / rejected / cancelled changes never change it).
 * </p>
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@code com.ejada.telemony.db.service.GlobalVersionLocalService} interface.
 * </p>
 */
public class GlobalVersionLocalServiceImpl
	extends GlobalVersionLocalServiceBaseImpl {

	private static final Log LOG = LogFactoryUtil.getLog(
		GlobalVersionLocalServiceImpl.class);

	/**
	 * Approval Update Flow (User Story 5.2).
	 *
	 * <p>
	 * Finds the record using companyId, channelId and componentName. Creates it
	 * with version 1 if it does not exist; otherwise increments the current
	 * version by 1. The {@code modifiedDate} is updated in the same
	 * transaction. This method must be called only after a component change is
	 * approved.
	 * </p>
	 *
	 * @param  companyId company/tenant identifier
	 * @param  channelId channel identifier
	 * @param  componentName one of {@code ComponentType} names
	 *         (APP_CONFIGURATION, LOCALIZATION, ASSET_MANAGEMENT, FEATURE_FLAG)
	 * @return the created or updated {@link GlobalVersion} record
	 */
	public GlobalVersion incrementApprovedVersion(
		long companyId, long channelId, String componentName) {

		GlobalVersion globalVersion = globalVersionPersistence.fetchByC_C_C(
			companyId, channelId, componentName);

		if (globalVersion == null) {
			globalVersion = createGlobalVersion(
				counterLocalService.increment());

			globalVersion.setCompanyId(companyId);
			globalVersion.setChannelId(channelId);
			globalVersion.setComponentName(componentName);
			globalVersion.setVersion(1L);
		}
		else {
			globalVersion.setVersion(globalVersion.getVersion() + 1);
		}

		globalVersion.setModifiedDate(new Date());

		globalVersion = globalVersionPersistence.update(globalVersion);

		LOG.info(
			"GlobalVersion for company=" + companyId + ", channel=" +
				channelId + ", component=" + componentName + " is now version " +
					globalVersion.getVersion());

		return globalVersion;
	}

	/**
	 * Returns the current approved internal version for the given
	 * company/channel/component, or {@code 0} if no version exists yet.
	 */
	public long getCurrentVersion(
		long companyId, long channelId, String componentName) {

		GlobalVersion globalVersion = globalVersionPersistence.fetchByC_C_C(
			companyId, channelId, componentName);

		return (globalVersion == null) ? 0L : globalVersion.getVersion();
	}

}

