package com.ejada.telemoney.configuration.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)

@Meta.OCD(id = "com.ejada.telemoney.configuration.config.ViewConfigurationConfig")

public interface ViewConfigurationConfig {
		@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration",
		    description = "URL for Configuration service",
		    name = "configurationURL",
		    required = false)
		public String configurationURL();
		
		@Meta.AD(
			deflt = "http://192.168.215.114:17434/api/v1/configuration/type/",
			description = "URL for getting configuration by type",
			name = "getConfigurationByTypeURL",
			required = false)
		public String getConfigurationByTypeURL();
		
		@Meta.AD(
			deflt = "http://192.168.215.114:17434/api/v1/configuration/key/",
			description = "URL for getting configuration by key",
			name = "getConfigurationByKeyURL",
			required = false)
		public String getConfigurationByKeyURL();
		
		@Meta.AD(
				deflt = "1234",
				name = "XCorrelationId",
				required = false)
		public String XCorrelationId();
		
		@Meta.AD(
				deflt = "key",
				name = "requestParam1",
				required = false)
		public String requestParam1();
		
		@Meta.AD(
				deflt = "newValue",
				name = "requestParam2",
				required = false)
		public String requestParam2();
		
		@Meta.AD(
				deflt = "type",
				name = "requestParam3",
				required = false)
		public String requestParam3();
		
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
