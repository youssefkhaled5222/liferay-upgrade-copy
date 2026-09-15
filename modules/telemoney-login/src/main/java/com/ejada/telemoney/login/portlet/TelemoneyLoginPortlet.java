package com.ejada.telemoney.login.portlet;

import com.ejada.telemoney.login.constants.TelemoneyLoginPortletKeys;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.security.auth.session.AuthenticatedSessionManagerUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author iatef
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TelemoneyLogin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyLoginPortletKeys.TELEMONEYLOGIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TelemoneyLoginPortlet extends MVCPortlet {
	public void validate(ActionRequest actionRequest, ActionResponse actionResponse) {

		String email = ParamUtil.getString(actionRequest, "email");
		String password = ParamUtil.getString(actionRequest, "password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
		/*
		 * long companyId = PortalUtil.getCompanyId(actionRequest); long userId = -1;
		 */
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		try {

			AuthenticatedSessionManagerUtil.login(request, response, email, password, rememberMe,
					CompanyConstants.AUTH_TYPE_EA);
			actionResponse.sendRedirect(themeDisplay.getPortalURL());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}