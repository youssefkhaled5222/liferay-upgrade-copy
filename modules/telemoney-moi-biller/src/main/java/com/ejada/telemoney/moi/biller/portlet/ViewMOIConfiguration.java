package com.ejada.telemoney.moi.biller.portlet;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.moi.biller.portlet.ViewMOIConfiguration")
public interface ViewMOIConfiguration {

	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/service-inq?paymentRefundType=",		    		
		    name = "getMOIService",
		    required = false
		)
		public String getMOIService();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/sub-service-inq/",
		    name = "getMOISubService",
		    required = false
		)
		public String getMOISubService();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/service-modification",
		    name = "updateMOIService",
		    required = false
		)
		public String updateMOIService();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/sub-service-modification",
		    name = "updateMOISubService",
		    required = false
		)
		public String updateMOISubService();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/service-deletion/",
		    name = "deleteMOIService",
		    required = false
		)
		public String deleteMOIService();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/sub-service-deletion/",
		    name = "deleteMOISubService",
		    required = false
		)
		public String deleteMOISubService();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/field-modification",
		    name = "updateMOIFields",
		    required = false
		)
		public String updateMOIFields();
}
