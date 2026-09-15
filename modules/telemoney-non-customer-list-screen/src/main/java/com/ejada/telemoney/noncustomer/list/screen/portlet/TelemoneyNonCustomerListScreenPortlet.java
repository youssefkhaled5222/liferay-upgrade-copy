package com.ejada.telemoney.noncustomer.list.screen.portlet;

import com.ejada.telemoney.noncustomer.list.screen.constants.TelemoneyNonCustomerListScreenPortletKeys;
import com.ejada.telemony.db.service.NonCustomerLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.PortletPreferences;

/**
 * @author rmostafa
 */
@Component(configurationPid = "com.ejada.telemoney.noncustomer.list.screen.portlet.ViewNonCustomerConfiguration", immediate = true, property = {
		"com.liferay.portlet.display-category=category.sample", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=TelemoneyNonCustomerListScreen",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TelemoneyNonCustomerListScreenPortletKeys.TELEMONEYNONCUSTOMERLISTSCREEN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TelemoneyNonCustomerListScreenPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String nonCustomerURL = portletPreferences.getValue("nonCustomerURL",
				String.valueOf(_viewNonCustomerConfiguration.nonCustomerURL()));
		String XCorrelationId = portletPreferences.getValue("XCorrelationId",
				String.valueOf(_viewNonCustomerConfiguration.XCorrelationId()));
		String userName = portletPreferences.getValue("userName",
				String.valueOf(_viewNonCustomerConfiguration.userName()));
		String password = portletPreferences.getValue("password",
				String.valueOf(_viewNonCustomerConfiguration.password()));

		String personaviewUrl = "/META-INF/resources/view.jsp";
		renderRequest.setAttribute("personaviewUrl", personaviewUrl);
		String myview = "view";
		// PortletSession pSession = renderRequest.getPortletSession();
		JSONObject originalData;
		if (renderRequest.getAttribute("myview") != null && renderRequest.getAttribute("myview") != "view") {
			myview = (String) renderRequest.getAttribute("myview");
		} else {
			String SMSResponse = _nonCustomerLocalService.getAllNonCustomer(nonCustomerURL, XCorrelationId, userName,
					password);

			try {
				originalData = JSONFactoryUtil.createJSONObject(SMSResponse);
				// JSONArray items = originalData.getJSONArray("body");
				JSONArray jsonItems = originalData.getJSONObject("body").getJSONArray("nonCustomersList");
				List<NonCustomerDTO> items = NonCustomerDTO.fromJSONArray(jsonItems);

				renderRequest.setAttribute("records", items);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String view = "/" + myview + ".jsp";
		renderRequest.setAttribute(ViewNonCustomerConfiguration.class.getName(), _viewNonCustomerConfiguration);
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);

	}

	@Reference
	private NonCustomerLocalService _nonCustomerLocalService;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_viewNonCustomerConfiguration = ConfigurableUtil.createConfigurable(ViewNonCustomerConfiguration.class,
				properties);
	}

	private volatile ViewNonCustomerConfiguration _viewNonCustomerConfiguration;

}