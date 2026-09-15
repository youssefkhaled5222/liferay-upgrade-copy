package com.ejada.telemoney.common.configs.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	category = "custom.configuration",
	scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(id = "com.ejada.telemoney.common.configs.configuration.HeaderChannelConfiguration")
public interface HeaderChannelConfiguration {

	@Meta.AD(
		deflt = "",
		description = "Maps a role name to the channels visible to it in the header dropdown. One entry per role, formatted as RoleName=channelNameOrId,channelNameOrId,... Example: PO=Web,Mobile. Roles not listed here are unrestricted (users see all approved channels).",
		name = "roleChannelMappings",
		required = false
	)
    String[] roleChannelMappings();

}
