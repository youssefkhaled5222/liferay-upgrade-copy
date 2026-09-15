package com.ejada.telemoney.noncustomer.list.screen.portlet;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
							scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.noncustomer.list.screen.portlet.ViewNonCustomerConfiguration")
public interface ViewNonCustomerConfiguration {
		
		
		@Meta.AD(
				deflt = "1234",
				name = "XCorrelationId",
				required = false)
		public String XCorrelationId();
	
		
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
		
		@Meta.AD(
				deflt = "http://192.168.215.114:17427/api/v1/login-management/non-customers",
				name = "nonCustomerURL",
				required = false)
		public String nonCustomerURL();
		
		
}