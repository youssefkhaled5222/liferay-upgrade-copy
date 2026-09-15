package com.ejada.telemoney.sms.template.portlet;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
								scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.sms.template.portlet.ViewSMSConfiguration")
public interface ViewSMSConfiguration {
		
		@Meta.AD(
		    deflt = "http://192.168.215.114:17491/api/v1/sms",
		    description = "URL for SMS service",
		    name = "smsURLGetAll",
		    required = false
		)
		public String smsURLGetAll();
		
		@Meta.AD(
			deflt = "http://192.168.215.114:17491/api/v1/sms/service-id",
			description = "URL for SMS service update",
			name = "smsURLServiceUpdate",
			required = false)
		public String smsURLServiceUpdate();
		
		@Meta.AD(
				deflt = "http://192.168.215.114:17491/api/v1/sms/description",
				description = "URL for SMS description update",
				name = "smsURLDescriptionUpdate",
				required = false)
		public String smsURLDescriptionUpdate();
		
		@Meta.AD(
				deflt = "1234",
				name = "XCorrelationId",
				required = false)
		public String XCorrelationId();
		
		@Meta.AD(
				deflt = "oldServiceId",
				name = "serviceRequestParam1",
				required = false)
		public String serviceRequestParam1();
		
		@Meta.AD(
				deflt = "newServiceId",
				name = "serviceRequestParam2",
				required = false)
		public String serviceRequestParam2();
		
		@Meta.AD(
				deflt = "serviceId",
				name = "descriptionRequestParam1",
				required = false)
		public String descriptionRequestParam1();
		
		@Meta.AD(
				deflt = "newEventDescription",
				name = "descriptionRequestParam2",
				required = false)
		public String descriptionRequestParam2();
		
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