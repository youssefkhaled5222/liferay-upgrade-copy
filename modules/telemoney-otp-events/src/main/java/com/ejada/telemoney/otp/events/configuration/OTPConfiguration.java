package com.ejada.telemoney.otp.events.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
							   scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.otp.events.configuration.OTPConfiguration")

public interface OTPConfiguration {
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17416/api/v1/otp-management/OTP-events-list",
		    description = "A URL for getting all OTP events.",
		    name = "getAllOTPEventsURL",
		    required = false
		)
	public String getAllOTPEventsURL();
	
	@Meta.AD(
			deflt = "http://192.168.215.114:17416/api/v1/otp-management/OTP-event-update",
			description = "A URL to update an OTP event.",
			name = "updateOTPEventURL",
			required = false
			)
	public String updateOTPEventURL();
	
	@Meta.AD(
			deflt = "12345",
			name = "XCorrelationId",
			required = false)
	public String XCorrelationId();
	
	@Meta.AD(
			deflt = "eventCode",
			name = "requestParam1",
			required = false)
	public String requestParam1();
	
	@Meta.AD(
			deflt = "eventReasonAr",
			name = "requestParam2",
			required = false)
	public String requestParam2();
	
	@Meta.AD(
			deflt = "eventReasonEn",
			name = "requestParam3",
			required = false)
	public String requestParam3();
	
	@Meta.AD(
			deflt = "eventDescription",
			name = "requestParam4",
			required = false)
	public String requestParam4();
	
	@Meta.AD(
			deflt = "",
			name = "userName",
			required = false)
	public String userName();
	
	@Meta.AD(
			deflt = "",
			name = "password",
			required = false)
	public String password();
}
