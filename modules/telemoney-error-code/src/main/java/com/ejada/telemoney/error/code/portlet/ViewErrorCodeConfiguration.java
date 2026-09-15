package com.ejada.telemoney.error.code.portlet;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
						scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.error.code.portlet.ViewErrorCodeConfiguration")
public interface ViewErrorCodeConfiguration {
		
		@Meta.AD(
		    deflt = "http://localhost:8081/api/v1/languages-management/status-code",
		    name = "errorCodeUrl",
		    required = false
		)
		public String errorCodeUrl();
		
		@Meta.AD(
			deflt = "http://localhost:8081/api/v1/languages-management/description-details",
			name = "updateErrorCode",
			required = false)
		public String updateErrorCode();
		
		@Meta.AD(
				deflt = "http://localhost:8081/api/v1/languages-management/languages",
				description = "URL for SMS description update",
				name = "getAllLanguages",
				required = false)
		public String getAllLanguages();
		
		@Meta.AD(
				deflt = "1234",
				name = "XCorrelationId",
				required = false)
		public String XCorrelationId();
		
		@Meta.AD(
				deflt = "http://localhost:8081/api/v1/languages-management/status-code/",
				name = "searchByCode",
				required = false)
		public String searchByCode();
		
		
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