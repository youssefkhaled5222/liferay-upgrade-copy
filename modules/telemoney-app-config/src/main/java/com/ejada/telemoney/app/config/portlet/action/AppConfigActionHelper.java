package com.ejada.telemoney.app.config.portlet.action;

import com.ejada.telemony.db.model.AppConfigItem;
import com.ejada.telemony.db.service.AppConfigItemLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AppConfigActionHelper.class)
public class AppConfigActionHelper {

	public long getChannelIdFromSession(PortletSession pSession) {
		return pSession.getAttribute(
				"LIFERAY_SHARED_ChannelId",
				PortletSession.APPLICATION_SCOPE) != null
			? (Long)pSession.getAttribute(
				"LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
			: 1L;
	}

	public void validateNoDuplicateKeys(
		String[] itemKeys, String[] itemValues) {

		Set<String> normalizedKeys = new HashSet<>();
		int itemCount = Math.min(itemKeys.length, itemValues.length);

		for (int i = 0; i < itemCount; i++) {
			String key = itemKeys[i] != null ? itemKeys[i].trim() : "";
			String value = itemValues[i] != null ? itemValues[i].trim() : "";

			if (key.isEmpty() && value.isEmpty()) {
				continue;
			}

			String normalizedKey = key.toLowerCase(Locale.ROOT);

			if (!normalizedKeys.add(normalizedKey)) {
				throw new IllegalArgumentException(
					"Duplicate config key found: " + key);
			}
		}
	}

	public void saveConfigItems(
		long environmentId, String[] itemKeys, String[] itemTypes,
		String[] itemValues) {

		int itemCount = Math.min(
			itemKeys.length, Math.min(itemTypes.length, itemValues.length));

		for (int i = 0; i < itemCount; i++) {
			String key = itemKeys[i] != null ? itemKeys[i].trim() : "";
			String type = itemTypes[i] != null ? itemTypes[i].trim() : "";
			String value = itemValues[i] != null ? itemValues[i].trim() : "";

			if (key.isEmpty() && value.isEmpty()) {
				continue;
			}

			AppConfigItem appConfigItem =
				_appConfigItemLocalService.createAppConfigItem(
					CounterLocalServiceUtil.increment());

			appConfigItem.setEnvironmentId(environmentId);
			appConfigItem.setKeyName(key);
			appConfigItem.setValueType(type);
			appConfigItem.setValue(value);

			_appConfigItemLocalService.addAppConfigItem(appConfigItem);
		}
	}

	public boolean hasManageRole(User user) {
		List<Role> roles = user.getRoles();

		boolean isAdministrator = roles.stream().anyMatch(
			role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(
			role -> role.getName().equalsIgnoreCase("po"));

		return isAdministrator || isPo;
	}

	@Reference
	private AppConfigItemLocalService _appConfigItemLocalService;

}
