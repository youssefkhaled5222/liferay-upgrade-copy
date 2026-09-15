package com.ejada.telemoney.ivr.events.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
							   scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.ivr.events.configuration.IVRConfiguration")

public interface IVRConfiguration {
	@Meta.AD(
		    deflt = "http://192.168.215.114:17488/api/v1/ivr-management/IVR-events-list",
		    description = "A URL for getting all IVR events.",
		    name = "getAllIVREventsURL",
		    required = false
		)
	public String getAllIVREventsURL();
	
	@Meta.AD(
			deflt = "http://192.168.215.114:17488/api/v1/ivr-management/IVR-event-update",
			description = "A URL to update an IVR event.",
			name = "updateIVREventURL",
			required = false
			)
	public String updateIVREventURL();
	
	@Meta.AD(
			deflt = "1234",
			name = "XCorrelationId",
			required = false)
	public String XCorrelationId();
	
	@Meta.AD(
			deflt = "eventCode",
			name = "requestParam1",
			required = false)
	public String requestParam1();
	
	@Meta.AD(
			deflt = "eventClass",
			name = "requestParam2",
			required = false)
	public String requestParam2();
	
	@Meta.AD(
			deflt = "eventSubClass",
			name = "requestParam3",
			required = false)
	public String requestParam3();
	
	@Meta.AD(
			deflt = "eventName",
			name = "requestParam4",
			required = false)
	public String requestParam4();
	
	@Meta.AD(
			deflt = "eventSource",
			name = "requestParam5",
			required = false)
	public String requestParam5();
	
	@Meta.AD(
			deflt = "eventType",
			name = "requestParam6",
			required = false)
	public String requestParam6();
	
	@Meta.AD(
			deflt = "TeleMoneyWrapper",
			name = "userName",
			required = false)
	public String userName();
	
	@Meta.AD(
			deflt = "9(Te1cwdM7K071DQ,qwCZ+xtF[5jmBRd",
			name = "password",
			required = false)
	public String password();
}
