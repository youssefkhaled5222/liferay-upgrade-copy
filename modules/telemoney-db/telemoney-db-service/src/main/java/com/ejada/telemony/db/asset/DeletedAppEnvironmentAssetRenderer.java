package com.ejada.telemony.db.asset;

import com.ejada.telemony.db.model.AppEnvironment;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

public class DeletedAppEnvironmentAssetRenderer
	extends BaseJSPAssetRenderer<AppEnvironment> {

	private final long _classPK;

	public DeletedAppEnvironmentAssetRenderer(long classPK) {
		_classPK = classPK;
	}

	@Override
	public AppEnvironment getAssetObject() {
		return null;
	}

	@Override
	public long getGroupId() {
		return 0;
	}

	@Override
	public long getUserId() {
		return 0;
	}

	@Override
	public String getUserName() {
		return StringPool.BLANK;
	}

	@Override
	public String getUuid() {
		return StringPool.BLANK;
	}

	@Override
	public String getClassName() {
		return AppEnvironment.class.getName();
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public String getTitle(Locale locale) {
		return "App Config (Deleted)";
	}

	@Override
	public String getSummary(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		return "This App Config entry has been deleted.";
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		request.setAttribute("entryDeleted", true);
		request.setAttribute("deletedEntryId", _classPK);

		if (TEMPLATE_FULL_CONTENT.equals(template)) {
			return "/assets/app_environment_full_content.jsp";
		}

		return StringPool.BLANK;
	}

}
