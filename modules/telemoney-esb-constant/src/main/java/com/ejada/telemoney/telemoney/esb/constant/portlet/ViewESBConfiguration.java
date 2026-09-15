package com.ejada.telemoney.telemoney.esb.constant.portlet;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
						scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.telemoney.esb.constant.portlet.ViewESBConfiguration")
public interface ViewESBConfiguration {
		
		@Meta.AD(
		    deflt = "http://192.168.215.114:17950/constants/list",
		    name = "esbUrl",
		    required = false
		)
		public String esbUrl();
		
		@Meta.AD(
			deflt = "http://192.168.215.114:17950/constants/reload",
			name = "esbReloadUrl",
			required = false)
		public String esbReloadUrl();
		
		@Meta.AD(
				deflt = "http://192.168.215.114:17950/constants/",
				name = "searchUrl",
				required = false)
		public String searchUrl();
		
		@Meta.AD(
				deflt = "1234",
				name = "XCorrelationId",
				required = false)
		public String XCorrelationId();
		
		@Meta.AD(
				deflt =  "http://192.168.215.114:17950/constants/",
				name = "entityReloadUrl",
				required = false)
		public String entityReloadUrl();
		
		
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
				deflt = "http://192.168.215.114:17950/constants/",
				name = "esbUpdateUrl",
				required = false)
		public String esbUpdateUrl();
		
		
		
		
}