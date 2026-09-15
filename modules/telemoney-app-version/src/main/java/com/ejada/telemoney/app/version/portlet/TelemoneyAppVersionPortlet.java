package com.ejada.telemoney.app.version.portlet;
import com.ejada.telemoney.app.version.constants.TelemoneyAppVersionPortletKeys;
import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.model.AppVersion;
import com.ejada.telemony.db.service.AppVersionLocalService;
import com.ejada.telemony.db.service.UserLogsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author maismail
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyAppVersion",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyAppVersionPortletKeys.TELEMONEYAPPVERSION,
		"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TelemoneyAppVersionPortlet extends MVCPortlet {
	@Reference
	private AppVersionLocalService _appVersionLocalService;


	@Reference
	private UserLogsLocalService _userLogsLocalService;
	private static final Pattern XSS_PATTERN = Pattern.compile(".*[<>\"'\\\\].*");

	private boolean containsXSS(String input) {
		return input != null && XSS_PATTERN.matcher(input).find();
	}
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			PortletSession pSession = renderRequest.getPortletSession();
			Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
					? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
					: 1;

			String myView = "view";
			String page = renderRequest.getParameter("myView");
			if(Objects.equals(page, "view") || Objects.equals(page, null))
			{

				// Provide map of record -> isPending (pending based on hasPendingDraft/entityResourceId)
				java.util.Map<AppVersion, Boolean> recordsWithPending =
						_appVersionLocalService.getLatestApprovedByChannelIdWithPending(chn);

				renderRequest.setAttribute("recordsWithPending", recordsWithPending);
				renderRequest.setAttribute("records", new java.util.ArrayList<>(recordsWithPending.keySet()));

			}
			if(Objects.equals(page, "add"))
			{
				myView = "add";
			}
			if(Objects.equals(page, "edit"))
			{
				myView = "edit";
				Long versionId = ParamUtil.getLong(renderRequest, "versionId");
				AppVersion record =_appVersionLocalService.fetchAppVersion(versionId);
				renderRequest.setAttribute("record", record);
				pSession.setAttribute("recordId", record.getVersionId());

			}
			String view = "/" + myView + ".jsp";
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
			dispatcher.include(renderRequest, renderResponse);


		} catch (Exception e) {
			SessionErrors.add(renderRequest, "error");
			renderRequest.setAttribute("errorMessage", e.getMessage());

		}
	}
	public void addAppVersion(ActionRequest actionRequest, ActionResponse actionResponse)
			 {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        List<Role> roles = user.getRoles();
        boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
        boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

        if (!isAdministrator && !isPo) {
            SessionErrors.add(actionRequest, "notAuthorized");
            return;
        }
        try {
            PortletSession pSession = actionRequest.getPortletSession();
            Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
                    ? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
                    : 1;
            String platform = ParamUtil.getString(actionRequest, "platform");
            if (containsXSS(platform)) {
                SessionErrors.add(actionRequest, "xssDetected");
                return;
            }
            if(platform.equals("IOS")|| platform.equals("Android")||platform.equals("Huawei"))
            {
                String versionNumber = ParamUtil.getString(actionRequest, "versionNumber");
                String url = ParamUtil.getString(actionRequest, "url");
                boolean status = ParamUtil.getBoolean(actionRequest, "status", false);
                if (containsXSS(versionNumber) || containsXSS(url)) {
                    SessionErrors.add(actionRequest, "xssDetected");
                    return;
                }

                ServiceContext serviceContext = ServiceContextFactory.getInstance(AppVersion.class.getName(), actionRequest);
                serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
                _appVersionLocalService.addAppVersion(platform,versionNumber,status,url,chn,serviceContext,user);

                String userName = themeDisplay.getUser().getFullName();
                String userAction = TelemoneyConstants.USER_ACTION_ADD.concat(TelemoneyConstants.USER_LOGS_APP_VERSION).concat(platform);
                _userLogsLocalService.addUserData(userName, userAction,chn);
            }
            else {
                throw new Exception("Invalid platform");
            }

        }
        catch (Exception e) {
            String ee =e.getMessage();
            System.out.println("from portlet error--->  "+ ee);
            actionRequest.setAttribute("errorMessage", e.getMessage());
            SessionErrors.add(actionRequest, "error");

        }
    }

	public void deleteAppVersion(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		try {
			PortletSession pSession = actionRequest.getPortletSession();
			Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
					? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
					: 1;
			Long selectedVersionId = ParamUtil.getLong(actionRequest, "selectedVersionId");
			String userName = themeDisplay.getUser().getFullName();
			String name = _appVersionLocalService.fetchAppVersion(selectedVersionId).getPlatform();
			String userAction = TelemoneyConstants.USER_ACTION_DELETE.concat(TelemoneyConstants.USER_LOGS_APP_VERSION).concat(name);
			_userLogsLocalService.addUserData(userName, userAction,chn);
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(AppVersion.class.getName(), actionRequest);
			serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
			
			_appVersionLocalService.deleteAppVersion(selectedVersionId, serviceContext, user);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			actionRequest.setAttribute("errorMessage", e.getMessage());
		}
	}
	public void editAppVersion(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> roles = user.getRoles();
		boolean isAdministrator = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("Administrator"));
		boolean isPo = roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("po"));

		if (!isAdministrator && !isPo) {
			SessionErrors.add(actionRequest, "notAuthorized");
			return;
		}
		PortletSession pSession = actionRequest.getPortletSession();
		Long chn = pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE) != null
				? (Long) pSession.getAttribute("LIFERAY_SHARED_ChannelId", PortletSession.APPLICATION_SCOPE)
				: 1;
		Long versionId = (Long) pSession.getAttribute("recordId");
		String versionNumber = ParamUtil.getString(actionRequest, "versionNumber");
		String url = ParamUtil.getString(actionRequest, "url");
		boolean status = ParamUtil.getBoolean(actionRequest, "status", false);
		if (containsXSS(versionNumber) || containsXSS(url)) {
			SessionErrors.add(actionRequest, "xssDetected");
			return;
		}
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AppVersion.class.getName(), actionRequest);
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		_appVersionLocalService.updateAppVersion(versionId,versionNumber,status,url,chn,serviceContext);
		pSession.removeAttribute("recordId");
		String userName = themeDisplay.getUser().getFullName();
		String userAction = TelemoneyConstants.USER_ACTION_UPDATE.concat(TelemoneyConstants.USER_LOGS_APP_VERSION).concat(versionNumber);
		_userLogsLocalService.addUserData(userName, userAction,chn);
	}
}
