package com.ejada.telemoney.whiteList.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.whiteList.configuration.WhiteListConfiguration")
public interface WhiteListConfiguration {
	
	@Meta.AD(
		    deflt = "https://dev-tm-login.apps.ocpdev.anb.net/api/v1/login-management/white-listed-users",
		    description = "A URL for getting all White Listed Clients.",
		    name = "getAllWhiteListed",
		    required = false
		)
	public String getAllWhiteListed();
	
	@Meta.AD(
			deflt = "https://dev-tm-login.apps.ocpdev.anb.net/api/v1/login-management/white-listed-users",
			description = "A URL to update an White Listed User Status.",
			name = "updateWhiteListedStatus",
			required = false
			)
	public String updateWhiteListedStatus();
	
	@Meta.AD(
			deflt = "1234",
			name = "XCorrelationId",
			required = false)
	public String XCorrelationId();
	
	@Meta.AD(
			deflt = "2512465309",
			name = "defaultPOI",
			required = false)
	public String defaultPOI();

}
